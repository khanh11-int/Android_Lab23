package com.example.lab23;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NotificationsFragment extends Fragment {

    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = view.findViewById(R.id.listView);

        // ===============================
        // 1. NẾU LỊCH SỬ TRỐNG → THÊM DỮ LIỆU TEST
        // ===============================
        if (Utils.furnitureHistory.isEmpty()) {
            Utils.furnitureHistory.add(new Furniture(
                    "Test Chair",
                    "Sample history item",
                    Furniture.convertStringToBitmapFromAccess(requireContext(), "chair.png")
            ));

            Utils.furnitureHistory.add(new Furniture(
                    "Test Sofa",
                    "Sample sofa item",
                    Furniture.convertStringToBitmapFromAccess(requireContext(), "sofa.png")
            ));
        }

        // ===============================
        // 2. HIỂN THỊ LÊN LISTVIEW
        // ===============================
        FurnitureAdapter adapter = new FurnitureAdapter(requireContext(), Utils.furnitureHistory);
        listView.setAdapter(adapter);
    }
}
