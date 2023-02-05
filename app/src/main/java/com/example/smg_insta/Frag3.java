package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
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

import com.example.smg_insta.API.Service;

import java.net.URI;
import java.util.ArrayList;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Frag3 extends Fragment {

    private View view;

    private ImageView selectPhoto;
    private EditText explain;
    private TextView upload;

    String accountId;  //로그인할때 저장해야하나?

    Service dataService = new Service();
    ArrayList<Uri> filePathList;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.upload, container, false);

        // 사진 여러개 가져오기... 하아.. 리스트로 해서 리싸이클러뷰로 보여줘야 할듯...


        selectPhoto = view.findViewById(R.id.iv_selectPhoto);
        selectPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //갤러리 호출
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);  // 다중 이미지를 가져올 수 있도록 세팅
                //intent.setAction(Intent.ACTION_PICK);
                activityResultLauncher.launch(intent);
            }
        });

        explain = view.findViewById(R.id.et_explain);

        upload = view.findViewById(R.id.tv_uploadBtn);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String content = explain.getText().toString();

                // 여러 file들을 담아줄 ArrayList
                ArrayList<MultipartBody.Part> files = new ArrayList<>();

                // 파일 경로들을 가지고있는 `ArrayList<Uri> filePathList`가 있다고 칩시다...
                for (int i = 0; i < filePathList.size(); ++i) {
                    // Uri 타입의 파일경로를 가지는 RequestBody 객체 생성
                    RequestBody fileBody = RequestBody.create(MediaType.parse("image/jpeg"), String.valueOf(filePathList.get(i)));

                    // 사진 파일 이름
                    String fileName = "photo" + i + ".jpg";
                    // RequestBody로 Multipart.Part 객체 생성
                    MultipartBody.Part filePart = MultipartBody.Part.createFormData("image", fileName, fileBody);

                    // 추가
                    files.add(filePart);
                }

                dataService.feed.insertOne(accountId, content, files).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        // 로딩화면 만들기
                        Toast.makeText(getContext(), "게시물 업로드 완료", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });

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
                }
            }
    );
}
