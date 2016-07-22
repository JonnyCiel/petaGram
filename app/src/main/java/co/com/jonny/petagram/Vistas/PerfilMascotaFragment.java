package co.com.jonny.petagram.vistas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.jonny.petagram.R;
import co.com.jonny.petagram.adaptadores.Adaptador_MascotasPerfil;
import co.com.jonny.petagram.modelos.MascotaJson;
import co.com.jonny.petagram.restApi.ContactoResponse;
import co.com.jonny.petagram.restApi.EndpointsApi;
import co.com.jonny.petagram.restApi.adapter.RestApiAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment implements Adaptador_MascotasPerfil.myOnclick{

    private RecyclerView mRecyclerView;
    private ArrayList<MascotaJson> mMascotas = new ArrayList<>();
    private ContactoResponse contactoResponse;
    public PerfilMascotaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.RecyclerView_PerfilMascota);
        CircularImageView perfil = (CircularImageView) v.findViewById(R.id.perfil_perro);
        Picasso.with(getActivity())
                .load("https://igcdn-photos-a-a.akamaihd.net/hphotos-ak-xpl1/t51.2885-19/s150x150/13671889_1805413829692072_485301905_a.jpg")
                .into(perfil);

        obtenerMascotasRecientes();




        return v;
    }


    @Override
    public void onClick(Adaptador_MascotasPerfil.myViewHolder holder, int idMascota) {

    }

    public void obtenerMascotasRecientes(){
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construirGsonMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionApiInstagram(gsonMediaRecent);
        Call<ContactoResponse> responseCall = endpointsApi.getRecentMedia();

        responseCall.enqueue(new Callback<ContactoResponse>() {
            @Override
            public void onResponse(Call<ContactoResponse> call, Response<ContactoResponse> response) {
                contactoResponse = response.body();
                mMascotas = contactoResponse.getMascotas();
                RecyclerView.LayoutManager manager = new GridLayoutManager(getActivity(), 3);
                Adaptador_MascotasPerfil mascotasPerfil = new Adaptador_MascotasPerfil(mMascotas, getActivity(), PerfilMascotaFragment.this);
                mRecyclerView.setLayoutManager(manager);
                mRecyclerView.setAdapter(mascotasPerfil);
            }

            @Override
            public void onFailure(Call<ContactoResponse> call, Throwable t) {
                Toast.makeText(getActivity(), "Falló la conexión", Toast.LENGTH_SHORT).show();
                Log.e("retrofit", t.getLocalizedMessage());
            }
        });
    }
}
