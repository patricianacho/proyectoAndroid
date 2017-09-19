package com.patty.proyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.patty.proyecto.model.DatosResponseIngredientes;
import com.patty.proyecto.model.Ingredientes;
import com.patty.proyecto.model.Receta;
import com.patty.proyecto.model.ResultResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.patty.proyecto.R.id.swipeRefreshLayout;

/**
 * Created by eddy on 17-09-17.
 */

public class IngredientesActivity extends AppCompatActivity {

    private RecyclerView ingredientesRecyclerView;
    private String idReceta;
    private TextView textView0,textView1,textView2,textView3,textView4,textView5,textView6,textView7,textView8,textView9,textView10;
    private int tamanio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredientes);

        Bundle bundle = getIntent().getExtras();

        idReceta = bundle.getString("idReceta");

        textView0 = (TextView) findViewById(R.id.textView0);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);


        DatosRecetaService service = ServiceGenerator.createService(DatosRecetaService.class);
        Call<DatosResponseIngredientes> call = service.obtenerDetalleReceta("ba6dc76995a574cfc1913ea20f2db52c",idReceta);
        call.enqueue(new Callback<DatosResponseIngredientes>() {
            @Override
            public void onResponse(Call<DatosResponseIngredientes> call, Response<DatosResponseIngredientes> response) {

                Log.i("MIAPP", response.body().getRecipe().getTitle());

                Log.i("MIAPP ------ TAMANO", String.valueOf(response.body().getRecipe().getIngredients().size()));
                tamanio = response.body().getRecipe().getIngredients().size();
                for(int i=0;i<tamanio;i++){
                    if(i==0) textView0.setText(response.body().getRecipe().getIngredients().get(0));
                    if(i==1) textView1.setText(response.body().getRecipe().getIngredients().get(1));
                    if(i==2) textView2.setText(response.body().getRecipe().getIngredients().get(2));
                    if(i==3) textView3.setText(response.body().getRecipe().getIngredients().get(3));
                    if(i==4) textView4.setText(response.body().getRecipe().getIngredients().get(4));
                    if(i==5) textView5.setText(response.body().getRecipe().getIngredients().get(5));
                    if(i==6) textView6.setText(response.body().getRecipe().getIngredients().get(6));
                    if(i==7) textView7.setText(response.body().getRecipe().getIngredients().get(7));
                    if(i==8) textView8.setText(response.body().getRecipe().getIngredients().get(8));
                    if(i==9) textView9.setText(response.body().getRecipe().getIngredients().get(9));
                    if(i==10) textView10.setText(response.body().getRecipe().getIngredients().get(10));
                }
            }

            @Override
            public void onFailure(Call<DatosResponseIngredientes> call, Throwable t) {

            }
        });

    }
}
