package com.blitz.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.blitz.sqliteapp.Adapters.ListAdapter;
import com.blitz.sqliteapp.Helpers.DBHelper;
import com.blitz.sqliteapp.model.ListaData;

import java.util.ArrayList;
import java.util.List;

public class Data {
    Context context;
    SQLiteDatabase sqLiteDatabase;
    SQLiteOpenHelper sqLiteOpenHelper;

    public Data (Context context) {
        this.context = context;
        sqLiteOpenHelper = new DBHelper(context);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open() {
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
    public void close() {
        sqLiteOpenHelper.close();
    }

    public long getItemCounts() {
        return DatabaseUtils.queryNumEntries(sqLiteDatabase, SQLConstants.TableList);
    }

    public void insertDataList (ListaData listaData) {
        ContentValues contentValues = listaData.toValues();
        sqLiteDatabase.insert(SQLConstants.TableList, null, contentValues);
    }

    public void insertDataListas(List<ListaData> listaData){
        long items = getItemCounts();
        if (items == 0) {
            for (ListaData lista: listaData){
                try {
                    insertDataList(lista);
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public List<ListaData> getAll(){
        List<ListaData> lista = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TableList,
                SQLConstants.ALL_COLUMNS, null, null, null, null, null );

        while (cursor.moveToNext()){
           ListaData list = new ListaData();
           list.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
           list.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
           list.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
           list.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
           list.setCaracteristicas(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CARACTERISTICAS)));
           list.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGEN)));
           list.setFavoritos(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
           lista.add(list);
        }
        return lista;
    }

    public void deleteItem(String nombre){
        String[] whereArgs = new String[]{String.valueOf(nombre)};
        sqLiteDatabase.delete(SQLConstants.TableList, SQLConstants.WHERE_CLAUSE_NOMBRE,whereArgs);
    }

    public List<ListaData> getFavs(){
        List<ListaData> list = new ArrayList<>();
        String[] whereArgs = new String [] {String.valueOf(1)};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TableList, SQLConstants.ALL_COLUMNS,SQLConstants.WHERE_CLAUSE_FAVS,
                whereArgs, null, null, null);

        while (cursor.moveToNext()){
            ListaData lista = new ListaData();
            lista.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            lista.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            lista.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            lista.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            lista.setCaracteristicas(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CARACTERISTICAS)));
            lista.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGEN)));
            lista.setFavoritos(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            list.add(lista);
        }
        return list;
    }

    public List<ListaData> getPersonas(int p){
        List<ListaData> list = new ArrayList<>();
        String[] whereArgs = new String [] {String.valueOf(p)};
        Cursor cursor = sqLiteDatabase.query(SQLConstants.TableList, SQLConstants.ALL_COLUMNS,SQLConstants.WHERE_CLAUSE_PERSONAS,
                whereArgs, null, null, null);

        while (cursor.moveToNext()){
            ListaData lista = new ListaData();
            lista.setId(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_ID)));
            lista.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_NOMBRE)));
            lista.setPersonas(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_PERSONAS)));
            lista.setDescripcion(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_DESCRIPCION)));
            lista.setCaracteristicas(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_CARACTERISTICAS)));
            lista.setImage(cursor.getString(cursor.getColumnIndex(SQLConstants.COLUMN_IMAGEN)));
            lista.setFavoritos(cursor.getInt(cursor.getColumnIndex(SQLConstants.COLUMN_FAV)));
            list.add(lista);
        }
        return list;
    }

}
