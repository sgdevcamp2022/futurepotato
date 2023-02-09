package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.UpdateProfileData;
import com.example.smg_insta.DTO.UpdateProfileId;
import com.example.smg_insta.DTO.UpdateProfileName;

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
    String accountId;
    String profilePhotoURL;

    String updateName;
    String updateId;


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

        Bundle bundle = getArguments();  //번들 받기. getArguments() 메소드로 받음.
        if(bundle != null){
            accountId = bundle.getString("accountId");

        }



        // 프로필 사진 바꾸기 눌렀을 때
        btn_updatePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 갤러리 호출
                Intent intent = new Intent(Intent.ACTION_PICK);
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
                    // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), String.valueOf(selectedImageUri));
                    // RequestBody로 Multipart.Part 객체 생성
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("photo", "photo.jpg", fileBody);

                    dataService.insertProfileImage.InsertProfileImage(accountId, filePart).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            //성공했을 때.
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                    });
                }

                // 이름, id 변경
                if(updateName.length() == 0 && updateId.length() > 0) {
                    // id 변경하기
                    UpdateProfileId id = new UpdateProfileId(updateId);
                    dataService.updateProfile.UpdateProfile_id(accountId, et_id.getText().toString()).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            // 성공
                            // 기존 아이디 삭제하고 새로운 아이디 저장
                            // 키 값 삭제하는 부분 자꾸 오류남..
                            if(response.isSuccessful()) {
                                if(!PreferenceManager.getString(getActivity(), "accountID").isEmpty()) {
                                    PreferenceManager.removeKey(getActivity(), "accountID");
                                }
                                PreferenceManager.setString(getActivity(), "accountID", updateName);
                                Toast.makeText(getContext(), PreferenceManager.getString(getActivity(), "accountID"), Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getContext(), response.code()+ " " + response.message(), Toast.LENGTH_SHORT).show();
                            }


                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            t.printStackTrace();
                            Toast.makeText(getContext(), "아이디 변경 실패ㅅㄷ", Toast.LENGTH_SHORT).show();
                        }
                    });
                } else if(updateName.length() > 0  && updateId.length() == 0 ){
                    // name 변경하기
                    UpdateProfileName name = new UpdateProfileName(updateName);
                    dataService.updateProfile.UpdateProfile_name(accountId, name).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            // 성공
                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                    });

                }else if(updateName.length() > 0  && updateId.length() > 0 ){
                    // 둘 다 변경하기
                    UpdateProfileData data = new UpdateProfileData(updateId, updateName);
                    dataService.updateProfile.UpdateProfile(accountId,data).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            // 성공
                            // 기존 아이디 삭제하고 새로운 아이디 저장
                            PreferenceManager.removeKey(getContext(), "accountID");
                            PreferenceManager.setString(getContext(), "accountID", updateName);

                            // 기존 이름 삭제

                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                    });
                } else {
                    Toast.makeText(getContext(), "다 null 값임...", Toast.LENGTH_SHORT).show();
                }


                // 프로필 화면으로 넘어가기
                //MainActivity activity = (MainActivity)getActivity();// 프래그먼트에서 메인엑티비티 접근
                //activity.FragmentView(2);
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

}
