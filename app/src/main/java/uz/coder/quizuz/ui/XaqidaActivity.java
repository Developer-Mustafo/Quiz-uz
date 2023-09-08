package uz.coder.quizuz.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import uz.coder.quizuz.R;

public class XaqidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xaqida);
    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(XaqidaActivity.this,StartActivity.class));
        finish();
    }
}