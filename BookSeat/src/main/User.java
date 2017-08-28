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
	 
}


