package com.example.testing.retro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.testing.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.postVH>{

       private List<Post> posts=new ArrayList<>();
        

public MyAdapter()
        {
        }

    public void setList(List<Post> posts) {
        this.posts = posts;
        notifyDataSetChanged();
    }


class postVH extends RecyclerView.ViewHolder  {

    TextView textViewUserId, textViewTitle;
    


    public postVH(@NonNull View itemView) {

        super(itemView);

        textViewTitle=itemView.findViewById(R.id.postTitle);
        textViewUserId=itemView.findViewById(R.id.user_Id);

    }

   
}


    @NonNull
    @Override
    public postVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_model, parent, false);

        postVH b = new postVH(v);


        return b;
    }


    public void onBindViewHolder(@NonNull postVH holder, int position) {

        holder.textViewTitle.setText(posts.get(position).getTitle());

        holder.textViewUserId.setText(posts.get(position).getUserId()+"");



    }

    @Override
    public int getItemCount() {
        return posts.size();
    }



}
