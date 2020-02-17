package proyecto.anigrud;

import org.junit.Before;
import org.junit.Test;
import proyecto.anigrud.models.Animal;

import static org.junit.Assert.assertEquals;


public class campoLugarFoto {
    Animal a;
    @Before
    public void setUp() {
        this.a = new Animal();
    }



    @Test
    public void nombreLugarFotoCorrecto(){
        assertEquals(false,a.setLugarFoto(null));
        assertEquals(false,a.setLugarFoto(""));
        assertEquals(true,a.setLugarFoto("Asia"));
    }

    @Test
    public void nombreLugarFotoGS(){
        assertEquals(false,a.setLugarFoto(null));
        assertEquals(true,a.setLugarFoto("Asia"));
        assertEquals("Asia",a.getLugarFoto());
    }

    /*
    set "Asia2" =>false
    set "Asia" =>true
    get =>"Asia"

     */


    @Test
    public  void noNumeroNombreLugar(){
        assertEquals(false,a.setLugarFoto("Asia2"));
        assertEquals(true,a.setLugarFoto("Asia"));
        assertEquals("Asia",a.getLugarFoto());
    }






}
