package com.patty.proyecto.model;

import java.util.List;

/**
 * Created by eddy on 17-09-17.
 */

public class ResultResponseIngredientes {
    private List<Ingredientes> recipe;

    public ResultResponseIngredientes(List<Ingredientes> recipes) {
        this.recipe = recipe;
    }

    public List<Ingredientes> getRecords() {
        return recipe;
    }

    public void setRecords(List<Ingredientes> recipe) {
        this.recipe = recipe;
    }
}
