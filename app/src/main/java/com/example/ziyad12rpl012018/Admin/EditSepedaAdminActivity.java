package com.example.ziyad12rpl012018.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.ziyad12rpl012018.Adapter.SepedaAdapter;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.Model.SepedaModel;
import com.example.ziyad12rpl012018.R;
import com.example.ziyad12rpl012018.initial;

import org.json.JSONObject;

import java.util.HashMap;

public class EditSepedaAdminActivity extends AppCompatActivity {
    ImageView ivBack;
    private Button btneditsepeda;
    private EditText tvNamaSepeda,tvKodeSepeda,tvMerkSepeda,tvJenisSepeda,tvWarnaSepeda,tvHargaSewa;

    private SwipeRefreshLayout swipeRefresh;
    private SepedaModel model;
    private String U_ID;
    private SepedaAdapter mAdapter;
    private RecyclerView rv;

    private String mLoginToken = "";
    private String mUserId = "";
    private String mNamaSepeda, mKodeSepeda, mJenisSepeda, mMerkSepeda, mWarnaSepeda,mHargaSewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_sepeda_admin);

        ivBack = findViewById(R.id.ivBack);
        ivBack.setOnClickListener(new View.OnClickListener() {
            private void doNothing() {

            }
            @Override
            public void onClick(View v) {
                finish();
            }
        });

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
                HashMap<String, String> body = new HashMap<>();
                body.put("id", U_ID);
                body.put("namsepeda",tvNamaSepeda.getText().toString());
                body.put("kodesepeda",tvKodeSepeda.getText().toString());
                body.put("jenissepeda",tvJenisSepeda.getText().toString());
                body.put("merksepeda",tvMerkSepeda.getText().toString());
                body.put("warnasepeda",tvWarnaSepeda.getText().toString());
                body.put("hargasewa",tvHargaSewa.getText().toString());

                AndroidNetworking.post(config.BASE_URL + "updatedatasepeda.php")
                        .addBodyParameter(body)
                        .setPriority(Priority.MEDIUM)
                        .setOkHttpClient(((initial) getApplication()).getOkHttpClient())
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {

                                String message = response.optString(config.RESPONSE_STATUS_VALUE_SUCCESS);
                                String status = response.optString(config.RESPONSE_STATUS_FIELD);

                                Toast.makeText(EditSepedaAdminActivity.this, message, Toast.LENGTH_LONG).show();
                                Log.d("AS", "onResponse: "+message);
                                if (message.equalsIgnoreCase("1")) {
                                    Toast.makeText(EditSepedaAdminActivity.this,"Update berhasil",Toast.LENGTH_SHORT).show();
                                    finish();
                                }
                                else {
                                    Toast.makeText(EditSepedaAdminActivity.this,"Update gagal",Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(EditSepedaAdminActivity.this, config.TOAST_AN_ERROR, Toast.LENGTH_SHORT).show();
                                Log.d("A", "onError: " + anError.getErrorBody());
                                Log.d("A", "onError: " + anError.getLocalizedMessage());
                                Log.d("A", "onError: " + anError.getErrorDetail());
                                Log.d("A", "onError: " + anError.getResponse());
                                Log.d("A", "onError: " + anError.getErrorCode());

                            }
                        });

            }
        });
    }

}
