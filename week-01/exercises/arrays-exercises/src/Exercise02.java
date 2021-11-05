public class Exercise02 {

    public static void main(String[] args) {

        String[] tenFavoriteFoods = new String[10]; // space for 10 favorite foods

        tenFavoriteFoods[5] = "squid ink";
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[6]);

        // 1. Set your 10 favorite foods. (It's okay to replace squid ink.)
        // 2. Print your top, 6th, and last favorite from tenFavoriteFoods.
        tenFavoriteFoods[0] = "squid ink";
        tenFavoriteFoods[1] = "pizza";
        tenFavoriteFoods[2] = "pasta";
        tenFavoriteFoods[3] = "grilled cheese";
        tenFavoriteFoods[4] = "hamburger";
        tenFavoriteFoods[5] = "sushi";
        tenFavoriteFoods[6] = "shrimp";
        tenFavoriteFoods[7] = "rice";
        tenFavoriteFoods[8] = "veggies";
        tenFavoriteFoods[9] = "milk";

        System.out.println(tenFavoriteFoods[0]);
        System.out.println(tenFavoriteFoods[5]);
        System.out.println(tenFavoriteFoods[9]);

    }
}
