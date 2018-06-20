package com.example.bruno.tarefas.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.example.bruno.tarefas.Services.BancoHelper;
import com.example.bruno.tarefas.Modelo.Tarefas;

import java.util.ArrayList;
import java.util.List;

public class TarefaDao {
    private Context context;

    public TarefaDao(Context context){
            this.context = context;
        }
    public void insereTarefa(Tarefas tarefas) {
        SQLiteDatabase db = BancoHelper.getBDWrite(context);

        ContentValues dados = new ContentValues();
        dados.put("descricao", tarefas.getDescricao());
        dados.put("idUsuario", tarefas.getIdUsuario());

        db.insert("Tarefas", null, dados);
    }

    public List<Tarefas> buscaTarefas(String idUsr) {
        String[] parametro = {idUsr};
        String sql = ("SELECT * FROM Tarefas WHERE idUsuario=?");
        SQLiteDatabase db = BancoHelper.getBDRead(context);
        Cursor c = db.rawQuery(sql,parametro);
        List<Tarefas> tarefas = new ArrayList<Tarefas>();

        while (c.moveToNext()){
            Tarefas tarefa = new Tarefas();
            tarefa.setId(c.getInt(c.getColumnIndex("id")));
            tarefa.setIdUsuario(c.getColumnIndex("idUsuario"));
            tarefa.setDescricao(c.getString(c.getColumnIndex("descricao")));

            tarefas.add(tarefa);
        }

        c.close();
        return tarefas;
    }
}

