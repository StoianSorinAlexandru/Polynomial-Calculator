package gui;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame{

    private JPanel contentPane;
    private JPanel polinomialPanel;
    private JLabel firstPolinomLabel;
    private JTextField firstPolinomTextField;
    private JLabel secondPolinomLabel;
    private JTextField secondPolinomTextField;
    private JLabel operationsLabel;
    private JComboBox operationComboBox;
    private JButton computeButton;
    private JPanel resultPanel;
    private JLabel resultValuePanel;
    private  JLabel resultLabel1;
    private  JLabel resultValueLabel1;
    private  JLabel resultLabel2;
    private  JLabel resultValueLabel2;

    Controller controller = new Controller(this);

    public View(String name){
        super(name);
        this.prepareGui();
    }

    ///INITIALIZAREA GUI-ULUI
    public void prepareGui(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.contentPane = new JPanel(new GridLayout(2, 2));
        this.prepareNumbersPanel();
        this.prepareResultPanel();
        this.setContentPane(this.contentPane);
    }

    public void prepareResultPanel(){
        this.resultPanel = new JPanel();
        this.resultPanel.setLayout(new GridLayout(2,1));
        this.resultLabel1=new JLabel("Result", JLabel.CENTER);
        this.resultValueLabel1 = new JLabel("", JLabel.CENTER);
        this.resultLabel2=new JLabel("Result", JLabel.CENTER);
        this.resultValueLabel2 = new JLabel("", JLabel.CENTER);
        this.resultPanel.add(this.resultLabel1);
        this.resultPanel.add(this.resultValueLabel1);
        this.resultPanel.add(this.resultLabel2);
        this.resultPanel.add(this.resultValueLabel2);
        this.contentPane.add(this.resultPanel);
    }

    ///IMPLEMENTAREA BUTOANELOR SI TEXTFIELD-URILOR
    public void prepareNumbersPanel(){
        this.polinomialPanel = new JPanel();
        this.polinomialPanel.setLayout(new GridLayout(5, 2));

        ///Prima casuta
        this.firstPolinomLabel = new JLabel("First polinomial", JLabel.CENTER);
        this.polinomialPanel.add(this.firstPolinomLabel);
        this.firstPolinomTextField = new JTextField();
        this.polinomialPanel.add(this.firstPolinomTextField);

        ///A doua casuta
        this.secondPolinomLabel = new JLabel("Second polinomial", JLabel.CENTER);
        this.polinomialPanel.add(this.secondPolinomLabel);
        this.secondPolinomTextField = new JTextField();
        this.polinomialPanel.add(this.secondPolinomTextField);

        ///Selectia de operatii
        this.operationsLabel = new JLabel("Select Operations", JLabel.CENTER);
        this.polinomialPanel.add(this.operationsLabel);

        ///Casuta selectie operatii
        String[] operations = new String[]{
                "Add",
                "Subtract",
                "Multiply",
                "Divide",
                "Derivate",
                "Integrate",
        };
        this.operationComboBox = new JComboBox(operations);
        this.polinomialPanel.add(operationComboBox);

        ///Casuta de calcul
        this.computeButton = new JButton("Compute");
        this.computeButton.setActionCommand("COMPUTE");
        this.computeButton.addActionListener(this.controller);
        this.polinomialPanel.add(this.computeButton);

        ///SETAREA CONTENT PANELUL-UL PE AFISARE
        this.contentPane.add(this.polinomialPanel);
    }

    public JTextField getFirstPolinomTextField() {
        return firstPolinomTextField;
    }

    public JTextField getSecondPolinomTextField() {
        return secondPolinomTextField;
    }

    public JComboBox getOperationsComboBox() {
        return operationComboBox;
    }

    public JLabel getResultValueLabel1() {
        return resultValueLabel1;
    }
    public JLabel getResultValueLabel2() {
        return resultValueLabel2;
    }
}
