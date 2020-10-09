package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
        this.calculatePerimeter();
        this.calculateArea();
    }

    @Override
    protected void calculatePerimeter() {
        setPerimeter(2 * (this.height + this.width));
    }

    @Override
    protected void calculateArea() {
        setArea(this.height * this.width);
    }

    public Double getHeight() {
        return this.height;
    }

    public Double getWidth() {
        return this.width;
    }
}
