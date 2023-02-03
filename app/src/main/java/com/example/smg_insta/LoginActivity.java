package com.example.smg_insta;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.smg_insta.API.RetrofitClient;
import com.example.smg_insta.API.ServiceApi;
import com.example.smg_insta.DTO.LoginData;
import com.example.smg_insta.DTO.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button signUp;
    private TextView join;
    private ServiceApi service;

    String JWT,ID= "";
    Bundle JWTbundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        JWTbundle = new Bundle(); // 번들을 통해 값 전달

        email = findViewById(R.id.et_login_email);
        password = findViewById(R.id.et_login_pw);

        service = RetrofitClient.getClient().create(ServiceApi.class);

        // 회원가입하러 가기
        join = findViewById(R.id.tv_login_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        // 로그인 버튼 클릭시 실행..
        signUp = findViewById(R.id.btn_login);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRequest();
            }
        });
    }

    private void loginRequest() { // 로그인 정보 파싱후 처리
        email.setError(null);
        password.setError(null);

        String accountId = email.getText().toString();
        String accountPw = password.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // 패스워드의 유효성 검사
        if (accountPw.isEmpty()) {
            password.setError("비밀번호를 입력해주세요.");
            focusView = password;
            cancel = true;
        }

        // 이메일의 유효성 검사
        if (accountId.isEmpty()) {
            email.setError("id를 입력해주세요.");
            focusView = email;
            cancel = true;
        }

        if (cancel) {
            focusView.requestFocus();
        } else {
            startLogin(new LoginData(accountId, accountPw));
        }
    }

    private void startLogin(LoginData data) {
        service.userLogin(data).enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, retrofit2.Response<LoginResponse> response) {
                if(!response.isSuccessful()) {
                    // 실패
                    Toast.makeText(LoginActivity.this, "실패" + response.code(), Toast.LENGTH_SHORT).show();
                    //Log.d("TAG", response.body().toString());
                } else {
                    LoginResponse result = response.body();
                    Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                    Log.d("TAG", "response.body() 확인하기 : " + result.toString());

                    JWT = result.getToken();
                    ID = result.getId();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("JWT", JWT);
                    intent.putExtra("ID", ID);
                    startActivity(intent);
                }
                
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "로그인 에러 발생", Toast.LENGTH_SHORT).show();
                Log.e("로그인 에러 발생", t.getMessage());
            }
        });
    }

}


