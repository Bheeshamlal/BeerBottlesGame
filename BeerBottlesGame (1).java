import java.util.Scanner;

 class BeerBottlesGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalBottles = 21;

        System.out.println("Welcome to the Beer Bottles Game!");
        System.out.println("There are 21 beer bottles, and you are playing against the computer.");
        System.out.println("Each turn, you can pick up 1 to 4 bottles.");

        System.out.print("Would you like to play first? (yes/no): ");
        String playFirst = scanner.nextLine();

        if (playFirst.equalsIgnoreCase("yes")) {
            playGame(scanner, totalBottles);
        } else {
            System.out.println("Thank you for playing!");
        }
    }

    public static void playGame(Scanner scanner, int totalBottles) {
        while (totalBottles > 0) {
            int userPick;
            do {
                System.out.print("How many bottles would you like to pick up? (1-4): ");
                userPick = scanner.nextInt();
                if (userPick < 1 || userPick > 4 || userPick > totalBottles) {
                    System.out.println("Invalid input. Please pick between 1 and 4 bottles.");
                }
            } while (userPick < 1 || userPick > 4 || userPick > totalBottles);

            totalBottles -= userPick;

            if (totalBottles == 0) {
                System.out.println("You picked up the last bottle, you lose!");
                break;
            }

            int computerPick = 5 - userPick;
            totalBottles -= computerPick;

            System.out.println("Computer picked " + computerPick + " bottles.");
            System.out.println("Bottles remaining: " + totalBottles);

            if (totalBottles == 0) {
                System.out.println("Computer picked up the last bottle, computer loses!");
                break;
            }
        }
    }
}
