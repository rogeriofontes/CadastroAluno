package br.com.unipac;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.unipac.dao.AlunoDAO;
import br.com.unipac.model.Aluno;
import br.com.unipac.ui.adapter.AlunoAdapter;
import br.com.unipac.ui.adapter.AlunoForm;

public class MainActivity extends AppCompatActivity {

    private List<Aluno> alunoList = null;

    private AlunoAdapter alunoAdapter;
    private ListView alunoListView;

    private AlunoDAO alunoDAO = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, AlunoForm.class);
                startActivity(i);
            }
        });

        alunoListView = (ListView) findViewById(R.id.lista_aluno);

        alunoDAO = new AlunoDAO(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        alunoList = alunoDAO.buscarTodos();
        if (!alunoList.isEmpty() && alunoList.size() > 0) {
            alunoAdapter = new AlunoAdapter(alunoList, this);
            alunoListView.setAdapter(alunoAdapter);
        } else {
            Toast.makeText(getApplicationContext(), "Não tem alunos cadastrados" , Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
