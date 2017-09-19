package com.patty.proyecto;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.patty.proyecto.adapters.RecetasAdapter;
import com.patty.proyecto.model.DatosResponse;
import com.patty.proyecto.model.Receta;
import com.patty.proyecto.model.ResultResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements RecetasAdapter.OnRecetaSelectedListener{


    private RecetasAdapter recetasAdapter;

    private SwipeRefreshLayout swipeRefreshLayout;
    private RecyclerView recetasRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recetasRecyclerView = (RecyclerView) findViewById(R.id.recetasRecyclerView);

        recetasRecyclerView.setHasFixedSize(true);
        recetasRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        recetasAdapter = new RecetasAdapter(this, this);

        recetasRecyclerView.setAdapter(recetasAdapter);

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setProgressBackgroundColorSchemeResource(R.color.colorAccent);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Esto se ejecuta cada vez que se realiza el gesto
                cargarDatos();

                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        swipeRefreshLayout.setRefreshing(true);
        cargarDatos();
    }

    private void cargarDatos() {

        // TODO: Hacer el request
        DatosRecetaService service = ServiceGenerator.createService(DatosRecetaService.class);
        Call<ResultResponse> call = service.recetas("ba6dc76995a574cfc1913ea20f2db52c");
        call.enqueue(new Callback<ResultResponse>() {
            @Override
            public void onResponse(Call<ResultResponse> call, Response<ResultResponse> response) {
                swipeRefreshLayout.setRefreshing(false);
                if(response.isSuccessful()){
                    List<Receta> lista = response.body().getRecords();  //devuelve la clase que agarro el json
                    recetasAdapter.setDataset(lista);
                }else{

                }
            }

            @Override
            public void onFailure(Call<ResultResponse> call, Throwable t) {
                swipeRefreshLayout.setRefreshing(false);
            }
        });

    }


    /**
     * Este método se ejecuta cuando se presiona una Unidad Educativa
     */
    @Override
    public void onRecetaSelected(Receta receta) {
        Intent intent = new Intent(this, RecetaActivity.class);
        intent.putExtra("fotoReceta", receta.getImageUrl());
        intent.putExtra("tituloReceta", receta.getTitle());
        intent.putExtra("idReceta", String.valueOf(receta.getRecipeId()));

        startActivity(intent);

    }
}
