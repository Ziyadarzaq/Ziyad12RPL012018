package com.example.ziyad12rpl012018.Admin;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.R;
import com.example.ziyad12rpl012018.initial;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class TambahUserActivity extends AppCompatActivity {
    ImageView ivBack;
    private EditText txtusername, txtemail, txtpassword, txtnotlp, txtnoktp, txtalamat ,txtroleuser;
    private Button btntambahuser;
    private boolean mIsFormFilled = false;
    private SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_user);
        binding();

            ivBack = findViewById(R.id.ivBack);
            ivBack.setOnClickListener(new View.OnClickListener() {
                private void doNothing() {

                }
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
           btntambahuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIsFormFilled = true;
                final String username = txtusername.getText().toString();
                final String email = txtemail.getText().toString().trim();
                final String password = txtpassword.getText().toString();
                final String notlp = txtnotlp.getText().toString();
                final String noktp = txtnoktp.getText().toString();
                final String alamat = txtalamat.getText().toString();
                final String roleuser = txtroleuser.getText().toString();



                if (username.isEmpty() || notlp.isEmpty() || alamat.isEmpty() || noktp.isEmpty() || password.isEmpty() || email.isEmpty() || roleuser.isEmpty()){
                    Toast.makeText(TambahUserActivity.this, "Harap lengkapi kolom Tambah User !", Toast.LENGTH_SHORT).show();
                    mIsFormFilled = false;
                }


                if (mIsFormFilled) {
                    HashMap<String, String> body = new HashMap<>();
                    body.put("username", username);
                    body.put("password", password);
                    body.put("email", email);
                    body.put("notlp", notlp);
                    body.put("noktp", noktp);
                    body.put("alamat", alamat);
                    body.put("roleuser", roleuser);

                    AndroidNetworking.post(config.BASE_URL+"tambahdatauser.php")
                            .addBodyParameter(body)
                            .setPriority(Priority.MEDIUM)
                            .setOkHttpClient(((initial) getApplication()).getOkHttpClient())
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    try {

//                                            String status = response.getString(config.RESPONSE_STATUS_FIELD);
                                        String message = response.getString(config.RESPONSE_MESSAGE_FIELD);

                                        Toast.makeText(TambahUserActivity.this, message, Toast.LENGTH_LONG).show();
                                        Log.d("f", "response: "+message);
                                        if (message.equalsIgnoreCase(config.RESPONSE_STATUS_VALUE_SUCCESS)) {

                                            Intent intent = new Intent(TambahUserActivity.this, list_data_customerActivity.class);
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
                                    Toast.makeText(TambahUserActivity.this, config.TOAST_AN_EROR, Toast.LENGTH_SHORT).show();
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
        txtusername= findViewById(R.id.txtusername);
        txtpassword= findViewById(R.id.txtpassword);
        txtemail= findViewById(R.id.txtemail);
        txtnotlp = findViewById(R.id.txtnotlp);
        txtnoktp  = findViewById(R.id.txtnoktp);
        txtalamat= findViewById(R.id.txtalamat);
        txtroleuser= findViewById(R.id.txtroleuser);
        btntambahuser = findViewById(R.id.btntambahuser);
    }
}