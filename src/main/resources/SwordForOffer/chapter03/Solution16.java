/**
 * @author mayuan
 * @desc
 * @date 2018/02/28
 */
public class Solution16 {

    public static void main(String[] args) {
        System.out.println(power(2.0, 5));
        System.out.println(power(2.0, -1));
        System.out.println(power(0, -1));
    }

    public static boolean invalidInput = false;

    public static double power(double base, int exponent) {
        invalidInput = false;

        if (base < 1e-7 && base > -1e-7 && exponent < 0) {
            invalidInput = true;
            return 0.0;
        }

        int absExponent = exponent;
        if (exponent < 0) {
            absExponent = -exponent;
        }

        double result = powerWithUnsignedExponent(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    public static double powerWithUnsignedExponent(double base, int exponent) {
        if (0 == exponent) {
            return 1.0;
        }
        if (1 == exponent) {
            return base;
        }

        double result = powerWithUnsignedExponent(base, exponent >> 1);
        result *= result;

        if (1 == (exponent & 1)) {
            result *= base;
        }
        return result;
    }
}
