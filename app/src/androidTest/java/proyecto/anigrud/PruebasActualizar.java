package proyecto.anigrud;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;
import proyecto.anigrud.models.AnimalModelo;
import proyecto.anigrud.models.Foto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PruebasActualizar {



    private AnimalModelo repositorio;
    private Animal animal ;
    private Animal animal2 ;



    @Before
    public void setUp(){
        repositorio = AnimalModelo.getInstance( ApplicationProvider.getApplicationContext());
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
    }



    @Test
    public void ActualizarAnimal() {
        this.animal = new Animal();
        animal.setId(1);
        animal.setNombreAnimal("leon");
        animal.setEspecie("felino");
        animal.setLugarFoto("patio");
        animal.setFechaFoto("1/1/2001");
        animal.setAdorable(1);
        animal.setTipo("Mamifero");
        animal.setImagen(null);


        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(true,animal.setNombreAnimal("elefante"));
        assertEquals(true,animal.setEspecie("elefantido"));
        assertEquals(true,animal.setLugarFoto("africa"));
        assertEquals(true,animal.setFechaFoto("1/1/2005"));
        assertEquals(true,animal.setAdorable(0));
        assertEquals(true,animal.setTipo("XXX"));
        animal.setImagen(null);
        assertEquals(1,repositorio.guardarCambios(animal));
        assertEquals("elefante",repositorio.obtenerAnimal(1).getNombreAnimal());
        assertEquals("elefantido",repositorio.obtenerAnimal(1).getEspecie());
        assertEquals("africa",repositorio.obtenerAnimal(1).getLugarFoto());
        assertEquals("1/1/2005",repositorio.obtenerAnimal(1).getFechaFoto());
        assertEquals(new Integer(0), repositorio.obtenerAnimal(1).getAdorable());
        assertEquals("XXX",repositorio.obtenerAnimal(1).getTipo());


    }




    @After
    public void tearDown() {
        repositorio.close();
    }
}
