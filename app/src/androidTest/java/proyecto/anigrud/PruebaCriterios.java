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

public class PruebaCriterios {

    private AnimalModelo repositorio;
    private Animal animal ;
    private Animal animal2 ;
    private Animal animal3 ;



    @Before
    public void setUp(){


        this.animal = new Animal();
        animal.setId(1);
        animal.setEspecie("fjkljkl");
        animal.setNombreAnimal("PerroGrande");
        animal.setLugarFoto("kfdsjkl");
        animal.setFechaFoto("1/1/2001");
        animal.setAdorable(1);
        animal.setTipo("canido");
        animal.setImagen(null);

        this.animal2 = new Animal();
        animal2.setId(2);
        animal2.setEspecie("fjkljkl");
        animal2.setNombreAnimal("perroMediano");
        animal2.setLugarFoto("kfdsjkl");
        animal2.setFechaFoto("1/1/2001");
        animal2.setAdorable(1);
        animal2.setTipo("canido");
        animal2.setImagen(Foto.fotoleon);

        this.animal3 = new Animal();
        animal3.setId(3);
        animal3.setEspecie("fjkljkl");
        animal3.setNombreAnimal(" perroMenor");
        animal3.setLugarFoto("kfdsjkl");
        animal3.setFechaFoto("1/1/2005");
        animal3.setAdorable(1);
        animal3.setTipo("Desconocido");
        animal3.setImagen(Foto.fotoleon);



        repositorio = AnimalModelo.getInstance( ApplicationProvider.getApplicationContext());
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
    }



    @Test
    public void CriterioNombreAnimal() {

        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(true, repositorio.addNewAnimal(animal2));
        assertEquals(true, repositorio.addNewAnimal(animal3));
        assertEquals(3 ,repositorio.obtenerAnimalporCriterio("perro","Desconocido","").size());


    }

    @Test
    public void CriterioTipoAnimal(){
        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(true, repositorio.addNewAnimal(animal2));
        assertEquals(true, repositorio.addNewAnimal(animal3));
        assertEquals(2 ,repositorio.obtenerAnimalporCriterio("","canido","").size());
    }



    @Test
    public void Criteriofecha(){
        assertEquals(true, repositorio.addNewAnimal(animal));
        assertEquals(true, repositorio.addNewAnimal(animal2));
        assertEquals(true, repositorio.addNewAnimal(animal3));
        assertEquals(2 ,repositorio.obtenerAnimalporCriterio("","","1/1/2001").size());
    }




    @After
    public void tearDown() {
        repositorio.close();
    }




}
