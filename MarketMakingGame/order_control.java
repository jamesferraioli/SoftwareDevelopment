package market_maker;

import java.util.Scanner;

public class order_control {
	public static void main(String[] args) throws Throwable
	{
	Scanner order_type = new Scanner(System.in);  
	System.out.println("enter a number for algo of choice: 1. TWAP, 2. POV, 3. get_done, 4. open_market: ");
	int n = order_type.nextInt(); 
		
		if(n==1) {
			twap.main(args);{
			}
		}
		else if(n==2) {
			pov.main(args);{
			}
		}
		else if(n==3) {
			get_done.main(args);{
			}
		}
		else if(n==4) {
			open_market.main(args);{
		}
		}
		else {
			twap.main(args);{
			}
			}

			
	order_type.close();
		
		
	}
}
