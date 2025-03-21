package org.skypro.skyshop.model.product;

import java.util.UUID;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 200;

    public FixPriceProduct(String name, UUID id) {
        super(name, id);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + ": Фиксированная цена " + FIXED_PRICE + getPrice();
    }
}