package com.example.lab23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    GridView gridView;
    ArrayList<Categories> categoriesArrayList;
    CategoriesAdapter adapter;
    public DashboardFragment() {}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = view.findViewById(R.id.gridView);

        categoriesArrayList = getMockCategories();
        adapter = new CategoriesAdapter(requireContext(), categoriesArrayList);
        gridView.setAdapter(adapter);
    }

    private ArrayList<Categories> getMockCategories() {

        ArrayList<Categories> tmp = new ArrayList<>();

        // ========= FURNITURE LISTS FOR EACH CATEGORY =========

        // Category 1: Chairs
        ArrayList<Furniture> chairs = new ArrayList<>();
        tmp.add(new Categories("Chairs", chairs,
                Categories.convertStringToBitmapFromAccess(requireContext(), "chair.png")));


        // Category 2: Sofas
        ArrayList<Furniture> sofas = new ArrayList<>();
        sofas.add(new Furniture("Luxury Sofa", "Brown velvet sofa",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "sofa.png")));
        sofas.add(new Furniture("Classic Sofa", "Beautiful traditional sofa",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "sofa.png")));

        tmp.add(new Categories("Sofas", sofas,
                Categories.convertStringToBitmapFromAccess(requireContext(), "sofa.png")));


        // Category 3: Lamps
        ArrayList<Furniture> lamps = new ArrayList<>();
        lamps.add(new Furniture("Desk Lamp", "White modern lamp",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "lamp.png")));
        lamps.add(new Furniture("Floor Lamp", "Tall elegant lamp",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "lamp.png")));

        tmp.add(new Categories("Lamps", lamps,
                Categories.convertStringToBitmapFromAccess(requireContext(), "lamp.png")));


        // Category 4: Beds
        ArrayList<Furniture> beds = new ArrayList<>();
        beds.add(new Furniture("King Size Bed", "Wood frame",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "bed.png")));
        beds.add(new Furniture("Single Bed", "Comfortable soft bed",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "bed.png")));

        tmp.add(new Categories("Beds", beds,
                Categories.convertStringToBitmapFromAccess(requireContext(), "bed.png")));


        // Category 5: Tables
        ArrayList<Furniture> tables = new ArrayList<>();
        tables.add(new Furniture("Dining Table", "6 seats",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "table.png")));
        tables.add(new Furniture("Coffee Table", "Small wooden table",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "table.png")));

        tmp.add(new Categories("Tables", tables,
                Categories.convertStringToBitmapFromAccess(requireContext(), "table.png")));

        return tmp;
    }
}
