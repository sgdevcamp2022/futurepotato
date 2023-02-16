package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;
import static android.content.Intent.FLAG_GRANT_READ_URI_PERMISSION;
import static android.content.Intent.FLAG_GRANT_WRITE_URI_PERMISSION;

import static androidx.core.content.ContextCompat.checkSelfPermission;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.loader.content.CursorLoader;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;

import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Url;

public class Frag3 extends Fragment {

    private View view;

    private ImageView selectPhoto;
    private EditText explain;
    private TextView upload;

    String content;
    List<MultipartBody.Part> files;

    String accountId;  //로그인할때 저장해야하나?

    Service dataService = new Service();
    ArrayList<Uri> filePathList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.upload, container, false);

        accountId = PreferenceManager.getString(getActivity(),"accountID");

        // 사진 여러개 가져오기... 하아.. 리스트로 해서 리싸이클러뷰로 보여줘야 할듯...
        selectPhoto = view.findViewById(R.id.iv_selectPhoto);
        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //갤러리 호출
                //Intent intent = new Intent(Intent.ACTION_PICK);
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);  // 다중 이미지를 가져올 수 있도록 세팅


                //intent.setAction(Intent.ACTION_PICK);
                activityResultLauncher.launch(intent);
            }
        });

        explain = view.findViewById(R.id.et_explain);
        explain.setText(null);

        upload = view.findViewById(R.id.tv_uploadBtn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                content = explain.getText().toString();

                // 여러 file들을 담아줄 ArrayList
                files = new ArrayList<>();

                // 파일 경로들을 가지고있는 `ArrayList<Uri> filePathList`가 있다고 칩시다...
                for (int i = 0; i < filePathList.size(); ++i) {

                    //String realPath = getFullPathFromUri(getContext(),filePathList.get(i));

                    // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), filePathList.get(i)+"");

                    // 사진 파일 이름
                    String fileName = "image" + i + ".jpg";
                    // RequestBody로 Multipart.Part 객체 생성
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", fileName, fileBody);
                    Log.e("filePart: " , filePart+"");
                    // 추가
                    files.add(filePart);
                }
                if(!files.isEmpty()) {
                    dataService.feed.insertOne(accountId, content, files).enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            if(response.isSuccessful()) {
                                // 로딩화면 만들기
                                Toast.makeText(getContext(), "게시물 업로드 완료", Toast.LENGTH_SHORT).show();
                                // 메인화면으로 이동하기!!
                                explain.setText(null);
                                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                                Frag1 mainFrag = new Frag1();
                                transaction.replace(R.id.main_frame, mainFrag).commit();
                            } else {
                                explain.setText(null);
                                Toast.makeText(getContext(), response.code()+ " " + response.message(), Toast.LENGTH_SHORT).show();

                            }

                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {t.printStackTrace();}
                    });
                }

            }
        });

        return view;
    }



    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        if(data == null){   // 어떤 이미지도 선택하지 않은 경우
                            Toast.makeText(getContext(), "이미지를 선택하지 않았습니다.", Toast.LENGTH_LONG).show();
                        }
                        else{   // 이미지를 하나라도 선택한 경우
                            if(data.getClipData() == null){     // 이미지를 하나만 선택한 경우
                                Log.e("single choice: ", String.valueOf(data.getData()));
                                Uri imageUri = data.getData();
                                filePathList.add(imageUri);
                            }
                            else{      // 이미지를 여러장 선택한 경우
                                ClipData clipData = data.getClipData();
                                Log.e("clipData", String.valueOf(clipData.getItemCount()));

                                if(clipData.getItemCount() > 10){   // 선택한 이미지가 11장 이상인 경우
                                    Toast.makeText(getContext(), "사진은 10장까지 선택 가능합니다.", Toast.LENGTH_LONG).show();
                                }
                                else{   // 선택한 이미지가 1장 이상 10장 이하인 경우
                                    Log.e("TAG", "multiple choice");

                                    for (int i = 0; i < clipData.getItemCount(); i++){
                                        Uri imageUri = clipData.getItemAt(i).getUri();  // 선택한 이미지들의 uri를 가져온다.
                                        try {
                                            filePathList.add(imageUri);  //uri를 list에 담는다.

                                        } catch (Exception e) {
                                            Log.e("TAG", "File select error", e);
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!filePathList.isEmpty()) {
                        Glide.with(getActivity())
                                .load(filePathList.get(0))
                                .into(selectPhoto);
                    }
                }
            }

    );

    //Uri -- > 절대경로로 바꿔서 리턴시켜주는 메소드
    public String getRealPathFromURI(Uri contentUri) {

        String[] proj = { MediaStore.Images.Media.DATA };

        Cursor cursor = getContext().getContentResolver().query(contentUri, proj, null, null, null);
        cursor.moveToNext();
        @SuppressLint("Range")
        String path = cursor.getString(cursor.getColumnIndex(MediaStore.MediaColumns.DATA));
        Uri uri = Uri.fromFile(new File(path));

        cursor.close();
        return path;
    }



    private String getRealPathFromURI2(Uri contentUri) {
        if (contentUri.getPath().startsWith("/storage")) {
            return contentUri.getPath();
        }

        String id = DocumentsContract.getDocumentId(contentUri).split(":")[1];
        String[] columns = { MediaStore.Files.FileColumns.DATA };
        String selection = MediaStore.Files.FileColumns._ID + " = " + id;
        Cursor cursor = getContext().getContentResolver().query(MediaStore.Files.getContentUri("external"), columns, selection, null, null);
        try {
            int columnIndex = cursor.getColumnIndex(columns[0]);
            if (cursor.moveToFirst()) {
                return cursor.getString(columnIndex);
            }
        } finally {
            cursor.close();
        }
        return null;
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
}

