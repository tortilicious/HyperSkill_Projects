package traffic;



public class Main {
  public static void greeting(){
    System.out.println("Welcome to the traffic management system!");
  }

  public static void userCLI(){
    System.out.println("""
            Menu:
            1. Add
            2. Delete
            3. System
            0. Quit
                       """);
  }

  public static void main(String[] args){

    greeting();
    userCLI();
  }
}
