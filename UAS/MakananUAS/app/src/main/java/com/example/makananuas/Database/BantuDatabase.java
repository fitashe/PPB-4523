package com.example.makananuas.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class BantuDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME="BantuDatabase.db";
    private static final int DATABASE_VER=1;

    public BantuDatabase(Context context) {

        super(context, DATABASE_NAME,null, DATABASE_VER);
    }

    public List<Order> getCarts()
    {
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb =  new SQLiteQueryBuilder();

        String[] sqlSelect = {"ProductName","ProductId","Quantity","Price","Discount"};
        String sqlTable = "OrderDetail";

        qb.setTables(sqlTable);
        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);

        final List<Order> result = new ArrayList<>();
        if(c.moveToFirst())
        {
            do {
                result.add(new Order(c.getString(c.getColumnIndexOrThrow("ProductId")),
                        c.getString(c.getColumnIndexOrThrow("ProductName")),
                        c.getString(c.getColumnIndexOrThrow("Quantity")),
                        c.getString(c.getColumnIndexOrThrow("Price")),
                        c.getString(c.getColumnIndexOrThrow("Discount"))
                ));
            }
            while (c.moveToNext());
        }
        return  result;
    }

    public void addToCart(Order order)
    {
        SQLiteDatabase db = getReadableDatabase();
        String query =  String.format("INSERT INTO OrderDetail(ProductId,ProductName,Quantity,Price,Discount) VALUES ('%s','%s','%s','%s','%s');",
                order.getProductId(),
                order.getProductName(),
                order.getQuantity(),
                order.getPrice(),
                order.getDiscount()
        );
        db.execSQL(query);
    }

    public void cleanCart()
    {
        SQLiteDatabase db = getReadableDatabase();
        String query =  String.format("DELETE FROM OrderDetail");
        db.execSQL(query);
    }
}
