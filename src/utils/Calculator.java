package utils;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    public int getElectrons(String inputOrbital) {
        Pattern pattern = Pattern.compile("\\d[a-zA-Z](\\d{1,2})");
        Matcher matcher = pattern.matcher(inputOrbital);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group(1));
        } else {
            throw new IllegalArgumentException("Formato no válido");
        }
    }

    public ArrayList<String> calculate(int atomicNumber) {

        ArrayList<String> result = new ArrayList<>();
        int currentElectrons = atomicNumber;

        for (String orbital : Diagram.moellerDiagram) {

            result.add(orbital);
            currentElectrons -= getElectrons(orbital);

            if (currentElectrons <= 0) break;

        }

        if (currentElectrons < 0) {
            String lastOrbital = result.removeLast();

            String lastOrbitalValue = lastOrbital.substring(0,2);
            int lastOrbitalElectrons = getElectrons(lastOrbital) + currentElectrons;

            result.add(lastOrbitalValue + lastOrbitalElectrons);
        }

        return result;
    }

    public void print(ArrayList<String> list) {
        list.forEach((orbital) -> {
            System.out.print(orbital + " ");
        });
    }

}
