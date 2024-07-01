package hw1arrays;                                                                                //Morgan Pickens
                                                                                                  // 5/19/2024
import java.io.IOException; // Import IOException

public class Main {
    public static void main(String[] args) {
        try {
            CityManager manager = new CityManager("countries.txt", "cities.txt"); // Create manager
            for (String country : manager.getCountries()) { // Loop through countries
                System.out.println("Cities in " + country + ":"); // Print country
                for (City city : manager.getCities(country)) { // Loop through cities
                    System.out.println(city); // Print city
                }
            }
        } catch (IOException e) {
            e.printStackTrace(); // Print exception
        }
    }
}
