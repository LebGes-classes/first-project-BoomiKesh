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
					new fieldClean();
					new levelChoice();
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
		}while (menuChoice!=1 && menuChoice!=2 && menuChoice!=3);
		new fieldClean();
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
class showRules{
	public showRules(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Управление:");
		System.out.println("w - вверх");
		System.out.println("a - влево");
		System.out.println("s - вниз");
		System.out.println("d - вправо");
		System.out.println("");
		System.out.println("Игрок обозначен @");
		System.out.println("");
		System.out.println("Цель:");
		System.out.println("Дойти до выхода (выход обозначен буквой E)");
		System.out.println("");
		System.out.println("Чтобы выйти в меню нажмите q");
		Character input = sc.nextLine().charAt(0);
		while (input!='q'){
			System.out.println("Неверная команда");
			input = sc.nextLine().charAt(0);
		}
		new fieldClean();
		new Menu();
	}
}
class levelChoice{
	String [][] maze1 = {
			{"#","#","#","#","#","#","#","#","#","#"},
			{"#"," ","#"," "," "," ","#"," "," ","#"},
			{"#"," ","#"," ","#"," ","#","#"," ","#"},
			{"#"," "," "," ","#"," "," ","#"," ","#"},
			{"#"," ","#","#","#","#"," "," "," ","#"},
			{"#"," "," "," "," ","#","#","#"," ","#"},
			{"#"," ","#","#"," ","#"," ","#"," ","#"},
			{"#"," "," ","#"," ","#"," ","#"," ","#"},
			{"#"," "," "," "," "," "," ","#"," ","#"},
			{"#","#","#","#","#","#","#","#","#","#"}
		};
	String [][] maze2 = {
			{"#","#","#","#","#","#","#","#","#","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#","#","#","#","#","#","#","#","#","#"}
		};
	String [][] maze3 = {
			{"#","#","#","#","#","#","#","#","#","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#"," "," "," "," "," "," "," "," ","#"},
			{"#","#","#","#","#","#","#","#","#","#"}
		};
	
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
					new levelStart(maze1);
					break;
				case 2:
					new fieldClean();
					new levelStart(maze2);
					break;
				case 3:
					new fieldClean();
					new levelStart(maze3);
					break;
				default:
					System.out.println("Неверная команда");
			menuChoice = sc.nextInt();
			}
		}while (menuChoice!=1 && menuChoice!=2 && menuChoice!=3);
		
	}
}
class levelStart{
	Integer player_x = 1;
	Integer player_y = 1;
	Integer exit_x = 8;
	Integer exit_y = 8;
	boolean a;
	boolean gameState=true;
	public levelStart(String[][] maze){
		a=false;
		Scanner sc = new Scanner(System.in);
		while (gameState==true){
			new drawMaze(maze,player_x,player_y,exit_x,exit_y);
			char movement = sc.nextLine().charAt(0);
			while (movement!='w' && movement!='a' && movement!='s' && movement!='d'){
				System.out.println("Неверная команда");
				movement = sc.nextLine().charAt(0);
			}
			switch (movement){
				case 'w':
					if (maze[player_x][player_y - 1]==" "){
						player_y = player_y-1;
					}
					break;
				case 'a':
					if (maze[player_x-1][player_y]==" "){
						player_x = player_x-1;
					}
					break;
				case 's':
					if (maze[player_x][player_y+1]==" "){
						player_y = player_y+1;
					}
					break;
				case 'd':
					if (maze[player_x+1][player_y]==" "){
						player_x = player_x+1;
					}
					break;
				default:
					System.out.println("Неверная команда");
			}
			if (player_x==exit_x && player_y==exit_y){
				gameState=false;
			}
			new fieldClean();
		}
		new winScreen();
	}
	public void setState (boolean gameState){
			this.gameState = gameState;
	}
	public boolean getState(){
			return gameState;
	}
}

class winScreen{
	public winScreen(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Вы победили!");
		System.out.println("");
		System.out.println("Нажмите q чтобы выйти в меню");
		Character input = sc.nextLine().charAt(0);
		while (input!='q'){
				System.out.println("Неверная команда");
				input = sc.nextLine().charAt(0);
			}
		new fieldClean();
		new Menu();
	}
}

class drawMaze{
	public drawMaze(String[][] maze, int player_x, int player_y,int exit_x,int exit_y){
		for (int y = 0; y<10;y+=1){
			for (int x=0; x<10; x+=1){
				if (x == player_x && y == player_y){
					System.out.print("@");
				}else if (x == exit_x && y == exit_y){
					System.out.print("E");
				}else{
					System.out.print(maze[x][y]);
				}
			}
			System.out.println();
		}
	}
}
/*
class newPosition{
	public static boolean newPosition(char movement,String[][] maze,int x, int y){
		Scanner sc = new Scanner(System.in);
		while(movement!='w' && movement!='a' && movement!='s' && movement!='d'){
			System.out.println("Неверная команда");
			movement = sc.next().charAt(0);
		}
		switch (movement){
			case 'w':
				if (maze[x][y-1]!="#"){
					return true;
				}
				break;
			case 'a':
				if (maze[x-1][y]!="#"){
					return true;
				}
				break;
			case 's':
				if (maze[x][y+1]!="#"){
					return true;
				}
				break;
			case 'd':
				if (maze[x+1][y]!="#"){
					return true;
				}
				break;
			default:
				System.out.println("Неверная команда");
		}
	}
}
*/