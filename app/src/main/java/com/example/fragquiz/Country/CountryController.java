package com.example.fragquiz.Country;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class CountryController {
    private DBHelper dbHelper;
    public CountryController(Context context)
    {
        dbHelper = new DBHelper(context);
    }
    public ArrayList<Country> getCountry( String RegionCode)
    {
        ArrayList<Country> listCountry = new ArrayList<Country>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Country where RegionCode = '" +RegionCode + "'" , null);
        cursor.moveToFirst();
        do{
            Country item;
            item = new Country(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3));
            listCountry.add(item);
        } while (cursor.moveToNext());
        return  listCountry;
    }
}
