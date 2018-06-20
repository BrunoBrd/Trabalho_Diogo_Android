package com.example.bruno.tarefas.Services;
import android.widget.EditText;

import com.example.bruno.tarefas.Activity.CadastraUsuarioActivity;
import com.example.bruno.tarefas.Modelo.Usuario;
import com.example.bruno.tarefas.R;

public class CadastroUsuario {

    private final EditText campoUsuario;
    private final EditText campoSenha;

    public CadastroUsuario(CadastraUsuarioActivity activity) {
        campoUsuario = activity.findViewById(R.id.cadastro_usuario);
        campoSenha = activity.findViewById(R.id.cadastro_senha);
    }

    public Usuario bancoUsuario() {
        Usuario usuario = new Usuario();
        usuario.setUsuario(campoUsuario.getText().toString());
        usuario.setSenha(campoSenha.getText().toString());
        return usuario;
    }
}
