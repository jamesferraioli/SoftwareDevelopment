package edu.gatech.seclass.words6300;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Settings s = new Settings();
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();
    	Object[] crunchifyKeys = poolLetters.keySet().toArray();
    	Object key = crunchifyKeys[new Random().nextInt(crunchifyKeys.length)];
    	System.out.println(key);
    	System.out.println(poolLetters.get(key).symbol);
    	System.out.println(poolLetters.get(key).points);
    	ArrayList<Character> boardLetters = new ArrayList<Character>();
    	boardLetters.add((Character) key) ;
		
    	ArrayList<Integer> randomNumbers = new ArrayList<Integer>(); 
    	while (randomNumbers.size() < 4) {
        	int random = new Random().nextInt(crunchifyKeys.length);
        	if (!randomNumbers.contains(random)) {
        		randomNumbers.add(random);
        	}
    	}
    	System.out.println(randomNumbers);
    	for (int i:randomNumbers)
    		System.out.println(i);
    	
  	
    	
	}

}
