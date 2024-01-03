package machine;
import java.util.Scanner;

public class CoffeeMachine {

    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public CoffeeMachine (int water, int milk, int coffeeBeans, int cups, int money){
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }


    public void displayStatus (){
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n", water);
        System.out.printf("%d ml of milk%n", milk);
        System.out.printf("%d g of coffee beans%n", coffeeBeans);
        System.out.printf("%d disposable cups%n", cups);
        System.out.printf("$%d of money%n", money);
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int coffeeBeansNeeded, int cost){

        if (waterNeeded > water){
            System.out.println("Sorry, not enough water!");
        } else if (milkNeeded > milk){
            System.out.println("Sorry, not enough milk!");
        } else if (coffeeBeansNeeded > coffeeBeans){
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1){
            System.out.println("Sorry, not enough cups!");
        } else {
            water -= waterNeeded;
            milk -= milkNeeded;
            coffeeBeans -= coffeeBeansNeeded;
            --cups;
            money += cost;
            System.out.println("I have enough resources, making you a coffee!");
        }

    }

    public void buyCoffee(String coffeeChoice) {
        switch (coffeeChoice){
            case "1":
                makeCoffee(250,0,16,4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            default:
                System.out.println("Invalid coffee choice");
        }
    }

    public void fillMachine (int addedWater, int addedMilk, int addedCoffeeBeans, int addedCups){
        water += addedWater;
        milk += addedMilk;
        coffeeBeans += addedCoffeeBeans;
        cups += addedCups;
    }

    public void takeMoney(){
        System.out.printf("I gave you $%d%n", money);
        money = 0;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        CoffeeMachine coffeeMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        boolean working = true;

        while (working){
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = input.nextLine().toLowerCase();

            switch (action){
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
                    String coffeeChoice = input.nextLine();
                    if (coffeeChoice.equals("back")){
                        continue;
                    }
                    coffeeMachine.buyCoffee(coffeeChoice);
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int addedWater = input.nextInt();
                    System.out.println("Write how many ml of milk you want to add:");
                    int addedMilk = input.nextInt();
                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int addedCoffeeBeans = input.nextInt();
                    System.out.println("Write how many disposable cups you want to add:");
                    int addedCups = input.nextInt();

                    input.nextLine();
                    coffeeMachine.fillMachine(addedWater, addedMilk, addedCoffeeBeans, addedCups);
                    break;

                case "take":
                    coffeeMachine.takeMoney();
                    break;

                case "remaining":
                    coffeeMachine.displayStatus();
                    break;

                case "exit":
                    working = false;
                    break;

                default:
                    System.exit(0);
                    break;
            }
        }



    }
}
