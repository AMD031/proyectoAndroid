package proyecto.anigrud.models;

import android.app.Person;
import android.util.Log;

import java.util.ArrayList;

public class AnimalModelo {



    public ArrayList<Animal> getAllanimal(){
        ArrayList<Animal> list = new ArrayList<>();

        //Integer id, String nombreAnimal, String imagen, String especie
        Animal a1 = new Animal(1,"gato","c:","felino");
        Animal a2 = new Animal(2,"perro","c:","canido");
        Animal a3 = new Animal(3,"elefante","c:","elefantido");
        list.add(a1);
        list.add(a2);
        list.add(a3);



        return list;
    }



}
