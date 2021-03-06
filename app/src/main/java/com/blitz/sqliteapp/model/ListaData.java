package com.blitz.sqliteapp.model;


import android.content.ContentValues;

import com.blitz.sqliteapp.SQLConstants;

public class ListaData {

    private String id;
    private String nombre;
    private int personas;
    private String descripcion;
    private String caracteristicas;
    private String image;
    private int favoritos;

    public ListaData(){

    }

    public ListaData(String id, String nombre, int personas, String descripcion, String caracteristicas, String image, int favoritos) {
        this.id = id;
        this.nombre = nombre;
        this.personas = personas;
        this.descripcion = descripcion;
        this.caracteristicas = caracteristicas;
        this.image = image;
        this.favoritos = favoritos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPersonas() {
        return personas;
    }

    public void setPersonas(int personas) {
        this.personas = personas;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(int favoritos) {
        this.favoritos = favoritos;
    }

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(7);
        contentValues.put(SQLConstants.COLUMN_ID, id);
        contentValues.put(SQLConstants.COLUMN_NOMBRE, nombre);
        contentValues.put(SQLConstants.COLUMN_PERSONAS, personas);
        contentValues.put(SQLConstants.COLUMN_DESCRIPCION, descripcion);
        contentValues.put(SQLConstants.COLUMN_CARACTERISTICAS, caracteristicas);
        contentValues.put(SQLConstants.COLUMN_IMAGEN, image);
        contentValues.put(SQLConstants.COLUMN_FAV, favoritos);
        return contentValues;
    }
}
