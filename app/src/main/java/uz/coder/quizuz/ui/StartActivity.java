package uz.coder.quizuz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import uz.coder.quizuz.databinding.ActivityStartBinding;

public class StartActivity extends AppCompatActivity {
    ActivityStartBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.start.setOnClickListener(view -> {
            Intent intent = new Intent(StartActivity.this,MainActivity.class);
        });
        binding.about.setOnClickListener(view1->{
            Intent intent = new Intent(StartActivity.this,XaqidaActivity.class);
            startActivity(intent);
        });
        binding.other.setOnClickListener(view2->{
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/dev?id=6145784553241991306"));
            startActivity(intent);
        });
        binding.we.setOnClickListener(view2->{
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://play.google.com/store/apps/dev?id=6145784553241991306"));
            startActivity(intent);
        });
    }
}