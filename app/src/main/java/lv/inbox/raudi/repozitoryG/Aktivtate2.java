package lv.inbox.raudi.repozitoryG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import lv.inbox.raudi.repozitorijsgmpi1nl.R;

public class Aktivtate2 extends AppCompatActivity {

    SharedPreferences sharedPrefs;
    SharedPreferences.Editor cleerEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aktivtate2);

        final EditText savedOutput = (EditText) findViewById(R.id.txtActivity2);
        Button btnRead = (Button) findViewById(R.id.btnRead);
        Button btnToA1 = (Button) findViewById(R.id.btnBack);

        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String savedUserInput = getStoredValue();

                if (!savedUserInput.isEmpty()){
                    savedOutput.setText(savedUserInput);
                } else {
                }
                clearPref();
            }
        });

        btnToA1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
//                Intent goToA1 = new Intent(getApplicationContext(), Aktivitate1.class);
//                startActivity(goToA1);
            }
        });
    }
    public String getStoredValue(){
        String returnValue;
        sharedPrefs = getSharedPreferences(getResources().getString(R.string.SharePrefName), MODE_PRIVATE);
        returnValue = sharedPrefs.getString(getResources().getString(R.string.SharePrefKey),"");
        return returnValue;
    }
    public void clearPref(){
        sharedPrefs = getSharedPreferences(getResources().getString(R.string.SharePrefName), MODE_PRIVATE);
        cleerEditor = sharedPrefs.edit();
        cleerEditor.putString(getResources().getString(R.string.SharePrefKey),"");
        cleerEditor.apply();
    }
}
