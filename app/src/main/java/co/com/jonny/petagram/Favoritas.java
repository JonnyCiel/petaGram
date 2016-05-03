package co.com.jonny.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity implements Adaptador_Mascotas.myOnclick{

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

        mMascotas.add(new Mascota("Anahi", getResources().getDrawable(R.drawable.perro), 1));
        mMascotas.add(new Mascota("Cielo", getResources().getDrawable(R.drawable.perro), 3));
        mMascotas.add(new Mascota("Sombra", getResources().getDrawable(R.drawable.perro), 6));
        mMascotas.add(new Mascota("Luna", getResources().getDrawable(R.drawable.perro), 2));
        mMascotas.add(new Mascota("Celeste", getResources().getDrawable(R.drawable.perro), 15));

        Adaptador_Mascotas adpter = new Adaptador_Mascotas(mMascotas, this, this);
        mRecyclerView.setAdapter(adpter);
    }

    @Override
    public void onClick(Adaptador_Mascotas.myViewHolder holder, int idMascota) {

    }
}
