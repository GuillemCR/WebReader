package edu.upc.eseiaat.pma.guillemcomas.webreader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Guillem CoRa on 9/10/2017.
 */

public class WebReader {
    public static String getURL(String surl){
        String error = "Error: ";
        try {
            URL url = new URL(surl);
            HttpURLConnection conn= (HttpURLConnection) url.openConnection();

            if (conn.getResponseCode() != HttpURLConnection.HTTP_OK)
                return error + conn.getResponseMessage();

            InputStream in = conn.getInputStream();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            copyBytes(in,out);
            out.close();                                                                            //in es tanca amb la connexió
            return  out.toString();

        } catch (MalformedURLException e) {                                                         //evitem que peti l'APP
            return error + e.toString();
        } catch (IOException e) {
            return error + e.toString();
        }
    }

    private static void copyBytes(InputStream in, ByteArrayOutputStream out) throws IOException {   //capturem excepció al try/catch d'adalt
        byte[] bytes = new byte[1024];
        int nbytes = in.read(bytes);

        while (nbytes>0) {
            out.write(bytes,0,nbytes);
            nbytes = in.read(bytes);
        }
    }
}
