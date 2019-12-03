package proyecto.anigrud.models;

public class Animal {

    private Integer id = null;
    private String nombreAnimal = null;
    private String imagen = null;
    private String especie = null;

    public Animal() {
    }

    public Animal(Integer id, String nombreAnimal, String imagen, String especie) {
        this.id = id;
        this.nombreAnimal = nombreAnimal;
        this.imagen = imagen;
        this.especie = especie;
    }



    public String getNombreAnimal() {
        return nombreAnimal;
    }

    public void setNombreAnimal(String nombreAnimal) {
        this.nombreAnimal = nombreAnimal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
