package edu.gatech.seclass.words6300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class HelloWorld {
	static Player p;	
	static Settings s;
	static Game g;

	

	public static void main(String[] args) throws IOException {
	s= new Settings();
	System.out.println(s.getMax_turns());
	
//	System.out.println(s.getPoolLetters().get('B').points);	
    // On Console Load
	p = new Player(s);
	// on PlayGame click
	g = new Game(s);
	// Goto Settings click on change Max turns
	// Text box -> 20;p.setMaxTurns(inputTextValue);
	p.setMaxTurns(20);
// -----------------Adjust settings for Letters ---------------------
	// Get the current poolLetters from Settings
	HashMap<Character, Letter> poolLetters = p.viewLetterPool();
		/*
		 * // Input character, points, count20 
		 * poolLetters.put('A', new Letter('A',10,9)); 
		 * poolLetters.put('B', new Letter('B',3,4));
		 */
	
	p.adjustLettersInfo(poolLetters);
	

// ----------------	 SHOW Board Letters ---------------------//
	ArrayList<Character> boardLetters = g.getBoardLetters();
	System.out.println(boardLetters);
	//Display them on board
// ----------------	 SHOW Rack Letters ---------------------//
	ArrayList<Character> rackLetters = g.getRackLetters();
	//Display them on rack	
	System.out.println(rackLetters);
	// Converting Pool letters to  a string (to display in Text box)
 /*   for (Entry<Character, Letter> me : s.poolLetters.entrySet()) {
        System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue().symbol + ":" + me.getValue().points + ":" + me.getValue().count );
      } */
    //------Check word validity --------//
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter Word");
    String madeWord = br.readLine();    
//    String madeWord = "come"; // hello
    g.validateWordAndTurn(madeWord);
    }

	
}