package proyecto.anigrud;

import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;

import static org.junit.Assert.assertEquals;

public class CampoNombreAnimal {
    Animal a;
    @Before
    public void setUp() {
        this.a = new Animal();
    }



    @Test
    public void nombreAnimal_correcto(){
        assertEquals(false,a.setNombreAnimal(null));
        assertEquals(false, a.setNombreAnimal(""));
        assertEquals(true, a.setNombreAnimal("perro"));
    }

    @Test
    public void nombreAnimal_correctoGS(){
        assertEquals(true,  a.setNombreAnimal("perro"));
        assertEquals("perro",  a.getNombreAnimal());
    }


}
