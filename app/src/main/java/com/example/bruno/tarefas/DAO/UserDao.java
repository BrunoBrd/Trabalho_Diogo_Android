package com.example.bruno.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.bruno.tarefas.Services.BancoHelper;
import com.example.bruno.tarefas.Modelo.Usuario;

public class UserDao {
    private Context context;

    public UserDao(Context context){
        this.context = context;
    }

    public void cadastra(Usuario usuario) {
        SQLiteDatabase db = BancoHelper.getBDWrite(context);

        ContentValues dados = new ContentValues();
        dados.put("usuario", usuario.getUsuario());
        dados.put("senha", usuario.getSenha());

        db.insert("Usuarios", null, dados);
    }

    public int VerificaID(String usuario, String senha) {
        SQLiteDatabase db = BancoHelper.getBDRead(context);
        String[] params = {usuario, senha};
        try {
            int i = 0;
            Cursor c = null;
            c = db.rawQuery("select * from Usuarios where usuario=? and senha=?", params);
            c.moveToFirst();
            i = c.getInt(c.getColumnIndex("id"));
            c.close();
            return i;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
