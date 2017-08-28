package main;

public class Theater {
	
	 public Integer[] AllTheater; 
	 public int AllSeat = Integer.parseInt(ControlMain.NumSeat);
	 
	 Theater(String number) {		 
		 AllTheater = new Integer[Integer.parseInt(number)];	
		 for(int i=0;i < Integer.parseInt(number);i++){
			 AllTheater[i] = AllSeat;
		 }
	 }
	 
	 
}
