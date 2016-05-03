package co.com.jonny.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Adaptador_Mascotas.myOnclick{

    private RecyclerView mRecyclerView;
    private ArrayList<Mascota> mMascotas = new ArrayList<Mascota>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        Adaptador_Mascotas mascotas = new Adaptador_Mascotas(mMascotas, this, this);

        mMascotas.add(new Mascota("Leo", getResources().getDrawable(R.drawable.perro), 5));
        mMascotas.add(new Mascota("Negrita", getResources().getDrawable(R.drawable.perro), 7));
        mMascotas.add(new Mascota("Princesa", getResources().getDrawable(R.drawable.perro), 7));
        mMascotas.add(new Mascota("Mono", getResources().getDrawable(R.drawable.perro), 20));
        mMascotas.add(new Mascota("Huesos", getResources().getDrawable(R.drawable.perro), 0));

        mRecyclerView.setAdapter(mascotas);

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
        if (id == R.id.favoritos_menu) {
            Intent intent = new Intent(this, Favoritas.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(Adaptador_Mascotas.myViewHolder holder, int idMascota) {

    }


}
