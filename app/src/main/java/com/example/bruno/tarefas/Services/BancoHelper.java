package com.example.bruno.tarefas.Services;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoHelper extends SQLiteOpenHelper {
    static BancoHelper instance;

    public BancoHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    private static BancoHelper getInstance(Context context) {
        if(instance == null) {
            instance = new BancoHelper(context, "Aplicativo", null,1);
        }
        return instance;
    }

    public static SQLiteDatabase getBDRead(Context context){
        return getInstance(context).getReadableDatabase();
    }

    public static SQLiteDatabase getBDWrite(Context context){
        return getInstance(context).getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE TAREFAS (id INTEGER PRIMARY KEY, descricao TEXT NOT NULL, " +
                "idUsuario INTEGER , FOREIGN KEY(idUsuario) REFERENCES Usuarios(id));";
        db.execSQL(sql);
        sql = "CREATE TABLE Usuarios (id INTEGER PRIMARY KEY, usuario TEXT NOT NULL, senha TEXT NOT NULL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
