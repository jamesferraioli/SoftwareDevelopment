package edu.gatech.seclass.words6300;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Letter implements Serializable {

	char symbol;
	int points;
	int count;
	int wordCount = 0;
	int swapCount = 0;
	int drawnCount = 0;

	public Letter(char c, int i, int j) {
		symbol = c;
		points = i;
		count = j;
	}
	/*    public Letter(char c, int i, int j, int drawnCount) {
            symbol = c;
            points = i;
            count = j;
            this.drawnCount = drawnCount;
        }

        public Letter(char c, int i, int j, int wordCount, int swapCount) {
            symbol = c;
            points = i;
            count = j;
            this.wordCount = wordCount;
            this.swapCount = swapCount;
        } */
	public Letter(char c, int i, int j, int drawnCount, int swapCount, int wordCount) {
		symbol = c;
		points = i;
		count = j;
		this.wordCount = wordCount;
		this.drawnCount = drawnCount;
		this.swapCount = swapCount;
	}
}