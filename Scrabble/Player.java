package edu.gatech.seclass.words6300;

import java.util.HashMap;
import java.io.Serializable;
@SuppressWarnings("serial")

public class Player implements Serializable{
	Game g;
	Settings s;
    int playerID;
    Player(Settings s) {
    	this.s = s;
    }

    char[] currentWord;

/*    void newGame(Settings s) {
    	g = new Game(s);
    } */
 
    HashMap<Character, Letter> viewLetterPool() {
    	HashMap<Character, Letter> poolLetters = s.getPoolLetters();
		return poolLetters;

    }    
    void adjustLettersInfo(HashMap<Character, Letter> poolLetters) {
    	s.setPoolLetters(poolLetters);
    }    
    void setMaxTurns(int i) {
    	s.setMax_turns(i);
    }
    
    void viewGameScoreStats() {

    }

    void viewWordBankStats() {

    }

    void viewLetterStats() {

    }

    void exitGame() {

    }

    void makeWordAndTurn(Game g) {

    }

    void swapLetters() {

    }



}
