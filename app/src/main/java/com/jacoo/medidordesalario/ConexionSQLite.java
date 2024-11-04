package com.jacoo.medidordesalario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConexionSQLite extends SQLiteOpenHelper {

    private static final String CREATE_TABLE_USUARIOS = "CREATE TABLE usuarios (id TEXT PRIMARY KEY, email TEXT)";
    private static final String CREATE_TABLE_HORAS = "CREATE TABLE horas_trabajadas (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "fecha TEXT, " +
            "horas_trabajadas TEXT, " +
            "horas_dominicales TEXT, " +
            "horas_extra TEXT, " +
            "pago_por_hora TEXT" +
            ")";

    public ConexionSQLite(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USUARIOS);
        db.execSQL(CREATE_TABLE_HORAS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS usuarios");
        db.execSQL("DROP TABLE IF EXISTS horas_trabajadas");
        onCreate(db);
    }
}
