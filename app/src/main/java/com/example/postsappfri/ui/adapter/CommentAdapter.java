package com.example.postsappfri.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.postsappfri.data.model.comment.CommentResponseItem;
import com.example.postsappfri.databinding.ItemCommentLayoutBinding;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentHolder> {

    private List<CommentResponseItem> comments;

    public void addComments(List<CommentResponseItem> comments) {
        this.comments = comments;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCommentLayoutBinding binding =
                ItemCommentLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new CommentHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder holder, int position) {
        CommentResponseItem comment = comments.get(position);
        holder.binding.userName.setText(comment.getName());
        holder.binding.commentContent.setText(comment.getBody());
    }

    @Override
    public int getItemCount() {
        if (comments != null)
            return comments.size();
        return 0;
    }


    static class CommentHolder extends RecyclerView.ViewHolder {
        ItemCommentLayoutBinding binding;

        public CommentHolder(@NonNull ItemCommentLayoutBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
