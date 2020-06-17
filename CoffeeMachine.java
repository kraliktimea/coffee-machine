/*  The coffee machine works with typical products: coffee, milk, sugar, and plastic cups;
* if it runs out of something, it shows a notification. You can get three types of coffee: espresso,
* cappuccino and latte. Since nothing’s for free, it also collects the money. */

import java.util.Scanner;

public class CoffeeMachine {
    public int water = 400;
    public int milk = 540;
    public int coffee = 120;
    public int cups = 9;
    public int money = 550;
    public String choice = "";
    public boolean exit = false;
    public Scanner sc = new Scanner(System.in);

    // Writes out the remaining resources.
    public void stateWriter() {
        System.out.println("The coffee machine has:");
        System.out.println(this.water + " of water");
        System.out.println(this.milk + " of milk");
        System.out.println(this.coffee + " of coffee beans");
        System.out.println(this.cups + " of disposable cups");
        System.out.println(this.money + " of money");
    }

    // Action chooser.
    public void chooseAction() {
        do {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        choice = sc.next();
            switch (choice) {
                case "buy":
                    this.buy();
                    break;
                case "fill":
                    this.fill();
                    break;
                case "take":
                    this.take();
                    break;
                case "remaining":
                    this.stateWriter();
                    break;
                case "exit":
                    this.exit = true;
                    break;
                default:
                    System.out.println("Error!");
                    break;
            }
        } while (!choice.equals("exit"));
    }

    //Which coffee do you want?
    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String answer = this.sc.next();
        switch(answer) {
            case "1":
                //espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
                if (this.water < 250) {
                    System.out.println("Sorry, not enough water!");
                } else if (this.coffee < 16) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 250;
                    this.coffee -= 16;
                    this.money += 4;
                    this.cups--;
                }
                break;
            case "2":
                //latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
                if (this.water < 350) {
                    System.out.println("Sorry, not enough water!");
                }else if (this.milk < 75) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffee < 20) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 350;
                    this.milk -= 75;
                    this.coffee -= 20;
                    this.money += 7;
                    this.cups--;
                }
                break;
            case "3":
                //cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee. It costs $6.
                if (this.water < 200) {
                    System.out.println("Sorry, not enough water!");
                }else if (this.milk < 100) {
                    System.out.println("Sorry, not enough milk!");
                } else if (this.coffee < 12) {
                    System.out.println("Sorry, not enough coffee beans!");
                } else if (this.cups < 1) {
                    System.out.println("Sorry, not enough cups!");
                } else {
                    System.out.println("I have enough resources, making you a coffee!");
                    this.water -= 200;
                    this.milk -= 100;
                    this.coffee -= 12;
                    this.money += 6;
                    this.cups--;
                }
                break;
            case "back":
                break;
            default:
                System.out.println("Wrong input!");
                break;
        }
    }
    
    // Fill the machine.
    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += this.sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += this.sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffee += this.sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += this.sc.nextInt();
    }

    // Take the money from the machine.
    public void take() {
        System.out.println("I gave you $" + this.money);
        this.money = 0;
    }

    public static void main(String[] args) {
        CoffeeMachine cm = new CoffeeMachine();
        cm.chooseAction();
    }

}
