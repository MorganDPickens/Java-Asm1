package hw1arrays;                                                                                                    // Morgan Pickens
                                                                                                                     // 5/19/2024
public interface CityInterface {
    /**
    * Retrieves the count of cities for every country
    * @return count of cities
    */
    public int getCountryCount();
    /**
    * Retrieves the ID (number of raw in the array of countries)
    * @return ID
    */
    public int getIDCountry(String country);
    /**
    * Retrieves the number of cities in the specified country (by name)
    * @param country the name of the country
    * @return cities count in that country
    */
    public int getCitiesCount(String country);
    /**
    * Retrieves the number of cities in all countries
    * @return cities count in all countries
    */
    public int getCitiesCount();
    /**
    * Retrieves a copy of the cities array for the country at the specified name
    * @param countryName the name of the country
    * @return copy of cities array
    */
    public City[] getCities(String countryName);
}
