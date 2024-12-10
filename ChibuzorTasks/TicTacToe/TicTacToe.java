import java.util.Scanner;

public class TicTacToe{

	public enum Cell {X, O, EMPTY}

	public enum GameStatus {XWINS, OWINS, DRAW, INCOMPLETE}
	
	private Cell[][] board;
	private String[] players;
	private Cell turn;
	private int numMoves;


	public TicTacToe (String player1, String player2){
		board = new Cell[3][3];
		players = new String[]{player1, player2};
		turn = Cell.X;
		numMoves = 0;

		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){

				board[row][column] = Cell.EMPTY;
			}


		}

	}

	public boolean makeMove (int row, int column){
		if (row < 0 || row >=3 || column < 0 || column >= 3 || board[row][column] != Cell.EMPTY){
			return false;
		}
		
		board[row][column] =turn;
		numMoves++;

		turn = (turn ==Cell.X)? Cell.O : Cell.X;
		return true;
	}

	public GameStatus getGameStatus(){
		for (int row = 0; row < 3; row++){
			if (board[row][0] != Cell.EMPTY && board[row][0] == board[row][1] && board[row][1] == board[row][2]){
				return (board[row][0] == Cell.X)? GameStatus.XWINS : GameStatus.OWINS;

			}
		}
	
		for (int column = 0; column < 3; column++){
			if (board[0][column] != Cell.EMPTY && board[0][column] == board[1][column] && board[1][column] == board[2][column]){
				return(board[0][column] == Cell.X)? GameStatus.XWINS :GameStatus.OWINS;
			}

		}


		if (board[0][0] != Cell.EMPTY && board[0][0] == board[1][1] && board[1][1] == board[2][2]){
			return(board[0][0] == Cell.X)? GameStatus.XWINS : GameStatus.OWINS;
		}
	
		if (board[0][2] != Cell.EMPTY && board[0][2] == board[1][1] && board[1][1] == board[2][0]){
			return(board[0][2] == Cell.X)? GameStatus.XWINS: GameStatus.OWINS;
		
		}
		return(numMoves == 9)? GameStatus.DRAW : GameStatus.INCOMPLETE;
	}

	public void printBoard(){
		System.out.println("\nCurrent Board");
		for (int row = 0; row < 3; row++){
			for (int column = 0; column < 3; column++){
				String gameBoard = (board[row][column] == Cell.EMPTY)? " ": board[row][column].toString();
				System.out.print(" " + gameBoard + " ");
				if (column < 2) System.out.print("|");
			}
			System.out.println();
			if (row < 2) System.out.print("---------------");
		}
	
	}

	public Cell getCurrentTurn(){
		return turn;
	}

	public String getCurrentPlayer(){
		return (turn == Cell.X)? players[0] : players[1];
	}


	public static void main (String... args){







	}








}