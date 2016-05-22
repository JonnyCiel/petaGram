package co.com.jonny.petagram.vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.jonny.petagram.modelos.Mascota;
import co.com.jonny.petagram.R;
import co.com.jonny.petagram.adaptadores.Adaptador_Mascotas;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasPrincipalesFragment extends Fragment implements Adaptador_Mascotas.myOnclick{

    private RecyclerView mRecyclerView;
    private ArrayList<Mascota> mMascotas = new ArrayList<Mascota>();

    public MascotasPrincipalesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View v = inflater.inflate(R.layout.fragment_mascotas_principales, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.RecyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Adaptador_Mascotas mascotas = new Adaptador_Mascotas(mMascotas, getActivity(), this);

        mMascotas.add(new Mascota("Leo", R.drawable.perro, 5));
        mMascotas.add(new Mascota("Negrita", R.drawable.perro, 7));
        mMascotas.add(new Mascota("Princesa", R.drawable.perro, 7));
        mMascotas.add(new Mascota("Mono", R.drawable.perro, 20));
        mMascotas.add(new Mascota("Huesos", R.drawable.perro, 0));

        mRecyclerView.setAdapter(mascotas);
        return v;
    }

    @Override
    public void onClick(Adaptador_Mascotas.myViewHolder holder, int idMascota) {

    }
}
