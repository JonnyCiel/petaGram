package co.com.jonny.petagram.adaptadores;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.jonny.petagram.R;
import co.com.jonny.petagram.modelos.MascotaJson;

/**
 * Created by Jonny on 02/05/2016.
 */
public class Adaptador_MascotasPerfil extends RecyclerView.Adapter<Adaptador_MascotasPerfil.myViewHolder>  {

    private ArrayList<MascotaJson> mMascotas = new ArrayList<MascotaJson>();
    private Context mContext;
    private myOnclick mMyOnclick;




    public Adaptador_MascotasPerfil(ArrayList<MascotaJson> mascotas, Context context, myOnclick myOnclick) {
        mMascotas = mascotas;
        mContext = context;
        mMyOnclick = myOnclick;
    }


    public interface myOnclick{
        public void onClick(myViewHolder holder, int idMascota);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalles_perfil_mascota, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        final MascotaJson actual = mMascotas.get(position);

        Picasso.with(mContext)
                .load(actual.getUrlImagen())
                .into(holder.imagenPerro);

        holder.raitingPerro.setText(String.valueOf(actual.getRaiting()));

    }




    @Override
    public int getItemCount() {
        return mMascotas.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imagenPerro;
        private TextView raitingPerro;

        public myViewHolder(View itemView) {
            super(itemView);

            imagenPerro = (ImageView) itemView.findViewById(R.id.imagen_perro);
            raitingPerro = (TextView) itemView.findViewById(R.id.textView_Raiting);

        }

        @Override
        public void onClick(View v) {
            mMyOnclick.onClick(this, getAdapterPosition());
            notifyDataSetChanged();
        }
    }

}
