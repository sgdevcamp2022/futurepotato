package com.example.smg_insta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private NavigationBarView bottomNavigationView;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private Frag1 frag1;
    private Frag2 frag2;
    private Frag3 frag3;
    private Frag4 frag4;
    private Frag5 frag5;
    //Bundle JWTbundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent intent = getIntent();
        //String ID = PreferenceManager.getString(getApplicationContext(), "accountID");

        //JWTbundle = new Bundle(); // 번들을 통해 값 전달
        //JWTbundle.putString("JWT",JWT);//번들에 넘길 값 저장
        //JWTbundle.putString("ID",ID);//번들에 넘길 값 저장


        bottomNavigationView = findViewById(R.id.bottomNavi);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_home:
                        setFrag(0);
                        break;
                    case R.id.action_search:
                        setFrag(1);
                        break;
                    case R.id.action_post:
                        setFrag(2);
                        break;
                    case R.id.action_notice:
                        setFrag(3);
                        break;
                    case R.id.action_profile:
                        setFrag(4);
                        break;
                }
                return true;
            }
        });
        frag1 = new Frag1();
        frag2 = new Frag2();
        frag3 = new Frag3();
        frag4 = new Frag4();
        frag5 = new Frag5();
        setFrag(0); // 첫 프래그먼트 화면으로 0을 지정함.
    }

    public void setFrag(int n) {
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch(n){
            case 0:
                //frag1.setArguments(JWTbundle);
                ft.replace(R.id.main_frame, frag1);
                ft.commit();
                break;
            case 1:
                //frag2.setArguments(JWTbundle);
                ft.replace(R.id.main_frame, frag2);
                ft.commit();
                break;
            case 2:
                //frag3.setArguments(JWTbundle);
                ft.replace(R.id.main_frame, frag3);
                ft.commit();
                break;
            case 3:
                //frag4.setArguments(JWTbundle);
                ft.replace(R.id.main_frame, frag4);
                ft.commit();
                break;
            case 4:
                //frag5.setArguments(JWTbundle);
                ft.replace(R.id.main_frame, frag5);
                ft.commit();
                break;
        }
    }

    public void FragmentView(int fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch(fragment) {
            case 0:
                FragUserInfo fragUserInfo = new FragUserInfo();
                transaction.replace(R.id.main_frame, fragUserInfo).commit();
                break;

            case 1:
                MyPostFrag myPostFrag = new MyPostFrag();
                //myPostFrag.setArguments(JWTbundle);
                transaction.replace(R.id.main_frame, myPostFrag).commit();
                break;

            case 2:
                Frag5 profileFrag = new Frag5();
                transaction.replace(R.id.main_frame, profileFrag).commit();
                break;
        }

    }


    public void FragmentViewAddBundle(int fragment, Bundle bundle){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch(fragment) {
            case 0:
                FragUserInfo fragUserInfo = new FragUserInfo();
                fragUserInfo.setArguments(bundle);
                transaction.replace(R.id.main_frame, fragUserInfo).commit();
                break;
            case 1:
                MyPostFrag myPostFrag = new MyPostFrag();
                myPostFrag.setArguments(bundle);
                // MyPostFrag에서 뒤로가기 문제 때문에 addToBackStack(null) 추가함
                transaction.replace(R.id.main_frame, myPostFrag).addToBackStack(null).commit();
                break;
        }

    }

}