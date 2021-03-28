package com.example.agendabd;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import static androidx.interpolator.view.animation.LinearOutSlowInInterpolator.VALUES;

public class ConectorBD {
    static final String NOMBRE_BD = "AgendaLocal";
    private ContactosSQLiteHelper dbHelper;
    private SQLiteDatabase db;
    /*Constructor*/
    public ConectorBD (Context ctx)
    {
        dbHelper = new ContactosSQLiteHelper(ctx, NOMBRE_BD, null, 1);
    }
    /*Abre la conexión con la base de datos*/
    public ConectorBD abrir() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }
    /*Cierra la conexión con la base de datos*/
    public void cerrar()
    {
        if (db != null) db.close();
    }
    /*inserta un contacto en la BD*/
    public void insertarContacto(String nombre, String telefono)
    {
        String consultaSQL = "INSERT INTO contactos VALUES('"+nombre+"','"+telefono+"')";
        db.execSQL(consultaSQL);
    }
    /*devuelve todos los contactos*/
    public Cursor listarContactos()
    {
        return db.rawQuery("SELECT * FROM Contactos", null);
    }
}

