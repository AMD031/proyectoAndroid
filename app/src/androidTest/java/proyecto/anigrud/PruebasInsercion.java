package proyecto.anigrud;

import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import android.content.Context;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.Before;

import static org.junit.Assert.assertEquals;


@RunWith(AndroidJUnit4.class)
public class PruebasInsercion {

    // Repositorio extends SQLiteOpenHelper
    private AnimalModelo repositorio;
    Animal animal ;

    @Before
    public void setUp(){
        this.animal = new Animal();
        animal.setId(500);
        animal.setEspecie("fjkljkl");
        animal.setNombreAnimal("fsdkljlksd");
        animal.setEspecie("ksdjflksjk");
        animal.setLugarFoto("kfdsjkl");
        animal.setFechaFoto("1/1/2001");
        animal.setAdorable(1);
        animal.setTipo("ave");

        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
        repositorio = AnimalModelo.getInstance(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }
    @Test
    public void insertarAnimal(){
        assertEquals(true, repositorio.addNewAnimal(animal));
    }





    @After
    public void tearDown() {
        repositorio.close();
    }


}
