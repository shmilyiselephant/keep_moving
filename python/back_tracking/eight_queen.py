BOARD_SIZE = 8

solution_count = 0
queen_list = [0]*BOARD_SIZE

def eight_queens(cur_column: int):
    if cur_column >= BOARD_SIZE:
        global solution_count
        solution_count += 1
        print(queen_list)
    else:
        for i in range(BOARD_SIZE):
            if is_valid_pos(cur_column, i):
                queen_list[cur_column] = i
                eight_queens(cur_column + 1)

def is_valid_pos(cur_colomn: int, pos: int) -> bool:
    i = 0
    while i < cur_colomn:
        if queen_list[i] == pos:
            return False

        if cur_colomn - i == abs(pos - queen_list[i]):
            return False
        i += 1
    return True


if __name__ == "__main__":
    print("--- eight queens sequence ---")
    eight_queens(0)

    print("\n --- solution count ---")
    print(solution_count)
