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
        Button btntt =  (Button)findViewById(R.id.btnbook);
        final EditText editten =  (EditText)findViewById(R.id.txtten);
        final EditText editsdt =  (EditText)findViewById(R.id.txtsdt);
        final CheckBox chk1 =  (CheckBox) findViewById(R.id.checkBox);
        final RadioButton rbvip =  (RadioButton) findViewById(R.id.rbtnvip);
        final RadioButton rbthuong =  (RadioButton) findViewById(R.id.rbtnthuong);
        final RadioButton rbgiuong =  (RadioButton) findViewById(R.id.rbtngiuong);
        final RadioButton rbghe =  (RadioButton) findViewById(R.id.rbtnghe);
        final Spinner spintt =  (Spinner) findViewById(R.id.spinner);


        btntt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                int a = 1200000;
                int b = 800000;
                int phi= 60000;
                String msg = "Tên: " + editten.getText().toString() +
                        System.getProperty("line.separator") +
                        "SĐT: " + editsdt.getText().toString()
                        + System.getProperty("line.separator") +
                        "Thành viên: ";

                editten.setText("");
                editsdt.setText("");

                if(rbvip.isChecked()) {
                    msg += rbvip.getText().toString() + System.getProperty("line.separator");
                    msg += "Giảm giá: 30%" + System.getProperty("line.separator");
                }

                if(rbthuong.isChecked())
                    msg += rbthuong.getText().toString()+ System.getProperty("line.separator");



                if(rbgiuong.isChecked()) {
                    msg += "Loại vé: " + rbgiuong.getText().toString() ;
                    msg += System.getProperty("line.separator") + "Giá tiền: " + a + " VNĐ ";
                }
                if(rbghe.isChecked()) {
                    msg += "Loại vé: " + rbghe.getText().toString();
                    msg += System.getProperty("line.separator") + "Giá tiền: " + b + " VNĐ ";
                }

                if(chk1.isChecked()) {
                    msg += System.getProperty("line.separator") + "Dịch vụ: " + "Có";
                    msg += System.getProperty("line.separator") + "Phí dịch vụ: " + phi+"VNĐ";
                }
                else
                    msg += System.getProperty("line.separator") + "Dịch vụ: "+"Không";


                msg += System.getProperty("line.separator") + "Hình thức thanh toán: " +
                        spintt.getSelectedItem().toString()+ System.getProperty("line.separator");


                if(rbgiuong.isChecked()) {
                    int thanhtien1= a-(a * 30 / 100)+60000;
                    int thanhtien2=a-(a*30/100);
                    int thanhtien3=a+phi;
                    if (spintt.getSelectedItem()=="VNĐ") {
                        if (rbvip.isChecked() && chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien1 + "VNĐ";
                        else if (rbvip.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien2 + "VNĐ";
                        else if (chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien3 + "VNĐ";
                        else
                            msg += System.getProperty("line.separator") + "Thành tiền:" + a + "VNĐ";
                    }
                    else {
                        if (rbvip.isChecked() && chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien1/20000 + "USD";
                        else if (rbvip.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien2/20000 + "USD";
                        else if (chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien3/20000 + "USD";
                        else
                            msg += System.getProperty("line.separator") + "Thành tiền:" + a/20000 + "USD";
                    }

                }


                if(rbghe.isChecked()) {
                    int thanhtien4= b-(b*30/100)+60000;
                    int thanhtien5=b-(b*30/100);
                    int thanhtien6=b+phi;
                    if(spintt.getSelectedItem()=="VNĐ") {
                        if (rbvip.isChecked() && chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien4 + "VNĐ";
                        else if (rbvip.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien5 + "VNĐ";
                        else if (chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien6 + "VNĐ";
                        else
                            msg += System.getProperty("line.separator") + "Thành tiền:" + b + "VNĐ";
                    }
                    else{
                        if (rbvip.isChecked() && chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien4/20000 + "USD";
                        else if (rbvip.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien5/20000 + "USD";
                        else if (chk1.isChecked())
                            msg += System.getProperty("line.separator") + "Thành tiền:" + thanhtien6/20000 + "USD";
                        else
                            msg += System.getProperty("line.separator") + "Thành tiền:" + b/20000 + "USD";
                    }
                }

                msg += System.getProperty("line.separator") + "CẢM ƠN QUÝ KHÁCH !!!";

                info(v,msg);

            }
        });
        btnhuy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(0);
            }
        });

    }

}
