package co.com.jonny.petagram.vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import co.com.jonny.petagram.modelos.BaseDatos;
import co.com.jonny.petagram.modelos.Mascota;
import co.com.jonny.petagram.R;
import co.com.jonny.petagram.adaptadores.Adaptador_Mascotas_Favoritas;

public class Favoritas extends AppCompatActivity implements Adaptador_Mascotas_Favoritas.myOnclick{

    private RecyclerView mRecyclerView;
    private ArrayList<Mascota> mMascotas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarFavoritos);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerViewDetalles);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        BaseDatos db = new BaseDatos(this);
        mMascotas = db.obtenerFavoritas();

        Adaptador_Mascotas_Favoritas adpter = new Adaptador_Mascotas_Favoritas(mMascotas, this, this);
        mRecyclerView.setAdapter(adpter);
    }


    @Override
    public void onClick(Adaptador_Mascotas_Favoritas.myViewHolder holder, int idMascota) {

    }
}
