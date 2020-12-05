package com.example.ziyad12rpl012018.Admin;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.ziyad12rpl012018.Adapter.AdminUserAdapter;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.Model.UserAdminModel;
import com.example.ziyad12rpl012018.R;

import java.util.ArrayList;

public class DetailUserActivity extends AppCompatActivity {
    ImageView ivBack;
    private Button btnlogout;
    private TextView tvUsername,tvEmail,tvNoTlp,tvNoKtp,tvAlamat,tvRoleUser;

    private SwipeRefreshLayout swipeRefresh;
    private ArrayList<UserAdminModel> mList = new ArrayList<>();
    private AdminUserAdapter mAdapter;
    private RecyclerView rv;

    private String mLoginToken = "";
    private String mUserId = "";
    private String mEmail, mUsername, mKtp, mPhone, mAlamat, mStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_user);


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
        SharedPreferences sp = getSharedPreferences(config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        mEmail = sp.getString(config.LOGIN_EMAIL_SHARED_PREF,"");
        mUsername = sp.getString(config.LOGIN_NAME_SHARED_PREF,"");
        mKtp = sp.getString(config.LOGIN_KTP,"");
        mPhone = sp.getString(config.LOGIN_PHONE_SHARED_PREF,"");
        mAlamat = sp.getString(config.LOGIN_ADDRESS_SHARED_PREF,"");
        mStatus = sp.getString(config.LOGIN_GROUP_ID_SHARED_PREF,"");
        tvEmail.setText(mEmail);
        tvUsername.setText(mUsername);
        tvNoKtp.setText(mKtp);
        tvNoTlp.setText(mPhone);
        tvAlamat.setText(mAlamat);
        tvRoleUser.setText(mStatus);


    }

    private void binding() {
        tvEmail = findViewById(R.id.tvEmail);
        tvUsername = findViewById(R.id.tvUsername);
        tvNoKtp = findViewById(R.id.tvNoKtp);
        tvNoTlp = findViewById(R.id.tvNoTlp);
        tvAlamat = findViewById(R.id.tvAlamat);
        tvRoleUser = findViewById(R.id.tvRoleUser);
    }
}
