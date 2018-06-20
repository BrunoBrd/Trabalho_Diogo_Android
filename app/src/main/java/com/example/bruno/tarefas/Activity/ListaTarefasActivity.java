package com.example.bruno.tarefas.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.bruno.tarefas.DAO.TarefaDao;
import com.example.bruno.tarefas.Modelo.Tarefas;
import com.example.bruno.tarefas.Modelo.Usuario;
import com.example.bruno.tarefas.R;

import java.util.List;

public class ListaTarefasActivity extends AppCompatActivity {

    private void buscaLista() {
        Usuario usuario = new Usuario();
        TarefaDao dao = new TarefaDao(this);
        List<Tarefas> tarefas = dao.buscaTarefas(Integer.toString(usuario.getConsultaID()));

        ListView listaTarefas = findViewById(R.id.lista_tarefa);
        ArrayAdapter<Tarefas> adapter = new ArrayAdapter<Tarefas>(this,  android.R.layout.simple_list_item_1, tarefas);
        listaTarefas.setAdapter(adapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_tarefas);

        buscaLista();
    }

    public void novaTarefa(View view) {
        Intent vaiProCadastro = new Intent(ListaTarefasActivity.this, CadastraTarefasActivity.class);
        startActivity(vaiProCadastro);
    }

    @Override
    protected void onResume() {
        super.onResume();
        buscaLista();

    }

}
