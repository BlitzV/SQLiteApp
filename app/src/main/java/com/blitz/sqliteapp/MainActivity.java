package com.blitz.sqliteapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.blitz.sqliteapp.Adapters.ListAdapter;
import com.blitz.sqliteapp.model.ListaData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerList;
    ArrayList<ListaData> Listdata;
    ListAdapter listAdapter;
    Data data;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createData();
        recyclerList = (RecyclerView) findViewById(R.id.recyclerList);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerList.setLayoutManager(linearLayoutManager);
        //listAdapter = new ListAdapter(this, Listdata);
        // recyclerList.setAdapter(listAdapter);
        update();

        ItemTouchHelper.SimpleCallback simpleCallback =
                new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
                    @Override
                    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                        return false;
                    }

                    @Override
                    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                        int position = viewHolder.getAdapterPosition();
                        ListAdapter listAdapter = (ListAdapter) recyclerList.getAdapter();
                        String value = listAdapter.list.get(position).getNombre();
                        data.deleteItem(value);
                        update();
                    }
                };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerList);
    }

    public void addValues(View view){
        Intent intent = new Intent(MainActivity.this, AddDataActivity.class);
        startActivity(intent);
        finish();
    }

    public void createData(){
        Listdata = new ArrayList<>();
        Listdata.add(new ListaData("1","objeto", 2, "objeto de prueba 1",
                "values a, b, c", "light.jpg",1));
        Listdata.add(new ListaData("2","objeto2", 3, "objeto de prueba 2",
                "values a, b, c", "light2.jpg",0));
        Listdata.add(new ListaData("3","objeto3", 6, "objeto de prueba 3",
                "values a, b, c", "light3.jpg",4));
        Listdata.add(new ListaData("4","objeto4", 1, "objeto de prueba 4",
                "values a, b, c", "light4.jpg",9));
        Listdata.add(new ListaData("5","objeto5", 2, "objeto de prueba 5",
                "values a, b, c", "light5.jpg",1));
        Listdata.add(new ListaData("6","objeto6", 3, "objeto de prueba 6",
                "values a, b, c", "light6.jpg",0));
        Listdata.add(new ListaData("7","objeto7", 6, "objeto de prueba 7",
                "values a, b, c", "light7.jpg",4));
        Listdata.add(new ListaData("8","objeto8", 1, "objeto de prueba 8",
                "values a, b, c", "light8.jpg",9));

        data = new Data(this);
        data.open();
        data.insertDataListas(Listdata);
    }

    public List<ListaData> getData(){
        List<ListaData> list = data.getAll();
        return list;
    }

    public void update(){
        listAdapter = new ListAdapter(this,getData());
        recyclerList.setAdapter(listAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        update();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fav:
                //Toast.makeText(this, "Favoritos", Toast.LENGTH_SHORT).show();
                listAdapter = new ListAdapter(this, data.getFavs());
                recyclerList.setAdapter(listAdapter);
                break;
            case R.id.personas:
                //Toast.makeText(this, "personas", Toast.LENGTH_SHORT).show();
                listAdapter = new ListAdapter(this, data.getPersonas(10));
                recyclerList.setAdapter(listAdapter);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
