public class App {

    public static void main(String[] args) {
        // 1. instantiation
        NationalForest one = new NationalForest();
        // 2. set a `public` field
        one.name = "Allegheny";

        NationalForest two = new NationalForest();
        two.name = "Angeles";

        NationalForest three = new NationalForest();
        three.name = "Angelina";

        String format = "name: %s, location: %s, acres: %s%n";
        // 3. read each `public` field
        // each object's fields have different values
        System.out.printf(format, one.name, one.location, one.acres);
        System.out.printf(format, two.name, two.location, two.acres);
        System.out.printf(format, three.name, three.location, three.acres);
    }
}

