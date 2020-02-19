package proyecto.anigrud;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;

import static org.junit.Assert.assertEquals;

public class PruebaInsersionEliminado {
    private AnimalModelo repositorio;
    private Animal animal ;
    private Animal animal2 ;



    @Before
    public void setUp(){
        repositorio = AnimalModelo.getInstance( ApplicationProvider.getApplicationContext());
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
    }



    @Test
    public void InsercionEliminar() {
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


        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(1, repositorio.getAllData().getCount());
        assertEquals(1,repositorio.eliminarAnimal(1));
    }


    @Test
    public void PruebaEliminadoNoExiste() {
        assertEquals(0, repositorio.getAllData().getCount());
        assertEquals(0,repositorio.eliminarAnimal(330));
    }






    @After
    public void tearDown() {
        repositorio.close();
    }




}
