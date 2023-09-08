package uz.coder.quizuz.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import uz.coder.quizuz.model.LaulageModel;
import uz.coder.quizuz.R;
import uz.coder.quizuz.databinding.FragmentStartBinding;

public class StartFragment extends Fragment {
    private FragmentStartBinding binding;
    private String laulage;
    private List<LaulageModel> laulageModelList;
    private SharedPreferences.Editor editor;
@Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentStartBinding.inflate(inflater,container,false);
    SharedPreferences sharedPreferences = requireContext().getSharedPreferences("S", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    loadData();
    binding.rv.setAdapter(new LaulageAdapter(laulageModelList, position -> {
        laulage = laulageModelList.get(position).getLaulage();
        Toast.makeText(requireContext(),laulageModelList.get(position).getLaulage()+" tili tanlandi",Toast.LENGTH_LONG).show();
    }));
            GridLayoutManager manager = new GridLayoutManager(requireContext(), 2);
        binding.rv.setLayoutManager(manager);
        binding.start.setOnClickListener(view -> {
            if (laulage != null){
                Bundle bundle = new Bundle();
                bundle.putString("laulage", laulage);
                editor.putString("a", laulage);
                editor.commit();
                Navigation.findNavController(binding.getRoot()).navigate(R.id.testFragment,bundle);
                laulage = null;
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