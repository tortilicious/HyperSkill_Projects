package tictactoe;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        char[][] grid = new char[3][3];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid.length; ++j) {
                grid[i][j] = ' ';
            }
        }
        int playerTurn = 1;

        printGrid(grid);
        boolean game = true;

        while (game) {
            int[] coordinates = checkInput();
            if (!checkGrid(coordinates, grid, playerTurn)){
                continue;
            }
            printGrid(grid);

            ++playerTurn;
            if (checkVictory(grid, playerTurn)) {
                break;
            }
        }

    }

    public static void printGrid(char[][] grid) {
        System.out.println("---------");
        for (int i = 0; i < 3; ++i) {
            System.out.print("| ");
            for (int j = 0; j < 3; ++j) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int[] checkInput() {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = new int[2];
        boolean validInput = false;

        while (!validInput) {

            if (scan.hasNextInt() && scan.hasNextInt()) {
                int x = scan.nextInt();
                int y = scan.nextInt();

                if (x < 1 || x > 3 || y < 1 || y > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");

                } else {
                    coordinates[0] = x;
                    coordinates[1] = y;
                    validInput = true;

                }

            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
        }
        return coordinates;
    }


    public static boolean checkGrid(int[] coordinates, char[][] grid, int playerTurn) {
        int cordX = coordinates[0];
        int cordY = coordinates[1];



        if (grid[cordX - 1][cordY - 1] == ' ') {
            if (playerTurn % 2 != 0) {
                grid[cordX - 1][cordY - 1] = 'O';
                return true;
            } else {
                grid[cordX - 1][cordY - 1] = 'X';
                return true;
            }
        } else {
            System.out.println("This cell is occupied! Choose another one!");
            return false;
        }

    }

    public static boolean checkVictory(char[][] grid, int playerTurn) {
        for (int i = 0; i < grid.length; ++i) {
            if (grid[i][0] != ' ' && grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2]) {
                if (playerTurn % 2 != 0) {
                    System.out.println("X wins");
                    return true;
                } else {
                    System.out.println("O wins");
                    return true;
                }
            }
        }
        for (int j = 0; j < grid.length; ++j) {
            if (grid[0][j] != ' ' && grid[0][j] == grid[1][j] && grid[1][j] == grid[2][j]) {
                if (playerTurn % 2 != 0) {
                    System.out.println("X wins");
                    return true;
                } else {
                    System.out.println("O wins");
                    return true;
                }
            }
        }

        if ((grid[0][0] != ' ' && grid[0][0] == grid[1][1] && grid[0][0] == grid[2][2])
                || (grid[0][2] != ' ' && grid[0][2] == grid[1][1] && grid[0][2] == grid[2][0])) {
            if (playerTurn % 2 != 0) {
                System.out.println("X wins");
                return true;
            } else {
                System.out.println("O wins");
                return true;
            }
        }
        if (playerTurn == 10) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
}


