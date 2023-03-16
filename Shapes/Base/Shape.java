package Shapes.Base;

import Shapes.Interfaces.CalculateArea;

public abstract class Shape implements CalculateArea, Comparable<Shape> {
    private String shapeName;

    protected Shape(String shapeName) {
        this.shapeName = shapeName;
    }

    protected void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public String toString() {
        return String.format("Тип фигуры: %s%n", this.shapeName);
    }

    public int compareTo(Shape o) {
        if (this.calculateArea() > o.calculateArea()) {
            return 1;
        } else if (this.calculateArea() < o.calculateArea()) {
            return -1;
        } else
            return 0;
    }
}