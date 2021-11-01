import java.util.Scanner;

public class capsuleHotel {

    static Scanner console = new Scanner(System.in);


    public static void main(String[] args) {
        boolean exitApp = false;
        greeting();
        String[] capsules = new String[numberOfCapsules()];
        int userChoice = (displayHotelMenu());
        while (!exitApp) {
            if (userChoice == 1) {
                boolean occupied = false;
                printOptionMenu("Guest check in", 13);
                String name = getGuestName();
                    // endless loop if full
                do {
                    int guestPlacement = getCapsuleNumber(capsules.length);
                    if (capsules[guestPlacement] == null) {
                        capsules[guestPlacement ] = name;
                        System.out.format("%s has been checked in to capsule #%s \n", capsules[guestPlacement], guestPlacement);
                        occupied = true;
                        userChoice = (displayHotelMenu());
                    }else
                        System.out.println("Sorry room is occupied!");
                }while (occupied = false);
            } else if (userChoice == 2) {
                boolean checkedIn = true;
                // does not exit if no one is checked in
                do {
                    printOptionMenu("Check out guests", 13);
                    int guestPlacement = getCapsuleNumber(capsules.length);

                    if (!(capsules[guestPlacement] == null)) {
                        System.out.format("%s has been checked out from capsule %d! \n",capsules[guestPlacement] ,guestPlacement);
                        capsules[guestPlacement] = null;
                        userChoice = (displayHotelMenu());
                    }else if ((capsules[guestPlacement] == null)){
                        System.out.format("Error! Capsule %d is already empty!\n" ,guestPlacement);
                    }
                } while (checkedIn);

            } else if (userChoice == 3) {
                printOptionMenu("View Guests", 13);
                int guestPlacement = getCapsuleNumber(capsules.length);
                displayRooms(guestPlacement, capsules);
                userChoice = (displayHotelMenu());
            } else if (userChoice == 4) {
                if(exitApp()) {
                    exitApp = true;
                }else{
                    userChoice = (displayHotelMenu());
                }
            }
        }
    }
    public static void greeting(){
        System.out.println("Welcome to Capsule-Capsule.");
        System.out.println("=".repeat(27));
    }

    public static int numberOfCapsules(){
        System.out.println("Enter the number of capsules available");
        return Integer.parseInt(console.nextLine());
    }


    public static int displayHotelMenu(){
        System.out.println("Guest Menu");
        System.out.println("==========");
        System.out.println("1. Check In");
        System.out.println("2. Check Out");
        System.out.println("3. View Guests");
        System.out.println("4. Exit");
        System.out.println("Choose on option [1-4]");
        return Integer.parseInt(console.nextLine());
    }



    public static String getGuestName(){
        System.out.println("Guest name");
        return console.nextLine();
    }


    public static int getCapsuleNumber(int numberOfCapsules){
        System.out.println("Capsule #[1-" + numberOfCapsules + "]:");
        return Integer.parseInt(console.nextLine());
    }

    public static void printOptionMenu(String prompt, int repeats){
        System.out.println(prompt);
        System.out.println("=".repeat(repeats));
    }



    public static void displayRooms(int guestPlacement, String[] capsules){
        if (guestPlacement <= 5) {
            for (int i = 0; i < guestPlacement + 6; i++) {
                if (capsules[i] == null) {
                    System.out.println(i+1 + ":[unoccupied]");
                } else System.out.println(i+1 + ":" + capsules[i]);
            }


        }else if(guestPlacement >= capsules.length - 4) {
            for (int i = guestPlacement -6; i < 100; i++) {
                if (capsules[i] == null) {
                    System.out.println(i+1 + ":[unoccupied]");
                } else System.out.println(i+1 + ":" + capsules[i]);
            }

        }
        else{
            for(int i = guestPlacement-6; i<guestPlacement+6; i++ ){
                if(capsules[i] == null){
                    System.out.println(i+1 +":[unoccupied]");
                }else System.out.println(i+1 + ":" + capsules[i]);
            }
        }
    }


    public static boolean exitApp(){
        System.out.println("Exit");
        System.out.println("====");
        System.out.println("Are you sure you want to exit\n" +
                "All data will be lost.\n" +
                "Exit [y/n]:");
        String exit = console.nextLine();
        if (exit.equals("y")) {
            System.out.println("GoodBye");
            return true;
        }
        return false;
    }
}