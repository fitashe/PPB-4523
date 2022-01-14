package com.example.makananuas.ViewHolder;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amulyakhare.textdrawable.TextDrawable;
import com.example.makananuas.Database.Order;
import com.example.makananuas.Interface.ItemClickListener;
import com.example.makananuas.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView nama_cart , harga_cart;
    public ImageView img_cart_count;

    public ItemClickListener itemClickListener;

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);

        nama_cart = (TextView)itemView.findViewById(R.id.cart_name);
        harga_cart = (TextView)itemView.findViewById(R.id.cart_price);
        img_cart_count = (ImageView)itemView.findViewById(R.id.cart_count);

    }

    @Override
    public void onClick(View v) {

    }
}

public class CardAdapter extends RecyclerView.Adapter<CardViewHolder>{

    private List<Order> list_data = new ArrayList<>();
    private Context context;

    public CardAdapter(List<Order> listData, Context context) {
        this.list_data = listData;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.cart_layout,parent,false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        TextDrawable drawable = TextDrawable.builder()
                .buildRound(""+list_data.get(position).getQuantity(), Color.RED);
        holder.img_cart_count.setImageDrawable(drawable);

        Locale locale = new Locale("en","US");
        NumberFormat fmt = NumberFormat.getCurrencyInstance(locale);
        int proce = (Integer.parseInt(list_data.get(position).getPrice()))*(Integer.parseInt(list_data.get(position).getQuantity()));
        holder.harga_cart.setText(fmt.format(proce));

        holder.nama_cart.setText(list_data.get(position).getProductName());
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }
}
