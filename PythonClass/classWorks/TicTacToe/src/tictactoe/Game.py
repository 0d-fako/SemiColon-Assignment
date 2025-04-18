from classWorks.TicTacToe.src.tictactoe.Board import Board
from classWorks.TicTacToe.src.tictactoe.ComputerPlayer import ComputerPlayer
from classWorks.TicTacToe.src.tictactoe.Player import Player


class Game:
    def __init__(self):
        self.board = Board()
        self.players = [Player("X"), Player("O")]
        self.current_player_index = 0
        self.board.current_player = self.players[self.current_player_index]

    def make_move(self, row=None, col=None):
        current_player = self.players[self.current_player_index]

        if isinstance(current_player, ComputerPlayer):
            row, col = current_player.choose_move(self.board)
            print(f"Computer chooses: Row {row}, Column {col}")

        self.board.make_move(row, col, current_player)

        if not self.board.is_game_over:
            self.current_player_index = (self.current_player_index + 1) % 2
            self.board.current_player = self.players[self.current_player_index]

    def get_winner(self):
        return self.board.winner

    def is_game_over(self):
        return self.board.is_game_over

    def get_current_player(self):
        return self.players[self.current_player_index]

    def display_board(self):
        return self.board.display()