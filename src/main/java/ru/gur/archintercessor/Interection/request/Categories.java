package ru.gur.archintercessor.Interection.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Categories {
    FRUIT("Фрукт"),
    VEGETABLES("Овощь"),
    MEAT("Мясо"),
    FISH("Рыба");

    private final String label;

    Categories(String label) {
        this.label = label;
    }

    @JsonValue
    public String getLabel() {
        return label;
    }

    @JsonCreator
    public static Categories fromName(String name) {
        for (Categories category : Categories.values()) {
            if (category.name().equals(name) || category.label.equals(name)) {
                return category;
            }
        } return null;
    }
}
