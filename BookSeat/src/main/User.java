package main;

import main.ControlMain;

public class User {
	
	 public Integer[][] UserStatus; 
	
	 User(String number) {		 
		  UserStatus = new Integer[Integer.parseInt(number)][3];	      
		  for(int i=0;i<Integer.parseInt(number);i++){
			  UserStatus[i][0] = 0;
		  }
	 }
	 
//	 public char Checkstatus(int Num){
//		 if(UserStatus[Num][0] == 0 ){
//			 return 'N'; //none
//		 } else if(UserStatus[Num][0] == 1){
//			 return 'W'; //wait
//		 } else if(UserStatus[Num][0] == 2){
//			 return 'B'; //Book
//		 } else {
//			 return 'F';
//		 }
//	 }
	 
//	 public void Cancel(int Num){
//		 UserStatus[Num] = 0;	 
//	 }
//	 
//	 public void StartBook(int Num){
//		 UserStatus[Num] = 1;	 
//	 }
//	 
//	 public void AlreadyBook(int Num){
//		 UserStatus[Num] = 2;
//	 }
	 
	 
}


