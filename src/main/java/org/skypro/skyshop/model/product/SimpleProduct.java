package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(String name, int price, boolean b, UUID id) {
        super(name, id);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена должна быть больше 0.");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }
}