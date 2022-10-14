package com.example.postsappfri.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.postsappfri.R;
import com.example.postsappfri.data.model.post.PostResponseItem;
import com.example.postsappfri.data.model.userModel.UserResponse;
import com.example.postsappfri.data.source.remote.RetrofitClient;
import com.example.postsappfri.databinding.FragmentPostsBinding;
import com.example.postsappfri.ui.adapter.PostsAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsFragment extends Fragment implements PostsAdapter.PostAction {


    private FragmentPostsBinding binding;

    private PostsAdapter postsAdapter;

    public PostsFragment() {
        // Required empty public constructor
    }


    private void initUI() {
        postsAdapter = new PostsAdapter();
        binding.postsRecycler.setAdapter(postsAdapter);
        binding.postsRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }

    private void getPosts() {
        RetrofitClient.getService()
                .getPosts().enqueue(new Callback<List<PostResponseItem>>() {
                    @Override
                    public void onResponse(Call<List<PostResponseItem>> call, Response<List<PostResponseItem>> response) {
                        Log.d("dddd", "onResponse: " + response.body());
                        if (response.isSuccessful())
                            postsAdapter.addPosts(response.body(), PostsFragment.this);
                    }

                    @Override
                    public void onFailure(Call<List<PostResponseItem>> call, Throwable t) {
                        Log.d("dddd", "onFailure: " + t.getLocalizedMessage());
                    }
                });
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_posts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = FragmentPostsBinding.bind(view);
        initUI();
        getPosts();
     //   testLogin();
    }

    private void testLogin(){
        RetrofitClient.getService()
                .testLogin("user10@app.com","password")
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Log.d("sssssss", "onResponse: "+response.code() +response.body());
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void postClick(PostResponseItem post) {
        Navigation.findNavController(getView())
                .navigate(PostsFragmentDirections.actionPostsFragmentToPostDetailsFragment(post));
    }
}