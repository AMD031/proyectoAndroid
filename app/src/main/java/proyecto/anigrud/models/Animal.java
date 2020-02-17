package proyecto.anigrud.models;

import android.util.Log;

import proyecto.anigrud.Utilidades.Validar;

public class Animal {

    private Integer id = null;
    private String nombreAnimal = null;
    private String imagen = null;
    private String especie = null;
    private String LugarFoto = null;
    private String fechaFoto = null;
    private String tipo = null;
    private Integer adorable =null;

    private final static String imagenDefecto = "iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAQAAAAAYLlVAAAABGdBTUEAALGPC/xhBQAAACBjSFJNAAB6JgAAgIQAAPoAAACA6AAAdTAAAOpgAAA6mAAAF3CculE8AAAAAmJLR0QAAKqNIzIAAAAJcEhZcwAADsQAAA7EAZUrDhsAAAAHdElNRQfkAQ4ONQQzfIYSAAADv0lEQVRo3sWZW2zNSRzHP07pJVotipC4bRsRt6gKkiIh+kDDLk0EDzbxIJuIRDy4bLMvEpdEPLjEkwfiQSREH2x2N5TEZkMOS9GWqNu6bMtxKY2qHsd4MObM6XFOZuY///jNy5zvnPn9Pv+ZM/P/zRxIt5/JZgsZRqiWywumZGmvZ324AD8h2JOxdRg9XAoX4ASC5+RmaN2EQDAuvPBD6EYgqM3Q3oJAsMtfwD69Pm9lBwCttDCYAoroC0AncV7ygSUAxBjJhzCeP8J9hFFZFUZ4qDEML7gQDsDvxgCCSf7DjyFhAbDfP8BW6fo4gxjNduK9QkaZTyHVEjMmf54e7YoMdEy6/jFlRP4iH4AqpS7wETS5DIt5rT494Qz3ibOaCap9DzFKmc5cIlLZya8+n7/CYv6/jpQHi6jaAOu+JX4B7iAs+7b6ANCtwXIKZvsGqExbeNlKve/wAGv4ZBi+idIwAGCdUfi7jAgnPMBFA4C94YWHegOABFW+wkXSlBdGvQ7Jjfk7AcB4Nn9fANjCD+EA/GfYM5+DPgBy0pRcfjHsW04bEKfLB0jSCo03o6/lNr8x0CfCE+sXs+A1a9NSfGc76QAgEJykvx+AjY4AgqifHGGGM4AgSlFwgAhPAyD8YZct53xDE4xhpjN+OXmcDToGswKMgCBBtfSznI885jjz7RFMXsqZSxtD5WSekcopiu0AagMBCI5KP8N5JpUWCWVoEaKBAD4xV3paobTrdot0tvWWnFr+VTvjn0prIM8G4XDAaaiRfsroUto+G4ASp7dCsjQoT3Xa1FTbICwKOAaTpZ98bWu7RT89RE5WgFZGUWFD3Mtech6Aj8RZKLVSHnLN3EUxjwKMQJPyk0e7UpvtnmJxoElI5o27NLXSDuFUAIDVykuZdt+yww5gotXlVWrRE9crSv07KUYMAJo5bUecAp+05DuyMpm+mQDAEWeAsVr9nKoVMNzOTRE9jlOgp+zlmj7NbgQ6aXQcAX3vb9fqKmsyA4AbjgA9Wv0dCVVXG6ApQJPh93qbftIcqO276kLMFOCmI8BdrT5Vqz+yBWh0BNCnbpmqddFm7+qB0yqoUf1H8U6p/7g8i8uBrVMd1gZxQ9M3uADUOQAckH3n0Kyp7/U7NtNTTB5lDtDnmUcFS6lKOTnv5n9bR1NSBjBYiVJgG34Bb72Fv2x/lTHaW/hutmX8RzaLBcuIvpQEV6n79snI5FplJbVMZIjatN7SQQevaCNGjHbeAFBIP0oYQBH59JW3BN108JR7XM98+fcZCjLlf2RYeysAAAAldEVYdGRhdGU6Y3JlYXRlADIwMjAtMDEtMTRUMTQ6NTM6MDQrMDA6MDC7cNncAAAAJXRFWHRkYXRlOm1vZGlmeQAyMDIwLTAxLTE0VDE0OjUzOjA0KzAwOjAwyi1hYAAAABl0RVh0U29mdHdhcmUAd3d3Lmlua3NjYXBlLm9yZ5vuPBoAAAAASUVORK5CYII=";


