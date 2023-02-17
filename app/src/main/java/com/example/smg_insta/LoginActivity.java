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

import com.example.smg_insta.API.LoginApi;
import com.example.smg_insta.API.RetrofitClient;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.DTO.LoginData;
import com.example.smg_insta.DTO.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button signUp;
    private TextView join;
    //private LoginApi service;

    String accountId;
    String accountPw;
    Service service;

    String JWT,ID= "";
    //Bundle JWTbundle;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);



        //JWTbundle = new Bundle(); // 번들을 통해 값 전달

        email = findViewById(R.id.et_login_email);
        password = findViewById(R.id.et_login_pw);

        //service = RetrofitClient.getClient().create(LoginApi.class);
        service = new Service();

        // 자동 로그인..?
        String accountID = PreferenceManager.getString(getApplicationContext(), "accountID");
        String accountPW = PreferenceManager.getString(getApplicationContext(), "accountPW");
        Log.e("PreferenceManager", accountID + " / " + accountPW);
        if (!accountID.isEmpty() && !accountPW.isEmpty()) {
            LoginData data = new LoginData(accountID, accountPW);
            service.login.userLogin(data).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    Toast.makeText(LoginActivity.this, "자동로그인 되었습니다.", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        }

        // 회원가입하러 가기
        join = findViewById(R.id.tv_login_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent);
            }
        });

        
        // 로그인 버튼 실행
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

        accountId = email.getText().toString();
        accountPw = password.getText().toString();

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
        service.login.userLogin(data).enqueue(new Callback<LoginResponse>() {

            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if(!response.isSuccessful()) {
                    // 실패
                    Toast.makeText(LoginActivity.this, "실패" + response.code(), Toast.LENGTH_SHORT).show();
                    //Log.d("TAG", response.body().toString());
                } else {
                    LoginResponse result = response.body();
                    Toast.makeText(LoginActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();

                    Log.d("TAG", "result.getToken() 확인하기 : " + result.getToken());


                    // 모든 저장 데이터 삭제 후 새로운 데이터 저장.
                    PreferenceManager.clear(getApplicationContext());
                    PreferenceManager.setString(getApplicationContext(), "accountID", result.getAccountId());
                    PreferenceManager.setString(getApplicationContext(), "token", result.getToken());
                    PreferenceManager.setString(getApplicationContext(), "accountPW", accountPw);

                    //JWT = result.getToken();
                    //ID = result.getAccountId();

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //intent.putExtra("JWT", JWT);
                    //intent.putExtra("ID", ID);
                    startActivity(intent);
                    finish();
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


