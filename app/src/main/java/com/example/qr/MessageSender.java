package com.example.qr;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageSender extends AsyncTask<String,Void,Void> {
    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... voids) {
        try {

            String message= voids[0];
            s=new Socket("10.70.26.255",7810);
            pw=new PrintWriter(s.getOutputStream());
            pw.write(message);
            pw.flush();
            pw.close();
            s.close();

        }catch (IOException e){
            System.out.println("connection problems doinbackground");
            e.printStackTrace();
        }
        return null;
    }
}
