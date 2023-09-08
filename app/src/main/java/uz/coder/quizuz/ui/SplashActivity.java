package uz.coder.quizuz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import uz.coder.quizuz.R;
import uz.coder.quizuz.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {
private ActivitySplashBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.animation);
        Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.animation1);
        binding.img.setAnimation(anim);
        binding.txt.setAnimation(anim1);
        int SPLASH_SCREEN = 4500;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashActivity.this, StartActivity.class);
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);
    }
}