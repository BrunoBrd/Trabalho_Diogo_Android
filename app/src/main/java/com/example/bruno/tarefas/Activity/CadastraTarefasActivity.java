package com.example.bruno.tarefas.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.bruno.tarefas.DAO.TarefaDao;
import com.example.bruno.tarefas.Modelo.Tarefas;
import com.example.bruno.tarefas.R;
import com.example.bruno.tarefas.Services.incluirTarefas;

public class CadastraTarefasActivity extends AppCompatActivity {

    private incluirTarefas incluirTarefas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_tarefas);
        incluirTarefas = new incluirTarefas(this);
    }

    public void novo(View view) {
        Tarefas tarefas = incluirTarefas.consultaBancooUser();
        TarefaDao dao = new TarefaDao(this);
        dao.insereTarefa(tarefas);
        finish();
    }
}
