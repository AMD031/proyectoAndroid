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
import java.util.List;

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
            dato.setFechaFoto(res.getString(4));
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


    public int eliminarAnimal(Integer id) {
        SQLiteDatabase baseDeDatos = this.getWritableDatabase();
        String[] argumentos = {String.valueOf(id)};
        return baseDeDatos.delete(TABLE_NAME, "id = ?", argumentos);
    }


    public Animal obtenerAnimal(Integer id) {
        Animal animal = new Animal();
        SQLiteDatabase db= this.getWritableDatabase();
        String[] argumentos = {String.valueOf(id)};
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE id = ?"
                ,argumentos);
        if(res.getCount()>0) {
            while (res.moveToNext()) {
                animal.setId(res.getInt(0));
                animal.setNombreAnimal(res.getString(1));
                animal.setEspecie(res.getString(2));
                animal.setLugarFoto(res.getString(3));
                animal.setFechaFoto(res.getString(4));
                animal.setAdorable(res.getInt(5));
                animal.setTipo(res.getString(6));
                animal.setImagen(res.getString(7));
            }
        }
        return animal;
    }


    public ArrayList<Animal> obtenerAnimalporCriterio(String nombreAnimal, String tipo,String fecha) {
        ArrayList<Animal> list = new ArrayList<>();
        SQLiteDatabase db= this.getWritableDatabase();
        if(tipo.equals("Desconocido")){
            tipo="";
        }
        String[] argumentos = {"%"+nombreAnimal+"%","%"+tipo+"%","%"+fecha+"%"};
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME +" WHERE nombreAnimal LIKE ? "+
                                      "AND tipo LIKE ? "+
                                      "AND fechafoto LIKE ? "
                ,argumentos);
        if(res.getCount()>0) {
            while (res.moveToNext()) {
                Animal animal = new Animal();
                animal.setId(res.getInt(0));
                animal.setNombreAnimal(res.getString(1));
                animal.setEspecie(res.getString(2));
                animal.setLugarFoto(res.getString(3));
                animal.setFechaFoto(res.getString(4));
                animal.setAdorable(res.getInt(5));
                animal.setTipo(res.getString(6));
                animal.setImagen(res.getString(7));
                list.add(animal);
            }
        }
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

    public int guardarCambios(Animal animal) {
        SQLiteDatabase baseDeDatos = this.getWritableDatabase();

        ContentValues valoresParaActualizar = new ContentValues();
        valoresParaActualizar.put("nombreAnimal", animal.getNombreAnimal());
        valoresParaActualizar.put("especie", animal.getEspecie());
        valoresParaActualizar.put("lugarfoto", animal.getLugarFoto());
        valoresParaActualizar.put("fechafoto", animal.getFechaFoto());
        valoresParaActualizar.put("adorable",animal.getAdorable() );
        valoresParaActualizar.put("tipo", animal.getTipo());
        valoresParaActualizar.put("foto", animal.getImagen());
        // where id...
        String campoParaActualizar = "id = ?";
        // ... = idMascota
        String[] argumentosParaActualizar = {String.valueOf(animal.getId())};
        return baseDeDatos.update(TABLE_NAME, valoresParaActualizar, campoParaActualizar, argumentosParaActualizar);
    }

    public boolean addNewAnimal(Animal animal) {

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
