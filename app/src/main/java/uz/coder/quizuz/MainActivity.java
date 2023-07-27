package uz.coder.quizuz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.os.Bundle;

import java.util.Objects;

import uz.coder.quizuz.databinding.ActivityMainBinding;
import uz.coder.quizuz.databinding.FragmentBlankBinding;

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
        if (Objects.requireNonNull(Navigation.findNavController(binding.fragmentContainerView).getCurrentDestination()).getId() == R.id.blankFragment) {
            super.onBackPressed();
        } else {
            Navigation.findNavController(binding.fragmentContainerView).navigateUp();
        }
    }
}