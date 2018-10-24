package br.unisantos.listadealunos2018;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.widget.AdapterView;

public class ListaAlunosActivity extends AppCompatActivity {
    private ListView listaAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_alunos);
        String[] alunos = {"Anderson", "Filipe",
                "Guilherme"};
        int layout = android.R.layout.simple_list_item_1;

        ArrayAdapter<String> adapter = new
                ArrayAdapter<String>(this, layout, alunos);

        listaAlunos = (ListView)
                findViewById(R.id.lista_alunos);
        listaAlunos.setAdapter(adapter);
        listaAlunos.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent,
                                            View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),
                                "Clique na posição " + position,
                                Toast.LENGTH_SHORT).show();
                    }
                });

        listaAlunos.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {

                    @Override
                    public boolean onItemLongClick(AdapterView<?>
                                                           parent, View view, int position, long id) {
                        Toast.makeText(getApplicationContext(),
                                "Clique em "
                                        + parent.getItemAtPosition(position),
                                Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.menu_novo:
/*
                Toast.makeText(getApplicationContext(),
                        "Você selecionou a opção " +
                                item.getTitle(), Toast.LENGTH_SHORT).
                        show();
*/
                Intent intent = new
                        Intent(this,
                        NovoAlunoActivity.class);

                startActivity(intent);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
