package co.com.jonny.petagram.adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import co.com.jonny.petagram.modelos.Mascota;
import co.com.jonny.petagram.R;

/**
 * Created by Jonny on 02/05/2016.
 */
public class Adaptador_Mascotas_Favoritas extends RecyclerView.Adapter<Adaptador_Mascotas_Favoritas.myViewHolder>  {

    private ArrayList<Mascota> mMascotas = new ArrayList<Mascota>();
    private Context mContext;
    private myOnclick mMyOnclick;




    public Adaptador_Mascotas_Favoritas(ArrayList<Mascota> mascotas, Context context, myOnclick myOnclick) {
        mMascotas = mascotas;
        mContext = context;
        mMyOnclick = myOnclick;
    }


   public interface myOnclick{
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

        holder.imagenPerro.setImageResource(actual.getImagen());

        holder.huesoRaiting.setImageDrawable(mContext.getResources().getDrawable(R.drawable.hueso_blanco));

        holder.huesoRaiting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext)
                        .setTitle("Ya es favorita")
                        .setMessage("Ya has indicado que esta mascota es favorita")
                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                builder.show();
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
