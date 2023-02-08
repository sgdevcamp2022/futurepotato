package com.example.smg_insta;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;

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

    private static final int NUM_PAGES = 2;
    private ViewPager2 pager;
    private FragmentStateAdapter pagerAdapter;

    private ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follow_list);

        back = findViewById(R.id.iv_follow_back);

        pager = findViewById(R.id.vp_followList);
        pagerAdapter = new FollowAdapter(this);
        pager.setAdapter(pagerAdapter);
        pager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private class FollowAdapter extends FragmentStateAdapter {


        public FollowAdapter(FragmentActivity fa) {
            super(fa);
        }

        @Override
        public Fragment createFragment(int position) {

            if(position%NUM_PAGES == 0) {
                return new Frag_follower();
            }else {
                return new Frag_following();
            }
        }

        @Override
        public int getItemCount() {
            return NUM_PAGES;
        }
    }
}
