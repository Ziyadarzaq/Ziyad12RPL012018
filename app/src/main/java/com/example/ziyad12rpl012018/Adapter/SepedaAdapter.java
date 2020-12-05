package com.example.ziyad12rpl012018.Adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ziyad12rpl012018.Adapter.AdminUserAdapter;
import com.example.ziyad12rpl012018.Admin.DetailSepedaAdminActivity;
import com.example.ziyad12rpl012018.Admin.list_data_sepedaActivity;
import com.example.ziyad12rpl012018.Helper.AppHelper;
import com.example.ziyad12rpl012018.Helper.config;
import com.example.ziyad12rpl012018.Model.SepedaModel;
import com.example.ziyad12rpl012018.Model.UserAdminModel;
import com.example.ziyad12rpl012018.R;
import com.example.ziyad12rpl012018.initial;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class SepedaAdapter extends RecyclerView.Adapter<SepedaAdapter.ItemViewHolder> {
    private Context context;
    private List<SepedaModel> mList;
    private boolean mBusy = false;
    private String mLoginToken = "";
    private ProgressDialog mProgressDialog;
    private list_data_sepedaActivity mAdminActivity;
    private TextView tvNamaSepeda;

    public SepedaAdapter(Context context, ArrayList<SepedaModel> mList, Activity AdminDataActivity) {

        this.context = context;
        this.mList = mList;
        this.mAdminActivity = (list_data_sepedaActivity) AdminDataActivity;

    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_list_data_sepeda, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        final SepedaModel Amodel = mList.get(i);
        itemViewHolder.bind(Amodel);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void clearData() {
        int size = this.mList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                this.mList.remove(0);
            }
        }
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView tvNamasepeda, tvJenissepeda, tvHargaSewa;
        private LinearLayout card_sepeda;
        private ImageView ivGambarSepeda;


        public ItemViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvNamasepeda = itemView.findViewById(R.id.tvNamaSepeda);
            tvJenissepeda = itemView.findViewById(R.id.tvJenisSepeda);
            tvHargaSewa = itemView.findViewById(R.id.tvHargaSewa);
            card_sepeda = itemView.findViewById(R.id.card_sepeda);
            ivGambarSepeda = itemView.findViewById(R.id.ivGambarSepeda);

        }

        private void bind(final SepedaModel Amodel) {
            tvNamasepeda.setText(Amodel.getNamaSepeda());
            tvJenissepeda.setText(Amodel.getJenisSepeda());
            tvHargaSewa.setText(Amodel.getHargaSewa());
            Picasso.get()
                    .load(config.BASE_URL+"img/"+Amodel.getGambarSepeda())
                    .into(ivGambarSepeda);
            card_sepeda.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(context, DetailSepedaAdminActivity.class);
                    AppHelper.goToDataAdminDetail(context,Amodel);
                }
            });

        }


    }

}
