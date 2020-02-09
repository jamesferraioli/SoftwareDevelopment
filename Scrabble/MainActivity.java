package edu.gatech.seclass.words6300;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map.Entry;
import java.util.Set;

import edu.jim.scrabbleprototype.R;


public class MainActivity extends AppCompatActivity {

    int totalTurns = 0;
    int scorecount = 0;
    TextView score;
    EditText wordToPlay;
    TextView board;
    TextView rack;
    //Button exitButton;
    Button playButton;
    Button swapRack;
    //Button back;
    static Player p;
    static Settings s;
    static Game g;
    Button viewPool;
    TextView viewPoolLetters;
    String strViewPoolLetters;
    Boolean checkword;
    TextView turns;
    TextView wordsplayed;
    TextView maxturns;


    @Override
    public void onBackPressed() {
        Intent intent = getIntent();
        intent.putExtra("gameObj",g);
        setResult(1,intent);
        finish();
        super.onBackPressed();
    }

    @Override
    protected void onResume() {
        wordsplayed.setText("word bank" + g.wordBank.toString());
        super.onResume();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        s= new Settings();
        Intent i = getIntent();
        s = (Settings)i.getSerializableExtra("settingsObj");
        g = (Game)i.getSerializableExtra("gameObj");
        p = (Player) i.getSerializableExtra("playerObj");

  //      p = new Player(s);
  //      g = new Game(s);
  //      p.setMaxTurns(20);

        //assigning each field on the GUI to an object
        board = findViewById(R.id.board);
        wordToPlay = findViewById(R.id.wordToPlay);
        playButton = findViewById(R.id.playButton);
        rack = findViewById(R.id.rack);
        //exitButton = findViewById(R.id.exitButton);
        score = findViewById(R.id.score);
        swapRack = findViewById(R.id.swapRack);
        viewPool = findViewById(R.id.viewPool);
        viewPoolLetters = findViewById(R.id.viewPoolLetters);
        turns = findViewById(R.id.turns);
        maxturns = findViewById(R.id.maxturns);
        wordsplayed = findViewById(R.id.wordsplayed);
//        back = findViewById(R.id.back);

        strViewPoolLetters = "";
        for (Entry<Character, Letter> me : s.poolLetters.entrySet()) {
            strViewPoolLetters = strViewPoolLetters + me.getValue().symbol + ":" + me.getValue().points + ":" + me.getValue().count;
        }
        maxturns.setText("max turns: " + String.valueOf(s.max_turns));

        //initial method to fill the board with 4 tiles
        if (board.getText().toString().isEmpty()) {
            board.setText(g.getBoardLetters().toString());
            score.setText("score: " + String.valueOf(g.points));
            turns.setText("turn: " + String.valueOf(g.currentTurn));
        }

        //method to fill the rack from the pool
        if (rack.getText().toString().isEmpty()) {
            //need to set the below line to pull up to 7 random tiles from the pool
            rack.setText(g.getRackLetters().toString());
        }

        //plays a word to the banner field upon using the "play" button
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkword = g.validateWordAndTurn(wordToPlay.getText().toString().toUpperCase());
                if (g.currentTurn > Integer.valueOf(s.max_turns + 1)) {
                    turns.setText(String.valueOf("Turn: " + s.max_turns));
                    Context context = getApplicationContext();
                    CharSequence text = "Reached Max turns";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    return;
                }
                if (!checkword) {
                    //error message
                    Context context = getApplicationContext();
                    CharSequence text = "Word not valid, Choose 1 letter from board and remaining letters from Rack";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                else {
                    score.setText("score: " + String.valueOf(g.points));
                    turns.setText(String.valueOf("Turn" + g.currentTurn));
                    board.setText(g.boardLetters.toString());
                    rack.setText(g.rackLetters.toString());
                    strViewPoolLetters = "";
                    for (Entry<Character, Letter> me : s.poolLetters.entrySet()) {
                        strViewPoolLetters = strViewPoolLetters + me.getValue().symbol + ":" + me.getValue().points + ":" + me.getValue().count;
                    }
                    wordsplayed.setText("word bank" + g.wordBank.toString());
                    wordToPlay.setText("");
                }
                //sets the board to whatever is in the wordToPlay field
                //hides pool letters after letter is played
                viewPoolLetters.setText(" ");
            }
        });

 /*       back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                //Intent intent = new Intent(MainActivity.this,MainMenu.class);
                //intent.putExtra("settingsObj",s);
                //                //intent.putExtra("gameObj",g);
                //                //intent.putExtra("playerObj",p);
                //                //startActivity(intent);
               // Log.d(Settings.tag, "Game: current Turn"+g.currentTurn);
                intent.putExtra("gameObj",g);
               // setResult(RESULT_OK,intent);
                setResult(1,intent);
                finish();
            }
        }); */
        //swaps out the tiles on the rack with tiles from the pool
        swapRack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //need to set the below line to pull up to 7 random tiles from the pool
                // need to do this for swap rack letters - change out Str
                //rackLetters.setText();
                rack.setText(g.getRackLetters().toString());
                //turns # is not being updated on GUI, but believe it is counting it which causes the program to shut down upon max turns
                //turns.setText(String.valueOf(g.currentTurn));
            }
        });

        viewPool.setOnClickListener(new View.OnClickListener() {
            @Override
            //need to trouble shoot so this shows hashmap value
            public void onClick(View view) {
                viewPoolLetters.setText(strViewPoolLetters);
            }
        });

}
}
