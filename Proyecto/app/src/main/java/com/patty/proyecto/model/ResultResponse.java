package com.patty.proyecto.model;

import java.util.List;

/**
 * Created by eddy on 15-09-17.
 */

public class ResultResponse {
    private List<Receta> recipes;

    public ResultResponse(List<Receta> recipes) {
        this.recipes = recipes;
    }

    public List<Receta> getRecords() {
        return recipes;
    }

    public void setRecords(List<Receta> recipes) {
        this.recipes = recipes;
    }
}
