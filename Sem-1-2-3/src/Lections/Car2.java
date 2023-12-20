package Lections;

public class Car2 {
    public String name;
    public String price;
    public String engType;
    public String engPower;
    public int maxSpeed;

    public Car2(String name) {
        this.name = name;
        this.price = "C";
        this.engType = "SQL";
        this.engPower = "fast";
        this.maxSpeed = 100;
    }

    @Override
    public String toString() {
        return "Lections.Car2{" +
                "name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", engType='" + engType + '\'' +
                ", engPower='" + engPower + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
