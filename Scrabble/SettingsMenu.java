package edu.gatech.seclass.words6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import edu.jim.scrabbleprototype.R;

public class SettingsMenu extends AppCompatActivity {
    static Player p;
    static Settings s;
    static Game g;
    TextView txtMaxTurns;
    TextView txtLetterField;
    TextView txtCountField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_menu);
        Intent i = getIntent();
        s = (Settings)i.getSerializableExtra("settingsObj");
        txtMaxTurns = findViewById(R.id.txtmaxTurns);
        txtLetterField = findViewById(R.id.letterField);
        txtCountField = findViewById(R.id.countField);
    }


    public void clickMaxTurns(View view) {
        s.setMax_turns(Integer.parseInt(txtMaxTurns.getText().toString()) );
        Context context = getApplicationContext();
        CharSequence text = "Max turns changed to " + txtMaxTurns.getText().toString();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void ClickChangeLetterCount(View view) {
        String letter = txtLetterField.getText().toString().toUpperCase();
        int count = Integer.parseInt(txtCountField.getText().toString());
        s.changeLetterCount(letter.charAt(0),count);
        Context context = getApplicationContext();
        CharSequence text = "Character " + letter.charAt(0)+ " count changed to: " + count;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        //User inputs 1 letter, what letter did they chose, find it in the arraylist, and change the count to the user input number

    }

    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("settingsObj",s);
        setResult(1,intent);
        finish();
        super.onBackPressed();
    }
}

