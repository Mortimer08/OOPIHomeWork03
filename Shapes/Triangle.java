package Shapes;

import java.util.ArrayList;

import Shapes.Base.Polygon;

public class Triangle extends Polygon {
    public Triangle(Double sideA, Double sideB, Double sideC) throws Exception {
        super("Треугольник");
        ArrayList<Double> sideLenghts = new ArrayList<>();
        sideLenghts.add(sideA);
        sideLenghts.add(sideB);
        sideLenghts.add(sideC);
        setSideLenghts(sideLenghts);
    }

    @Override
    public Double calculateArea() {
        Double p = this.calculatePerimeter() / 2;
        Double a = super.sideLenghts.get(0);
        Double b = super.sideLenghts.get(1);
        Double c = super.sideLenghts.get(2);
        Double area = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return area;
    }

    public void setSideLenghts(ArrayList<Double> sideLenghts) throws Exception {
        if (sideLenghts.get(0) > 0 && sideLenghts.get(1) > 0 && sideLenghts.get(2) > 0) {
            if (sideLenghts.get(0) + sideLenghts.get(1) > sideLenghts.get(2) &&
                    sideLenghts.get(1) + sideLenghts.get(2) > sideLenghts.get(0) &&
                    sideLenghts.get(2) + sideLenghts.get(0) > sideLenghts.get(1)) {
                super.setSideLenghts(sideLenghts);
            } else {
                throw new Exception("Такой треугольник невозможен");
            }
        } else {
            throw new Exception("Длины сторон должны быть положительными числами");
        }
    }
}
