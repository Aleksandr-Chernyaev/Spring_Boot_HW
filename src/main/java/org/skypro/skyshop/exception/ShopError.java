package org.skypro.skyshop.exception;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class ShopError {
    private final String code;
    private final String message;

    @JsonCreator
    public ShopError(@JsonProperty("code") String code, @JsonProperty("message") String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ShopError{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ShopError)) return false;
        ShopError shopError = (ShopError) o;
        return code.equals(shopError.code) && message.equals(shopError.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, message);
    }
}