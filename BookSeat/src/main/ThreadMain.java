package main;

import main.User;
import main.Theater;
import main.ControlMain;
import java.util.Random;
	
class RunnableAuto implements Runnable {
	
		   private Thread t;
		   private String threadName;
		   public int timeupdate =0;
		   Integer[] time = new Integer[Integer.parseInt(ControlMain.NumUser)];
		   User use;
		   Theater aTheater;
		   int x;
		   int NumMovie;
		   int NumBook;
		   Random ran = new Random();

		   
		   RunnableAuto(String name,User user,Theater theater,int numuser) {
		      threadName = name+" "+(numuser+1);
		      use = user;
		      aTheater = theater;
		      x =  numuser;
		      System.out.println("Creating " +  threadName );
		   }
		   
		   public void run() {
			
		      System.out.println("Running " +  threadName );
		      try {
		    	
		    	  	while(true){
		    	  		int delay = ran.nextInt(4000);
		    	  		int decide = ran.nextInt(2);
		    	  		int NumBook = ran.nextInt(5);
		    	  		int NumMovie = ran.nextInt(Integer.parseInt(ControlMain.NumTheater));
        			
        			
        			int SeatA_now = aTheater.AllTheater[NumMovie];
        		
        			if(SeatA_now == 0 || !(SeatA_now - (NumBook+1) >= 0)){
        				System.out.print("Sorry, User: "+(x+1)+" Movie "+(NumMovie+1)+" is full now."+'\n');
        				continue;
        			} else {
        				aTheater.AllTheater[NumMovie] -=  NumBook+1;
        			}
        			
//        			if(use.UserStatus[x][0] == 2){
//        				System.out.print("Sorry, User: "+(x+1)+" already book last minute."+'\n');
//        				
//        			}
        		
        				System.out.print("Wait Process by " +"User: " + (x+1)+" Movie: " + (NumMovie+1) + " Book: " + (NumBook+1) + " Now Arrival : " +SeatA_now+'\n');
        				
        				Thread.sleep(delay);
        				if(delay >= 3000){
        					System.out.print("Sorry, User: "+(x+1)+" be Time out now!!! "+'\n');
        				} else if(decide == 0){
        					aTheater.AllTheater[NumMovie] +=  NumBook+1;
        					System.out.print("Cancle by " +"User: " + (x+1)+" Movie: " + (NumMovie+1) + " Book: " + (NumBook+1) + '\n'); 
	        			} else if(decide == 1){		
	        				use.UserStatus[x][0] = 2;
	            			use.UserStatus[x][1] = NumBook+1;
	            			use.UserStatus[x][2] = NumMovie+1;
	            			if(aTheater.AllTheater[NumMovie] - use.UserStatus[x][1] >= 0){
	            				//aTheater.AllTheater[NumMovie] -= use.UserStatus[x][1];
	            				System.out.print("Book by " +"User: " + (x+1)+" Movie: " + use.UserStatus[x][2] + " Book: " +use.UserStatus[x][1] + " Seat saw: " + SeatA_now+ " Now free: "+ aTheater.AllTheater[NumMovie]+'\n'); 
	            			} else {
	            				System.out.print("Sorry, User: "+(x+1)+" Movie "+(NumMovie+1)+" is full now. "+'\n');
	            			}
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

class RunnableManual implements Runnable {
	   private Thread t;
	   private String threadName;
	   
	   RunnableManual(String name) {
	      threadName = name;
	      System.out.println("Creating " +  threadName );
	   }
	   
	   public void run() {
	      System.out.println("Running " +  threadName );
	      try {
	         for(int i = 4; i > 0; i--) {
	            System.out.println("Thread: " + threadName + ", " + i);
	            // Let the thread sleep for a while.
	            Thread.sleep(50);
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

public class ThreadMain {

		   public static void main(String args[]) {
	      
		   }   
}

