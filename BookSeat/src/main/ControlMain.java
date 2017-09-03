package main;

import main.Theater;
import main.User;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import main.ThreadMain;

public class ControlMain {
	
	static String NumSeat ;
	static String NumUser ;
	static String NumTheater ;
	static char Confirm;
	static Random ran = new Random();
	
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to KSS Theater, Next is a setting option."+'\n');

		Confirm = 'A';
		if(Confirm == 'M'){
			do{
			System.out.println("Enter Number of Seat per Movie : ");
			NumSeat = in.nextLine();
			System.out.println("Enter Number of User come to Theater : ");
			NumUser = in.nextLine();
			System.out.println("Enter Number of Movie : ");
			NumTheater = in.nextLine();
	
			System.out.println("Your Setting is "+'\n'+"#Seat: "+NumSeat+'\n'+"#User: "+NumUser+'\n'+"#Theater: "+NumTheater+'\n'+'\n');
			System.out.println("Confirm Setting(Y/N)");
			Confirm = in.next().charAt(0);
	
			} while(Confirm != 'Y');
			System.out.println("Thank you for Setting!!");
		}else if(Confirm == 'A'){
			
			ExecutorService executor = Executors.newFixedThreadPool(5);
			
			NumSeat = "20";
			NumUser = "5";
			NumTheater = "5";
			User use = new User(NumUser);
			Theater aTheater = new Theater(NumTheater);
		
			for(int i=0;i<5;i++){
				int NumBook = ran.nextInt(5);
				int NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
				executor.submit(new ThreadMain("Start-AutoMode",use,aTheater,i));
				
			}
			
			executor.shutdown();
			System.out.println("All task submitted");
			
			try{
				executor.awaitTermination(1, TimeUnit.DAYS);
				
			} catch (InterruptedException ignored){
				
			}
			System.out.println("All task is Complete "); 
		} 
		
	}

}
