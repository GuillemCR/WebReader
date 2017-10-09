package edu.upc.eseiaat.pma.guillemcomas.webreader;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class WebActivity extends AppCompatActivity {
    private EditText editTextURL;
    private TextView textViewWEB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        editTextURL = (EditText) findViewById(R.id.editURL);
        textViewWEB = (TextView) findViewById(R.id.web_reader);

    }

    public void click_go(View view) {
        String url= editTextURL.getText().toString();
        //textViewWEB.setText(WebReader.getURL(editTextURL.getText().toString()));                  //no podem fer getURL aquí!
    }

    private class WebReaderTask extends AsyncTask<String,Void,String>{                              //Void pq no usarem el parametre
        @Override
        protected String doInBackground(String... url) {
            return WebReader.getURL(url[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            textViewWEB.setText(s);
        }
    }

}
