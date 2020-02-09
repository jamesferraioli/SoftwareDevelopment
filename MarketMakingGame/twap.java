package market_maker;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class twap {
	public static void main(String[] args) throws InterruptedException 
	{
		Scanner twap = new Scanner(System.in);  
		System.out.println("enter order quantity");
		int trade_size = twap.nextInt(); 
		Scanner vol = new Scanner(System.in);  
		System.out.println("enter average volume quantity");
		int volume = vol.nextInt(); 
		double time_rem = 390;
		double total_vol_twap = volume / time_rem;
		double trade_twap = trade_size / time_rem;
		double trade_remaining = trade_size;
		trade_twap = Math.floor(trade_twap);

		double shares_sold = 0;
		
		while(time_rem>0) {
			System.out.println(trade_twap);
			shares_sold = shares_sold + trade_twap;
			trade_remaining = trade_remaining - trade_twap;
			time_rem = time_rem - 1;
				if(trade_remaining<trade_twap) {
					trade_twap = trade_remaining;
				}
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