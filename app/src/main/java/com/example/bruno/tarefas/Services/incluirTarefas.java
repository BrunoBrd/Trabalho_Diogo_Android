package com.example.bruno.tarefas.Services;

import android.widget.EditText;

import com.example.bruno.tarefas.Activity.CadastraTarefasActivity;
import com.example.bruno.tarefas.Modelo.Tarefas;
import com.example.bruno.tarefas.Modelo.Usuario;
import com.example.bruno.tarefas.R;

public class incluirTarefas {
    private final EditText campoDescricao;


    public incluirTarefas(CadastraTarefasActivity activity) {
        campoDescricao = activity.findViewById(R.id.cadastra_tarefas_descricao);
    }

    public Tarefas consultaBancooUser() {
        Usuario usuario = new Usuario();
        Tarefas tarefas = new Tarefas();
        int idComplementar = usuario.getConsultaID();
        tarefas.setIdUsuario(idComplementar);
        tarefas.setDescricao(campoDescricao.getText().toString());
        return tarefas;
    }
}
