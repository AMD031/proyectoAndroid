package proyecto.anigrud.models;

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

    private final static String imagenDefecto = "iVBORw0KGgoAAAANSUhEUgAAAGAAAABgCAYAAADimHc4AAAABHNCSV" +
            "QICAgIfAhkiAAAAAlwSFlzAAAOxAAADsQBlSsOGwAACCRJREFUeJztnWmMFEUUx3+" +
            "z7Cwr16IiKyACq4sKijdqRKMQE03UaIzGRCRG45F4JHh98IxHYlQ0xOsDxiPxPr5goqAi" +
            "XvFCgzfxgF3xYlFYV11wD2bGD/8dd7btnunqY7qnt39JBWa2uqu6XlV11av33kBKSkpKSkpKS" +
            "kpKkGTcZBoRdi0i5CCgF+iJqPwrgBzwa0TlR85LwD0RlT0Z6ARei6j8yJmNel8PsH8E5T8FFAbqMD+C" +
            "8iPnIdQABWBVlcueD+woKf91XL4PksJ4oIvBBsgDZ1Sp7CzwVUnZxVEwt0rlx4KLGNoABaAdGFOFsq9FA" +
            "reW/1QVyo4N7/L/BigAt4Zc7jTgT4eye4DmkMuPBS0MnX9LUzewl4t71KNprBmYCOwCNLi47nmHcovpSoPnqFkW" +
            "U74Rlg/kawAOAS4BHkTLxW/QuyPvkP4GvgVWAkuAMxns1Seiub5c2Z+F8sQx403KN0IeWAFsxn6uNk29wNtAm4u8O4B9wn" +
            "v06BmN5lq/jRpmutpa6boAGyBqjsbdXB0lJ1i/SJIAjiD+G565QGPpF0kSwKFRV8AFTcDM0i+SJID9oq6ACzLAAaVfJEUAjUgD" +
            "WQu0ln5IigB2xjK3xphJpR+SIoCx1M7h0i6lH+qjqkXANFJ5BZQHOoDfkGJuGtJe+qEP2AhsQ7vi3V3Uw2+ZsWQWzpufDuBmtAstjpIM" +
            "sCdwP5VVCE672iXAlJI61KOFwG1op+107QvBPno8mIZ9Qy5BO+RyXORwbbnGP7fCPccADzhcv6w0Y1LeAX8gvYyVdWh6KMcy4BmDsh4FnqiQpxs" +
            "p9+z40aCsmsJOIfayy2v3xt0o6EGjzQ1vOtzjdJfX1xwv8v+H7cO9BvIDm+ut6Q2X9zoQ6Le5vp+h743ETEEAb9l8lwXucHn9OwHlqRso026F+TkWO6EkCW" +
            "A5WmpaOQ2d1VbC7h3iJc9N6IDGjmfQSEgsK7CfOvLoxTmbwZ45Ei1frwG+xN0BTR74FJ287cOg+jsLzAGeK3OfP4Bdw3joOLGA8g1Z3Iy1AVsr5HUjjC0D93Jzw" +
            "mZrFBCG/nw8cDCwLzAVSX2ngb9tRw/+C7Ae9bxNAZadQSufkwK8ZxCsR7aqlZbEnsig4Xc7sBZtVNwO5zzwE/AksIhgTDdmoJ7ptWcHnboJyTBrBLI4ew9v23mndfZK4B" +
            "xglI+6nYL9MrDaqQ8428dzODIPWEMwlgVOqQONKq+j4kKiFUIvsNBj3R1pBJbibPwURtoG3IuMpEw5C9nzVLvxfwaO81DfskzG3W4xrNSJ1vOmBy9z0LupGnXMofdZ4GaIL" +
            "ehNHlXjl6Z1wPGG9W9AHisdIdUpj8zQ5xnWyxWTcWf5Vc2UQz4A4wyfZRRwMfAx/qfR4gruPjTKQmEnop12KqVvcF7iTcfGEKqEVuBS4NmB+2yvUFbRNvQFtHs+nCqcKC6tUK" +
            "k4pH+Ayxm6qbwAGdrmkJZ0iCWCDRl0cDMdOAy9QBcAx6AN1BT8LYs9MY94rKXdTgdPI/PzolKu9O99yEniSMJRQE4CriJA26QMWudH3bCmqVKHySMXoluBo/BuytKAdP6LkQ9a0" +
            "Sj4FtMbOemCTkZunnG3tfRDAfgL6aO+AjYgHVUn2nvkkMZ0NDABLUZmoF4+C9kiWdvnQyRY36wi+t5ci6mPQcWjK+zmw+nAsSY3SfmPLJqaXGMngJNJqPFQlZhlktlOAMPSsztA" +
            "WkwyWwVQh5zXUryzh0lmqwDGUjtm3nFlgklmqwCaSed/vzSZZLYKwOjiFFuMVBZWAdSKjX2cMWpDqwD+CbAiw5WCSWarAIrWBCneMQqRZhVAJzKjSPGOke2P3RTUFlxdhiVdJpnt" +
            "dsKfBFSR4crvJpntBPBWMPUYtnSYZLYTwOtEF2szCRi5INkJYDOKgZPijXaTzE7no4+RLke98p1JZqcjxyxaDRlp9lLoQkeVrnEaAf1EF/a3lvnC9IJyJhoPk2Cf1pBYa3pBOQFsA24" +
            "gfReY8FHQN6wDVhO9tUEtpBwyaDDCjd1PK/JvdTK3yCG7yeHORnSca+cq65vrcZZ8Pwl2v48LI5GOyEkI3Zjb7KcYMpvy7j5/I+e4lBBZSHmPyH7gRpITiSt0vBjf3okcFMpd+z6yH" +
            "F7jpVKGZFActmZkUjMJmYaMQ4a1WQY7Rzc6dNqEdDbtGOrvg8aLAEagoEWLKuTbAbyCIketRiPHD6NQfIaZJf+2oqVfEzIZN3meAnIlbUdeQG8AryJP/qrh1fy8HngEhe6qdI8CCpS" +
            "3Cj3oOuRbtRX1StB+YzTSozQjj5SpyMyvBTV2Mc5OWCbzBdRpVgOPI0ePWBsp1AF3491LPo96YK+Pe4SZfgGuowZspRbi/NMdSUgdwGXE3GJwBpo/wwxdEGUqxgk6LKgGKxLkfJpB+4Cb" +
            "Ubiaaro3FZDysAsdinehUbkdTW9Z9BLfGQVXnYhWSaZ17EV+YHfhf1EBHirghjrkY3A+EkhQPx9VQEvI9ejUacPA/39AephOdJbtRhfTiARxIPLpWoD0OG48KAsoJlFx6vVF2L10JHJ3msdgEKfm" +
            "ge/r0QMXUG/qRw24BQW7+AmdyrWhhv6ecJeIe6IwOReipW2ltvkaOJUatKPKoihaU1AMzqlIKGOJh1dmA3Ae2h9Uejf8SDS/VTksGIPm+koxJX5FoyclJOajRi4nhOWOV6cEwnR04O4kgF5gt6gqN1zYF" +
            "efATzncx5RO8cEEtCGzCuBjkhWFONY0oTA+m1CsiZV4OIxP8U8Ww7gQKSkpKTHjX5XP+kFNUfLZAAAAAElFTkSuQmCC";


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
       if(Validar.comprobarString(nombreAnimal)){
           this.nombreAnimal = nombreAnimal;
           valido = true;
       }
        return  valido;
    }
    public void setImagen(String imagen) {
        if(imagen==null || imagen.isEmpty() || imagen.equals("") ){
            this.imagen = imagenDefecto;
        }else {
            this.imagen =imagen;
        }

    }
    public boolean setEspecie(String especie) {
        boolean valido = false;
      if( Validar.comprobarString(especie)){
          this.especie = especie ;
          valido = true;
      }
        return valido;
    }
    public boolean setLugarFoto(String lugarFoto) {
        boolean valido = false;
        if(Validar.comprobarString(lugarFoto)){
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
        if(Validar.comprobarString(tipo)){
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
    public void setId(Integer id) {
        this.id = id;
    }
    public String getImagen() {
        return imagen;
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
