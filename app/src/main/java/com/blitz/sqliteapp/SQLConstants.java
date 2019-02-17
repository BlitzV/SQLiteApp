package com.blitz.sqliteapp;

public class SQLConstants {

    //DB
    public static final String DB = "bdlist.db";

    //TABLES
    public static final String TableList = "listas";

    //COLUMNS
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOMBRE = "nombre";
    public static final String COLUMN_PERSONAS = "personas";
    public static final String COLUMN_DESCRIPCION = "descripcion";
    public static final String COLUMN_CARACTERISTICAS = "caracteristicas";
    public static final String COLUMN_IMAGEN = "imagen";
    public static final String COLUMN_FAV = "fav";

    //QUERY
    public static final String SQL_CREATE_TABLE_LISTA = "CREATE TABLE " + TableList + "(" +
            COLUMN_ID + " TEXT PRIMARY KEY," + COLUMN_NOMBRE + " TEXT," + COLUMN_PERSONAS + " INT," +
            COLUMN_DESCRIPCION + " TEXT," + COLUMN_CARACTERISTICAS + " TEXT," + COLUMN_IMAGEN + " TEXT," +
            COLUMN_FAV + " INT" + ");";

    public static final String WHERE_CLAUSE_NOMBRE = "nombre=?";
    public static final String WHERE_CLAUSE_FAVS = "fav=?";
    public static final String WHERE_CLAUSE_PERSONAS = "personas=?";

    public static final String SQL_DELETE = "DROP TABLE " + TableList;


    public static final String[] ALL_COLUMNS = {
            COLUMN_ID, COLUMN_NOMBRE, COLUMN_PERSONAS, COLUMN_DESCRIPCION, COLUMN_CARACTERISTICAS, COLUMN_IMAGEN,
            COLUMN_FAV };

}
