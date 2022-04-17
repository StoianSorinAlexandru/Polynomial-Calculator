package gui;

import logic.Operations;
import model.Polynoms;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Controller implements ActionListener {

    private View view;

    private Operations operations = new Operations();

    public Controller(View view){
        this.view = view;
    }

    public void actionPerformed(ActionEvent e){

        String command = e.getActionCommand();
        if(command == "COMPUTE"){

            if(view.getFirstPolinomTextField().getText().isEmpty())
                view.getResultValueLabel1().setText("EROARE POLINOM LIPSA");
            else {

                String firstString = view.getFirstPolinomTextField().getText();
                String secondString = view.getSecondPolinomTextField().getText();
                if(operations.checkString(firstString + " + " + secondString)) {
                //if(operations.checkString(firstString) && operations.checkString(secondString)) {

                    Polynoms firstPolynoms = operations.toPolynoms(view.getFirstPolinomTextField().getText());
                    Polynoms secondPolynoms = operations.toPolynoms(view.getSecondPolinomTextField().getText());
                    String operation = String.valueOf(view.getOperationsComboBox().getSelectedItem());
                    //System.out.println(operation);

                    Polynoms result1 = new Polynoms();
                    Polynoms result2 = new Polynoms();
                    boolean error2 = false;
                    ArrayList<Polynoms> polynomsArrayList = new ArrayList<>();
                    switch (operation) {
                        case "Add":
                            result1 = operations.addPolynoms(firstPolynoms, secondPolynoms);
                            break;
                        case "Subtract":
                            result1 = operations.subtractPolynoms(firstPolynoms, secondPolynoms);
                            break;
                        case "Multiply":
                            if(secondPolynoms.monomArrayList.isEmpty())
                                error2 = true;
                            else
                                result1 = operations.multiplyPolynoms(firstPolynoms, secondPolynoms);
                            break;
                        case "Divide":
                            if(secondPolynoms.monomArrayList.isEmpty())
                                error2 = true;
                            else {
                                polynomsArrayList = operations.dividePolynoms(firstPolynoms, secondPolynoms);
                                result1 = polynomsArrayList.get(0);
                                result2 = polynomsArrayList.get(1);
                            }
                            break;
                        case "Derivate":
                            result1 = operations.derivatePolynoms(firstPolynoms);
                            break;
                        case "Integrate":
                            result1 = operations.integratePolynoms(firstPolynoms);
                            break;
                    }
                    //System.out.println(result1.toString());
                    //System.out.println(result2.toString() + "\n");
                    if(error2 == false) {
                        view.getResultValueLabel1().setText(result1.toString());
                        view.getResultValueLabel2().setText(result2.toString());
                    }
                    else {
                        view.getResultValueLabel1().setText("SECOND POLINOMIAL MUST BE NOT ZERO FOR THIS OPERATION");
                    }
                }
                else{
                    String result1 = "FIRST OR SECOND POLINOMIAL IS WRONGLY ENTERED";
                    view.getResultValueLabel1().setText(result1);
                }
            }
        }

    }


}
