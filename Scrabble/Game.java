package edu.gatech.seclass.words6300;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Game implements Serializable {
	int GameID;
	int points = 0;
	int currentTurn = 1;
	Boolean validTurn = false;
	Boolean active = true;
	ArrayList<String> wordBank = new ArrayList<String>();
	//ArrayList<char> currentWord = new ArrayList<char>();
	int score;
	int totalTurns;
	ArrayList<Character> boardLetters = new ArrayList<Character>();
	ArrayList<Character> rackLetters = new ArrayList<Character>();
	ArrayList<Character> poolLetters = new ArrayList<Character>();
	//    char boardLetters[] = new char[4];
//    char rackLetters[] = new char[7];
//    char poolLetters[] = new char[27];
	ArrayList<Letter> lettersInfo = new ArrayList<Letter>();

	HashMap<Character, Integer> letterWordCount = new HashMap<Character, Integer>();
	HashMap<Character, Integer> letterSwapCount = new HashMap<Character, Integer>();
	HashMap<Character, Integer> letterDrawnCount = new HashMap<Character, Integer>();

	Settings s;

	public Game(Settings s) {
		this.s = s;
	}

	void startGame() {

	}

	public int getCurrentTurn() {
		return currentTurn;
	}
	void endGame() {

	}

	ArrayList<Character> getBoardLetters() {
		ArrayList<Character> boardLetters = new ArrayList<Character>();
		//Get 4 random letters from Pool and update the Pool with new count
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();
		// filter the pool and eliminate the letters that have count 0
		Map<Character, Letter> filteredPoolLetters = poolLetters.entrySet()
				.stream()
				.filter(map -> map.getValue().count != 0)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		Object[] crunchifyKeys = filteredPoolLetters.keySet().toArray();
		/* Get 4 non-duplicate random numbers to randomNumbers Array */
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		while (randomNumbers.size() < 4) {
			int random = new Random().nextInt(crunchifyKeys.length);
			if (!randomNumbers.contains(random)) {
				randomNumbers.add(random);
			}
		}
		// Find keys for the random Numbers and add to board letters
		for (int i:randomNumbers) {
			Object key = crunchifyKeys[i];
			boardLetters.add((Character) key);
			// update pool letters
			// If count of that symbol is 1, remove the symbol from pool, else reduce the symbol count by 1
/*    		if (poolLetters.get(key).count == 1)
    			poolLetters.remove(key);
    		else */
			poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count - 1,poolLetters.get(key).drawnCount + 1,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount));

		}
		// Update the settings with new pool letters
		s.setPoolLetters(poolLetters);
		this.boardLetters = boardLetters;
		return boardLetters;
	}

	ArrayList<Character> getRackLetters() {
		ArrayList<Character> rackLetters = new ArrayList<Character>();
		//Get 4 random letters from Pool and update the Pool with new count
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();

		// filter the pool and eliminate the letters that have count 0
		Map<Character, Letter> filteredPoolLetters = poolLetters.entrySet()
				.stream()
				.filter(map -> map.getValue().count != 0)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		Object[] crunchifyKeys = filteredPoolLetters.keySet().toArray();
		/* Get 4 non-duplicate random numbers to randomNumbers Array */
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
		while (randomNumbers.size() < 7) {
			int random = new Random().nextInt(crunchifyKeys.length);
			if (!randomNumbers.contains(random)) {
				randomNumbers.add(random);
			}
		}
		// Find keys for the random Numbers and add to board letters
		for (int i:randomNumbers) {
			Object key = crunchifyKeys[i];
			rackLetters.add((Character) key);
			// update pool letters
			// Reduce the symbol count by 1
			poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count - 1,poolLetters.get(key).drawnCount + 1,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount));
		}
		// Update the settings with new pool letters
		s.setPoolLetters(poolLetters);
		this.rackLetters = rackLetters;
		return rackLetters;
	}

	private ArrayList<Character> getRackLetters( ArrayList<Character> inRackLetters) {
		ArrayList<Character> rackLetters = inRackLetters;
		//Get 4 random letters from Pool and update the Pool with new count
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();

		// filter the pool and eliminate the letters that have count 0
		Map<Character, Letter> filteredPoolLetters = poolLetters.entrySet()
				.stream()
				.filter(map -> map.getValue().count != 0)
				.collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

		Object[] crunchifyKeys = filteredPoolLetters.keySet().toArray();
		/* Get 4 non-duplicate random numbers to randomNumbers Array */
		ArrayList<Integer> randomNumbers = new ArrayList<Integer>();
// IF inRackLetter size is 5, we just need to fill in the rack with remaining 2 letters (IF condition: 7-5 = 2)
		while (randomNumbers.size() < (7-inRackLetters.size())) {
			int random = new Random().nextInt(crunchifyKeys.length);
			if (!randomNumbers.contains(random)) {
				randomNumbers.add(random);
			}
		}
		// Find keys for the random Numbers and add to board letters
		for (int i:randomNumbers) {
			Object key = crunchifyKeys[i];
			rackLetters.add((Character) key);
			// update pool letters
			// Reduce the symbol count by 1
			poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count - 1,poolLetters.get(key).drawnCount + 1,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount));
		}
		// Update the settings with new pool letters
		s.setPoolLetters(poolLetters);
		this.rackLetters = rackLetters;
		return rackLetters;
	}


	ArrayList<Character> swapRackLetters() {
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();
		for (char key: rackLetters) {
			poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count + 1,poolLetters.get(key).drawnCount,poolLetters.get(key).swapCount + 1,poolLetters.get(key).wordCount));
