package cinema;
import java.util.Scanner;


public class Cinema {
    public static char[][] roomCreator(int rows, int seats) {
        char[][] matrix = new char[rows][seats];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < seats; ++j) {
                matrix[i][j] = 'S';
            }
        }
        return matrix;
    }

    public static void screenPrinter(char[][] array) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= array[0].length; ++i) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < array.length; ++i) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < array[i].length; ++j) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String seatPicker(char[][] array, int rows, int seats) {

        Scanner read = new Scanner(System.in);
        String ticketPrice;

        System.out.println("Enter a row number:");
        int clientRowNumber = read.nextInt();

        System.out.println("Enter a seat number in that row:");
        int clientSeatNumber = read.nextInt();

        int roomSize = rows * seats;

        if (roomSize <= 60) {
            ticketPrice = "$10";
        } else if (clientRowNumber <= array.length / 2) {
            ticketPrice = "$10";
        } else {
            ticketPrice = "$8";
        }

        array[clientRowNumber - 1][clientSeatNumber - 1] = 'B';
        return "Ticket price: " + ticketPrice;
    }


    public static String showMenu() {

        return "1. Show the seats\n2. Buy a ticket\n0. Exit";
    }


    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        boolean programIsWorking = true;

        System.out.println("Enter the number of rows:");
        int rows = read.nextInt();

        System.out.println("Enter the number of seats in each row:");
        int seats = read.nextInt();

//      Creamos nuestra sala de cine con los datos proporcionados
        char[][] theaterRoom = roomCreator(rows, seats);

        String menu = showMenu();

        while (programIsWorking) {
            System.out.print(menu);
            System.out.println();
            int option = read.nextInt();

            switch (option) {
                case 1:
//      Mostramos en consola el estado de la sala.
                    screenPrinter(theaterRoom);
                    System.out.println();
                    break;

                case 2:
//      Calculamos precio entrada y actualizamos estado de la sala.
                    String ticketPrice = seatPicker(theaterRoom, rows, seats);
                    System.out.println(ticketPrice);
                    break;

                case 0:
                    programIsWorking = false;
                    System.exit(0);
                    break;

                default:
                    System.exit(0);

            }


        }
    }
}