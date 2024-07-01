package hw1arrays;                                                                                             // Morgan Pickens
                                                                                                               // 5/19/2024
import java.io.BufferedReader; //this is to  Import BufferedReader 
import java.io.FileReader; // Import FileReader
import java.io.IOException; // Import IOException
import java.util.Arrays; // Import Arrays - had to avoid using array list

public class CityManager implements CityInterface {
    private String[] countries; // this is the  Array for country names
    private City[][] cities; // 2D array for cities
    private int countryCount; // Number of countries

    public CityManager(String countryFileName, String cityFileName) throws IOException {
        try (BufferedReader countryReader = new BufferedReader(new FileReader(countryFileName));
             BufferedReader cityReader = new BufferedReader(new FileReader(cityFileName))) {
            countries = countryReader.lines().skip(1).map(line -> line.split("\t")[0]).toArray(String[]::new); // Read countries
            countryCount = countries.length; // Set country count
            cities = new City[countryCount][]; // Initialize cities array
            cityReader.readLine(); // Skip header line 1 because parsing error
            cityReader.readLine(); // Skip second header line this also gives a paring error
            String line; // Initialize line 
            while ((line = cityReader.readLine()) != null) { // Read each line
                if (line.trim().isEmpty()) continue; // Skip empty lines because we dont need 
                String[] parts = line.split("\t"); // Split line
                if (parts.length < 2) continue; // Skip if not enough parts
                String country = parts[0]; // Get the country
                String cityName = parts[1]; // Get the city name
                String state = parts.length > 2 ? parts[2] : ""; // Get state
                int population = parts.length > 3 ? Integer.parseInt(parts[3]) : 0; // Get population
                addCity(country, cityName, state, population); // Add city
            }
        }
    }

    private void addCity(String country, String cityName, String state, int population) {
        int countryIndex = getIDCountry(country); // Get country index
        if (countryIndex == -1) return; // what we do if country not found
        City[] countryCities = cities[countryIndex]; // Get cities of country
        if (countryCities == null) { // If no cities yet
            cities[countryIndex] = new City[] { new City(cityName, state, population, country) }; // Add first city
        } else {
            int length = countryCities.length; // Get the length
            City[] newCities = Arrays.copyOf(countryCities, length + 1); // Copy and extend array
            newCities[length] = new City(cityName, state, population, country); // Add new city
            cities[countryIndex] = newCities; // Update cities array
        }
        System.out.printf("Added city: %s, %s, %s, %d to country: %s%n", cityName, state, country, population, country); // Print added city
    }
                                     // this section below is for the overriding functions 
    @Override
    public int getCountryCount() {
        return countryCount; // Return country count
    }

    @Override
    public int getIDCountry(String country) {
        for (int i = 0; i < countries.length; i++) { // Loop through countries
            if (countries[i].equals(country)) { // If country matches
                return i; // Return index
            }
        }
        return -1; // If not found
    }

    @Override
    public int getCitiesCount(String country) {
        int countryIndex = getIDCountry(country); // Get country index
        if (countryIndex == -1) return 0; // If country not found
        return cities[countryIndex] == null ? 0 : cities[countryIndex].length; // Return city count
    }

    @Override
    public int getCitiesCount() {
        int total = 0; // Initialize total
        for (City[] countryCities : cities) { // Loop through countries
            if (countryCities != null) { // If the cities exist
                total += countryCities.length; //then we  Add to total
            }
        }
        return total; // Return total cities count
    }

    @Override
    public City[] getCities(String countryName) {
        int countryIndex = getIDCountry(countryName); // Get country index
        if (countryIndex == -1 || cities[countryIndex] == null) return new City[0]; // If country is  not found
        return Arrays.copyOf(cities[countryIndex], cities[countryIndex].length); // Return copy of cities array
    }

    public String[] getCountries() {
        return Arrays.copyOf(countries, countries.length); // Return copy of countries array
    }
}

    	
