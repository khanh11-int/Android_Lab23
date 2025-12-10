package com.example.lab23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriesAdapter extends BaseAdapter {

    Context context;
    ArrayList<Categories> categoriesList;

    public CategoriesAdapter(Context context, ArrayList<Categories> categoriesList) {
        this.context = context;
        this.categoriesList = categoriesList;
    }

    @Override
    public int getCount() {
        return categoriesList.size();
    }

    @Override
    public Object getItem(int i) {
        return categoriesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView imgCategory;
        TextView txtCategoryName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_grid_category, parent, false);

            holder = new ViewHolder();
            holder.imgCategory = convertView.findViewById(R.id.imgCategory);
            holder.txtCategoryName = convertView.findViewById(R.id.txtCategoryName);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Categories category = categoriesList.get(position);

        holder.txtCategoryName.setText(category.getName());
        holder.imgCategory.setImageBitmap(category.getImage());

        return convertView;
    }
}
