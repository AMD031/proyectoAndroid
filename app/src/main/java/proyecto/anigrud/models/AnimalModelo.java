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

import proyecto.anigrud.Utilidades.Util;
import proyecto.anigrud.views.AniCRUD;
import proyecto.anigrud.views.MyApplication;

public class AnimalModelo extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "AnimalDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "animal";
    private ArrayList<String>datos;

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
            if(res.moveToFirst()){
                 while (res.moveToNext()){
                    Animal animal = new Animal();
                     animal.setId(res.getInt(res.getColumnIndex("id")));
                     animal.setNombreAnimal(res.getString(res.getColumnIndex("nombreAnimal")));
                     animal.setEspecie(res.getString(res.getColumnIndex("especie")));
                     animal.setLugarFoto(res.getString(res.getColumnIndex("lugarfoto")));
                     animal.setFechaFoto(res.getString(res.getColumnIndex("fechafoto")));
                     animal.setAdorable(res.getInt(res.getColumnIndex("adorable")));
                     animal.setTipo(res.getString(res.getColumnIndex("tipo")));
                     animal.setImagen(res.getString(res.getColumnIndex("foto")));
                    list.add(animal);
                  }
         }

      }

        return list;
    }

    public ArrayList<String> getTipos(){
       if(datos ==null){
           datos = new ArrayList<>();
           datos.add("Desconocido");
          /* datos.add("Mamífero");
           datos.add("Ave");
           datos.add("Reptil");
           datos.add("Agnato");
           datos.add("Anfibio");*/
       }

        SQLiteDatabase db= this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT DISTINCT tipo FROM "+TABLE_NAME
                ,null);

        if(res.getCount()>0) {
            while (res.moveToNext()) {
             String resulatado =   res.getString(0);
             if(!Util.comprobarSiExiste(datos, resulatado)){
                 datos.add( resulatado );
             }
            }
        }
        return  datos;
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
                animal.setId(res.getInt(res.getColumnIndex("id")));
                animal.setNombreAnimal(res.getString(res.getColumnIndex("nombreAnimal")));
                animal.setEspecie(res.getString(res.getColumnIndex("especie")));
                animal.setLugarFoto(res.getString(res.getColumnIndex("lugarfoto")));
                animal.setFechaFoto(res.getString(res.getColumnIndex("fechafoto")));
                animal.setAdorable(res.getInt(res.getColumnIndex("adorable")));
                animal.setTipo(res.getString(res.getColumnIndex("tipo")));
                animal.setImagen(res.getString(res.getColumnIndex("foto")));
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
                animal.setId(res.getInt(res.getColumnIndex("id")));
                animal.setNombreAnimal(res.getString(res.getColumnIndex("nombreAnimal")));
                animal.setEspecie(res.getString(res.getColumnIndex("especie")));
                animal.setLugarFoto(res.getString(res.getColumnIndex("lugarfoto")));
                animal.setFechaFoto(res.getString(res.getColumnIndex("fechafoto")));
                animal.setAdorable(res.getInt(res.getColumnIndex("adorable")));
                animal.setTipo(res.getString(res.getColumnIndex("tipo")));
                animal.setImagen(res.getString(res.getColumnIndex("foto")));
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
        agregarPorDefecto(new Animal("leon",Foto.fotoleon,"felino","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("tigre",Foto.fotoTigre,"felino","india","8/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("perro",Foto.fotoperro,"canido","mi casa","10/01/2020","Mamífero",0),db);
        agregarPorDefecto(new Animal("leon",Foto.fotoleon,"desconocido","africa","13/01/2020","Desconocido",0),db);
        agregarPorDefecto(new Animal("caracal",null,"felino","europa","13/01/1980","Mamífero",0),db);
        agregarPorDefecto(new Animal("leopardo",null,"felino","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("puma",null,"felino","africa","13/01/2020","Mamífero",0),db);
        agregarPorDefecto(new Animal("elefante",null,"elefantido","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",0),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",0),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",1),db);
        agregarPorDefecto(new Animal("leon",null,"felino","africa","13/01/2020","Mamífero",1),db);
    }


    private void agregarPorDefecto(Animal animal,SQLiteDatabase db ){
        ContentValues values = new ContentValues();
        values.put("nombreAnimal", animal.getNombreAnimal());
        values.put("especie", animal.getEspecie());
        values.put("lugarfoto", animal.getLugarFoto());
        values.put("fechafoto", animal.getFechaFoto());
        values.put("adorable",animal.getAdorable() );
        values.put("tipo", animal.getTipo());
        values.put("foto", animal.getImagen());
        db.insertOrThrow(TABLE_NAME, null, values);
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
        String campoParaActualizar = "id = ?";
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

    public void borrarTipos() {
        datos =null;
    }
}
