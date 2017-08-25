package main;

import main.User;
import main.Theater;
import main.ControlMain;
import java.util.Random;
	
class RunnableAuto implements Runnable {
		   private Thread t;
		   private String threadName;
		   Random ran = new Random();
		   public int timeupdate =0;
		   Integer[] time = new Integer[Integer.parseInt(ControlMain.NumUser)];
		   
		   RunnableAuto( String name) {
		      threadName = name;
		      System.out.println("Creating " +  threadName );
		   }
		   
		   public void run() {
			  User use = new User(ControlMain.NumUser);
			  Theater aTheater = new Theater(ControlMain.NumTheater);
		      System.out.println("Running " +  threadName );
		      try {
                while(true){
                	
                	int x = ran.nextInt(Integer.parseInt(ControlMain.NumUser));
                	if(x == 0) x = 1;
                	int select = ran.nextInt(4);
                	int NumBook = ran.nextInt(4);
        			if(NumBook == 0) NumBook = 1;
        			int NumMovie = ran.nextInt(Integer.parseInt(ControlMain.NumTheater));
                		
                	if(select == 1 && use.UserStatus[x][0] != 1 && use.UserStatus[x][0] != 2){ //StartBook    		
                			
                			use.UserStatus[x][0] = select;
                			use.UserStatus[x][1] = NumBook;
                			use.UserStatus[x][2] = NumMovie;
                			
                			System.out.print("Wait Process by " +"User: " + x+" Movie: " + (NumMovie+1) + " Book: " + NumBook + '\n');
                	}else if(select == 0 && use.UserStatus[x][0] == 1){ //Cancel
                		System.out.print("Cancle by " +"User: " + x+" Movie: " + (use.UserStatus[x][2]+1) + " Book: " + use.UserStatus[x][1] + '\n');
                   		use.UserStatus[x][0] = 0;
                   		use.UserStatus[x][1] = 0;
                   		use.UserStatus[x][2] = 0;
                	}else if(select == 0 && use.UserStatus[x][0] == 2){
                		System.out.print("Cancle by " +"User: " + x+" Movie: " + (use.UserStatus[x][2]+1) + " Book: " + use.UserStatus[x][1] + '\n');      		
                		aTheater.AllTheater[use.UserStatus[x][2]] += use.UserStatus[x][1];
                	
                		use.UserStatus[x][0] = 0;
                		use.UserStatus[x][1] = 0;
                   		use.UserStatus[x][2] = 0;
                	}else if(select == 2){ //AlreadyBook
                		
                		if(use.UserStatus[x][0] == 0){
                			use.UserStatus[x][1] = NumBook;
                			use.UserStatus[x][2] = NumMovie;
                		}
                		if(aTheater.AllTheater[use.UserStatus[x][2]]-use.UserStatus[x][1] >= 0){
                			aTheater.AllTheater[use.UserStatus[x][2]] -= use.UserStatus[x][1];
                			System.out.print("Book by " +"User: " + x+" Movie: " + (use.UserStatus[x][2]+1) + " Book: " +use.UserStatus[x][1] + '\n');
                			use.UserStatus[x][0] = 2;
             
                		} else {
                			System.out.print("Sorry, User: "+x+" Movie "+(use.UserStatus[x][2]+1)+" is full now."+'\n');
                			use.UserStatus[x][0] = 0;
                    		use.UserStatus[x][1] = 0;
                       		use.UserStatus[x][2] = 0;
                		}
                	
                    }
                    
                	//check event
                	
                	if( timeupdate == 5000){
		    	    System.out.println("Update----------");
		    	    for(int i=0;i< Integer.parseInt(ControlMain.NumTheater);i++)
		    	    	System.out.print("Movie : "+(i+1)+" Free Seat now: " + aTheater.AllTheater[i] +'\n');
		    	    	timeupdate = 0;
		    	    	Thread.sleep(3000);
                	}
		    	    Thread.sleep(20);
		    	    timeupdate += 20;
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
//		      RunnableAuto R1 = new RunnableAuto( "Thread-1");
//		      R1.start();
//		      
//		      RunnableManual R2 = new RunnableManual( "Thread-2");
//		      R2.start();
		   }   
}

