package com.blitz.sqliteapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blitz.sqliteapp.Adapters.ListAdapter;
import com.blitz.sqliteapp.model.ListaData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerList;
    ArrayList<ListaData> Listdata;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        recyclerList = (RecyclerView) findViewById(R.id.recyclerList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);
        listAdapter = new ListAdapter(this, Listdata);
        recyclerList.setAdapter(listAdapter);
    }

    public void createData(){
        Listdata = new ArrayList<>();
        Listdata.add(new ListaData("1","objeto", 2, "objento de prueba 1",
                "values a, b, c", "light.jpg",1));
        Listdata.add(new ListaData("2","objeto2", 3, "objento de prueba 2",
                "values a, b, c", "light2.jpg",0));
        Listdata.add(new ListaData("3","objeto3", 6, "objento de prueba 3",
                "values a, b, c", "light3.jpg",4));
        Listdata.add(new ListaData("4","objeto4", 1, "objento de prueba 4",
                "values a, b, c", "light4.jpg",9));
        Listdata.add(new ListaData("5","objeto5", 2, "objento de prueba 5",
                "values a, b, c", "light5.jpg",1));
        Listdata.add(new ListaData("6","objeto6", 3, "objento de prueba 6",
                "values a, b, c", "light6.jpg",0));
        Listdata.add(new ListaData("7","objeto7", 6, "objento de prueba 7",
                "values a, b, c", "light7.jpg",4));
        Listdata.add(new ListaData("8","objeto8", 1, "objento de prueba 8",
                "values a, b, c", "light8.jpg",9));
    }
}
