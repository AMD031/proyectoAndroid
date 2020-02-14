package proyecto.anigrud;

import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.models.Animal;

import static org.junit.Assert.assertEquals;

public class CampoFecha {
    Animal a;
    @Before
    public void setUp() {
        this.a = new Animal();
    }


    @Test
    public void fecha_correcta() {
        assertEquals(false, a.setFechaFoto("13/19/2001") );
        assertEquals(false, a.setFechaFoto("1/13/2001"));
        assertEquals(true, a.setFechaFoto("1/11/2001"));
        assertEquals(false, a.setFechaFoto("a9/1/1111"));
    }

    @Test
    public void fecha_correctaGS(){
        assertEquals(true, a.setFechaFoto("1/11/2001"));
        assertEquals("1/11/2001",a.getFechaFoto());
    }



}
