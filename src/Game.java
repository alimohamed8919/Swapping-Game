
import java.util.Scanner;

public class Game {
	
	int[][] gameBoard = {{17,10,50,36,25,75},
						  {82,62,38,94,0,68},
						  {93,43,4,80,16,20},
						  {32,58,47,1,99,12},
						  {29,78,97,64,9,56}};
	int[] temp = new int[30];
	Scanner in2 = new Scanner(System.in);

	public void generateBoard() {
		
		System.out.println(" -------------------------------");
		for (int i = 0; i < this.gameBoard.length; i++) {
			
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				
				if (this.gameBoard[i][j] < 10) {
					System.out.print(" | " + "0" + this.gameBoard[i][j]);
				}
				else {
					System.out.print(" | " + this.gameBoard[i][j]);
				}
				
			}
			System.out.println(" | ");
			System.out.println(" -------------------------------");
		}
		System.out.println();
	}
	
	
	// int r = ThreadLocalRandom.current().nextInt(1,100); // reduce chance of duplicate random numbers
	//System.out.println(r);
	
	
	public void swap(int num1, int num2) {
		int temp1 = 0;
		int temp2 = 0;
		int temp3 = 0;
		int temp4 = 0;
		
		for (int i = 0; i < this.gameBoard.length; i++) {
			
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				
				if (num1 == this.gameBoard[i][j]) {	
					temp1 = i;
					temp2 = j;
					break;
				}
			}
		}
	
		
		for (int i = 0; i < this.gameBoard.length; i++) {
			
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				
				if (num2 == this.gameBoard[i][j]) {
					temp3 = i;
					temp4 = j;
					break;
				}
			}
		}
		
		if (this.gameBoard[temp1][temp2] == num1 && this.gameBoard[temp3][temp4] == num2) {
			System.out.printf("Swapping %d and %d\n", num1, num2);
			this.gameBoard[temp1][temp2] = num2;
			this.gameBoard[temp3][temp4] = num1;
		}else {
			if (this.gameBoard[temp1][temp2] != num1 && this.gameBoard[temp3][temp4] != num2) {
				System.out.println();
				System.out.println(num1 + " and " + num2 + " is not in this board, try again!");
				System.out.println("Press Enter to Continue!");
				in2.nextLine();
			}
			else if (this.gameBoard[temp1][temp2] != num1) {
				System.out.println();
				System.out.println(num1 + " is not in this board, try again!");
				System.out.println("Press Enter to Continue!");
				in2.nextLine();
			}
			else if (this.gameBoard[temp3][temp4] != num2) {
				System.out.println();
				System.out.println(num2 + " is not in this board, try again!");
				System.out.println("Press Enter to Continue!");
				in2.nextLine();
			}
		}
		
	}

	public boolean isComplete() {
		boolean complete = false;
		int length = this.temp.length - 30;
		
		for (int i = 0; i < this.gameBoard.length; i++) {
			
			for (int j = 0; j < this.gameBoard[i].length; j++) {
				
				this.temp[length] = this.gameBoard[i][j];
				length++;
				
				}
			}
		
		int counter = 0;
		for (int j = 1; j < this.temp.length; j++) {
			
			if (this.temp[j-1] > this.temp[j]) {
				counter++;
			}
		}
		if (counter == 0) {
			complete = true;
		}

		return complete;
	}
	
	public static void main(String[] args) {
		
		Game g = new Game();

		Scanner in = new Scanner(System.in);

		g.generateBoard();
		
		while(!g.isComplete()) {
			
			System.out.print("List two numbers to swap (separated by comma): ");
			String numbers = in.nextLine();
			
			try {
				
				int num1 = Integer.parseInt(numbers.split(",")[0].trim());
				int num2 = Integer.parseInt(numbers.split(",")[1].trim());
				g.swap(num1, num2);
				
			}catch(NumberFormatException e) {
				System.out.println();
				System.out.println("Sorry, did not understand what you mean, please try again!");
				System.out.println("Press Enter to Continue!");
				in.nextLine();
				
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println();
				System.out.println("Sorry, did not understand what you mean, please try again!");
				System.out.println("Press Enter to Continue!");
				in.nextLine();
			}
			
			g.generateBoard();
		}
		System.out.println("Game complete. Well done!");
	}
}