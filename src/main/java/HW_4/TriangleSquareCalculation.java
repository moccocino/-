package HW_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleSquareCalculation {

    public static double countTriangleArea(double sideA, double sideB, double sideC) throws BadTriangleException {
        //вырожденный
        if (sideA < 0 || sideB < 0 || sideC < 0) throw new BadTriangleException();
        double halfP = (sideA + sideB + sideC) / 2;
        double square = Math.sqrt(halfP * (halfP - sideA) * (halfP - sideB) * (halfP - sideC));
        return square;
    }
}