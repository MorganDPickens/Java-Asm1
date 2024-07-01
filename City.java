package hw1arrays;                                                                                           // Morgan Pickens
                                                                                                            // 5/19/2024
public class City implements Comparable<City> {
    private String name; // For City name
    private String state; // For City state
    private int population; // For City population
    private String country; // FOr City country

    public City(String name, String state, int population, String country) { // Constructor
        this.name = name; // this is Set name
        this.state = state; // this is to Set state
        this.population = population; //this is to  Set population
        this.country = country; // and last we Set country
    }

    public City(String name, int population) { // Constructor
        this(name, "", population, ""); // Call other constructor
    }

    @Override
    public int compareTo(City other) { // CompareTo method
        return Integer.compare(this.population, other.population); // Compare by population
    }

    @Override
    public String toString() { // toString method
        return String.format("%s, %s, %s, %d", name, state, country, population); // Return formatted string
    }
}
