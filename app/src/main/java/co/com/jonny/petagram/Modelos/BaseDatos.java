package co.com.jonny.petagram.modelos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Jonny on 21/05/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    public static final String DBNAME = "favoritos.db";
    public static final int DBVERSION = 1;
    private Context mContext;

    //Tabla

    public static final String TABLE_FAVORITOS = "favoritos";
    public static final String FAVORITOS_ID = "id";
    public static final String FAVORITOS_NOMBRE = "nombre";
    public static final String FAVORITOS_IMAGEN = "imagen";
    public static final String FAVORITOS_RAITING = "raiting";

    public BaseDatos(Context context) {
        super(context, DBNAME, null, DBVERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query = "CREATE TABLE " + TABLE_FAVORITOS + "(" +
                        FAVORITOS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + FAVORITOS_NOMBRE + " TEXT, "
                        + FAVORITOS_IMAGEN + " INTEGER, " + FAVORITOS_RAITING + " INTEGER" + ");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + TABLE_FAVORITOS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerFavoritas(){

        ArrayList<Mascota>  mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + TABLE_FAVORITOS + " ORDER BY " + FAVORITOS_ID + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setImagen(registros.getInt(2));
            mascotaActual.setRaiting(registros.getInt(3));

            mascotas.add(mascotaActual);
        }

        db.close();
        registros.close();

        return mascotas;
    }

    public void AgregarFavorito(ContentValues values){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(TABLE_FAVORITOS, null, values);
        db.close();
    }
}
