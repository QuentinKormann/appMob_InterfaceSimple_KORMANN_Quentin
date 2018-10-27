package com.example.killxportable.app_mobile_android_td1;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    //Variable
    private String nameApp;
    private String formattedDate;
    private Calendar currentTime;
    private SimpleDateFormat Date;
    private TextView tvDate;
    private TextView tvMail;
    private EditText etNom;
    private EditText etPrenom;
    private RadioGroup rgFM;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Nom de l'app dans la console
        nameApp = getResources().getString(R.string.app_name);
        Log.i("nameApp", nameApp);

        //Liaison par ID
        tvDate = (TextView) findViewById(R.id.tvDate);
        tvMail = (TextView) findViewById(R.id.tvMail);
        etNom = (EditText) findViewById(R.id.etNom);
        etPrenom = (EditText) findViewById(R.id.etPrenom);
        rgFM = (RadioGroup) findViewById(R.id.rgFM);

        //Affichage de la date
        currentTime = Calendar.getInstance();
        Date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        formattedDate = Date.format(currentTime.getTime());
        tvDate.setText(formattedDate);
        //tvDate.setTextColor();
        tvDate.setTypeface(null, Typeface.ITALIC);

        //EditText clavier majuscule
        etNom.setInputType(InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS);

        //EditText clavier 1er lettre majuscule
        etPrenom.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //Update un TextView
        etPrenom.addTextChangedListener(new TextWatcher() {

           @Override
           public void beforeTextChanged(CharSequence s, int start, int count,
           int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before,
           int count) {

           }

           @Override
           public void afterTextChanged(Editable arg0) {

               tvMail.setText(etPrenom.getText().toString() + etNom.getText().toString() + "@ludus-academie.com");

           }
        });

        //RadioBouton et toast du choix F ou M
        rgFM.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {



                if(checkedId == R.id.rbF){

                    Toast.makeText(getApplicationContext(),"Bonjour Madame " + etNom.getText().toString(), Toast.LENGTH_SHORT).show();
                }

                else if(checkedId == R.id.rbM){

                    Toast.makeText(getApplicationContext(), "Bonjour Monsieur " + etNom.getText().toString(), Toast.LENGTH_SHORT).show();
                }

                else{
                    Toast.makeText(getApplicationContext(), "Erreur", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
