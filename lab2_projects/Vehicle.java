import java.io.Serializable;
//The Serializable interface is added to the Vehicle class to enable instances of the class to be serialized

public class Vehicle implements Serializable
{
    private static final long serialVersionUID = 1L;
    private String owner;
    private String regNumber;
    private String make;
    private int year;
    private double price;

    /**
     * Constructor for objects of class Vehicle
     */
    public Vehicle()
    {

    }
    /**
     * Parameterized constructor for objects of class Vehicle
     * @param owner The owner of the vehicle
     * @param regNumber The registration number of the vehicle
     * @param make The make of the vehicle
     * @param year The year of the vehicle
     * @param price The price of the vehicle
     */
    public Vehicle(String owner, String regNumber,String make, int year, double price)
    {
        this.owner = owner;
        this.regNumber = regNumber;
        this.make = make;
        this.year = year;
        this.price = price;
    }

    // Getters and setters for the private fields
    public String getOwner()
    {
        return owner;
    }
    public String getRegNumber()
    {
        return regNumber;
    }
    public String getMake()
    {
        return make;
    }
    public int getYear()
    {
        return year;
    }
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double newPrice)
    {
        price = newPrice;
    }

    /**
     * Returns a string representation of the vehicle
     * @return A formatted string representing the vehicle details
     */
    public String toString()
    {
        String newStr = String.format("%-20s%-15s%-20s%-10d%-8.2f", owner, regNumber, make, year, price);
        return newStr;
    }

    // Main method for testing
    public static void main(String[] args) throws Exception {
        testVehicle.main(args);
    }
}
