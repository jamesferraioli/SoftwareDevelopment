package edu.gatech.seclass.words6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.jim.scrabbleprototype.R;

public class StatisticsMenu extends AppCompatActivity {

    Button btnGame, btnLetter, btnWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_menu);

        // gameDB = new DatabaseGame(this) ????

        btnGame = (Button) findViewById(R.id.gameScoreStats);
        btnLetter = (Button) findViewById(R.id.letterStats);
        btnWord = (Button) findViewById(R.id.wordBankStats);


    }

    public void goToGameScoreStats(View view){
        Intent intent = new Intent(StatisticsMenu.this,GameScoreStats.class);
        startActivity(intent);
    }

    public void goToLetterStats(View view){
        Intent intent = new Intent(StatisticsMenu.this,LetterStats.class);
        startActivity(intent);
    }

    public void goToWordBank(View view){
        Intent intent = new Intent(StatisticsMenu.this,WordBank.class);
        startActivity(intent);
    }


//    public void viewGameStatistics(){
//        btnGame.setOnClickListener(
//                new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //Cursor res = gameDB.getGameData();
//                        //if(res.getCount() == 0)
//                        return;
//                    }
//                }
//        );
//    }
}


/*
    gameDB: add data when Game over. Need score, turns, setting.
    letterDB: update the data when "Word()" function was called.
    WrodDB: update or insert new row data when "Word()" function was called.

 */