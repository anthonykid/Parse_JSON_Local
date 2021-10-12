package com.example.hacktiv8latihan13part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String JSON_STRING ="{\"dataBuku\":{" +
                            "\"judul\":\"Hehehe It's Me MariooooKid\"," +
                            "\"author\":\"AnthonyKid\"," +
                            "\"tahun_terbit\":\"2000\"," +
                            "\"edisi\":\"limited Edition\"," +
                            "\"hargabuku\":{\"diskon\":\"15%\",\"harga\":\"75000\"} "+
                        "}}";

    String judul,author,tahun_terbit,edisi,diskon,harga;
    TextView book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        book = (TextView)findViewById(R.id.tvnama);

        try {
            //get JSONObject from JSON file
            JSONObject obj = new JSONObject(JSON_STRING);
            //fetch object dataBuku
            JSONObject buku = obj.getJSONObject("dataBuku");
            JSONObject innerElement = buku.getJSONObject("hargabuku");

            // get nama
            judul = buku.getString("judul");
            author = buku.getString("author");
            tahun_terbit = buku.getString("tahun_terbit");
            edisi = buku.getString("edisi");
            harga = innerElement.getString("harga");
            diskon = innerElement.getString("diskon");

            book.setText("\nJudul : "+judul);
            book.setText(book.getText()+"\nAuthor : "+author);
            book.setText(book.getText()+"\nTahun Terbit : "+tahun_terbit);
            book.setText(book.getText()+"\nEdisi : "+edisi);
            book.setText(book.getText()+"\nDiskon : "+diskon);
            book.setText(book.getText()+"\nHarga : "+harga);

        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}