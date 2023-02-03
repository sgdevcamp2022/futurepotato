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

import com.example.smg_insta.API.RetrofitClient;
import com.example.smg_insta.API.ServiceApi;
import com.example.smg_insta.DTO.JoinData;
import com.example.smg_insta.DTO.JoinResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class JoinActivity extends AppCompatActivity {

    //api에 name이 인스타 아이디?
    private EditText email, name, password, id;
    private Button btn_join;
    private AlertDialog dialog;
    private ServiceApi service;
    //final static private  String url = "http://10.0.2.2:8000/auth/signup";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        email = findViewById(R.id.et_register_email);
        name = findViewById(R.id.et_register_name);
        id = findViewById(R.id.et_register_id);
        password = findViewById(R.id.et_register_pw);

        service = RetrofitClient.getClient().create(ServiceApi.class);

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

        String UserEmail = email.getText().toString();
        String UserName = name.getText().toString();
        String UserId = id.getText().toString();
        String UserPwd = password.getText().toString();

        //한 칸이라도 입력 안했을 경우
        if (UserEmail.equals("") || UserPwd.equals("") || UserName.equals("") || UserId.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(JoinActivity.this);
            dialog = builder.setMessage("모두 입력해주세요.").setNegativeButton("확인", null).create();
            dialog.show();
            return;
        } else {
            startJoin(new JoinData(UserEmail, UserId, UserPwd, UserName));
        }
    }
    private void startJoin(JoinData data) {
        service.userJoin(data).enqueue(new Callback<JoinResponse>() {

            @Override
            public void onResponse(Call<JoinResponse> call, retrofit2.Response<JoinResponse> response) {
                JoinResponse result = response.body();
                if(!response.isSuccessful()) {
                    // 실패
                    Toast.makeText(JoinActivity.this, "실패: " + response.code(), Toast.LENGTH_SHORT).show();
                    if(response.code() == 400) {
                        //Toast.makeText(JoinActivity.this, "실패: " + result.getError(), Toast.LENGTH_SHORT).show();
                    }

                } else {
                    //Toast.makeText(JoinActivity.this, result.getAccountId()+"님 회원가입을 축하합니다.", Toast.LENGTH_SHORT).show();

                    if (response.code() == 200) {
                        finish();
                    }
                }
            }

            @Override
            public void onFailure(Call<JoinResponse> call, Throwable t) {
                Toast.makeText(JoinActivity.this, "회원가입 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("회원가입 에러 발생", t.getMessage());
            }
        });
    }

}
