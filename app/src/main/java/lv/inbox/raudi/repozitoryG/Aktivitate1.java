package lv.inbox.raudi.repozitoryG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import lv.inbox.raudi.repozitorijsgmpi1nl.R;

public class Aktivitate1 extends AppCompatActivity {

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor prefsEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText a1InputField = (EditText) findViewById(R.id.txtActivity1);
        Button btnSave = (Button) findViewById(R.id.btnSave);
        final Button btnToA2 = (Button) findViewById(R.id.btnActivity2);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = a1InputField.getText().toString();
                saveData(userInput);
            }
        });

        btnToA2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goToA2 = new Intent(getApplicationContext(), Aktivtate2.class);
                startActivity(goToA2);
            }
        });

    }
    public void saveData(String userInput){
        sharedPrefs = getSharedPreferences(getResources().getString(R.string.SharePrefName), MODE_PRIVATE);
        prefsEditor = sharedPrefs.edit();

        prefsEditor.putString(getResources().getString(R.string.SharePrefKey), userInput);
        prefsEditor.apply();

    }
}
