package com.e.jsonrecyclerview.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.jsonrecyclerview.Model.Item;
import com.e.jsonrecyclerview.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<Item> itemArrayList;

    public ItemAdapter(Context context, ArrayList<Item> itemArrayList ){
        this.context = context;
        this.itemArrayList = itemArrayList;

    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView imgItem;
        public TextView txtCreator, txtCurtir;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.imgItem);
            txtCreator = itemView.findViewById(R.id.txtCreatNome);
            txtCurtir = itemView.findViewById(R.id.txtDownloads);
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Item item = itemArrayList.get(position);
        String imageUrl = item.getImgUrl();
        String creatorName = item.getCreator();
        int likeCount = item.getCurtir();

        holder.txtCreator.setText(creatorName);
        holder.txtCurtir.setText("Likes: " + likeCount);
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imgItem);


    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }


}
