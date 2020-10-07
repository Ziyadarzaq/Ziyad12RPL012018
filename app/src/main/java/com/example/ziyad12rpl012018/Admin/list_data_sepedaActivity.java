package com.example.ziyad12rpl012018.Admin;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ziyad12rpl012018.R;

public class list_data_sepedaActivity extends AppCompatActivity {

    private ImageView gambarsepeda, ivBack;
    private TextView tvNamaSepeda,tvHargaSewa;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data_sepeda);

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
