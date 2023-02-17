package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.UpdateProfileData;
import com.example.smg_insta.DTO.UpdateProfileId;
import com.example.smg_insta.DTO.UpdateProfileName;

import java.io.File;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Multipart;

public class EditProfileFrag extends Fragment {

    private View view;
    private TextView btn_cancel, btn_ok, btn_updatePhoto;
    private EditText et_name, et_id;
    private CircleImageView profileImage;
    final int REQUEST_CODE = 101;
    private Uri selectedImageUri;
    private boolean isChangedPhoto = false;

    Service dataService = new Service();
    String accountId, name, profile;
    String profilePhotoURL;

    String updateName;
    String updateId;

    String[] permission_list = {
            android.Manifest.permission.WRITE_CONTACTS,
            Manifest.permission.READ_EXTERNAL_STORAGE};


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.edit_profile, container, false);

        accountId = PreferenceManager.getString(getContext(), "accountID");
        profilePhotoURL = PreferenceManager.getString(getContext(), "profileImage");

        btn_cancel = view.findViewById(R.id.tv_btn_cancel);
        btn_ok = view.findViewById(R.id.tv_btn_ok);
        profileImage = view.findViewById(R.id.civ_profile_image);
        btn_updatePhoto = view.findViewById(R.id.tv_btn__edit_profilePhoto);
        et_name = view.findViewById(R.id.et_profile_name);
        et_id = view.findViewById(R.id.et_profile_id);
        et_id.setText(accountId);

        Bundle bundle = getArguments();  //번들 받기. getArguments() 메소드로 받음.
        if(bundle != null){
            name = bundle.getString("name");
            et_name.setText(name);
            profile = bundle.getString("profile");
            if(profile != null) {
                Glide.with(getActivity())
                        .load(profile)
                        .into(profileImage);
            }
        }



        // 프로필 사진 바꾸기 눌렀을 때
        btn_updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkPermission();

                // 갤러리 호출
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });


        // 취소 버튼 눌렀을 때
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(EditProfileFrag.this).commit();
                fragmentManager.popBackStack();
            }
        });


        // 확인 버튼 눌렀을 때
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 수정할 이름 입력받기
                updateName = et_name.getText().toString();
                // 수정할 사용자 id 입력받기
                updateId = et_id.getText().toString();

                // 프로필 변경
                if(isChangedPhoto) {
                    String realPath = getFullPathFromUri(getContext(),selectedImageUri);
                    File realFile = new File(realPath);
                    // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), realFile);
                    // RequestBody로 Multipart.Part 객체 생성
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("multipartFile", "image.jpg", fileBody);

                    dataService.insertProfileImage.InsertProfileImage(accountId, filePart).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            //성공했을 때.
                            if(response.isSuccessful()) {
                                Toast.makeText(getContext(), "프로필 사진 바꾸기 성공", Toast.LENGTH_LONG).show();
                            } else {
                                Toast.makeText(getContext(), "프로필 사진 바꾸기 오류: " + response.code(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(getContext(), "프로필 사진 바꾸기 실패", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                // 이름, id 변경
                if(updateName.length() >= 0  && updateId.length() > 0 ) {
                    // 둘 다 변경하
                    UpdateProfileData data = new UpdateProfileData(updateId, updateName);
                    dataService.updateProfile.UpdateProfile(accountId, data).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.isSuccessful()) {
                                // 성공
                                // 기존 아이디 삭제하고 새로운 아이디 저장
                                PreferenceManager.removeKey(getContext(), "accountID");
                                PreferenceManager.setString(getContext(), "accountID", updateId);
                                Toast.makeText(getContext(), "updateName: " + updateName, Toast.LENGTH_LONG).show();

                                //딜레이 후 시작할 코드 작성
                                MainActivity activity = (MainActivity)getActivity();// 프래그먼트에서 메인엑티비티 접근
                                activity.FragmentView(2);
                                // 기존 이름 삭제
                            } else {
                                Toast.makeText(getContext(), "이름, id 변경 오류: " + response.code(), Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(getContext(), "이름, id 변경 실패", Toast.LENGTH_LONG).show();
                        }
                    });
                }

            }
        });



        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            profileImage.setImageURI(selectedImageUri);
            isChangedPhoto = true;
        }
    }


    public static String getFullPathFromUri(Context ctx, Uri fileUri) {
        String fullPath = null;
        final String column = "_data";
        Cursor cursor = ctx.getContentResolver().query(fileUri, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            String document_id = cursor.getString(0);
            if (document_id == null) {
                for (int i=0; i < cursor.getColumnCount(); i++) {
                    if (column.equalsIgnoreCase(cursor.getColumnName(i))) {
                        fullPath = cursor.getString(i);
                        break;
                    }
                }
            } else {
                document_id = document_id.substring(document_id.lastIndexOf(":") + 1);
                cursor.close();

                final String[] projection = {column};
                try {
                    cursor = ctx.getContentResolver().query(
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                            projection, MediaStore.Images.Media._ID + " = ? ", new String[]{document_id}, null);
                    if (cursor != null) {
                        cursor.moveToFirst();
                        fullPath = cursor.getString(cursor.getColumnIndexOrThrow(column));
                    }
                } finally {
                    if (cursor != null) cursor.close();
                }
            }
        }
        return fullPath;
    }


    public void checkPermission(){
        //현재 안드로이드 버전이 6.0미만이면 메서드를 종료한다.
        if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M)
            return;

        for(String permission : permission_list){
            //권한 허용 여부를 확인한다.
            int chk = getContext().checkCallingOrSelfPermission(permission);

            if(chk == PackageManager.PERMISSION_DENIED){
                //권한 허용을여부를 확인하는 창을 띄운다
                requestPermissions(permission_list,0);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==0)
        {
            for(int i=0; i<grantResults.length; i++)
            {
                //허용됬다면
                if(grantResults[i]==PackageManager.PERMISSION_GRANTED){
                }
                else {
                    Toast.makeText(getContext(),"앱권한설정하세요",Toast.LENGTH_LONG).show();
                    //finish();
                }
            }
        }
    }

}
