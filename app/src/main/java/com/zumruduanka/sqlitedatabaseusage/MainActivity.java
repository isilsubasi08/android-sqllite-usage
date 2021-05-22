package com.zumruduanka.sqlitedatabaseusage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database = this.openOrCreateDatabase("Musicians", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY, name VARCHAR, age INT)");

//            database.execSQL("INSERT INTO musicians (name, age) VALUES ('Osman', 30)");
//            database.execSQL("INSERT INTO musicians (name, age) VALUES ('Işıl', 26)");
//            database.execSQL("INSERT INTO musicians (name, age) VALUES ('Sevgi', 49)");

            // UPDATE
//            database.execSQL("UPDATE musicians SET age = 31 WHERE name = 'Osman'");

            // DELETE
//            database.execSQL("DELETE FROM musicians WHERE id = 2");
            
//            Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name = 'Osman'", null);
            Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE name LIKE 's%'", null);
            int nameIndex = cursor.getColumnIndex("name");
            int ageIndex = cursor.getColumnIndex("age");
            int idIndex = cursor.getColumnIndex("id");

            while(cursor.moveToNext()){
                System.out.println("Name : " + cursor.getString(nameIndex));
                System.out.println("Age : " + cursor.getString(ageIndex));
                System.out.println("Id : " + cursor.getInt(idIndex));
            }
            cursor.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}