from TicTacToe.src.tictactoe.ComputerPlayer import ComputerPlayer
from TicTacToe.src.tictactoe.Game import Game
from TicTacToe.src.tictactoe.Player import Player


def play_game():
    print("Welcome to Tic-tac-toe!")

    choice = input("Do you want to play against the computer? (yes/no): ").strip().lower()
    while choice not in {"yes", "no"}:
        choice = input("Invalid choice. Please type 'yes' or 'no': ").strip().lower()

    if choice == "yes":
        player_symbol = input("Choose your symbol (e.g., X or O): ").strip()
        while not player_symbol or len(player_symbol) != 1:
            player_symbol = input("Please choose a valid single-character symbol: ").strip()
        computer_symbol = "O" if player_symbol == "X" else "X"

        players = [Player(player_symbol), ComputerPlayer(computer_symbol)]
        print(f"The computer will play as {computer_symbol}.")
    else:
        player1_symbol = input("Player 1, choose your symbol (e.g., X or O): ").strip()
        while not player1_symbol or len(player1_symbol) != 1:
            player1_symbol = input("Please choose a valid single-character symbol: ").strip()

        player2_symbol = input("Player 2, choose your symbol: ").strip()
        while not player2_symbol or len(player2_symbol) != 1 or player2_symbol == player1_symbol:
            player2_symbol = input(f"Please choose a valid symbol different from Player 1 ({player1_symbol}): ").strip()

        players = [Player(player1_symbol), Player(player2_symbol)]

    game = Game()
    game.players = players


    while not game.is_game_over():
        print("\nCurrent board:")
        print(game.display_board())
        current_player = game.get_current_player()
        print(f"Player {current_player.symbol}'s turn")

        if isinstance(current_player, ComputerPlayer):
            row, col = current_player.choose_move(game.board)
            print(f"Computer chooses: Row {row}, Column {col}")
            game.make_move(row, col)
        else:
            try:
                row = int(input("Enter row (0-2): "))
                col = int(input("Enter column (0-2): "))
                game.make_move(row, col)
            except ValueError as e:
                print(f"Invalid move: {e}")

    print("\nFinal board:")
    print(game.display_board())

    winner = game.get_winner()
    if winner:
        print(f"Player {winner.symbol} wins!")
    else:
        print("It's a draw!")


if __name__ == "__main__":
    play_game()
