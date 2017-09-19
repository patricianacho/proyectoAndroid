package com.patty.proyecto;

import com.patty.proyecto.model.DatosResponse;
import com.patty.proyecto.model.DatosResponseIngredientes;
import com.patty.proyecto.model.Ingredientes;
import com.patty.proyecto.model.Receta;
import com.patty.proyecto.model.ResultResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by eddy on 15-09-17.
 */

public interface DatosRecetaService {
    @GET("api/search")
    Call<ResultResponse> recetas(@Query("key") String resourceId);

    @GET("api/get")
    Call<DatosResponseIngredientes> obtenerDetalleReceta(@Query("key") String resourceId, @Query("rId") String query);

}
