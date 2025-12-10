package com.example.lab23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class FurnitureAdapter extends BaseAdapter {

    Context context;
    ArrayList<Furniture> arrayList;

    public FurnitureAdapter(Context context, ArrayList<Furniture> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        TextView txtName, txtDescription;
        ImageView imgFurniture;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_furniture, parent, false);

            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtDescription = convertView.findViewById(R.id.txtDescription);
            holder.imgFurniture = convertView.findViewById(R.id.imgFurniture);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Furniture f = arrayList.get(pos);
        holder.txtName.setText(f.getName());
        holder.txtDescription.setText(f.getDescription());
        holder.imgFurniture.setImageBitmap(f.getImage());

        return convertView;
    }
}
