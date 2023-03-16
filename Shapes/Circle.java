package Shapes;

import Shapes.Base.Shape;
import Shapes.Interfaces.CalculateCircleLenght;

public class Circle extends Shape implements CalculateCircleLenght {
    Double radius;

    public Circle(Double radius) throws Exception {
        super("Круг");
        setRadius(radius);
    }

    private void setRadius(Double radius) throws Exception {
        if (radius > 0) {
            this.radius = radius;
        } else {
            throw new Exception("Радиус должен быть положительным числом");
        }
    }

    public String toString() {
        return String.format("%sРадиус равен: %.1f%nДлина окружности равна: %.1f%nПлощадь равна: %.1f",
                super.toString(), this.radius,
                this.calculateCircleLenght(),
                this.calculateArea());
    }

    @Override
    public Double calculateArea() {
        Double area;
        area = Math.PI * this.radius * this.radius;
        return area;
    }

    @Override
    public Double calculateCircleLenght() {
        Double circleLenght;
        circleLenght = 2 * Math.PI * this.radius;
        return circleLenght;

    }
}
