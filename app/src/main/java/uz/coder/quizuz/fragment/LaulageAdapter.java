package uz.coder.quizuz.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import uz.coder.quizuz.databinding.ItemLaulageBinding;
import uz.coder.quizuz.model.LaulageModel;

public class LaulageAdapter extends RecyclerView.Adapter<LaulageAdapter.VH> {
    private final List<LaulageModel> laulageModelList;
    private final OnClickListener onClickListener;

    public LaulageAdapter(List<LaulageModel> laulageModelList, OnClickListener onClickListener) {
        this.laulageModelList = laulageModelList;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(ItemLaulageBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.binding.img.setImageResource(laulageModelList.get(position).getImage());
        holder.binding.txt.setText(laulageModelList.get(position).getName());
        holder.itemView.setOnClickListener(view -> onClickListener.OnClick(position));
    }

    @Override
    public int getItemCount() {
        return laulageModelList.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        ItemLaulageBinding binding;
        public VH( @NonNull ItemLaulageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface OnClickListener{
        void OnClick(int position);
    }
}
