import java.util.Scanner;


public class testVehicle
{
    public static void main(String [] args) throws Exception
    {
        Scanner inputString = new Scanner(System.in);
        Scanner inputNumber = new Scanner(System.in);

        FileClass file = new FileClass();
        file.readFromFile("VehicleData.txt");
        Vehicle [] arrVehicles = file.getVehiclesArr();
        int count = file.getCount();

        displayList(arrVehicles, count);
        FileClass.serializeVehicleArr(file);
        FileClass.readObjects(file);


    }
    //displaying the list of vehicle objects
    public static void displayList(Vehicle [] arrVehicles, int count)
    {
        System.out.printf("%-20s%-17s%-20s%-10s%-10s\n", "Owner", "Reg Number", "Make", "Year", "Price(R.c)");

        for (int k = 0; k < count; k++)
        {
            System.out.println((k + 1) + "." + arrVehicles[k].toString());
        }
    }



}
