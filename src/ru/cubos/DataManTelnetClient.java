package ru.cubos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DataManTelnetClient {
    public DataManTelnetClient(DataManCallback dataManCallback, String host){

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {

                Socket socket = null;
                BufferedReader in = null;

                try {
                    socket = new Socket(host, 23);
                    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                } catch (IOException e) {
                    return;
                }

                try {
                    while (true){
                        String outString = in.readLine();
                        if(outString!=null){
                            dataManCallback.onCodeScanned(outString);
                        }
                        Thread.sleep(1);
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    socket.close();
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

    }
}
