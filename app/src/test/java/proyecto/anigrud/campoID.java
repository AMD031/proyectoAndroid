package proyecto.anigrud;
import org.junit.Before;
import org.junit.Test;

import proyecto.anigrud.Utilidades.Validar;
import proyecto.anigrud.models.Animal;

import static org.junit.Assert.*;

public class campoID {
    Animal a;
    @Before
    public void setUp() {
       this.a = new Animal();
    }


 @Test
 public void id_correcto() {
     assertEquals(false, a.setId(-1) );
     assertEquals(true, a.setId(5));
 }

 @Test
 public void id_correctoGS(){
     assertEquals(true, a.setId(5));
     assertEquals(new Integer(5), a.getId());
 }









}
