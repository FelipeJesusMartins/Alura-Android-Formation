package com.jesus.ceep.ui.activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import com.jesus.ceep.R;
import com.jesus.ceep.dao.NotaDAO;
import com.jesus.ceep.model.Nota;
import com.jesus.ceep.ui.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for (int i = 0; i < 10000; i++) {
        dao.insere(new Nota("Nota "+ (i+1), "Primeira descrição"));
        }
        List<Nota> todasNotas = dao.todos();

        //listaNotas.setAdapter(new ListaNotasAdapter());
    }
}