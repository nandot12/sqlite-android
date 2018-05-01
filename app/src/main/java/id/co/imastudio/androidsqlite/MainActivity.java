package id.co.imastudio.androidsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.etMkanan)
    EditText etMkanan;
    @BindView(R.id.etPrice)
    EditText etPrice;
    @BindView(R.id.etRestoran)
    EditText etRestoran;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;
    @BindView(R.id.literecycler)
    RecyclerView literecycler;


    //deklrasi variable
    MakanandbHelper helper ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //inisialisasi
        helper = new MakanandbHelper(this);

        //deklrar method baru untuk ambil data
        ambilData();


    }

    private void ambilData() {
        //proses get from database local

        List<Makanan> data = new ArrayList<>();

        data.clear();
      data =  helper.getAllMakanan();

     MyAdapter adapter = new MyAdapter(data);
     literecycler.setAdapter(adapter);
     literecycler.setLayoutManager(new LinearLayoutManager(this));



    }

    @OnClick(R.id.btnSubmit)
    public void onViewClicked() {

        //ambil inputan user
        String name = etMkanan.getText().toString();
        String price = etPrice.getText().toString() ;
        String restoran = etRestoran.getText().toString() ;

        helper.inserMakanan(name,price,restoran);

        ambilData();

//        startActivity(new Intent(this,MainActivity.class));




    }
}
