from src.tictactoe.Game import Game


def play_game():
    game = Game()
    print("Welcome to Tic-tac-toe!")

    while not game.is_game_over():
        print("\nCurrent board:")
        print(game.display_board())
        current_player = game.get_current_player()
        print(f"Player {current_player.symbol}'s turn")

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