    public static String getImagenDefecto() {
        return imagenDefecto;
    }

    public Animal() {
    }

    public Animal(Integer id, String nombreAnimal, String imagen, String especie, String lugarFoto, String fechaFoto, String tipo, Integer adorable) {
        this.id = id;
        this.nombreAnimal = nombreAnimal;
        this.setImagen(imagen);
        this.especie = especie;
        this.LugarFoto = lugarFoto;
        this.fechaFoto = fechaFoto;
        this.tipo = tipo;
        this.adorable = adorable;
    }


    public Animal(String nombreAnimal, String imagen, String especie, String lugarFoto, String fechaFoto, String tipo, Integer adorable) {
        this.nombreAnimal = nombreAnimal;
        this.setImagen(imagen);
        this.especie = especie;
        LugarFoto = lugarFoto;
        this.fechaFoto = fechaFoto;
        this.tipo = tipo;
        this.adorable = adorable;
    }

    public boolean setNombreAnimal(String nombreAnimal) {
      boolean valido = false;
       if(Validar.comprobarString(nombreAnimal) && !Validar.contineNumero(nombreAnimal)){
           this.nombreAnimal = nombreAnimal;
           valido = true;
       }
        return  valido;
    }
    public void setImagen(String imagen) {
        if(imagen==null || imagen.isEmpty() || imagen.equals("")  ){
           this.imagen = imagenDefecto;
        }else {
            this.imagen =imagen;
       }
    }
    public boolean setEspecie(String especie ) {
        boolean valido = false;
      if( Validar.comprobarString(especie) &&  !Validar.contineNumero(especie)){
          this.especie = especie ;
          valido = true;
      }
        return valido;
    }
    public boolean setLugarFoto(String lugarFoto) {
        boolean valido = false;
        if(Validar.comprobarString(lugarFoto) && !Validar.contineNumero(lugarFoto)){
            LugarFoto = lugarFoto;
            valido = true;
        }
        return valido;
    }
    public boolean setAdorable(Integer adorable) {
        boolean valido = false;
        if(Validar.ceroUno(adorable)){
            this.adorable = adorable;
            valido = true;
        }
        return valido;
    }
    public boolean setTipo(String tipo) {
        boolean valido = false;
        if(Validar.comprobarString(tipo) && !Validar.contineNumero(tipo)){
            this.tipo = tipo;
            valido = true;
        }
        return valido;
    }
    public boolean setFechaFoto(String fechaFoto) {
        boolean valido = false;
        if(Validar.validarFecha(fechaFoto)){
            this.fechaFoto = fechaFoto;
            valido = true;
        }
        return  valido;
    }

    public String getNombreAnimal() {
        return nombreAnimal;
    }
    public Integer getId() {
        return id;
    }
    public boolean setId(Integer id) {
        boolean valido = false;
       if(id>0){
           this.id = id;
           valido = true;
       }
       return valido;
    }
    public String getImagen() {

        return this.imagen;
    }


    public String getEspecie() {
        return especie;
    }
    public Integer getAdorable() {
        return adorable;
    }
    public String getTipo() {
        return tipo;
    }
    public String getFechaFoto() {
        return fechaFoto;
    }
    public String getLugarFoto() {
        return LugarFoto;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", nombreAnimal='" + nombreAnimal + '\'' +
                ", especie='" + especie + '\'' +
                ", LugarFoto='" + LugarFoto + '\'' +
                ", fechaFoto='" + fechaFoto + '\'' +
                ", tipo='" + tipo + '\'' +
                ", adorable=" + adorable +
                '}';
    }


}
