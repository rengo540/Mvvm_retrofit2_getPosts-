package com.example.testing;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import com.example.testing.retro.ApiInterface;
import com.example.testing.retro.MyAdapter;
import com.example.testing.retro.Post;
import com.example.testing.retro.PostViewModel;
import com.example.testing.retro.RetroFitData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {
TextView title;
RecyclerView recyclerView ;
    PostViewModel postViewModel;
    List<Post> list ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getAllPost();
recyclerView=findViewById(R.id.RecyclerPost);
       final MyAdapter adapter =new MyAdapter();
        recyclerView.setLayoutManager( new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        postViewModel.mutableLiveData.observe(this, new Observer<List<Post>>() {
            @Override
            public void onChanged(List<Post> posts)
            {
                adapter.setList(posts);
            }
        });






/*
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);

        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });

    */







     /*   recyclerView=findViewById(R.id.RecyclerPost);

        adapter=new MyAdapter();

        Call<ArrayList<Post>> call = RetroFitData.getInstance().getPost();
        call.enqueue(new Callback<ArrayList<Post>>() {
            @Override
            public void onResponse(Call<ArrayList<Post>> call, Response<ArrayList<Post>> response) {

                adapter.setList(response.body());

            }
            @Override
            public void onFailure(Call<ArrayList<Post>> call, Throwable t) {

            }
        });


        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager( new LinearLayoutManager(this,RecyclerView.VERTICAL,false));



*/



    }
}


