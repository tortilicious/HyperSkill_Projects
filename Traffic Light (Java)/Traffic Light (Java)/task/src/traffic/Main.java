package traffic;
import java.util.Scanner;



public class Main {
  public static void greeting(){
    System.out.println("Welcome to the traffic management system!");
  }

  public static void userCLI(){
    System.out.println("""
            Menu:
            1. Add road
            2. Delete road
            3. Open system
            0. Quit
                       """);
  }

  public static int numberOfRoads(){
    Scanner read = new Scanner(System.in);
    System.out.println("Input the number of roads: ");
    return read.nextInt();
  }

  public static int lightsInterval(){
    Scanner read = new Scanner(System.in);
    System.out.println("Input the interval: ");
    return read.nextInt();
  }

  public static void addRoad(int roads){
    System.out.println("Road added");
    ++roads;
  }

  public static void deleteRoad(int roads){
      System.out.println("Road deleted");
    --roads;
  }

  public static void openSystem(){
    System.out.println("System opened");
  }

  public static void quit(){
    System.out.println("Bye!");
  }

  public static void main(String[] args){
      Scanner read = new Scanner(System.in);
      boolean working = true;



    greeting();

    int roads = numberOfRoads();
    int interval = lightsInterval();

    while (working){
        userCLI();
        int menu = read.nextInt();
        switch (menu){
            case 1:
                addRoad(roads);
                break;
            case 2:
                deleteRoad(roads);
                break;
            case 3:
                openSystem();
                break;
            case 0:
                quit();
                working = false;
                break;
        }
    }



  }
}
