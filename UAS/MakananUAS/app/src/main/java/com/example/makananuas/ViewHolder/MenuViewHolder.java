package com.example.makananuas.ViewHolder;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.makananuas.R;

public class MenuViewHolder<ItemClickListener> extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView textNamaMenu;
    public ImageView gambarView;
    private ItemClickListener itemClickListener;
    private View view;

    public MenuViewHolder(@NonNull View itemView) {
        super(itemView);
        textNamaMenu = (TextView) itemView.findViewById(R.id.nama_menu);
        gambarView = (ImageView) itemView.findViewById(R.id.menu_gambar);

        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {

    }
}
