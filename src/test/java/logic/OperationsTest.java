package logic;

import model.Monom;
import model.Polynoms;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperationsTest {

    @Test
    void addPolynoms() {
        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms p2 = new Polynoms();
        Polynoms sum = new Polynoms();

        p1=op.toPolynoms("X^2 + 2x + 1");
        p2=op.toPolynoms("X^3 + 3x^2 + 1");
        sum=op.toPolynoms("X^3 + 4X^2 + 2X + 2");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(sum.toString(), op.addPolynoms(p1,p2).toString());
    }

    @Test
    void subtractPolynoms() {
        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms p2 = new Polynoms();
        Polynoms dif = new Polynoms();

        p1=op.toPolynoms("X^2 + 2x + 1");
        p2=op.toPolynoms("X^3 + 3X^2 + 1");
        dif=op.toPolynoms("-X^3 - 2X^2 + 2X");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(dif.toString(), op.subtractPolynoms(p1,p2).toString());
    }

    @Test
    void multiplyPolynoms() {

        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms p2 = new Polynoms();
        Polynoms prod = new Polynoms();

        p1=op.toPolynoms("X^2 + 2x + 1");
        p2=op.toPolynoms("X^3 + 3X^2 + 1");
        prod=op.toPolynoms("X^5 + 5X^4 + 7X^3 + 4X^2 + 2X + 1");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(prod.toString(), op.multiplyPolynoms(p1,p2).toString());
    }

    @Test
    void dividePolynoms() {


        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms p2 = new Polynoms();
        Polynoms quotient = new Polynoms();
        Polynoms remainder = new Polynoms();

        p1=op.toPolynoms("X^7 + 2X + 1");
        p2=op.toPolynoms("X^3 + 3X^2 + 1");
        quotient=op.toPolynoms("X^4 - 3X^3 + 9X^2 - 28X + 87");
        remainder=op.toPolynoms("-270X^2 + 30X - 86");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(quotient.toString(), op.dividePolynoms(p1,p2).get(0).toString());
        Assertions.assertEquals(remainder.toString(), op.dividePolynoms(p1,p2).get(1).toString());
    }

    @Test
    void derivatePolynoms() {

        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms deriv = new Polynoms();

        p1=op.toPolynoms("X^2 + 2x + 1");
        deriv=op.toPolynoms("2X + 2");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(deriv.toString(), op.derivatePolynoms(p1).toString());

    }

    @Test
    void integratePolynoms() {

        Operations op = new Operations();
        Polynoms p1 = new Polynoms();
        Polynoms integ = new Polynoms();

        p1=op.toPolynoms("3X^2 + 2x + 1");
        integ=op.toPolynoms("X^3 + X^2 + X");

        //System.out.printf(p1.toString());

        Assertions.assertEquals(integ.toString() + " + C", op.integratePolynoms(p1).toString());
    }

    @Test
    void toPolynoms() {

        Operations op = new Operations();
        String s2 = "X^2    +   2X  +    1";
        Polynoms p1 = op.toPolynoms("X^2+2X+1");
        Assertions.assertEquals(op.toPolynoms(s2).toString(), p1.toString());
    }

    @Test
    void checkString() {
        Operations op = new Operations();
        String s1 = "X^2 + 2X + 1";
        String s2 = "X^2 + 2x + 1";
        Assertions.assertEquals(op.checkString(s1), true);
        Assertions.assertEquals(op.checkString(s2), false);

    }
}