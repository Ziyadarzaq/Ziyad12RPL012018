package com.example.ziyad12rpl012018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.ziyad12rpl012018.Admin.list_data_customerActivity;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.Model.UserAdminModel;
import com.example.ziyad12rpl012018.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class EditActivity extends AppCompatActivity {
    private TextView tvRegister;
    private EditText txtusernameReg, txtpasswordReg, txtemailReg, txtnotlpReg, txtnoktpReg, txtalamatReg;
    private Button btnedit;
    private boolean mIsFormFilled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        binding();

        Intent i = getIntent();
        UserAdminModel item = i.getParcelableExtra("EXTRA_ADMIN");

        txtusernameReg.setText(item.getUsername());
        txtemailReg.setText(item.getEmail());
        txtnotlpReg.setText(item.getNoTlp());
        txtnoktpReg.setText(item.getNoKtp());
        txtalamatReg.setText(item.getAlamat());

        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsFormFilled = true;
                final String username = txtusernameReg.getText().toString();
                final String email = txtemailReg.getText().toString().trim();
                final String notlp = txtnotlpReg.getText().toString();
                final String noktp = txtnoktpReg.getText().toString();
                final String alamat = txtalamatReg.getText().toString();



                if (username.isEmpty() || notlp.isEmpty() || alamat.isEmpty() || noktp.isEmpty() || email.isEmpty()) {
                    Toast.makeText(EditActivity.this, "Harap lengkapi kolom register !", Toast.LENGTH_SHORT).show();
                    mIsFormFilled = false;
                }


                if (mIsFormFilled) {
                    HashMap<String, String> body = new HashMap<>();
                    body.put("id", String.valueOf(14));
                    body.put("email", email);
                    body.put("nama", username);
                    body.put("nohp", notlp);
                    body.put("alamat", alamat);
                    body.put("noktp", noktp);

                    AndroidNetworking.post(config.BASE_URL + "EditCustomer.php")
                            .addBodyParameter(body)
                            .setPriority(Priority.MEDIUM)
                            .setOkHttpClient(((initial) getApplication()).getOkHttpClient())
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {
                                        Log.e("ziyaddd", "dataaa" + response);
//                                            String status = response.getString(config.RESPONSE_STATUS_FIELD);
                                        JSONObject message = response.getJSONObject("hasil");
                                        Boolean status = message.getBoolean("respon");

//                                        Toast.makeText(EditActivity.this, message, Toast.LENGTH_LONG).show();
                                        Log.d("f", "response: "+message);
                                        if (status) {

                                            Intent intent = new Intent(EditActivity.this, list_data_customerActivity.class);
                                            startActivity(intent);
                                            finishAffinity();
                                        }
                                    }
                                    catch (JSONException e) {
                                        e.printStackTrace();
                                        Log.d("b", "JSONException: " + e.getMessage());
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {
//                                        mProgress.dismiss();
                                    Toast.makeText(EditActivity.this, config.TOAST_AN_EROR, Toast.LENGTH_SHORT).show();
                                    Log.d("ab", "onError: " + anError.getErrorBody());
                                    Log.d("ab", "onError: " + anError.getLocalizedMessage());
                                    Log.d("ab", "onError: " + anError.getErrorDetail());
                                    Log.d("ab", "onError: " + anError.getResponse());
                                    Log.d("ab", "onError: " + anError.getErrorCode());
                                }
                            });
                }

            }
        });
    }
    private void binding() {
        txtusernameReg = findViewById(R.id.txtusernameReg);
        txtnotlpReg = findViewById(R.id.txtnotlpReg);
        txtnoktpReg = findViewById(R.id.txtnoktpReg);
        txtalamatReg = findViewById(R.id.txtalamatReg);
        txtemailReg= findViewById(R.id.txtemailReg);
        btnedit = findViewById(R.id.btnedit);
    }
}