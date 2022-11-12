package com.example.postsappfri.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.postsappfri.data.model.post.PostResponseItem;
import com.example.postsappfri.data.source.remote.RetrofitClient;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class PostViewModel extends ViewModel {


    private MutableLiveData<List<PostResponseItem>> _postsLiveData = new MutableLiveData<List<PostResponseItem>>();
    public LiveData<List<PostResponseItem>> postsLiveData = _postsLiveData;


    private MutableLiveData<String> _message = new MutableLiveData<String>();
    public LiveData<String> message = _message;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public void getPosts() {
        RetrofitClient.getService()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<PostResponseItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                            compositeDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<PostResponseItem> postResponseItems) {
                        _postsLiveData.postValue(postResponseItems);

                    }

                    @Override
                    public void onError(Throwable e) {
                        _message.postValue(e.getLocalizedMessage());
                    }
                });
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
        compositeDisposable.clear();
    }
}
