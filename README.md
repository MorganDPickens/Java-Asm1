# Java-Projects
1 Understand
1.1 Know the Objectives
Upon project completion, you will have acquired a solid understanding of the following concepts and their
implementation in code:
• Two-dimensional, jagged, and parallel arrays
• Interfaces usage
1.2 Understand the Problem
The task involves managing data for cities with populations exceeding 1,000,000. The objective is to develop code
allowing clients to access data for countries and cities efficiently. To achieve this, we will employ a two-
dimensional jagged array to store city data and a parallel one-dimensional array for country names.
2 Design
2.1 Draw a Class Diagram
Provide a class diagram illustrating the project's structure, including interfaces and all classes, excluding Main.
2.2 Draw an Object Diagram
Submit an object diagram depicting the initial state of the system after adding a few countries and cities, clearly
illustrating the array data and parallelism.
3 Code
3.1 Understand the Details
3.1.1 Cities
Create a City class that has the following fields, in this order: Name, Country, State, and Population. All of these
should be of String type except Population (integer). Add preconditions to prevent null and empty parameter
contents except State. Implement natural ordering by cities by name using compareTo() and Comparable
interface.
3.1.2 CityManager
This class manages city and country data, utilizing the CityInterface.java class. Implement methods to access city
and country data. Ensure the constructor accepts two File references indicating the countries and cities files,
handling any FileNotFoundExceptions appropriately.
3.1.3 Files
Utilize the provided data files: country.txt for country data and cities.txt for cities data.
3.1.4 Use These
Utilize a two-dimensional jagged array for cities data and a one-dimensional array for country names.
