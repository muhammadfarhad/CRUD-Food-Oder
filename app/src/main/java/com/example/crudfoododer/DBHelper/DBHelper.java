package com.example.crudfoododer.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.crudfoododer.Models.OderModal;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    final static String DBName = "mydatabase.db";
    final static int DBVERSION = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DBName, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(
                "create table orders " +
                        "(id integer primary key autoincrement," +
                        "name text," +
                        "phone text," +
                        "price int," +
                        "image int," +
                        "quantity int," +
                        "description text," +
                        "foodname text)"

        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP table if exists orders");
        onCreate(db);
    }

    public boolean insertOrder(String name, String phone, int price, int image, String desc, String foodName, int quantity) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*    id = 0,
        name = 1,
        phone = 2,
        price = 3 ,
        image = 4  ,
        description = 5 ,
        foodname = 6
        quantity = 7
        */
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodName);
        values.put("quantity", quantity);
        long id = database.insert("orders", null, values);
        if (id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<OderModal> getOrder() {
        ArrayList<OderModal> orders = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select id, foodname, image, price from orders ", null);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                OderModal modal = new OderModal();
                modal.setOderNumber(cursor.getInt(0) + "");
                modal.setOderName(cursor.getString(1));
                modal.setOderImage(cursor.getInt(2));
                modal.setOderPrice(cursor.getInt(3) + "");
                orders.add(modal);
            }
        }
        cursor.close();
        database.close();
        return orders;
    }

    public Cursor getOrderById(int id) {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery("Select * from orders where id = " + id, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public boolean updateOrders(String name, String phone, int price, int image, String desc, String foodName, int quantity, int id) {
        SQLiteDatabase database = getReadableDatabase();
        ContentValues values = new ContentValues();
        /*    id = 0,
        name = 1,
        phone = 2,
        price = 3 ,
        image = 4  ,
        description = 5 ,
        foodname = 6
        quantity = 7
        */
        values.put("name", name);
        values.put("phone", phone);
        values.put("price", price);
        values.put("image", image);
        values.put("description", desc);
        values.put("foodname", foodName);
        values.put("quantity", quantity);
        long row = database.update("orders", values, "id=" + id, null);
        if (row <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public int oderDelete(String id) {
        SQLiteDatabase database = this.getWritableDatabase();
        return database.delete("orders", "id=" + id, null);
    }
}
