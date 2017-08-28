package main;

import main.Theater;
import main.User;

import java.util.Random;
import java.util.Scanner;
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
		
		do{
			System.out.println("Select System: Auto or Manual(A/M)");
			Confirm = in.next().charAt(0);
			
		}while(!(Confirm == 'A' || Confirm == 'M'));
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
			
			NumSeat = "20";
			NumUser = "5";
			NumTheater = "5";
			User use = new User(NumUser);
			Theater aTheater = new Theater(NumTheater);
		
	
        	int NumBook = ran.nextInt(5);
			int NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
			
			RunnableAuto R1 = new RunnableAuto("Start-AutoMode",use,aTheater,0);
			NumBook = ran.nextInt(5);
			NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
			RunnableAuto R2 = new RunnableAuto("Start-AutoMode",use,aTheater,1);
			NumBook = ran.nextInt(5);
			NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
			RunnableAuto R3 = new RunnableAuto("Start-AutoMode",use,aTheater,2);
			NumBook = ran.nextInt(5);
			NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
			RunnableAuto R4 = new RunnableAuto("Start-AutoMode",use,aTheater,3);
			NumBook = ran.nextInt(5);
			NumMovie = ran.nextInt(Integer.parseInt(NumTheater));
			RunnableAuto R5 = new RunnableAuto("Start-AutoMode",use,aTheater,4);
		    R1.start();
			R2.start();
		    R3.start();
			R4.start();
		    R5.start();
		} 
		
	}

}
