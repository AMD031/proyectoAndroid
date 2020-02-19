package proyecto.anigrud;

import proyecto.anigrud.Utilidades.Image;
import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.models.Foto;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;
import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class PruebasInsercion {

    private AnimalModelo repositorio;
    private Animal animal ;
    private Animal animal2 ;



    @Before
    public void setUp(){
        repositorio = AnimalModelo.getInstance( ApplicationProvider.getApplicationContext());
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
    }



    @Test
    public void Insercion() {
        this.animal = new Animal();
        animal.setId(1);
        animal.setEspecie("fjkljkl");
        animal.setNombreAnimal("fsdkljlksd");
        animal.setEspecie("ksdjflksjk");
        animal.setLugarFoto("kfdsjkl");
        animal.setFechaFoto("1/1/2001");
        animal.setAdorable(1);
        animal.setTipo("ave");
        animal.setImagen(null);

        this.animal2 = new Animal();
        animal2.setId(2);
        animal2.setEspecie("fjkljkl");
        animal2.setNombreAnimal("fsdkljlksd");
        animal2.setEspecie("ksdjflksjk");
        animal2.setLugarFoto("kfdsjkl");
        animal2.setFechaFoto("1/1/2001");
        animal2.setAdorable(1);
        animal2.setTipo("ave");
        animal2.setImagen(Foto.fotoleon);

        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(1, repositorio.getAllData().getCount());
        assertEquals(true, repositorio.addNewAnimal(animal2));
        assertEquals(2, repositorio.getAllData().getCount());
    }

    @Test
    public void InsercionAnimalIncorrecto() {
        this.animal = new Animal();
        animal.setId(1);
        animal.setEspecie("fjkljkl");
        animal.setNombreAnimal("fsdkljlksd");
        animal.setEspecie("ksdjflksjk");
        animal.setLugarFoto("kfdsjkl");
        animal.setFechaFoto("1/13/2001");
        animal.setAdorable(4);
        animal.setTipo("ave");
        //animal.setImagen(null);



        assertEquals(false, repositorio.addNewAnimal(animal));
        assertEquals(0, repositorio.getAllData().getCount());

    }





    @After
    public void tearDown() {
        repositorio.close();
    }


}
