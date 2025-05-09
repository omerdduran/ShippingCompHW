package containers;

public abstract class Container {
    private double width;
    private double height;
    private double length;

    public Container(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public double calculateVolume() {
        return width * height * length;
    }

    public void printContainerInfo() {
        System.out.println("Container Volume: " + calculateVolume());
    }

    // Getter and Setter
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
}
