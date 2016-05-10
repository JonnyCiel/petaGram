package co.com.jonny.petagram;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jonny on 02/05/2016.
 */
public class Adaptador_MascotasPerfil extends RecyclerView.Adapter<Adaptador_MascotasPerfil.myViewHolder>  {

    private ArrayList<Mascota> mMascotas = new ArrayList<Mascota>();
    private Context mContext;
    private myOnclick mMyOnclick;




    public Adaptador_MascotasPerfil(ArrayList<Mascota> mascotas, Context context, myOnclick myOnclick) {
        mMascotas = mascotas;
        mContext = context;
        mMyOnclick = myOnclick;
    }


    interface myOnclick{
        public void onClick(myViewHolder holder, int idMascota);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detalles_perfil_mascota, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        final Mascota actual = mMascotas.get(position);

        holder.imagenPerro.setImageDrawable(actual.getImagen());

        String raiting = Integer.toString(actual.getRaiting());

        holder.raitingPerro.setText(raiting);

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
