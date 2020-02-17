package proyecto.anigrud;

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

    @Before
    public void setUp(){
        InstrumentationRegistry.getInstrumentation().getTargetContext().deleteDatabase(repositorio.getDatabaseName());
        repositorio = AnimalModelo.getInstance(InstrumentationRegistry.getInstrumentation().getTargetContext());
    }
    @Test
    public void insertarAnimal(){
        assertEquals(false, repositorio.addNewAnimal(null));
    }





    @After
    public void tearDown() {
        repositorio.close();
    }


}
