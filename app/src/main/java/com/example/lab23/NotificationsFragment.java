package com.example.lab23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {

    ListView listView;
    ArrayList<Furniture> arrayList;
    FurnitureAdapter furnitureAdapter;
    public NotificationsFragment() {
// Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);

        Utils utils = new Utils();
        arrayList = utils.getFurnitureHistory();

        furnitureAdapter = new FurnitureAdapter(requireContext(), arrayList);
        listView.setAdapter(furnitureAdapter);

        listView.setOnItemClickListener((a, v, i, l) -> {
            utils.addFurnitureHistory(arrayList.get(i));
        });
    }

}
