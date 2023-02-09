package com.example.smg_insta;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.JoinData;
import com.example.smg_insta.DTO.JoinResponse;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;

public class JoinActivity extends AppCompatActivity {

    //api에 name이 인스타 아이디?
    private EditText email, name, password, id;
    private Button btn_join;
    private AlertDialog dialog;

    private Service dataService = new Service();

    String UserEmail;
    String UserName;
    String UserId;
    String UserPwd;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        email = findViewById(R.id.et_register_email);
        name = findViewById(R.id.et_register_name);
        id = findViewById(R.id.et_register_id);
        password = findViewById(R.id.et_register_pw);

        btn_join = findViewById(R.id.btn_register_join);
        // 가입하기 버튼 클릭했을 때
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptJoin();
           }
        });

        }

    private void attemptJoin() {
        email.setError(null);
        name.setError(null);
        id.setError(null);
        password.setError(null);

        UserEmail = email.getText().toString();
        UserName = name.getText().toString();
        UserId = id.getText().toString();
        UserPwd = password.getText().toString();

        //한 칸이라도 입력 안했을 경우
        if (UserEmail.equals("") || UserPwd.equals("") || UserId.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
            dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
            dialog.show();
            return;
        } else {
            startJoin(new JoinData(UserEmail, UserId, UserPwd, UserName));
        }
    }
    private void startJoin(JoinData data) {
        dataService.login.userJoin(data).enqueue(new Callback<JoinResponse>() {

            @Override
            public void onResponse(Call<JoinResponse> call, retrofit2.Response<JoinResponse> response) {
                JoinResponse result = response.body();
                if(!response.isSuccessful()) {
                    // 실패
                    try {
                        String body = response.errorBody().string();
                        Toast.makeText(JoinActivity.this, "실패(errorBody): " + body + " errorCode: " + response.code(), Toast.LENGTH_SHORT).show();
                        Log.e("TAG", "error - body : " + body);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Log.e("회원가입 실패", response.message());
                } else {
                    Toast.makeText(JoinActivity.this, result.getAccountId()+"님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();

                    if (response.code() == 200) {
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<JoinResponse> call, Throwable t) {
                Toast.makeText(JoinActivity.this, "회원가입 에러 발생: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());
            }
        });
    }

}
