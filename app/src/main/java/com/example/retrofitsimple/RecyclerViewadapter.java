package com.example.retrofitsimple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.HashMap;
import java.util.List;

public class RecyclerViewadapter extends RecyclerView.Adapter<RecyclerViewadapter.MyViewHolder> {

    Context context;
    List<Hero> HeroList;

    public RecyclerViewadapter(Context context, List<Hero> heroList) {
        this.context = context;
        HeroList = heroList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view= LayoutInflater.from (context).inflate (R.layout.mrecycler_layoutmovielist,viewGroup,false);

        return new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Hero hero = HeroList.get(i);


        Glide.with(context)
                .load(hero.getImageurl())
                .into(myViewHolder.imageView);
        myViewHolder.textView.setText(hero.getName());
        myViewHolder.textview1.setText ("Created by : "+hero.getCreatedby ());



//        Glide.with (context).load (Hero.getImageurl()).into (myViewHolder.imageView);
//          myViewHolder.textView.setText(Hero.getName());

    }

    @Override
    public int getItemCount() {
        return HeroList.size ();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {


        public ImageView imageView;
        public TextView textView,textview1;

        public MyViewHolder(@NonNull View itemView) {
            super (itemView);
            imageView=itemView.findViewById (R.id.imageView);
            textView=itemView.findViewById (R.id.textView);
            textview1=itemView.findViewById (R.id.textView1);
        }
    }
}
