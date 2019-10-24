package com.example.theourgifts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView img_Logo;
    TextView t_v;
    Animation anim_txt, anim_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        t_v = (TextView) findViewById(R.id.textView_logo_name);
        img_Logo = (ImageView) findViewById(R.id.image_View_Logo);

        anim_img = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.antirotation);
        anim_txt = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.down_to_up);


        img_Logo.startAnimation(anim_img);

        anim_img.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                img_Logo.setVisibility(View.VISIBLE);


            }

            @Override
            public void onAnimationEnd(Animation animation) {

                t_v.startAnimation(anim_txt);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        anim_txt.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                t_v.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent i = new Intent(SplashActivity.this, NewUserActivity.class);
                startActivity(i);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


    }
}
