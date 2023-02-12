package com.example.smg_insta;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class FollowActivity  extends FragmentActivity {

    private static final int FRAG_PAGES = 2;
    private int page;
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    private ImageView back;
    private TextView tv_userId;

    private Bundle bundle;
    private String accountID;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_list);

        Intent intent = getIntent();
        page = intent.getIntExtra("NUM_PAGES", 2);
        if(intent.getStringExtra("userId") != null) {
            bundle = new Bundle();
            accountID = intent.getStringExtra("userId");
            bundle.putString("userId", accountID);

        } else {
            accountID = PreferenceManager.getString(this, "accountID");
        }

        back = findViewById(R.id.iv_follow_back);
        tv_userId = findViewById(R.id.tv_follow_userId);

        pager = findViewById(R.id.vp_followList);
        pagerAdapter = new FollowAdapter(this, page);
        pager.setAdapter(pagerAdapter);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        tv_userId.setText(accountID);


    }

    private class FollowAdapter extends FragmentStateAdapter {
        int pageNum;

        public FollowAdapter(FragmentActivity fa, int num) {
            super(fa);
            this.pageNum = num;
        }

        @Override
        public Fragment createFragment(int position) {

            if((position+pageNum)%FRAG_PAGES == 0) {
                Frag_follower fragFollower = new Frag_follower();
                if(bundle != null) {
                    fragFollower.setArguments(bundle);
                }
                return fragFollower;
            }else {
                Frag_following fragFollowing = new Frag_following();
                if(bundle != null) {
                    fragFollowing.setArguments(bundle);
                }
                return fragFollowing;
            }
        }

        @Override
        public int getItemCount() {
            return FRAG_PAGES;
        }
    }
}
