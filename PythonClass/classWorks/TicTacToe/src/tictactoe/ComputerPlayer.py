import random

from classWorks.TicTacToe.src.tictactoe.Player import Player


class ComputerPlayer(Player):
    def __init__(self, symbol):
        super().__init__(symbol)

    def choose_move(self, board):
        empty_cells = [(row, col) for row in range(3) for col in range(3) if board.grid[row][col] is None]
        return random.choice(empty_cells)
