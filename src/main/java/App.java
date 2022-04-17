
import gui.View;
import logic.Operations;
import model.*;

import javax.swing.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {


        JFrame frame = new View("Calculator Polinoame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setVisible(true);

        //Operations op = new Operations();

        //String string = "5X^5 + 3X^2 + 4X^2 - 1";
        //System.out.println(op.checkString(string));


//        Polynoms polynoms = new Polynoms();
//        polynoms = new Operations().toPolynoms(string);
//        System.out.println(polynoms.toString());

//
//        Polynoms p = new Polynoms();
//        Polynoms d = new Polynoms();
//        Polynoms t = new Polynoms();
//        ArrayList <Polynoms> test = new ArrayList<Polynoms>();

//        p.addMonom(new Monom(2, 1));
//        p.addMonom(new Monom(1, 2));
//        p.addMonom(new Monom(0, 1));
//        p=op.derivatePolynoms(p);
//        System.out.println(p.toString());
//        d.addMonom(new Monom(3, 2));
//        d.addMonom(new Monom(1, 9));
//        d.addMonom(new Monom(0, 2));
//
//        System.out.println(p.toString());
//        System.out.println(d.toString());
//
//        t=op.addPolynoms(p,d);
//        System.out.println(t.toString());
//
//        t=op.subtractPolynoms(p,d);
//        System.out.println(t.toString());
//
//        t=op.multiplyPolynoms(p,d);
//        System.out.println(t.toString());
//
//        test = op.dividePolynoms(d,p);
//        for (Polynoms a : test)
//            System.out.println(a.toString());

    }

}
