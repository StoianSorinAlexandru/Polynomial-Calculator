package model;

import java.util.ArrayList;

import static java.lang.Math.abs;

public class Polynoms {

    public ArrayList<Monom> monomArrayList = new ArrayList<>();
    private boolean isIntegrated;

    public boolean isIntegrated() {
        return isIntegrated;
    }

    public void setIntegrated(boolean integrated) {
        isIntegrated = integrated;
    }

    public Polynoms(){
        this.isIntegrated = false;
    }

    public Polynoms(ArrayList<Monom> monomArrayList) {
        this.monomArrayList = monomArrayList;
        this.isIntegrated = false;
    }

    public int getMaximum(){
        int Max = 0;
        for(Monom m : monomArrayList){
            if(Max < m.getGrad())
                Max = m.getGrad();
        }

        return Max;
    }

    public Monom getCoefficientOfGrade(int grad){

        for(Monom m : monomArrayList){
            if(m.getGrad() == grad){
                return m;
            }
        }

        return new Monom(0,0);
    }

    public void addMonom(Monom monom){

        boolean ok = false;

        for(Monom m : monomArrayList){
            if(monom.getGrad() == m.getGrad()) {
                ok=true;
                m.setCoefficient(m.getCoefficient() + monom.getCoefficient());
                break;
            }
        }
        if(!ok)
            monomArrayList.add(new Monom(monom.getGrad(), monom.getCoefficient()));
        monomArrayList.sort(Monom::compareTo);

    }

    public String toString(){

        if(monomArrayList.isEmpty())
            return "0";

        String result = new String();

        for(Monom m : monomArrayList){
                if(m.getCoefficient() < 0) {
                    result = result + " - " + m.toString();

                }else {
                    if(m.getCoefficient() > 0)
                        result = result + " + " + m.toString();
                }
        }
        if(result.charAt(1) == '+')
            result = result.replaceFirst(" \\+ ", "");

        if(isIntegrated == true)
            result = result + " + C";


        return result;
    }

    public void deleteZeroes(){

        Polynoms polynoms = new Polynoms();

        for(Monom monom : monomArrayList){
            if(!monom.getCoefficient().equals(0.0)) {
                polynoms.addMonom(monom);
            }
        }

        this.monomArrayList = polynoms.monomArrayList;

    }

}
