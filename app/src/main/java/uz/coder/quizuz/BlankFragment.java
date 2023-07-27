package uz.coder.quizuz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uz.coder.quizuz.databinding.FragmentBlankBinding;

public class BlankFragment extends Fragment {
    private FragmentBlankBinding binding;
    private String java;
    private SharedPreferences sharedPreferences;
    private List<LaulageModel> laulageModelList;
    private SharedPreferences.Editor editor;
@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater,container,false);
        sharedPreferences = requireContext().getSharedPreferences("S", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loadData();
        binding.rv.setAdapter(new LaulageAdapter(laulageModelList, position -> java = laulageModelList.get(position).getLaulage()));
        GridLayoutManager manager = new GridLayoutManager(requireContext(),2);
        binding.rv.setLayoutManager(manager);
        binding.start.setOnClickListener(view -> {
            if (java != null){
                Bundle bundle = new Bundle();
                bundle.putString("laulage",java);
                editor.putString("a",java);
                editor.commit();
                Navigation.findNavController(binding.getRoot()).navigate(R.id.blankFragment2,bundle);
                java = null;
            }else {
                Toast.makeText(requireContext(), "Tilni tanlang", Toast.LENGTH_SHORT).show();
            }
          });
    return binding.getRoot();
    }

    private void loadData() {
        laulageModelList = new ArrayList<>();
        laulageModelList.add(new LaulageModel(R.drawable.java,"Java","Java"));
        laulageModelList.add(new LaulageModel(R.drawable.kotlin,"Kotlin","Kotlin"));
        laulageModelList.add(new LaulageModel(R.drawable.database,"Database","Database"));
        laulageModelList.add(new LaulageModel(R.drawable.android,"Android","Android"));
    }
}