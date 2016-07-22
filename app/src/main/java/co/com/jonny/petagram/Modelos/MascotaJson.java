package co.com.jonny.petagram.modelos;

/**
 * Created by Jonny on 02/05/2016.
 */
public class MascotaJson {


    private String idInsta;
    private String Nombre;
    private int Raiting;
    private String urlImagen;


    public MascotaJson() {

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

    public int getRaiting() {
        return Raiting;
    }

    public void setRaiting(int raiting) {
        Raiting = raiting;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getIdInsta() {
        return idInsta;
    }

    public void setIdInsta(String idInsta) {
        this.idInsta = idInsta;
    }
}
