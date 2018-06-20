package com.example.bruno.tarefas.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bruno.tarefas.DAO.UserDao;
import com.example.bruno.tarefas.Modelo.Usuario;
import com.example.bruno.tarefas.R;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.tela_login);
    }

    public void botaoLogar(View view) {

        EditText usuario = findViewById(R.id.tela_login_usuario);
        EditText senha = findViewById(R.id.tela_login_senha);

        String validaUsuario = usuario.getText().toString();
        String validaSenha = senha.getText().toString();

        UserDao userDao = new UserDao(this);
        int id = userDao.VerificaID(validaUsuario, validaSenha);

        if (id > 0){
            Intent vaiPraLista = new Intent(MainActivity.this, ListaTarefasActivity.class);
            startActivity(vaiPraLista);

            Usuario usr = new Usuario();
            usr.setConsultaID(id);

            Toast.makeText(this, "Usr" + usr.getConsultaID(), Toast.LENGTH_SHORT).show();
            finish();

        }else {
            Toast.makeText(this, "Usuário ou senha Inválidos", Toast.LENGTH_SHORT).show();
        }
    }

    public void cadastre(View view) {
        Intent telaCadastro = new Intent(MainActivity.this, CadastraUsuarioActivity.class);
        startActivity(telaCadastro);
    }
}
