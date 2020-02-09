package market_maker;

import java.util.concurrent.TimeUnit;
import java.util.Scanner;


public class get_done {
	public static void main(String[] args) throws InterruptedException 
	{
		System.out.println("enter order quantity");
		Scanner trade_size = new Scanner(System.in); 
		int order_quantity = trade_size.nextInt(); 
		Scanner vol = new Scanner(System.in);  
		System.out.println("enter average volume quantity");
		int volume = vol.nextInt(); 
		int time_rem = 390;
		double trade_remaining = order_quantity;
		double get_done_release = trade_remaining * .05;
		get_done_release = Math.floor(get_done_release);
		double shares_sold = 0;
		
		while(trade_remaining>0 && time_rem>0)  {
			System.out.println(get_done_release);
			shares_sold = shares_sold + get_done_release;
			trade_remaining = trade_remaining - get_done_release;
			time_rem = time_rem - 1;
				if(trade_remaining<get_done_release) {
					get_done_release = trade_remaining;
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

