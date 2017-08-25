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
	 
	 char IsFull(int Num){
		 
		 if(AllTheater[Num] == 0){
		 	 return 'F';
		 } else {
			 AllTheater[Num] -= 1;
			 return 'N';
		 }
	 }
	 
	 
}
