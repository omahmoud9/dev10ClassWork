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
                checkInGuest();
                String name = getGuestName();

                // endless loop if full
                do {
                    int guestPlacement = getCapsuleNumber(capsules.length);
                    if (capsules[guestPlacement] == null) {
                        capsules[guestPlacement] = name;
                        System.out.format("%s has been checked in to capsule #%s", capsules[guestPlacement], guestPlacement);
                        occupied = true;
                        userChoice = (displayHotelMenu());
                    }else
                        System.out.println("Sorry room is occupied!");
                }while (occupied = false);
            } else if (userChoice == 2) {
                boolean checkedIn = true;
                // does not exit if no one is checked in
                do {
                    checkOutGuest();

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
                viewGuests();
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
            Scanner console = new Scanner(System.in);
            System.out.println("Enter the number of capsules available");
            return Integer.parseInt(console.nextLine());
        }


        public static int displayHotelMenu(){
            Scanner console = new Scanner(System.in);
            System.out.println("Guest Menu");
            System.out.println("==========");
            System.out.println("1. Check In");
            System.out.println("2. Check Out");
            System.out.println("3. View Guests");
            System.out.println("4. Exit");
            System.out.println("Choose on option [1-4]");
            return Integer.parseInt(console.nextLine());
        }


        public static void checkInGuest(){
            System.out.println("Guest Check In");
            System.out.println("=".repeat(13));
        }


        public static String getGuestName(){
            Scanner console = new Scanner(System.in);
            System.out.println("Guest name");
            return console.nextLine();
        }


        public static int getCapsuleNumber(int numberOfCapsules){
//            Scanner console = new Scanner(System.in);
            System.out.println("Capsule #[1-" + numberOfCapsules + "]:");
            return Integer.parseInt(console.nextLine());
        }


        public static void checkOutGuest(){
            System.out.println("Guest check out");
            System.out.println("=".repeat(13));
        }


        public static void viewGuests(){
            System.out.println("View Guests");
            System.out.println("=".repeat(13));
        }


        public static void displayRooms(int guestPlacement, String[] capsules){
            for(int i = guestPlacement-5; i<guestPlacement+6; i++ ){
                if(capsules[i] == null){
                    System.out.println(i +":[unoccupied]");
                }else System.out.println(i + ":" + capsules[i]);
            }
        }


        public static boolean exitApp(){
            Scanner console = new Scanner(System.in);
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