package com.example.smg_insta;

import static android.app.Activity.RESULT_OK;

import static com.example.smg_insta.Frag3.getFullPathFromUri;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.smg_insta.API.Service;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StoryPostFrag extends Fragment {
    private View view;
    private ImageView btnBack, storyImage;
    private TextView btnOK;
    private TextView userId;

    final int REQUEST_CODE = 101;
    Uri selectedImageUri;

    // 스토리는 나만 post할 수 있으니까.
    String accountId;

    Service dataService = new Service();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.frag_post_story, container, false);

        btnBack = view.findViewById(R.id.iv_story_back);
        storyImage = view.findViewById(R.id.tv_postStroy_image);
        btnOK = view.findViewById(R.id.tv_story_btnOK);
        userId = view.findViewById(R.id.tv_story_accountId);

        accountId = PreferenceManager.getString(getContext(), "accountID");
        userId.setText(accountId);

        // 갤러리 호출
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent, REQUEST_CODE);


        // 스토리 올리기 취소하기
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 뒤로가기
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(StoryPostFrag.this).commit();
                fragmentManager.popBackStack();
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 스토리 올리기
                //
                String realPath = getFullPathFromUri(getContext(),selectedImageUri);
                File realFile = new File(realPath);
                // 절대경로를 가지는 RequestBody 객체 생성
                RequestBody fileBody = RequestBody.create(MediaType.parse("image/*"), realFile);
                // RequestBody로 Multipart.Part 객체 생성
                MultipartBody.Part filePart = MultipartBody.Part.createFormData("multipartFile", "image.jpg", fileBody);

                dataService.story.InsertStory(accountId, filePart).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if(response.isSuccessful()) {
                            // 성공했을 때. 메인화면으로 넘어가기!
                            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                            Frag1 mainFrag = new Frag1();
                            transaction.replace(R.id.main_frame, mainFrag).commit();
                        } else {
                            Toast.makeText(getContext(), "스토리 생성 오류: " + response.code(), Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                        Log.e("story", "스토리 생성 실패지만 사실은 성공");
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        Frag1 mainFrag = new Frag1();
                        transaction.replace(R.id.main_frame, mainFrag).commit();

                    }
                });


            }
        });


        // 이미지 변경
        storyImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null && data.getData() != null) {
            selectedImageUri = data.getData();
            storyImage.setImageURI(selectedImageUri);
        }
    }
}
