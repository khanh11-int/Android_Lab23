package com.example.lab23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    public HomeFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);

        arrayList = getMockData();
        furnitureAdapter = new FurnitureAdapter(requireContext(), arrayList);
        listView.setAdapter(furnitureAdapter);

        listView.setOnItemClickListener((adapterView, v, pos, id) -> {
            Utils.furnitureHistory.add(arrayList.get(pos));
            Toast.makeText(getContext(), pos+"", Toast.LENGTH_SHORT).show();
        });
    }

    public ArrayList<Furniture> getMockData() {
        ArrayList<Furniture> tmp = new ArrayList<>();

        tmp.add(new Furniture(
                "Chair",
                "Comfortable black chair",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "chair.png")
        ));

        tmp.add(new Furniture(
                "Sofa",
                "Soft and modern sofa",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "sofa.png")
        ));

        tmp.add(new Furniture(
                "Lamp",
                "Classic decorative lamp",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "lamp.png")
        ));

        tmp.add(new Furniture(
                "Bed",
                "High quality wooden bed",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "bed.png")
        ));

        tmp.add(new Furniture(
                "Table",
                "Luxury wooden table",
                Furniture.convertStringToBitmapFromAccess(requireContext(), "table.png")
        ));

        return tmp;
    }
}
