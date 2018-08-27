package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper{

    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //CREAR TABLA USUARIOS
    @Override
    public void onCreate(SQLiteDatabase db) {

        String query="create table usuarios(_ID integer primary key autoincrement,"+ "Nombre text, Distrito text, Correo text, Password text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //METODO PARA ABRIR DB

    public void abrir(){
        this.getWritableDatabase();
    }
    //METODO PARA CERRAR LA DB

    public void cerrar(){
        this.close();
    }

    //METODO PARA INSERTAR EN LA TABLE USURIO

    public void insertarReg(String nom, String dis, String cor, String pas){
        ContentValues valores=new ContentValues();
        valores.put("Nombre", nom);
        valores.put("Distrito", dis);
        valores.put("Correo", cor);
        valores.put("Password", pas);
        this.getWritableDatabase().insert("usuarios", null, valores);
    }

    //METODO PARA VALIDAR SI EL USUARIO EXISTE

    public Cursor ConsultarUsuario(String usu, String pas) throws SQLException{
        Cursor mcursor=null;
            mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Distrito","Correo","Password"}
                    ,"Correo like '"+usu+"' and Password like '"+pas+"'"
                    ,null, null,null,null);
        return mcursor;
    }

}
