package market_maker;

import java.util.Scanner;
import java.util.Random;

public class client_instructions {
	public static void main(String[] args) throws Throwable
	{
		System.out.println("I'm looking to");
		Random rand = new Random(); 
		int value = rand.nextInt(100); 
		if(value>50) {
			System.out.println("buy");
		}
		else {
			System.out.println("sell");
		}
		Random rand1 = new Random();
		int rand2 = rand1.nextInt(2000000);
		System.out.println(rand2);
		System.out.println("shares of Appletosh Computer at");
		if(value>50) {
			System.out.println("the market.");
		}
		else {
			Random rand3 = new Random();
			int rand4 = rand3.nextInt(205);
			System.out.println(rand4);
			System.out.println("limit.");
		}
	}
}
