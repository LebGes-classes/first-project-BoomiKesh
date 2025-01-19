import java.util.Scanner;

public class Maze{
	public static void main(String[] args){
		new Menu();
	}
}
class Menu{
	public Menu(){
		System.out.println("1)Начать игру");
		System.out.println("2)Правила");
		System.out.println("3)Выйти из игры");
		Scanner sc = new Scanner(System.in);
		int menuChoice = sc.nextInt();
		do {
			switch (menuChoice){
				case 1:
					new levelChoice();
					new fieldClean();
					break;
				case 2:
					new fieldClean();
					new showRules();
					break;
				case 3:
					break;
				default:
					System.out.println("Неверная команда");
			menuChoice = sc.nextInt();
			}
		}while (menuChoice!=1 || menuChoice!=2 || menuChoice!=3);
	}
}
class fieldClean{
	public fieldClean(){
		try {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} catch (Exception E) {
			System.out.println(E);
		}
	}
}


class levelChoice{
	public levelChoice(){
		System.out.println("1)Level 1");
		System.out.println("2)Level 2");
		System.out.println("3)Level 3");
		Scanner sc = new Scanner(System.in);
		int menuChoice = sc.nextInt();
		do {
			switch (menuChoice){
				case 1:
					new fieldClean();
					new levelStart(1);
					break;
				case 2:
					new fieldClean();
					new levelStart(2);
					break;
				case 3:
					new fieldClean();
					new levelStart(3);
					break;
				default:
					System.out.println("Неверная команда");
			menuChoice = sc.nextInt();
			}
		}while (menuChoice!=1 || menuChoice!=2 || menuChoice!=3);
	}
}
class levelStart{
	Integer x = 1;
	Integer y = 1;
	boolean gameState=true;
	public levelStart(int levelChoice,){
		Scanner sc = new Scanner(System.in);
		while (gameState==true){
			String movement = sc.next();
			new newPosition(movement,maze1);
			new drawMaze(levelChoice,x,y);
		}
	}
	public void setState (boolean gameState){
			this.gameState = gameState;
	}
	public boolean getState(){
			return gameState;
	}
}
class newPosition{
	String move;
	public newPosition(String movement,Character[][] maze1){
		Scanner sc = new Scanner(System.in);
		move = movement;
		do {
			switch (move){
				case "w":
					if (maze1[x][y-1]!="#"){
						this.y = y-1;
					}
					break;
				case "a":
					if (maze1[x-1][y]!="#"){
						this.x = x-1;
					}
					break;
				case "s":
					if (maze1[x][y+1]!="#"){
						this.y = y+1;
					}
					break;
				case "d":
					if (maze1[x+1][y]!="#"){
						this.x = x+1;
					}
					break;
				default:
					System.out.println("Неверная команда");
			move = sc.next();
			}
		}while (move!="w" || move!="a" || move!="s" || move!="d");
	}
}
class drawMaze{
	Character [][] maze1 = {
			{'#','#','#','#','#','#','#','#','#','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#','#','#','#','#','#','#','#','#','#'}
		};
	Character [][] maze2 = {
			{'#','#','#','#','#','#','#','#','#','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#','#','#','#','#','#','#','#','#','#'}
		};
	Character [][] maze3 = {
			{'#','#','#','#','#','#','#','#','#','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#',' ',' ',' ',' ',' ',' ',' ',' ','#'},
			{'#','#','#','#','#','#','#','#','#','#'}
		};
	
	public drawMaze(int levelChoice, int xPosition, int yPosition){
		for (int x = 0; x<10;x+=1){
			for (int y=0; y<10; y+=1){
				if (x == xPosition && y == yPosition){
					System.out.print("@");
				}else{
					System.out.print(maze1[x][y]);
				}
			}
			System.out.println();
		}
		
	}
}

