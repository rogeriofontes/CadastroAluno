package br.com.unipac.ui.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.unipac.MainActivity;
import br.com.unipac.R;
import br.com.unipac.dao.AlunoDAO;
import br.com.unipac.model.Aluno;

public class AlunoForm extends AppCompatActivity {

    private ViewHolder viewHolder = new ViewHolder();

    private AlunoDAO alunoDAO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aluno_form);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AlunoForm.this, MainActivity.class);
                startActivity(i);
            }
        });

        this.viewHolder.nomeEdt = (EditText) findViewById(R.id.nomeEdt);
        this.viewHolder.emailEdt = (EditText) findViewById(R.id.emailEdt);
        this.viewHolder.telefoneEdt = (EditText) findViewById(R.id.telefoneEdt);
        this.viewHolder.salvarBtn = (Button) findViewById(R.id.salvarBtn);

        alunoDAO = new AlunoDAO(this);

        this.viewHolder.salvarBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nome = AlunoForm.this.viewHolder.nomeEdt.getText().toString();
                String email = AlunoForm.this.viewHolder.emailEdt.getText().toString();
                String telefone = AlunoForm.this.viewHolder.telefoneEdt.getText().toString();

                Aluno aluno = criaAluno(nome, email, telefone);
                gravaAluno(aluno);
            }

        });
    }

    public void gravaAluno(Aluno aluno){
        alunoDAO.salvar(aluno);
        Toast.makeText(AlunoForm.this,"Aluno Cadastrado", Toast.LENGTH_LONG).show();
    }

    private Aluno criaAluno(String nome, String email, String telefone) {
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setTelefone(telefone);
        return aluno;
    }

    public static class ViewHolder {
        EditText nomeEdt;
        EditText emailEdt;
        EditText telefoneEdt;
        Button salvarBtn;
        Button listaAlunoBtn;
    }
}
