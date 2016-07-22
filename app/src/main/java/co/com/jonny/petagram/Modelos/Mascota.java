package co.com.jonny.petagram.modelos;

/**
 * Created by Jonny on 02/05/2016.
 */
public class Mascota {

    private int Id;
    private String idInsta;
    private String Nombre;
    private int Imagen;
    private int Raiting;
    private String urlImagen;

    public Mascota(String nombre, int imagen, int raiting) {
        Nombre = nombre;
        Imagen = imagen;
        Raiting = raiting;
    }

    public Mascota(int imagen, int raiting) {
        Imagen = imagen;
        Raiting = raiting;
    }

    public Mascota() {

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

    public int getImagen() {
        return Imagen;
    }

    public void setImagen(int imagen) {
        Imagen = imagen;
    }

    public int getRaiting() {
        return Raiting;
    }

    public void setRaiting(int raiting) {
        Raiting = raiting;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
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
