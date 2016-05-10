package co.com.jonny.petagram;

import android.graphics.drawable.Drawable;

/**
 * Created by Jonny on 02/05/2016.
 */
public class Mascota {

    private String Nombre;
    private Drawable Imagen;
    private int Raiting;

    public Mascota(String nombre, Drawable imagen, int raiting) {
        Nombre = nombre;
        Imagen = imagen;
        Raiting = raiting;
    }

    public Mascota(Drawable imagen, int raiting) {
        Imagen = imagen;
        Raiting = raiting;
    }
    public int incRating(){
        this.Raiting++;
        return this.Raiting;
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Drawable getImagen() {
        return Imagen;
    }

    public void setImagen(Drawable imagen) {
        Imagen = imagen;
    }

    public int getRaiting() {
        return Raiting;
    }

    public void setRaiting(int raiting) {
        Raiting = raiting;
    }
}
