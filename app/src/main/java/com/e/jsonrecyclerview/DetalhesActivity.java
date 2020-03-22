package com.e.jsonrecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetalhesActivity extends AppCompatActivity {
    private ImageView imageViewDetalhes;
    private TextView txtNameDetalhes, txtLikesDetalhes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        imageViewDetalhes = findViewById(R.id.imgDetalhes);
        txtNameDetalhes = findViewById(R.id.txtCreatNomeDetalhes);
        txtLikesDetalhes = findViewById(R.id.txtLikesDetalhes);

        String imgUrl = getIntent().getStringExtra("imagem");
        String creatorName = getIntent().getStringExtra("creatorName");
        int likes = getIntent().getIntExtra("likes", 0);

        Picasso.with(DetalhesActivity.this).load(imgUrl).fit().centerInside().into(imageViewDetalhes);
        txtNameDetalhes.setText(creatorName);
        txtLikesDetalhes.setText(String.valueOf(likes));

    }
}
