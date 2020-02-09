package market_maker;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class pov {
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("enter order quantity");
		Scanner pov = new Scanner(System.in); 
		int trade_size = pov.nextInt(); 
		Scanner vol = new Scanner(System.in);  
		System.out.println("enter average volume quantity");
		int volume = vol.nextInt(); 		
		int time_rem = 20;
		double pov1 = volume * .15;
		double trade_remaining = trade_size;
		double pov_release = pov1 / time_rem;
		pov_release = Math.floor(pov_release);  
		double shares_sold = 0;
		
		while(time_rem>0 && trade_remaining>0) {
			System.out.println(pov_release);
			shares_sold = shares_sold + pov_release;
			trade_remaining = trade_remaining - pov_release;
			time_rem = time_rem - 1;
				if(trade_remaining<pov_release) {
					pov_release = trade_remaining;
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
