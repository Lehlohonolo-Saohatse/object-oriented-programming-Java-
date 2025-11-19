public class Contact {
    private String name;
    private String cell_Phone_Number;

    public Contact(){
        //Default constructor
    }

    public Contact(String name, String cell_Phone_Number){
        this.name = name;
        this.cell_Phone_Number = cell_Phone_Number;
    }

    public String getName(){
        return name;
    }

    public String getCell_Phone_Number(){
        return cell_Phone_Number;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setCellNum(String cell_Phone_Number){
        this.cell_Phone_Number = cell_Phone_Number;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + "          " + getCell_Phone_Number();
    }


}
