package com.patty.proyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by eddy on 17-09-17.
 */

public class RecetaActivity extends AppCompatActivity {

    private ImageView posterImageView;
    private TextView tituloTextView;

    private String idReceta;
    private String fotoReceta;
    private String tituloReceta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receta);

        posterImageView = (ImageView) findViewById(R.id.posterImageView);
        tituloTextView = (TextView) findViewById(R.id.tituloTextView);

        Bundle bundle = getIntent().getExtras();

        fotoReceta = bundle.getString("fotoReceta");
        tituloReceta = bundle.getString("tituloReceta");
        idReceta = bundle.getString("idReceta");
        tituloTextView.setText(tituloReceta);
        Glide.with(RecetaActivity.this).load(fotoReceta).into(posterImageView);

     }

    public void mostrarIngredientes(View view) {
        Intent intent = new Intent(this, IngredientesActivity.class);
        intent.putExtra("idReceta", idReceta);
        startActivity(intent);
    }

}
