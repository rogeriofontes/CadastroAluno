package br.com.unipac.model;

import java.io.Serializable;

public class Aluno implements Serializable {

    public static final String TABLE_NAME = "aluno";

    public static final String ID = "_id";
    public static final String NOME = "nome";
    public static final String EMAIL = "email";
    public static final String TELEFONE = "telefone";

    public static final String DATABASE_CREATE = "create table "
            + TABLE_NAME + "( "
            + ID + " integer primary key autoincrement, "
            + NOME + " text not null, "
            + EMAIL + " text not null, "
            + TELEFONE +" text not null);";

    private Long id;
    private String nome;
    private String email;
    private String telefone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
