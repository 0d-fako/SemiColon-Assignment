class Board:
    def __init__(self):
        self.grid = [[None] * 3 for row in range(3)]
        self.current_player = None
        self.winner = None
        self.is_game_over = False

    def make_move(self, row, col, player):
        if self.is_game_over:
            raise ValueError("Game is already over")

        if not (0 <= row < 3 and 0 <= col < 3):
            raise ValueError("Position out of bounds")

        if self.grid[row][col] is not None:
            raise ValueError("Position already taken")

        self.grid[row][col] = player.symbol
        self.check_game_status(player)

    def check_game_status(self, player):
        for row in range(3):
            if self.grid[row][0] == self.grid[row][1] == self.grid[row][2] == player.symbol:
                self.winner = player
                self.is_game_over = True
                return


        for col in range(3):
            if self.grid[0][col] == self.grid[1][col] == self.grid[2][col] == player.symbol:
                self.winner = player
                self.is_game_over = True
                return

        if self.grid[0][0] == self.grid[1][1] == self.grid[2][2] == player.symbol:
            self.winner = player
            self.is_game_over = True
            return

        if self.grid[0][2] == self.grid[1][1] == self.grid[2][0] == player.symbol:
            self.winner = player
            self.is_game_over = True
            return

        is_full = True
        for row in range(3):
            for col in range(3):
                if self.grid[row][col] is None:
                    is_full = False
        if is_full:
            self.is_game_over = True

    def display(self):
        result = ""
        for row in range(3):
            for col in range(3):
                cell = self.grid[row][col] if self.grid[row][col] is not None else " "
                result += cell
                if col < 2:
                    result += "|"
            if row < 2:
                result += "\n-+-+-\n"
        return result