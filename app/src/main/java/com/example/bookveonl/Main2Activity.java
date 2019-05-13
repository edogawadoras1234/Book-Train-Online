package com.example.bookveonl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        String ten = extras.getString("qten");
        final TextView idten1 = (TextView)findViewById(R.id.idten);
        idten1.setText("Tên: "+ten);

        String sdt = extras.getString("qsdt");
        final TextView idsdt1 = (TextView)findViewById(R.id.idsdt);
        idsdt1.setText("SDT: "+sdt);

        String thanhvien = extras.getString("qthanhvien");
        final TextView idthanhvien1 = (TextView)findViewById(R.id.idthanhvien);
        idthanhvien1.setText("Thành viên: "+thanhvien);

        String loaive = extras.getString("qloaive");
        final TextView idloaive1 = (TextView)findViewById(R.id.idloaive);
        idloaive1.setText("Loại vé: "+ loaive);

        String dichvu = extras.getString("qdichvu");
        final TextView iddichvu1 = (TextView)findViewById(R.id.iddichvu);
        iddichvu1.setText("Dịch vụ: "+ dichvu);

        String thanhtoan = extras.getString("qthanhtoan");
        final TextView idthanhtoan1 = (TextView)findViewById(R.id.idthanhoan);
        idthanhtoan1.setText("Thanh toán: "+ thanhtoan);

        String thanhtien = extras.getString("qthanhtien");
        final TextView idthanhtien1 = (TextView)findViewById(R.id.idthanhtien);
        idthanhtien1.setText("Thành tiền: "+ thanhtien);
    }
}