/*            Integer in = letterSwapCount.putIfAbsent(key, 1); 
            if (in!=null)
            	letterWordCount.put(key, in + 1); */
		}
		currentTurn ++;
		return getRackLetters();
	}


	Boolean validateWordAndTurn(String madeWord) {
		char boardLetter = 0;
		int wordPoints = 0;
		HashMap<Character, Letter> poolLetters = s.getPoolLetters();
		ArrayList<Character> madeWordCharArray = new ArrayList<Character>();
		ArrayList<Character> tempWordCharArray = new ArrayList<Character>();
		for (char c : madeWord.toCharArray()) {
			madeWordCharArray.add(c);
			tempWordCharArray.add(c);
			wordPoints += poolLetters.get(c).points;
		}
		System.out.println("validateWordAndTurn(): Word Points:" + wordPoints);
		Boolean validWord = false;

		ArrayList<Character> tempBoardLetters = (ArrayList<Character>) boardLetters.clone();
		ArrayList<Character> tempRackLetters = (ArrayList<Character>) rackLetters.clone();

		System.out.println("validateWordAndTurn(): Current Board letters:" + tempBoardLetters);
		System.out.println("validateWordAndTurn(): Current Rack letters:" + tempRackLetters);

		/* Check if a letter from word exists in board, if not return false*/
		for (char c:madeWordCharArray) {
			if (tempBoardLetters.contains(c)) {
				boardLetter = c;
				madeWordCharArray.remove(new Character(c));
				tempBoardLetters.remove(new Character(c));
				validWord = true;
				break;
			}
		}
		if (!validWord) {
			System.out.println("validateWordAndTurn(): Not a valid word. Word doesn't contain letter from board:");
			return false;
		}
		else {
			System.out.println("validateWordAndTurn(): Word has a letter choosen from board, used board letter: " + boardLetter);
		}
		// Check if remaining letters of word are present in rack
		validWord = tempRackLetters.containsAll(madeWordCharArray);
		if (!validWord) {
			System.out.println("validateWordAndTurn(): Invalid word - doesn't contain letters from rack:");
			return false;
		}
		else { // Word is valid; Increase the turn count and add points to game; add word to wordlist
			System.out.println("validateWordAndTurn(): Valid word - has letters choosen from rack");
			if (wordBank.contains(madeWord)) {
				System.out.println("validateWordAndTurn(): Invalid - word already exists in word bank");
				return false;
			}
			currentTurn ++;
			wordBank.add(madeWord);
			points = points + wordPoints;
			System.out.println("validateWordAndTurn(): Game points so far: " + points);
			if (currentTurn == s.getMax_turns()) { // Set game status to Inactive
				System.out.println("validateWordAndTurn(): Reached maximum turns");
				active = false;
			}
			System.out.println("validateWordAndTurn(): Word bank: " + wordBank);
			System.out.println("letter word count before" + letterWordCount );
			/* Add letter count for words formed */
			for (char key:tempWordCharArray) {
				poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count,poolLetters.get(key).drawnCount,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount+1));
/*                Integer in = letterWordCount.putIfAbsent(c, 1); 
                if (in!=null)
                	letterWordCount.put(c, in + 1); */
			}
			System.out.println("letter word count after" + letterWordCount );
		} // End of Valid Word else loop
		/* Swap a random letter from word to the board */
		Random rand = new Random();
		int randIndex = rand.nextInt(madeWordCharArray.size());
		char randomSwapBoardLetter = madeWordCharArray.get(randIndex);
		tempBoardLetters.add(randomSwapBoardLetter);
		System.out.println("validateWordAndTurn(): New Board Letters " + tempBoardLetters);
		boardLetters = (ArrayList<Character>) tempBoardLetters.clone();

//        madeWordCharArray.remove(new Character(randomSwapBoardLetter));       
		tempRackLetters.removeAll(madeWordCharArray);
// Get the new rack letters for the letters that got moved out for forming a word
		getRackLetters(tempRackLetters);

		// Add tempRackLetters to pool letters - Increment the existing count by 1
/*        for (char key: tempRackLetters) {
    		poolLetters.put((Character) key, new Letter((char) key,poolLetters.get(key).points,poolLetters.get(key).count + 1,poolLetters.get(key).drawnCount,poolLetters.get(key).swapCount,poolLetters.get(key).wordCount));       	
        }
        s.setPoolLetters(poolLetters); 
        getRackLetters(); */
		System.out.println("validateWordAndTurn(): New Rack Letters " + rackLetters);
		return true;
	}

	Boolean isMaxTurn() {
		if (currentTurn == s.getMax_turns())
			return true;
		else
			return false;
	}

}
