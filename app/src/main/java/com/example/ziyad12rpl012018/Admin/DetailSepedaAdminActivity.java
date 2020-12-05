package com.example.ziyad12rpl012018.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ziyad12rpl012018.Adapter.SepedaAdapter;
import com.example.ziyad12rpl012018.Helper.AppHelper;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.Model.SepedaModel;
import com.example.ziyad12rpl012018.R;
import com.squareup.picasso.Picasso;

public class DetailSepedaAdminActivity extends AppCompatActivity {
    ImageView ivBack, ivGambarSepeda;
    private Button btneditsepeda;
    private TextView tvNamaSepeda,tvKodeSepeda,tvMerkSepeda,tvJenisSepeda,tvWarnaSepeda,tvHargaSewa;

    private SwipeRefreshLayout swipeRefresh;
    private SepedaModel model;
    private String U_ID;
    private SepedaAdapter mAdapter;
    private RecyclerView rv;

    private String mLoginToken = "";
    private String mUserId = "";
    private String mNamaSepeda, mKodeSepeda, mJenisSepeda, mMerkSepeda, mWarnaSepeda,mHargaSewa,GambarSepeda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_sepeda_admin);
        ivGambarSepeda = findViewById(R.id.ivSepeda);
        btneditsepeda = findViewById(R.id.btneditsepeda);


        binding();
        model = getIntent().getExtras().getParcelable("extra_data");
        if(/*bundle*/ model != null) {
            U_ID = model.getId();

            tvNamaSepeda.setText(model.getNamaSepeda());
            tvKodeSepeda.setText(model.getKodeSepeda());
            tvJenisSepeda.setText(model.getJenisSepeda());
            tvMerkSepeda.setText(model.getMerkSepeda());
            tvWarnaSepeda.setText(model.getWarnasepeda());
            tvHargaSewa.setText(model.getHargaSewa());
            Picasso.get()
                    .load(config.BASE_URL + "img/" + model.getGambarSepeda())
                    .into(ivGambarSepeda);

            btneditsepeda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                Intent i = new Intent(DetailSepedaAdminActivity.this,EditSepedaAdminActivity.class);
//                startActivity(i);
                    AppHelper.goToDataAdminDetailEdit(DetailSepedaAdminActivity.this,model);
                }
            });
        }
    }

    private void binding() {
        tvNamaSepeda = findViewById(R.id.tvNamaSepeda);
        tvKodeSepeda = findViewById(R.id.tvKodeSepeda);
        tvJenisSepeda = findViewById(R.id.tvJenisSepeda);
        tvMerkSepeda = findViewById(R.id.tvMerkSepeda);
        tvWarnaSepeda = findViewById(R.id.tvWarnaSepeda);
        tvHargaSewa = findViewById(R.id.tvHargaSewa);
        btneditsepeda = findViewById(R.id.btneditsepeda);
        btneditsepeda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DetailSepedaAdminActivity.this,EditSepedaAdminActivity.class);
                startActivity(i);
            }
        });
        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}