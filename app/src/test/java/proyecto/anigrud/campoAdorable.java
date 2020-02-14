package proyecto.anigrud;

import org.junit.Before;

import proyecto.anigrud.models.Animal;

import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;

import static org.junit.Assert.assertEquals;



public class campoAdorable {
    Animal a;
    @Before
    public void setUp() {
        this.a = new Animal();
    }

    @Test
    public void adorable_correcta() {
        assertEquals(true, a.setAdorable(1));
        assertEquals(true, a.setAdorable(0));
        assertEquals(false, a.setAdorable(4));

    }

    @Test
    public void adorable_correctoGS(){
        assertEquals(true, a.setAdorable(0));
        assertEquals(new Integer(0), a.getAdorable());
        assertEquals(true, a.setAdorable(1));
        assertEquals(new Integer(1), a.getAdorable());
    }





}
