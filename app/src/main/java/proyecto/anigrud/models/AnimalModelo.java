package proyecto.anigrud.models;

import android.app.Person;
import android.util.Log;

import java.util.ArrayList;

public class AnimalModelo {


    public ArrayList<Animal> getAllanimal(){
        ArrayList<Animal> list = new ArrayList<>();

        //Integer id, String nombreAnimal, String imagen, String especie




        Animal a1 = new Animal(1,"gato",null,"felino");
        Animal a2 = new Animal(2,"perro",Foto.fotoperro,"canido");
        Animal a3 = new Animal(3,"elefante",null,"elefantido");

        Animal a4 = new Animal();
        a4.setEspecie("Felino");
        a4.setId(4);
        a4.setImagen(Foto.fotoTigre);
        a4.setNombreAnimal("tigre");

         Animal a5 = new Animal(5,"caiman",null,"reptil");
         Animal a6 = new Animal(6,"leon",Foto.fotoleon,"felino");
         Animal a7 = new Animal(7,"leopardo",null,"felino");
         Animal a8 = new Animal(8,"puma",null,"felino");
         Animal a9 = new Animal(9,"lince",null,"felino");
        Animal a10 = new Animal(10,"caracal",null,"felino");

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);





        return list;
    }



}
