package ru.kharina.study.mvchome.models;

public enum WeaponType {
    EDGED("Edged"),
    FIREARMS("Firearms");

    private final String displayValue;

    private WeaponType(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}