package com.example.qr;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    public static TextView productText;
    public static TextView  xText;
    Button scanProduct_button;
    Button scanX_button;
    Button message_sender_button;
    public static String messageProduct="";
    public static String messagex="";
    public static String messages="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        productText=(TextView)findViewById(R.id.editText);
        xText=(TextView)findViewById(R.id.editText2);
        scanProduct_button=(Button)findViewById(R.id.scn_button);



        scanProduct_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    startActivity(new Intent(getApplicationContext(), ScanCodeActivity.class));
            }
        });

        scanX_button=(Button)findViewById(R.id.scn_button2);

        scanX_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScanCodeActivity2.class));
            }
        });


        message_sender_button=(Button)findViewById(R.id.button2);
        message_sender_button.setBackgroundColor(Color.LTGRAY);
        message_sender_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MessageSender messageSender =new MessageSender();
                messages=productText.getText().toString()+","+xText.getText().toString();
                try {
                    if (messages.length() > 1) {
                        messageSender.execute(messages);
                        productText.setText("");
                        xText.setText("");
                        Toast.makeText(getApplicationContext(),"Veri Gönderildi!!",Toast.LENGTH_SHORT)
                                .show();

                    }else
                        Toast.makeText(getApplicationContext(),"Bu alanlar boş olamaz",Toast.LENGTH_SHORT)
                                .show();

                }catch (Exception e){
                    throw e;
                }

            }
        });


    }
}
