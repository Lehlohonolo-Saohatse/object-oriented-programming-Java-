import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.JOptionPane;

public class FileClass
{
    private Vehicle [] arrVehicles = new Vehicle[20];
    private int count = 0;

    // Method to read vehicle data from a file
    public void readFromFile(String fileName)
    {
        try
        {
            Scanner sc = new Scanner(new FileReader(fileName));

            while (sc.hasNext())
            {
                String line = sc.nextLine();
                String [] info = line.split(",");

                String owner = info[0];
                String regNum = info[1];
                String make = info[2];
                int year = Integer.parseInt(info[3]);
                double price = Double.parseDouble(info[4]);
                arrVehicles[count] = new Vehicle(owner, regNum, make, year, price);
                count++;
            }

            sc.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error using the file");
        }
    }

    // Getter for the count of vehicles
    public int getCount()
    {
        return count;
    }

    // Setter for the count of vehicles
    public void setCount(int count) {
        this.count = count;
    }

    // Getter for the array of vehicles
    public Vehicle [] getVehiclesArr()
    {
        return arrVehicles;
    }

    // Method to write vehicle data to a file
    public void writeToFile() //throws IOException
    {
        try
        {
            PrintWriter fileWrite = new PrintWriter(new FileWriter("NewData.txt"));
            for (int k = 0; k < count; k++)
            {
                fileWrite.println(arrVehicles[k].getOwner()+ "@" + arrVehicles[k].getPrice() );
            }
            fileWrite.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error creating the file");
        }
    }

    // Method to serialize the array of vehicles
    public static void serializeVehicleArr(FileClass file) {
        try {
            FileOutputStream fos = new FileOutputStream("vehicles.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (int i = 0; i < file.getCount(); i++) {
                oos.writeObject(file.getVehiclesArr()[i]);
            }

            oos.close();
            System.out.println("serialization successful.");
        } catch (IOException e) {
            System.err.println("Error serializing vehicle array: " + e.getMessage());
        }
    }

    // Method to deserialize the array of vehicles
    public static void readObjects(FileClass file) {
        try {
            FileInputStream fis = new FileInputStream("vehicles.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {
                Vehicle vehicle = (Vehicle) ois.readObject();
                if (vehicle != null) {
                    file.getVehiclesArr()[file.getCount()] = vehicle;
                    file.setCount(file.getCount() + 1);
                    System.out.println(vehicle.toString());
                }
            }
            ois.close();
        } catch (IOException e) {
            System.err.println("Error deserializing vehicle array: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found during deserialization: " + e.getMessage());
        }
    }
}
