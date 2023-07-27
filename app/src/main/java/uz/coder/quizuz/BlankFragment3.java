package uz.coder.quizuz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import uz.coder.quizuz.databinding.FragmentBlank3Binding;
import uz.coder.quizuz.databinding.FragmentBlankBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment3#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment3 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private int mParam2;
    private int mParam3;

    public BlankFragment3() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment3.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment3 newInstance(String param1, String param2) {
        BlankFragment3 fragment = new BlankFragment3();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString("l");
            mParam2 = getArguments().getInt("h");
            mParam3 = getArguments().getInt("hamma");
        }
    }
    FragmentBlank3Binding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBlank3Binding.inflate(inflater,container,false);
        sharedPreferences = requireContext().getSharedPreferences("S", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        binding.home.setOnClickListener(view -> Navigation.findNavController(binding.getRoot()).navigate(R.id.blankFragment));
        binding.refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("a",mParam1);
                editor.commit();
                Navigation.findNavController(binding.getRoot()).navigate(R.id.blankFragment2);
            }
        });
        if (mParam3 != 0){
            if(mParam3 >= 4){
                if (mParam2 >= mParam3 || mParam2 >= mParam3-1){
                    binding.img.setImageResource(R.drawable.winner);
                }else {
                    binding.img.setImageResource(R.drawable.loser);
                }
            }else {
                if (mParam2 >= mParam3 || mParam2 >= mParam3-1 || mParam2 >= mParam3-2 || mParam2>= mParam3-3){
                    binding.img.setImageResource(R.drawable.winner);
                }else {
                    binding.img.setImageResource(R.drawable.loser);
                }
            }
        }
        binding.dan.setText(String.valueOf(mParam2)+"/"+mParam3);
        return binding.getRoot();
    }
}