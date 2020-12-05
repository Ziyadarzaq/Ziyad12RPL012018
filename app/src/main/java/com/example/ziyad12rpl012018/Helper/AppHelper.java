package com.example.ziyad12rpl012018.Helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.ziyad12rpl012018.Admin.DetailSepedaAdminActivity;
import com.example.ziyad12rpl012018.Admin.EditSepedaAdminActivity;
import com.example.ziyad12rpl012018.Model.SepedaModel;
import com.example.ziyad12rpl012018.Model.UserAdminModel;

import org.json.JSONObject;

public class AppHelper {
    public static UserAdminModel mapUserAdminModel(JSONObject rowData) {
        UserAdminModel item = new UserAdminModel();
        item.setId(rowData.optString("id"));
        item.setRoleUser(rowData.optString("roleuser"));
        item.setEmail(rowData.optString("email"));
        item.setUsername(rowData.optString("username"));
        item.setNoKtp(rowData.optString("noktp"));
        item.setNoTlp(rowData.optString("notlp"));
        item.setAlamat(rowData.optString("alamat"));



        return item;
    }
    public static SepedaModel mapSepedaAdminModel(JSONObject rowData) {
        SepedaModel item = new SepedaModel();
        item.setHargaSewa(rowData.optString("hargasewa"));
        item.setJenisSepeda(rowData.optString("jenissepeda"));
        item.setKodeSepeda(rowData.optString("kodesepeda"));
        item.setMerkSepeda(rowData.optString("merksepeda"));
        item.setWarnasepeda(rowData.optString("warnasepeda"));
        item.setNamaSepeda(rowData.optString("namasepeda"));
        item.setGambarSepeda(rowData.optString("gambarsepeda"));

        return item;
    }

    public static void goToUserAdminDetail(Context context, UserAdminModel rowData) {
        Bundle bundle = new Bundle();

        bundle.putString("id", String.valueOf(rowData.getId()));
        bundle.putString("roleuser", rowData.getRoleUser().toUpperCase());
        bundle.putString("email", rowData.getEmail().toUpperCase());
        bundle.putString("username", rowData.getUsername().toUpperCase());
        bundle.putString("noktp", rowData.getNoKtp());
        bundle.putString("notlp", rowData.getNoTlp());
        bundle.putString("alamat", rowData.getAlamat().toUpperCase());



//        Intent i = new Intent(context, CustomerDetailActivity.class);
//        i.putExtra("extra_customer", rowData);
//        context.startActivity(i);
    }

    public static void goToDataAdminDetail(Context context, SepedaModel amodel) {
        Bundle bundle = new Bundle();

        bundle.putString("id", String.valueOf(amodel.getId()));
        bundle.putString("namasepeda", amodel.getNamaSepeda().toUpperCase());
        bundle.putString("kodesepeda", amodel.getKodeSepeda().toUpperCase());
        bundle.putString("jenissepeda", amodel.getJenisSepeda().toUpperCase());
        bundle.putString("merksepeda", amodel.getMerkSepeda().toUpperCase());
        bundle.putString("warnasepeda", amodel.getWarnasepeda().toUpperCase());
        bundle.putString("hargasewa", amodel.getHargaSewa().toUpperCase());


        Intent i = new Intent(context, DetailSepedaAdminActivity.class);
        i.putExtra("extra_data", amodel);
        context.startActivity(i);
    }

    public static void goToDataAdminDetailEdit (Context context, SepedaModel amodel) {
        Bundle bundle = new Bundle();

        bundle.putString("id", String.valueOf(amodel.getId()));
        bundle.putString("namasepeda", amodel.getNamaSepeda().toUpperCase());
        bundle.putString("kodesepeda", amodel.getKodeSepeda().toUpperCase());
        bundle.putString("jenissepeda", amodel.getJenisSepeda().toUpperCase());
        bundle.putString("merksepeda", amodel.getMerkSepeda().toUpperCase());
        bundle.putString("warnasepeda", amodel.getWarnasepeda().toUpperCase());
        bundle.putString("hargasewa", amodel.getHargaSewa().toUpperCase());


        Intent i = new Intent(context, EditSepedaAdminActivity.class);
        i.putExtra("extra_data", amodel);
        context.startActivity(i);
    }
}
