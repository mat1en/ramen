package vo;

public class Add{
    private String name; // option name of an item
    private double price; // price of an item
    private int num; // sold number of an item
    private boolean availability; // the availabilty of an item

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public boolean isAvailability() {
        return availability;
    }
}