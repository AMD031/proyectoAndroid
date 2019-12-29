package proyecto.anigrud.models;

import android.app.Person;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

import java.util.ArrayList;

import proyecto.anigrud.views.AniCRUD;
import proyecto.anigrud.views.MyApplication;

public class AnimalModelo extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AnimalDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "animal";

    private static AnimalModelo sInstance;

    private AnimalModelo (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized AnimalModelo getInstance() {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = new AnimalModelo(MyApplication.getContext());
        }
        return sInstance;
    }

     private Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return  res;
    }




    public ArrayList<Animal> getAllanimal(){
        ArrayList<Animal> list = new ArrayList<>();

        Cursor res = getAllData();

          if(res.getCount()>0){
         while (res.moveToNext()){
            Animal dato = new Animal();
            dato.setId(res.getInt(0));
            dato.setNombreAnimal(res.getString(1));
            dato.setEspecie(res.getString(2));
            dato.setLugarFoto(res.getString(3));
           // dato.setFechaFoto(res.getString(4));
            dato.setAdorable(res.getInt(5));
            dato.setTipo(res.getString(6));
            dato.setImagen(res.getString(7));
            list.add(dato);
          }
      }





      /*Animal a1 = new Animal(1,"gato",null,"felino",null,null,null,null);
        Animal a2 = new Animal(2,"perro",Foto.fotoperro,"canido",null,null,null,null);
        Animal a3 = new Animal(3,"elefante",null,"elefantido",null,null,null,null);

        Animal a4 = new Animal();
        a4.setEspecie("Felino");
        a4.setId(4);
        a4.setImagen(Foto.fotoTigre);
        a4.setNombreAnimal("tigre");

         Animal a5 = new Animal(5,"caiman",null,"reptil",null,null,null,null);
         Animal a6 = new Animal(6,"leon",Foto.fotoleon,"felino",null,null,null,null);
         Animal a7 = new Animal(7,"leopardo",null,"felino",null,null,null,null);
         Animal a8 = new Animal(8,"puma",null,"felino",null,null,null,null);
         Animal a9 = new Animal(9,"lince",null,"felino",null,null,null,null);
        Animal a10 = new Animal(10,"caracal",null,"felino",null,null,null,null);

        list.add(a1);
        list.add(a2);
        list.add(a3);
        list.add(a4);
        list.add(a5);
        list.add(a6);
        list.add(a7);
        list.add(a8);
        list.add(a9);
        list.add(a10);*/






        return list;
    }







    @Override
    public void onCreate(SQLiteDatabase db) {

       String CREATE_TABLE_ANIMAL ="CREATE TABLE IF NOT EXISTS "+ TABLE_NAME +"("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "nombreAnimal TEXT,"+
                "especie TEXT," +
                "lugarfoto TEXT,"+
                "fechafoto TEXT,"+
                "adorable INTEGER,"+
                "tipo TEXT,"+
                "foto TEXT"+
                 ")";

        db.execSQL(CREATE_TABLE_ANIMAL);




    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }







    public boolean addNewAnimal(Animal animal) {

        Log.d("ani",animal.toString());
     SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
     try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
            ContentValues values = new ContentValues();
            values.put("nombreAnimal", animal.getNombreAnimal());
            values.put("especie", animal.getEspecie());
            values.put("lugarfoto", animal.getLugarFoto());
            values.put("fechafoto", animal.getFechaFoto());
            values.put("adorable",animal.getAdorable() );
            values.put("tipo", animal.getTipo());
            values.put("foto", animal.getImagen());


            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_NAME, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.d("AnimalDB", "Error while trying to add post to database");
            return  false;
        } finally {
            db.endTransaction();
            db.close();
            return true;
        }

    }
}
