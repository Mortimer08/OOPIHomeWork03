package ShapesCollection;

import Shapes.Circle;
import Shapes.Retrangle;
import Shapes.Square;
import Shapes.Triangle;
import Shapes.Base.Shape;

public class ShapesCreation {

    public static void fillCollection(ShapesCollection sc) throws Exception {
        Shape triangle = new Triangle(3.0, 4.0, 5.0);
        Shape sq = new Square(5.0);
        Shape circle = new Circle(7.0);
        Shape retrangle = new Retrangle(5.0, 7.0);
        sc.addShape(triangle);
        sc.addShape(circle);
        sc.addShape(sq);
        sc.addShape(retrangle);
    }
}
