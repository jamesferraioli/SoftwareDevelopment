package market_maker;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class open_market {
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("enter order quantity");
		Scanner open_market = new Scanner(System.in); 
		int open_market_release = open_market.nextInt(); 
		Scanner vol = new Scanner(System.in);  
		System.out.println("enter average volume quantity");
		int volume = vol.nextInt(); 	
		int time_rem = 390;
		int trade_remaining = open_market_release;
		open_market_release = (int) Math.floor(open_market_release);
		double shares_sold = 0;
		
		while(trade_remaining>0)  {
			System.out.println(open_market_release);
			shares_sold = shares_sold + open_market_release;
			trade_remaining = trade_remaining - open_market_release;
			time_rem = time_rem - 1;
			System.out.println(trade_remaining);
			TimeUnit.SECONDS.sleep(1);
							
		}
	System.out.println("Sold"); 
	System.out.println(shares_sold); 
	System.out.println("shares");
		
	}

	private static boolean len(double trade_remaining) {
		// TODO Auto-generated method stub
		return false;
	}

	}


