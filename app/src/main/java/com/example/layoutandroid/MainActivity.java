package com.example.layoutandroid;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.core.widget.ImageViewCompat;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.ActionBar;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;

// carregamento lazy

public class MainActivity extends AppCompatActivity {

    private AnimationDrawable animationDrawable;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void run() {

            cardView.animate().scaleX(2f).scaleY(2f).alpha(.1f).setDuration(950).withEndAction(new Runnable() {
                @Override
                public void run() {
                    cardView.setScaleX(.3f);
                    cardView.setScaleY(.3f);
                    cardView.setAlpha(1f);
                }
            });

            cardView_.animate().scaleX(1.5f).scaleY(1.5f).alpha(.2f).setDuration(850).withEndAction(new Runnable() {
                @Override
                public void run() {
                    cardView_.setScaleX(.7f);
                    cardView_.setScaleY(.7f);
                    cardView_.setAlpha(1f);
                }
            });

            ObjectAnimator scale = ObjectAnimator.ofPropertyValuesHolder(
                    R.id.me,
                    PropertyValuesHolder.ofFloat("scaleX",.7f),
                    PropertyValuesHolder.ofFloat("scaleY",.7f));

            scale.setDuration(500);
            scale.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    Log.e("animation value",animation.getAnimatedValue().toString());
                }
            });
            scale.setRepeatCount(ObjectAnimator.INFINITE);
            scale.setRepeatMode(ObjectAnimator.REVERSE);
            scale.start();

            handler.postDelayed(runnable,1000);
        }
    };

    private AppCompatImageView cardView;
    private AppCompatImageView cardView_;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardView = findViewById(R.id.card_anim);
        cardView_ = findViewById(R.id.card_anim_);

        handler.post(runnable);

        /*final Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate_animator);
        animation.setRepeatMode(Animation.INFINITE);

        final View view = findViewById(R.id.main_view);

        view.animate().setUpdateListener(new ValueAnimator.AnimatorUpdateListener(){

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Log.e("Animation Value",animation.getAnimatedValue()+"");
            }
        });

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                animation.setAnimationListener(new Animation.AnimationListener(){
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.e("on Anmation start","start");
                    }

                    @Override
                    public void onAnimationEnd(Animation ani) {
                        Log.e("on Animation end","end");
                        view.clearAnimation();
                        view.startAnimation(animation);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.e("on Anmation repet","start");
                    }
                });
                view.startAnimation(animation);
            }
        });*/



    }
}
