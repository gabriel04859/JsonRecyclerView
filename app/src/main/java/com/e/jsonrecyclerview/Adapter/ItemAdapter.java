package com.e.jsonrecyclerview.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.e.jsonrecyclerview.DetalhesActivity;
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

        public CardView cardView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgItem = itemView.findViewById(R.id.imgItem);
            txtCreator = itemView.findViewById(R.id.txtCreatNome);
            txtCurtir = itemView.findViewById(R.id.txtDownloads);
            cardView = itemView.findViewById(R.id.cardViewItem);
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
        final Item item = itemArrayList.get(position);
        final String imageUrl = item.getImgUrl();
        final String creatorName = item.getCreator();
        int likeCount = item.getCurtir();

        holder.txtCreator.setText(creatorName);
        holder.txtCurtir.setText("Likes: " + likeCount);
        Picasso.with(context).load(imageUrl).fit().centerInside().into(holder.imgItem);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalhesActivity.class);
                intent.putExtra("imagem", item.getImgUrl());
                intent.putExtra("creatorName", item.getCreator());
                intent.putExtra("likes", item.getCurtir());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }


}
