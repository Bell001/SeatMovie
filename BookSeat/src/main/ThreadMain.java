package main;

import main.User;
import main.Theater;
import main.ControlMain;
import java.util.Random;
	
class ThreadMain implements Runnable {
	
		   private Thread t;
		   private String threadName;
		   public int timeupdate =0;

		   User use;
		   Theater aTheater;
		   int x;
		   int NumMovie;
		   int NumBook;
		   Random ran = new Random();

		   
		   ThreadMain (String name,User user,Theater theater,int numuser) {
		      threadName = name+" "+(numuser+1);
		      use = user;
		      aTheater = theater;
		      x =  numuser;
		      System.out.println("Creating " +  threadName );
		   }
		   
		   public synchronized void run() {
			
		      System.out.println("Running " +  threadName );
		      try {
		    	  
		    	  while(true){
		    	
		    	  	int delay = ran.nextInt(40000);
		    	  	int decide = ran.nextInt(2);
		    	  	int NumBook = ran.nextInt(5);
		    	  	int NumMovie = ran.nextInt(Integer.parseInt(ControlMain.NumTheater));
        			
        			
        			int SeatA_now = aTheater.AllTheater[NumMovie];
        		    int temp = 0;
        			
        			if(SeatA_now == 0 || !(SeatA_now - (NumBook+1) >= 0)){
        				System.out.print("Status: FULL" + " User: "+(x+1)+'\n'+"	Movie "+(NumMovie+1)+'\n');
        				//continue;
        			} else {
        				aTheater.AllTheater[NumMovie] -=  NumBook+1;
        			}    			

        				System.out.print("Status: WAIT "+"User: " + (x+1)+'\n'+"	Movie: " + (NumMovie+1) + " Book: " + (NumBook+1) + " S.Now: " +SeatA_now+ " S.Beforelock : "+aTheater.AllTheater[NumMovie]+'\n');
        				
        				Thread.sleep(delay);
        				if(delay >= 30000){
        					System.out.print("Status: TIMEOUT "+ "User: "+(x+1)+ '\n' +"	Movie: " + (NumMovie+1) + " Book: " + (NumBook+1)+'\n');
        				} else if(decide == 0){
        					aTheater.AllTheater[NumMovie] += NumBook+1; 
        					System.out.print("Status: CANCLE "+"User: "  + (x+1)+'\n'+"		Movie: " + (NumMovie+1) + " Book: " + (NumBook+1) + " S.Now: "+aTheater.AllTheater[NumMovie]+'\n'); 
	        			} else if(decide == 1){		
	        				use.UserStatus[x][0] = 2;
	            			use.UserStatus[x][1] = NumBook+1;
	            			use.UserStatus[x][2] = NumMovie+1;
	            		
	            			System.out.print("Status: BOOK " +"User: " + (x+1)+'\n'+"	Movie: " + use.UserStatus[x][2] + " Book: " +use.UserStatus[x][1] + " S.Now: " + aTheater.AllTheater[NumMovie] +'\n');            		
	        		} 
        			
        			Thread.sleep(100);
		    	  }
                	
                
		      }catch (InterruptedException e) {
		         System.out.println("Thread " +  threadName + " interrupted.");
		      }
		      System.out.println("Thread " +  threadName + " exiting.");
		   }
		   
		   public void start () {
		      System.out.println("Starting " +  threadName );
		      if (t == null) {
		         t = new Thread (this, threadName);
		         t.start ();
		      }
		   }
		   
}


