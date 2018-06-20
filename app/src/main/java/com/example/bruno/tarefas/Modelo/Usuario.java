package com.example.bruno.tarefas.Modelo;

public class Usuario {
    private int id;
    private static int consultaID;
    private String usuario;
    private String senha;

    public int getConsultaID() {
        return consultaID;
    }

    public void setConsultaID(int consultaID) {
        this.consultaID = consultaID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

      public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
