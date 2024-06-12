package items;

public abstract class Item {
    private String name;
    private double width;
    private double height;
    private double length;
    private double weight;

    public Item(String name, double width, double height, double length, double weight) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.weight = weight;
    }

    public double calculateVolume() {
        return width * height * length;
    }

    public void printItemInfo() {
        System.out.println("Name: " + name + ", Volume: " + calculateVolume() + ", Weight: " + weight);
    }

    // Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
