package com.example.smg_insta;

import static java.lang.Integer.parseInt;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.example.smg_insta.API.Service;
import com.example.smg_insta.Adapter.ImageSliderAdapter;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateFeedFrag extends Fragment {

    private View view;
    private ImageView btn_back;
    private TextView btn_ok, tv_userId;
    private CircleImageView civ_profileImage;
    private ViewPager2 img_content;
    private LinearLayout layoutIndicator;
    private ScrollView scrollView;

    // 글 입력하려고 하면 메뉴바가 올라와서 가려짐.. 새로운 액티비티로??
    private EditText et_modifiedContent;

    String userId;
    String profileImage;
    ArrayList<String> images;
    String content;
    int postId;

    Service dataService = new Service();
    String updateContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.update_post_view, container, false);

        Bundle bundle = getArguments();  //번들 받기. getArguments() 메소드로 받음.
        if(bundle != null){
            userId = bundle.getString("userId");
            profileImage = bundle.getString("profileImage");
            content = bundle.getString("content");
            images = bundle.getStringArrayList("images");
            postId = parseInt(bundle.getString("postId"));
        }

        tv_userId = view.findViewById(R.id.tv_post_profile);
        tv_userId.setText(userId);

        // 프로필 이미지
        civ_profileImage = view.findViewById(R.id.civ_profile);
        if(profileImage != null) {
            Glide.with(getActivity())
                    .load(profileImage)
                    .into(civ_profileImage);
        }

        // feed 이미지
        img_content = view.findViewById(R.id.sliderViewPager_profile);
        img_content.setOffscreenPageLimit(1);
        img_content.setAdapter(new ImageSliderAdapter(getActivity(), images));

        layoutIndicator = view.findViewById(R.id.layoutIndicators_profile);
        img_content.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });
        setupIndicators(images.size());


        et_modifiedContent = view.findViewById(R.id.et_modifiedCotent);
        et_modifiedContent.setText(content);
        et_modifiedContent.setSelection(et_modifiedContent.length()); //커서를 끝에 위치!
        et_modifiedContent.setImeOptions(EditorInfo.IME_ACTION_NONE); //엔터키 아무 의미 없음.

        et_modifiedContent.requestFocus(); //focus 주기
        // 키보드 띄우기
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);

        //스크롤 맨 아래로
        scrollView = view.findViewById(R.id.scrollView2);
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
//                scrollView.fullScroll(ScrollView.FOCUS_UP);
            }
        });

        //-----------------------------------------------

        btn_ok = view.findViewById(R.id.tv_update_btn_ok);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 키보드 내리기
                InputMethodManager immhide = (InputMethodManager) requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE);
                immhide.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);

                // 수정...
                updateContent = et_modifiedContent.getText().toString();
                dataService.feed.UpdateFeed(userId, postId, updateContent).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Toast.makeText(getActivity(), "수정 되었습니다.", Toast.LENGTH_SHORT).show();

                        // 화면이동
                        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                        Frag5 frag5 = new Frag5();
                        transaction.replace(R.id.main_frame, frag5).commit();

                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        btn_back = view.findViewById(R.id.iv_blockList_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 이전화면으로
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().remove(UpdateFeedFrag.this).commit();
                fragmentManager.popBackStack();

//                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
//                MyPostFrag myPostFrag = new MyPostFrag();
//                transaction.replace(R.id.main_frame, myPostFrag).commit();
            }
        });

        return view;
    }



    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(getActivity());
            indicators[i].setImageDrawable(ContextCompat.getDrawable(getActivity(),
                    R.drawable.bg_indicator_inactive));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getActivity(),
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        getActivity(),
                        R.drawable.bg_indicator_inactive
                ));
            }
        }
    }
}
