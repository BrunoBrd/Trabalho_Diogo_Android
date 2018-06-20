package com.example.bruno.tarefas.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.bruno.tarefas.DAO.UserDao;
import com.example.bruno.tarefas.Modelo.Usuario;
import com.example.bruno.tarefas.R;
import com.example.bruno.tarefas.Services.CadastroUsuario;


public class CadastraUsuarioActivity extends AppCompatActivity {

    private CadastroUsuario cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        cadastro = new CadastroUsuario(this);
    }

    public void cadastre(View view) {

            Usuario usuario = cadastro.bancoUsuario();
            UserDao dao = new UserDao(this);
            dao.cadastra(usuario);
            Toast.makeText(this, "Pronto!", Toast.LENGTH_SHORT).show();
            finish();
    }
}
