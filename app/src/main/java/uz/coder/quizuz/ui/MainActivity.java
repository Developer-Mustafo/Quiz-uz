package uz.coder.quizuz.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import java.util.Objects;

import uz.coder.quizuz.R;
import uz.coder.quizuz.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public void onBackPressed() {
        if (Objects.requireNonNull(Navigation.findNavController(binding.fragmentContainerView).getCurrentDestination()).getId() == R.id.startFragment) {
            super.onBackPressed();
        } else {
            Navigation.findNavController(binding.fragmentContainerView).navigateUp();
        }
    }
}