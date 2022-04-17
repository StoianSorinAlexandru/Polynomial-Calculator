package model;

import static java.lang.Math.abs;

public class Monom {

    private int grad;
    private Double coefficient;

    public int getGrad() {
        return grad;
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public Double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public Monom() {
        this.grad = 0;
        this.coefficient = 0.0;
    }

    public Monom(int grad, double coefficient) {
        this.grad = grad;
        this.coefficient = coefficient;
    }

    public int compareTo(Monom monom) {
        return monom.grad - this.grad;
    }

    public String toString(){
        String result = new String();
        System.out.println(coefficient);
        if(!coefficient.equals(1.0) && !coefficient.equals(-1.0)) {
            if (coefficient < 0)
                result = String.valueOf((-1.0) * coefficient);
            else
                result = String.valueOf(coefficient);
        }
        System.out.println(result);
        if(grad > 0){
            result = result + "X";
            if(grad > 1)
                result = result + "^" + grad;
        }

        return  result;
    }
}
