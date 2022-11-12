package com.example.postsappfri.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.postsappfri.R;
import com.example.postsappfri.data.model.post.PostResponseItem;
import com.example.postsappfri.data.model.userModel.UserResponse;
import com.example.postsappfri.data.source.remote.RetrofitClient;
import com.example.postsappfri.databinding.FragmentPostsBinding;
import com.example.postsappfri.ui.adapter.PostsAdapter;
import com.example.postsappfri.viewmodel.PostViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PostsFragment extends Fragment implements PostsAdapter.PostAction {


    private FragmentPostsBinding binding;

    private PostsAdapter postsAdapter;

    private PostViewModel postViewModel;

    public PostsFragment() {
        // Required empty public constructor
    }


    private void initUI() {
        postsAdapter = new PostsAdapter(this::postClick);
        binding.postsRecycler.setAdapter(postsAdapter);
        binding.postsRecycler.setLayoutManager(new LinearLayoutManager(requireContext()));
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        postViewModel = new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();

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
        observe();

        //   testLogin();
    }

    private void observe() {
        postViewModel.postsLiveData.observe(getViewLifecycleOwner(), new Observer<List<PostResponseItem>>() {
            @Override
            public void onChanged(List<PostResponseItem> postResponseItems) {
                postsAdapter.addPosts(postResponseItems);
            }
        });


        postViewModel.message.observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireContext(), "" + s, Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void testLogin() {
        RetrofitClient.getService()
                .testLogin("user10@app.com", "password")
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        Log.d("sssssss", "onResponse: " + response.code() + response.body());
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