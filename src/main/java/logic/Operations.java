package logic;

import model.Polynoms;
import model.Monom;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Math.max;

public class Operations {

    public Polynoms addPolynoms(Polynoms polinom1, Polynoms polinom2){

        ///Identificam puterea maxima a polinomului rezultat
        int gradMaxim = max(polinom1.getMaximum(), polinom2.getMaximum());
        Polynoms polinomAuxiliar = new Polynoms();
        Monom monAux = new Monom(0, 0);

        for(int i=0; i<=gradMaxim; ++i){
            monAux = new Monom(i, polinom1.getCoefficientOfGrade(i).getCoefficient() + polinom2.getCoefficientOfGrade(i).getCoefficient());
            polinomAuxiliar.addMonom(monAux);
        }
        polinomAuxiliar.monomArrayList.sort(Monom::compareTo);
        return polinomAuxiliar;
    }

    public Polynoms subtractPolynoms(Polynoms polinom1, Polynoms polinom2){

        ///Identificam puterea maxima a polinomului rezultat
        int gradMaxim = max(polinom1.getMaximum(), polinom2.getMaximum());
        Polynoms polinomAuxiliar = new Polynoms();
        Monom monAux = new Monom(0, 0);

        for(int i=0; i<=gradMaxim; ++i){
            monAux = new Monom(i, polinom1.getCoefficientOfGrade(i).getCoefficient() - polinom2.getCoefficientOfGrade(i).getCoefficient());
            polinomAuxiliar.addMonom(monAux);
        }
        polinomAuxiliar.monomArrayList.sort(Monom::compareTo);
        return polinomAuxiliar;
    }

    public Polynoms multiplyPolynoms(Polynoms polinom1, Polynoms polinom2){

        Polynoms polinomAuxiliar = new Polynoms();
        Monom monomAuxiliar = new Monom(0,0);
        ArrayList<Polynoms> polinoameInmultite = new ArrayList<>();

        for(Monom m : polinom1.monomArrayList){
            polinomAuxiliar = new Polynoms();
            for(Monom n : polinom2.monomArrayList){
                monomAuxiliar = new Monom(m.getGrad() + n.getGrad(), m.getCoefficient() * n.getCoefficient());
                polinomAuxiliar.addMonom(monomAuxiliar);
            }
            polinoameInmultite.add(polinomAuxiliar);
        }

        polinomAuxiliar = new Polynoms();
        for(Polynoms p : polinoameInmultite){
            polinomAuxiliar = addPolynoms(polinomAuxiliar, p);
        }

        return  polinomAuxiliar;

    }

    public ArrayList<Polynoms> dividePolynoms(Polynoms p1, Polynoms p2){

        ArrayList<Polynoms> result = new ArrayList<>();
        Polynoms cat = new Polynoms();

        while(!p1.monomArrayList.isEmpty() && p1.getMaximum() - p2.getMaximum() >=0){
            Monom monomAuxiiar1 = p1.monomArrayList.get(0);
            Monom monomAuxiiar2 = p2.monomArrayList.get(0);
            Polynoms polinomAuxiliar = new Polynoms();
            if(monomAuxiiar1.getGrad() >= monomAuxiiar2.getGrad()){
                Monom monomAuxiliar3 = new Monom(monomAuxiiar1.getGrad() - monomAuxiiar2.getGrad(), monomAuxiiar1.getCoefficient() / monomAuxiiar2.getCoefficient());
                polinomAuxiliar.addMonom(new Monom(monomAuxiliar3.getGrad(), monomAuxiliar3.getCoefficient()));
            }
            else break;
            Polynoms polinomAuxiliar2 = multiplyPolynoms(p2, polinomAuxiliar);
            polinomAuxiliar2 = subtractPolynoms(new Polynoms(), polinomAuxiliar2);
            cat=addPolynoms(cat, polinomAuxiliar);
            p1 = addPolynoms(p1, polinomAuxiliar2);
            p1.deleteZeroes();
        }

        result.add(cat);
        result.add(p1);

        return result;
    }

