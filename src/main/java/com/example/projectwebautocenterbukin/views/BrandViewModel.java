package com.example.projectwebautocenterbukin.views;

public class BrandViewModel {
    private String name; // Имя объекта

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                '}';
    }
}
