package id.co.imastudio.androidsqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nandoseptianhusni on 4/12/18.
 */

public class MakanandbHelper extends SQLiteOpenHelper {

    //create nama database
    private static final String DB_NAME = "db_makanan";

    private static final int DB_VERSION = 1;


    public MakanandbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //membuat table sesuai query yang di bkin di class makanan tadi
        db.execSQL(Makanan.CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + Makanan.TABLE_NAME);

        onCreate(db);


    }

    public void inserMakanan(String name, String price, String restoran) {
        // Gets the data repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();

// Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Makanan.NAME, name);
        values.put(Makanan.HARGA, price);
        values.put(Makanan.RESTORAN, restoran);


// Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(Makanan.TABLE_NAME, null, values);

        db.close();
    }

    //ini method untuk ambil array dari database local
    public List<Makanan> getAllMakanan() {

        SQLiteDatabase db = this.getWritableDatabase();

        //set query ambil data
        String q = "SELECT * FROM " + Makanan.TABLE_NAME;

        //eksekusi query nya
        Cursor hasil = db.rawQuery(q, null);

        //bikin array untuk angkut data yang ambil dari database local
        ArrayList<Makanan> makan = new ArrayList<>();

        //deklrasi object makanan biar set makanan


        while (hasil.moveToNext()) {
            Makanan m = new Makanan();

            //waktu proses masing2 data ke masukkan ke objext makanan

            m.setId(hasil.getInt(hasil.getColumnIndex(Makanan.ID)));
            m.setName(hasil.getString(hasil.getColumnIndex(Makanan.NAME)));
            m.setHarga(hasil.getString(hasil.getColumnIndex(Makanan.HARGA)));
            m.setRestoran(hasil.getString(hasil.getColumnIndex(Makanan.RESTORAN)));
            makan.add(m);


        }
        hasil.close();

        return makan;
    }
}