    public Polynoms derivatePolynoms(Polynoms polynoms){

        Polynoms polynoms1 = new Polynoms();
        Monom monom = new Monom(0, 0);

        for(Monom m : polynoms.monomArrayList){
            if(m.getGrad() > 0){
                monom = new Monom(m.getGrad() - 1, m.getCoefficient() * m.getGrad());
                polynoms1.addMonom(monom);
            }
        }
        return polynoms1;
    }

    public Polynoms integratePolynoms(Polynoms polynoms){
        Polynoms polynoms1 = new Polynoms();
        polynoms1.setIntegrated(true);
        Monom monom = new Monom(0, 0);

        for(Monom m : polynoms.monomArrayList){
            if(m.getGrad() != 0)
                monom = new Monom(m.getGrad() + 1, m.getCoefficient() / (m.getGrad() + 1));
            else
                monom = new Monom(m.getGrad() + 1, m.getCoefficient());
            polynoms1.addMonom(monom);
        }

        return polynoms1;
    }

    public String[] prepString(String string){
        String[] test2;
        string = string.replaceAll("\\s+", "");
        string = string.replaceAll("\\-", "+-");
        test2 = string.split("\\+");
        return test2;
    }

    public Polynoms toPolynoms(String string){
        Monom monom = new Monom();
        Polynoms polynoms = new Polynoms();
        String[] test2 = prepString(string);
        for(String s : test2){
            String[] test3 = s.split("\\^");
            System.out.println(s);
            if(!test3[0].isEmpty()) {
                if (test3.length == 1) {
                    String aux = test3[0];
                    //char ch = aux.charAt(aux.length() - 1);
                    //if ((65 <= ch && ch <= 90) || (97 <= ch && ch <= 122)) {
                    if ((65 <= aux.charAt(aux.length() - 1) && aux.charAt(aux.length() - 1) <= 90) || (97 <= aux.charAt(aux.length() - 1) && aux.charAt(aux.length() - 1) <= 122)) {
                        monom.setGrad(1);
                        if (aux.substring(0, aux.length() - 1).length() == 0) monom.setCoefficient(1.0);
                        else {  if(aux.substring(0, aux.length() - 1).equals("-")) monom.setCoefficient(-1.0);
                                else monom.setCoefficient(Integer.parseInt(aux.substring(0, aux.length() - 1)));
                        }
                    } else  { monom=new Monom(0, Integer.parseInt(aux));}
//                       { monom.setGrad(0);
//                        monom.setCoefficient(Integer.parseInt(aux)); }
                } else {
                    monom.setGrad(Integer.parseInt(test3[1]));
                    String aux = test3[0];
                    if (aux.substring(0, aux.length() - 1).length() == 0) monom.setCoefficient(1.0);
                    else {  if (aux.substring(0, aux.length() - 1).equals("-"))  monom.setCoefficient(-1.0);
                            else monom.setCoefficient(Integer.parseInt(aux.substring(0, aux.length() - 1)));
                    }
                }
                polynoms.addMonom(monom);
            }
        }
        return polynoms;
    }


    public boolean checkString(String string){
        boolean ok = true;
        if(string.isEmpty())
            return true;
        string = string.replaceAll("\\s+", "");

        if(string.charAt(0) != '-')
            string="+"+string;
        String[] strings = string.split("[-+][0-9]*([a-zA-Z](\\^[0-9]*)?)?");
        for(String s : strings)
            if(s.isEmpty())
                ok=false;
        if(ok == true) {
            String patternString1 = "[a-zA-Z]";
            Pattern pattern = Pattern.compile(patternString1);
            Matcher matcher = pattern.matcher(string);
            ArrayList<String> stringArrayList = new ArrayList<>();
            while (matcher.find()) {
                if(!stringArrayList.contains(matcher.group(0)))
                    stringArrayList.add(matcher.group(0));
            }
            if(stringArrayList.size() > 1)
                ok = false;
        }
        return ok;
    }
}
