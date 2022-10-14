package com.example.postsappfri.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.postsappfri.R;
import com.example.postsappfri.data.model.comment.CommentResponseItem;
import com.example.postsappfri.data.model.post.PostResponseItem;
import com.example.postsappfri.data.source.remote.RetrofitClient;
import com.example.postsappfri.databinding.FragmentPostDetailsBinding;
import com.example.postsappfri.ui.adapter.CommentAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostDetailsFragment extends Fragment {


    FragmentPostDetailsBinding binding;

    CommentAdapter commentAdapter;

    public PostDetailsFragment() {
        // Required empty public constructor
    }

    private void bindUI(PostResponseItem post) {
        binding.postIdTxt.setText(String.valueOf(post.getId()));
        binding.postUserIdTxt.setText(String.valueOf(post.getUserId()));
        binding.postTitleTxt.setText(post.getTitle());
        binding.postDescTxt.setText(post.getBody());

    }

    private void getPosts(int postId) {
        RetrofitClient.getService().getPost(postId)
                .enqueue(new Callback<PostResponseItem>() {
                    @Override
                    public void onResponse(Call<PostResponseItem> call, Response<PostResponseItem> response) {
                        Log.d("ddddddd", "onResponse: " + response.body());
                        if (response.isSuccessful())
                            bindUI(response.body());
                    }

                    @Override
                    public void onFailure(Call<PostResponseItem> call, Throwable t) {
                        Log.d("dddddd", "onFailure: " + t.getLocalizedMessage());
                    }
                });
    }

    private void getComments(int postId) {
        RetrofitClient.getService()
                .getPostComments(postId)
                .enqueue(new Callback<List<CommentResponseItem>>() {
                    @Override
                    public void onResponse(Call<List<CommentResponseItem>> call, Response<List<CommentResponseItem>> response) {
                        Log.d("ddddddd", "resposne: "+response.message());

                        if (response.isSuccessful())
                            commentAdapter.addComments(response.body());
                    }

                    @Override
                    public void onFailure(Call<List<CommentResponseItem>> call, Throwable t) {
                        Log.d("ddddddd", "onFailure: "+t.getLocalizedMessage());
                    }
                });

    }

    PostResponseItem post;

    private void setUpCommentsRecycler() {
        commentAdapter = new CommentAdapter();
        binding.postCommentsRecycler.setAdapter(commentAdapter);
        binding.postCommentsRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        post = PostDetailsFragmentArgs.fromBundle(getArguments())
                .getPost();
        getComments(post.getId());

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_post_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPostDetailsBinding.bind(view);
        setUpCommentsRecycler();
        if (post != null)
            bindUI(post);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}