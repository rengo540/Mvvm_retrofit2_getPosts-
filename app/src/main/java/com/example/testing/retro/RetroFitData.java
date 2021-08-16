package com.example.testing.retro;

import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitData {

    private static String BaseUrl ="https://jsonplaceholder.typicode.com/";
    private ApiInterface apiInterface;
    private static RetroFitData Instance ;

    public RetroFitData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiInterface = retrofit.create(ApiInterface.class);
    }

    public static RetroFitData getInstance(){
        if(Instance == null ){
            Instance = new RetroFitData();
        }
        return Instance;
    }

    public Call<List<Post>> getPosts (){
        return apiInterface.getPost();
    }
/*
    private static final String BASE_URL = "http://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static PostsClient INSTANCE;

    public PostsClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static PostsClient getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new PostsClient();
        }
        return INSTANCE;
    }

    public Call<List<PostModel>> getPosts(){
        return postInterface.getPosts();
    }
*/
}
