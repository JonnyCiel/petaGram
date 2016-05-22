package co.com.jonny.petagram.vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import co.com.jonny.petagram.modelos.Mascota;
import co.com.jonny.petagram.R;
import co.com.jonny.petagram.adaptadores.Adaptador_MascotasPerfil;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment implements Adaptador_MascotasPerfil.myOnclick{

    private RecyclerView mRecyclerView;
    private ArrayList<Mascota> mMascotas = new ArrayList<>();
    public PerfilMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.RecyclerView_PerfilMascota);

        mMascotas.add(new Mascota(R.drawable.perro, 5));
        mMascotas.add(new Mascota(R.drawable.perro, 8));
        mMascotas.add(new Mascota(R.drawable.perro, 15));
        mMascotas.add(new Mascota(R.drawable.perro, 20));
        mMascotas.add(new Mascota(R.drawable.perro, 3));
        mMascotas.add(new Mascota(R.drawable.perro, 11));
        mMascotas.add(new Mascota(R.drawable.perro, 0));
        mMascotas.add(new Mascota(R.drawable.perro, 69));
        mMascotas.add(new Mascota(R.drawable.perro, 7));
        mMascotas.add(new Mascota(R.drawable.perro, 24));
        mMascotas.add(new Mascota(R.drawable.perro, 30));
        mMascotas.add(new Mascota(R.drawable.perro, 10));

        RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 3);
        Adaptador_MascotasPerfil mascotasPerfil = new Adaptador_MascotasPerfil(mMascotas, getActivity(), this);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mascotasPerfil);


        return v;
    }


    @Override
    public void onClick(Adaptador_MascotasPerfil.myViewHolder holder, int idMascota) {

    }
}
