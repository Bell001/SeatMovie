package main;

import main.Theater;
import main.User;
import java.util.Scanner;
import main.ThreadMain;

public class ControlMain {
	
	static String NumSeat ;
	static String NumUser ;
	static String NumTheater ;
	static char Confirm;
	
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
			RunnableAuto R1 = new RunnableAuto("Start-AutoMode");
			RunnableAuto R2 = new RunnableAuto("Start-AutoMode");
			RunnableAuto R3 = new RunnableAuto("Start-AutoMode");
			RunnableAuto R4 = new RunnableAuto("Start-AutoMode");
			RunnableAuto R5 = new RunnableAuto("Start-AutoMode");
		    R1.start();
			R2.start();
		    R3.start();
			R4.start();
		    R5.start();
		} 
		
	}

}
