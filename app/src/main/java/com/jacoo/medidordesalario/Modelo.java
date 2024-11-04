package com.jacoo.medidordesalario;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Modelo {

    // Método para obtener una conexión a la base de datos
    public SQLiteDatabase getConn(Context context){
        ConexionSQLite conn = new ConexionSQLite(context, "dbusuarios", null, 2); // Asegúrate de usar la versión correcta
        return conn.getWritableDatabase();
    }

    // Método para insertar un usuario en la tabla "usuarios"
    public int insertaUsuario(Context context, UsuariosDTO dto) {
        int res = 0;
        String sql = "INSERT INTO usuarios (id, email) VALUES ('" + dto.getId() + "','" + dto.getEmail() + "')";
        SQLiteDatabase db = this.getConn(context);
        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception e) {
            Log.e("Modelo", "Error al insertar usuario", e); // Log para facilitar la depuración
        } finally {
            db.close();
        }
        return res;
    }

    // Método para validar el inicio de sesión de un usuario
    public boolean loginUsuario(Context context, String id, String email) {
        SQLiteDatabase db = this.getConn(context);
        Cursor cursor = null;
        boolean isValidUser = false;

        try {
            cursor = db.query("usuarios", null, "id=? AND email=?", new String[]{id, email}, null, null, null);
            isValidUser = (cursor != null && cursor.getCount() > 0);
        } catch (Exception e) {
            Log.e("Modelo", "Error al iniciar sesión", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return isValidUser;
    }

    // Método para insertar registro de horas trabajadas en la tabla "horas_trabajadas"
    public int insertaHorasTrabajadas(Context context, String fecha, String horasTrabajadas, String horasDominicales, String horasExtra, String pagoPorHora) {
        int res = 0;
        String sql = "INSERT INTO horas_trabajadas (fecha, horas_trabajadas, horas_dominicales, horas_extra, pago_por_hora) " +
                "VALUES ('" + fecha + "', '" + horasTrabajadas + "', '" + horasDominicales + "', '" + horasExtra + "', '" + pagoPorHora + "')";
        SQLiteDatabase db = this.getConn(context);

        try {
            db.execSQL(sql);
            res = 1;
        } catch (Exception e) {
            Log.e("Modelo", "Error al insertar horas trabajadas", e);
        } finally {
            db.close();
        }
        return res;
    }

    // Método para obtener el registro de horas de una fecha específica de la tabla "horas_trabajadas"
    public String getHorasTrabajadas(Context context, String fecha) {
        SQLiteDatabase db = this.getConn(context);
        Cursor cursor = null;
        String result = null;

        try {
            cursor = db.query("horas_trabajadas", null, "fecha=?", new String[]{fecha}, null, null, null);
            if (cursor != null && cursor.moveToFirst()) {
                String horasTrabajadas = cursor.getString(cursor.getColumnIndex("horas_trabajadas"));
                String horasDominicales = cursor.getString(cursor.getColumnIndex("horas_dominicales"));
                String horasExtra = cursor.getString(cursor.getColumnIndex("horas_extra"));
                String pagoPorHora = cursor.getString(cursor.getColumnIndex("pago_por_hora"));

                result = "Horas: " + horasTrabajadas + ", Dominicales: " + horasDominicales +
                        ", Extra: " + horasExtra + ", Pago/hora: " + pagoPorHora;
            }
        } catch (Exception e) {
            Log.e("Modelo", "Error al obtener horas trabajadas", e);
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return result;
    }
}
