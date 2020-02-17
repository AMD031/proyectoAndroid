package proyecto.anigrud;

import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;

import static org.junit.Assert.assertEquals;

public class campoTipo {
    Animal a;
    @Before
    public void setUp() {
        this.a = new Animal();
    }

    //null =>false
    //""=>false
    //"perro"=>true


    @Test
    public void tipo_correcto(){
        assertEquals(false,a.setTipo(null));
        assertEquals(false, a.setTipo(""));
        assertEquals(true, a.setTipo("ave"));
    }

    @Test
    public void tipo_correctoGS(){
        assertEquals(true,  a.setTipo("ave"));
        assertEquals("ave",  a.getTipo());
    }


    @Test
    public void noNumeroTipo(){
        assertEquals(false,  a.setTipo("ave2"));
        assertEquals(true,  a.setTipo("ave"));
        assertEquals("ave", a.getTipo());
    }



}