package edu.gatech.seclass.words6300;

import java.util.HashMap;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Settings implements Serializable {
	public static String tag = "scrabble";
	int max_turns = 5;
	HashMap<Character, Letter> poolLetters = new HashMap<>();

	public int getMax_turns() {
		return max_turns;
	}
	public void setMax_turns(int max_turns) {
		this.max_turns = max_turns;
	}
	public HashMap<Character, Letter> getPoolLetters() {
		return poolLetters;
	}
	public void setPoolLetters(HashMap<Character, Letter> poolLetters) {
		this.poolLetters = poolLetters;
	}
	// Set Default Letter Info
	Settings() {
		//Default scrabble values
		//https://en.wikipedia.org/wiki/Scrabble_letter_distributions#English
		poolLetters.put('A', new Letter('A',1,9));
		poolLetters.put('E', new Letter('E',1,12));
		poolLetters.put('I', new Letter('I',1,9));
		poolLetters.put('O', new Letter('O',1,8));
		poolLetters.put('N', new Letter('N',1,6));
		poolLetters.put('R', new Letter('R',1,6));
		poolLetters.put('T', new Letter('T',1,6));
		poolLetters.put('L', new Letter('L',1,4));
		poolLetters.put('S', new Letter('S',1,4));
		poolLetters.put('U', new Letter('U',1,4));
		// 2 points
		poolLetters.put('D', new Letter('D',2,4));
		poolLetters.put('G', new Letter('G',2,3));
		// 3 points
		poolLetters.put('B', new Letter('B',3,2));
		poolLetters.put('C', new Letter('C',3,2));
		poolLetters.put('M', new Letter('M',3,2));
		poolLetters.put('P', new Letter('P',3,2));
		// 4 points
		poolLetters.put('F', new Letter('F',4,2));
		poolLetters.put('H', new Letter('H',4,2));
		poolLetters.put('V', new Letter('V',4,2));
		poolLetters.put('W', new Letter('W',4,2));
		poolLetters.put('Y', new Letter('Y',4,2));
		// 5 points
		poolLetters.put('K', new Letter('K',5,1));
		// 8 points
		poolLetters.put('J', new Letter('J',8,1));
		poolLetters.put('X', new Letter('x',8,1));
		// 10 points
		poolLetters.put('Q', new Letter('Q',10,1));
		poolLetters.put('Z', new Letter('Z',10,1));
	}
	void changeLetterCount(char inKey, int count) {
		char key = Character.toUpperCase(inKey);
		poolLetters.put(key, new Letter(key, poolLetters.get(key).points, count,poolLetters.get(key).drawnCount,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount ));
	}



}

