package id.co.imastudio.androidsqlite;

/**
 * Created by nandoseptianhusni on 4/12/18.
 */
//TODO 1 bikin table dan object penyimpanan

public class Makanan {


    //delrasi nama field table
    public static final String TABLE_NAME = "makanan";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String HARGA = "harga";
    public static final String RESTORAN = "restoran";

    public Makanan() {
    }

    private int id ;
//
    public Makanan(int id, String name, String harga, String restoran) {
        this.id = id;
        this.name = name;
        this.harga = harga;
        this.restoran = restoran;
    }

    private String name ,harga,restoran;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getRestoran() {
        return restoran;
    }

    public void setRestoran(String restoran) {
        this.restoran = restoran;
    }

    public static final  String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "(" +
                    ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    NAME + " TEXT," +
                    HARGA + " TEXT," +
                    RESTORAN +" TEXT )" ;








}
