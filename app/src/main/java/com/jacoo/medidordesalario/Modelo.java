package com.jacoo.medidordesalario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class Modelo {

    public SQLiteDatabase getConn(Context context){
        ConexionSQlite conn = new ConexionSQlite(context, "dbusuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        return db;
    }

    int insertaUsuario(Context context, UsuariosDTO dto) {
        int res = 0;
        String sql = "INSERT INTO usuarios (id, email) VALUES ('" + dto.getId() + "','" + dto.getEmail() + "')";
        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error para depuración
        } finally {
            db.close(); // Asegúrate de cerrar la base de datos
        }
        return res;
    }




    public boolean loginUsuario(Context context, String id, String email) {
        SQLiteDatabase db = this.getConn(context);
        Cursor cursor = null;
        boolean isValidUser = false;

        try {
            cursor = db.query("usuarios", null, "id=? AND email=?", new String[]{id, email}, null, null, null);
            isValidUser = (cursor != null && cursor.getCount() > 0);
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error para depuración
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return isValidUser;
    }
}
