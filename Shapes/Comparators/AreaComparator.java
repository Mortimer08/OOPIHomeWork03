package Shapes.Comparators;

import java.util.Comparator;

import Shapes.Base.Shape;

public class AreaComparator implements Comparator<Shape>{

    @Override
    public int compare(Shape arg0, Shape arg1) {
        
        if (arg0.calculateArea() > arg1.calculateArea()) {
            return 1;
        } else if (arg1.calculateArea() > arg0.calculateArea()) {
            return -1;
        } else
            return 0;
    
    }
    
}
