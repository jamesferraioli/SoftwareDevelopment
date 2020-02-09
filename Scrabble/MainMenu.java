package edu.gatech.seclass.words6300;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.util.Log;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Set;

import edu.jim.scrabbleprototype.R;

public class MainMenu extends AppCompatActivity {

    private Button playGame;
    Settings s = new Settings();
    Game g = new Game(s);
    Player p = new Player(s);

    //Database object
    DataBaseGame g_DB;
    DataBaseLetter l_DB;
    DataBaseWord w_DB;

    // Time stamp formate
    private static final DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Log.d(Settings.tag, "Menu:Create()" + g.currentTurn);

        //ToDo: Database constructor
        g_DB = new DataBaseGame(this);
        l_DB = new DataBaseLetter(this);
        w_DB = new DataBaseWord(this);

    }

    // THIS BUTTON KEEPS CRASHING. I BELIEVE THERE IS SOMETHING WRONG WITH MAINACTIVITY.CLASS
    public void goToGame(View view) {
        //       Log.d(Settings.tag,"Menu current turn" + g.currentTurn);
        Intent intent = new Intent(MainMenu.this, MainActivity.class);
        intent.putExtra("settingsObj", s);
        intent.putExtra("gameObj", g);
        intent.putExtra("playerObj", p);
        startActivityForResult(intent, 1); // 1 for game

    }

    public void goToSettingsMenu(View view) {

        Intent intent = new Intent(MainMenu.this, SettingsMenu.class);
        intent.putExtra("settingsObj", s);
        startActivityForResult(intent, 2); // 2 for settings

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1: // For result from Game obj
                this.g = (Game) data.getExtras().getSerializable("gameObj");

                /**************************************************************************/
                //
                // Getting the game's points and turns and add them into the game database
                //
                /*************************************************************************/
                int points = g.points;
                int turns = g.currentTurn;

                System.out.println("Game points is " + Integer.toString(points));
                System.out.println("Game turns is " + Integer.toString(turns));

                boolean game_inserted = g_DB.insertGameData(Integer.toString(points), Integer.toString(turns));
                if (game_inserted) {
                    Toast.makeText(MainMenu.this, "Inserted the Game info", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainMenu.this, "Not Inserted the Game info ", Toast.LENGTH_LONG).show();
                }

                /**************************************************************************/
                //
                // get the letter information and update into the

                /************************************************************************/
                HashMap<Character, Letter> pool_letters = g.s.getPoolLetters();

                // Get the previous letter database
                Cursor res = l_DB.getAllData();

                for (int i = 0; i < 26; i++) {
                    char key = (char) (i + 'A');
                    Letter lt_obj = pool_letters.get(key);

                    // Get the sym of letter
                    char sym = lt_obj.symbol;

                    // Get word count of letter
                    int word_cnt = lt_obj.wordCount;

                    // Get the swap count of letter
                    int swap_cnt = lt_obj.swapCount;


                    if (res.getCount() == 0) { // If the letter database is empty we add the letter directly
                        System.out.println("Letter Database is empty!");
                        // Insert the Database
                        boolean letter_inserted = l_DB.insertLetterData(Character.toString(sym),
                                Integer.toString(word_cnt),
                                Integer.toString(swap_cnt));

                        // Check the inserting process
                        if (!letter_inserted) {
                            Toast.makeText(MainMenu.this, "Letter " + sym + " Inserted Failure! ", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        // Update the database
                        l_DB.updateLetterData(Character.toString(sym),
                                Integer.toString(word_cnt),
                                Integer.toString(swap_cnt));
                    }
                }

                /***********************************************************************
                 *
                 * ToDo: For Word Database
                 *
                 ***********************************************************************/
                ArrayList<String> wordsPlayed = g.wordBank;
                System.out.println(Arrays.toString(wordsPlayed.toArray()));

                for (String word : wordsPlayed) {
                    boolean flag = w_DB.checkWordDB(word); // if or not the word was found in DB
                    if (flag) {
                        // update word
                        w_DB.updateWordData(word, sdf.format(new Date()));
                    } else {
                        // insert word
                        boolean letter_inserted = w_DB.insertWordData(word, "1", sdf.format(new Date()));
                        // Check the inserting process
                        if (!letter_inserted) {
                            Toast.makeText(MainMenu.this, "Wrod " + word + " Inserted Failure! ", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                break;

            case 2: // For result from Settings obj
                this.s = (Settings) data.getExtras().getSerializable("settingsObj");
                Log.d(Settings.tag, "max turns" + s.max_turns);
                break;


                /*case 3: // For result from Stats Obj
                this.g = (Game)data.getExtras().getSerializable("gameObj"); */

        }
    }


    // Statistic Result show functions
    public void viewGameDB(View view) {
        Cursor res = g_DB.getGameData();
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found in Game Statistic Database");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            String scores = res.getString(1);
            String turns = res.getString(2);
            int avg_s = Integer.parseInt(scores) / Integer.parseInt(turns);

            buffer.append("Id :" + res.getString(0) + "\n");
            buffer.append("Scores :" + scores + "\n");
            buffer.append("Turns :" + turns + "\n");
            buffer.append("Average Scores :" + avg_s + "\n\n");
        }
        // show all data
        showMessage("Game Statistic", buffer.toString());
    }

    public void viewLetterDB(View view) {
        Cursor res = l_DB.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found in Letter Statistic Database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            String playWord = res.getString(1);
            String tradeback = res.getString(2);

            double percent = 0.0;
            if (tradeback != "0") {
                percent = Double.valueOf(playWord) / Double.valueOf(tradeback);
            }

            buffer.append("Letter :" + res.getString(0) + "\n");
            buffer.append("playWord :" + playWord + "\n");
            buffer.append("tradeBack :" + tradeback + "\n");
            buffer.append("Percent :" + formatDouble(percent) + "%\n\n");
        }
        // show all data
        showMessage("Letter Statistic", buffer.toString());
    }

    public void viewLWordDB(View view) {
        Cursor res = w_DB.getWordData();
        if (res.getCount() == 0) {
            showMessage("Error", "Nothing found in Word Statistic Database");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Word :" + res.getString(0) + "\n");
            buffer.append("Number :" + res.getString(1) + "\n");
            buffer.append("TT :" + res.getString(2) + "\n\n");
        }
        // show all data
        showMessage("Word Statistic", buffer.toString());
    }

    public String formatDouble(double s) {
        DecimalFormat fmt = new DecimalFormat("##0.0");
        return fmt.format(s);
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);

        builder.show();
    }

}

