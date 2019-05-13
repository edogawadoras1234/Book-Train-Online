package com.example.bookveonl;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.app.AlertDialog;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public void info(View v, String msg) {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(msg);
        dlgAlert.setTitle("Thông Tin");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    Spinner danhsach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        danhsach = (Spinner) findViewById(R.id.spinner);
        ArrayList<String> money = new ArrayList<String>();
        money.add("VNĐ");
        money.add("USD");
        ArrayAdapter arradapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, money);
        danhsach.setAdapter(arradapter);

        Button btnhuy = (Button) findViewById(R.id.btncancel);

        btnhuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });
    }

    public void onClick(View v) {
        Intent i = new Intent(this, Main2Activity.class);
        final EditText editten =  (EditText)findViewById(R.id.txtten);
        final EditText editsdt =  (EditText)findViewById(R.id.txtsdt);
        final CheckBox chk1 =  (CheckBox) findViewById(R.id.checkBox);
        final RadioButton rbvip =  (RadioButton) findViewById(R.id.rbtnvip);
        final RadioButton rbthuong =  (RadioButton) findViewById(R.id.rbtnthuong);
        final RadioButton rbgiuong =  (RadioButton) findViewById(R.id.rbtngiuong);
        final RadioButton rbghe =  (RadioButton) findViewById(R.id.rbtnghe);
        final Spinner spintt =  (Spinner) findViewById(R.id.spinner);

        String ten = editten.getText().toString();
        String sdt = editsdt.getText().toString();
        String dichvu = chk1.getText().toString();
        i.putExtra("qten", ten);
        i.putExtra("qsdt", sdt);
        i.putExtra("qdichvu", dichvu);

        String thanhvien;
        if(rbvip.isChecked()) {
            thanhvien = rbvip.getText().toString()+"\nGiảm giá:30%";
            i.putExtra("qthanhvien", thanhvien);
        }
        if(rbthuong.isChecked()) {
            thanhvien = rbthuong.getText().toString();
            i.putExtra("qthanhvien", thanhvien);
        };

        String loaive;
        if(rbgiuong.isChecked()) {
            loaive = rbgiuong.getText().toString();
            i.putExtra("qloaive", loaive);
        }
        if(rbghe.isChecked()) {
            loaive = rbghe.getText().toString();
            i.putExtra("qloaive", loaive);
        };

        if(chk1.isChecked()) {
            dichvu = "Có" + " \nPhí dịch vụ: 60000VNĐ";
            i.putExtra("qdichvu", dichvu);
        }
        else
            dichvu = "Không";
            i.putExtra("qdichvu", dichvu);

        String thanhtoan = spintt.getSelectedItem().toString();
        i.putExtra("qthanhtoan", thanhtoan);

        String thanhtien;
        int a = 1200000;
        int b = 800000;
        int phi= 60000;
        if(rbgiuong.isChecked()) {
            int thanhtien1= a-(a * 30 / 100)+60000;
            int thanhtien2=a-(a*30/100);
            int thanhtien3=a+phi;
            if (spintt.getSelectedItem()=="VNĐ") {
                if (rbvip.isChecked() && chk1.isChecked())
                    thanhtien = thanhtien1 + "VNĐ";
                else if (rbvip.isChecked())
                    thanhtien =  thanhtien2 + "VNĐ";
                else if (chk1.isChecked())
                    thanhtien = thanhtien3 + "VNĐ";
                else
                    thanhtien = a + "VNĐ";
            }
            else {
                if (rbvip.isChecked() && chk1.isChecked())
                    thanhtien = thanhtien1/20000 + "USD";
                else if (rbvip.isChecked())
                    thanhtien = thanhtien2/20000 + "USD";
                else if (chk1.isChecked())
                    thanhtien = thanhtien3/20000 + "USD";
                else
                    thanhtien = + a/20000 + "USD";
            }
            i.putExtra("qthanhtien", thanhtien);

        }

        if(rbghe.isChecked()) {
            int thanhtien4= b-(b*30/100)+60000;
            int thanhtien5=b-(b*30/100);
            int thanhtien6=b+phi;
            if(spintt.getSelectedItem()=="VNĐ") {
                if (rbvip.isChecked() && chk1.isChecked())
                    thanhtien = thanhtien4 + "VNĐ";
                else if (rbvip.isChecked())
                    thanhtien = thanhtien5 + "VNĐ";
                else if (chk1.isChecked())
                    thanhtien = thanhtien6 + "VNĐ";
                else
                    thanhtien = b + "VNĐ";
            }
            else{
                if (rbvip.isChecked() && chk1.isChecked())
                    thanhtien = thanhtien4/20000 + "USD";
                else if (rbvip.isChecked())
                    thanhtien = thanhtien5/20000 + "USD";
                else if (chk1.isChecked())
                    thanhtien = thanhtien6/20000 + "USD";
                else
                    thanhtien = b/20000 + "USD";
            }
            i.putExtra("qthanhtien", thanhtien);
        }
        startActivity(i);
    };

}
