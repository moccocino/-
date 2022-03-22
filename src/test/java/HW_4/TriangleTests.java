package HW_4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static HW_4.TriangleSquareCalculation.countTriangleArea;

public class TriangleTests {

    @Test
    void calcArea() throws BadTriangleException {
        double result = countTriangleArea(3, 4, 5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void badTriangleTest() {
        assertThatExceptionOfType(BadTriangleException.class).isThrownBy(
                () -> countTriangleArea(2, 3, 4));
    }

    private org.assertj.core.api.NotThrownAssert assertThatExceptionOfType(Class<BadTriangleException> badTriangleExceptionClass) {
        return null;
    }
}

