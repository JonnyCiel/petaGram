package co.com.jonny.petagram.restApi;

import java.util.ArrayList;

import co.com.jonny.petagram.modelos.MascotaJson;

/**
 * Created by Jonny on 21/07/2016.
 */
public class ContactoResponse {

    ArrayList<MascotaJson> mMascotas;

    public ArrayList<MascotaJson> getMascotas() {
        return mMascotas;
    }

    public void setMascotas(ArrayList<MascotaJson> mascotas) {
        mMascotas = mascotas;
    }
}
