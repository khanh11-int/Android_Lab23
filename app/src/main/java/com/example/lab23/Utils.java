package com.example.lab23;

import java.util.ArrayList;

public class Utils {

    public static ArrayList<Furniture> furnitureHistory = new ArrayList<>();

    public void addFurnitureHistory(Furniture furniture){
        furnitureHistory.add(0, furniture);
    }

    public ArrayList<Furniture> getFurnitureHistory(){
        return furnitureHistory;
    }
}
