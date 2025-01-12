package com.smart.commerce.owner.module.recipe;

import java.util.List;

public interface Recipe {
    void prepare();
    String getName();
    List<String> getIngredients();
}
