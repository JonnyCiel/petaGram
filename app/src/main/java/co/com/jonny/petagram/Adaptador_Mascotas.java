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
public class Adaptador_Mascotas extends RecyclerView.Adapter<Adaptador_Mascotas.myViewHolder>  {

    private ArrayList<Mascota> mMascotas = new ArrayList<Mascota>();
    private Context mContext;
    private myOnclick mMyOnclick;




    public Adaptador_Mascotas(ArrayList<Mascota> mascotas, Context context, myOnclick myOnclick) {
        mMascotas = mascotas;
        mContext = context;
        mMyOnclick = myOnclick;
    }


    interface myOnclick{
        public void onClick(myViewHolder holder, int idMascota);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascotas_lista_detalle, parent, false);

        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {

        final Mascota actual = mMascotas.get(position);

        holder.imagenPerro.setImageDrawable(actual.getImagen());

        holder.huesoRaiting.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hueso_blanco));

        holder.huesoRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.raitingPerro.setText(""+ actual.incRating());
            }
        });

        holder.nombrePerro.setText(actual.getNombre());

        String raiting = Integer.toString(actual.getRaiting());

        holder.raitingPerro.setText(raiting);

    }




    @Override
    public int getItemCount() {
        return mMascotas.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private ImageView imagenPerro;
        private TextView nombrePerro;
        private TextView raitingPerro;
        private ImageView huesoRaiting;
        public myViewHolder(View itemView) {
            super(itemView);

            imagenPerro = (ImageView) itemView.findViewById(R.id.imagen_perro);
            nombrePerro = (TextView) itemView.findViewById(R.id.textView_NombreMascota);
            raitingPerro = (TextView) itemView.findViewById(R.id.textView_Raiting);
            huesoRaiting = (ImageView) itemView.findViewById(R.id.hueso_raiting);
            huesoRaiting.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mMyOnclick.onClick(this, getAdapterPosition());
            notifyDataSetChanged();
        }
    }


}
