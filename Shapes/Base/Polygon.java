package Shapes.Base;

import java.util.ArrayList;

import Shapes.Interfaces.CalculatePerimeter;

public abstract class Polygon extends Shape implements CalculatePerimeter {
    protected ArrayList<Double> sideLenghts;

    protected Polygon(String shapeName) {
        super(shapeName);
    }

    public void setSideLenghts(ArrayList<Double> sideLenghts) throws Exception {
        this.sideLenghts = sideLenghts;
    }

    @Override
    public Double calculatePerimeter() {
        Double perimeter = 0.0;
        for (Double sideLenght : this.sideLenghts) {
            perimeter += sideLenght;
        }
        return perimeter;
    }

    public String toString() {
        return String.format("%sДлины сторон равны: %s%nПериметр равен: %.1f%nПлощадь равна: %.1f", super.toString(),
                this.sideLenghts.toString(), this.calculatePerimeter(),
                this.calculateArea());
    }

    @Override
    public abstract Double calculateArea();
}
