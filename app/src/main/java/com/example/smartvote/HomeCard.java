package com.example.smartvote;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HomeCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_card);
        final EditText card = findViewById(R.id.card_Text);
        Button summit = findViewById(R.id.summit_button);
        summit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = card.getText().toString();

                if(card.length()!=13){
                    Toast t = Toast.makeText(HomeCard.this,"กรุณากรอกหมายเลขบัตรประชาชน 13 หลัก",Toast.LENGTH_LONG);
                    t.show();
                }
                else{
                    String print = "";
                    boolean check = checkid(ID);
                    if(check == true){
                        print = "คุณมีสิทะิ์เลือกตั้ง";
                    }
                    else{
                        print = "คุณไม่มีสิทธิ์เลือกตั้ง";
                    }

                    AlertDialog.Builder dialog = new AlertDialog.Builder(HomeCard.this);
                    dialog.setTitle("ผลการตรวจสอบสิทธิเลือกตั้ง");
                    dialog.setMessage(print);
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });
                    dialog.setCancelable(true);
                    dialog.show();

                }
            }

        });
        }

        private boolean checkid(String number) {
            char c = number.charAt(0);
            int lenght = number.length();
            int count = 0;
            for (int i = 0; i < lenght; i++) {
                if (number.charAt(i) == c) {
                    count++;
                }
            }
            if (count == lenght)
                return true;
            else
                return false;
    }
}
