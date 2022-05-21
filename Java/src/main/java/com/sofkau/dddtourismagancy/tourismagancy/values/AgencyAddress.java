package com.sofkau.dddtourismagancy.tourismagancy.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class AgencyAddress implements ValueObject<String> {
    private final String value;

    public AgencyAddress(String value) {
        this.value = Objects.requireNonNull(value);
        if(this.value.isBlank()){
            throw new IllegalArgumentException("The value can't be blank.");
        }
        if(this.value.length() < 1){
            throw new IllegalArgumentException("The value must have at least one character.");
        }
        if(this.value.length() >= 50){
            throw new IllegalArgumentException("The value must have at most fifty characters.");
        }
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AgencyAddress that = (AgencyAddress) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
