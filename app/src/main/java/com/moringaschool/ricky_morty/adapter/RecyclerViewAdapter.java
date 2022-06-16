package com.moringaschool.ricky_morty.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.ricky_morty.R;
import com.moringaschool.ricky_morty.models.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.myHolder> {
    List<Result> list;
    Context context;
    View view;

    public RecyclerViewAdapter(List<Result> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.dispalyitem,parent,false);
        return new myHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.myHolder holder, int position) {
        Picasso.get().load(list.get(position).getImage()).into(holder.mimageview);
        holder.mname.setText(list.get(position).getName());
        holder.mstatus.setText(list.get(position).getStatus());

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class myHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.idIVCourseImage) ImageView mimageview;
        @BindView(R.id.idTVCourseName) TextView mname;
        @BindView(R.id.idTVCourseRating) TextView mstatus;
        public myHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
