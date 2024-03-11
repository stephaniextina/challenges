package org.diamond;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DiamondKata {

    public static void main(String[] args) {
        System.out.println("Welcome to Diamond Kata!");
        DiamondKata diamondKata = new DiamondKata();
        String diamond = diamondKata.diamondGenerator();
        System.out.println(diamond);
    }

    public String diamondGenerator(){
        String diamond = "";
        Scanner scanner = new Scanner(System.in);
        String inputLetter = "";
        while (!checkValidInput(inputLetter) && scanner.hasNext()) {
                inputLetter = scanner.next();
        }
        if (checkValidInput(inputLetter)) {
            inputLetter = inputLetter.toUpperCase();
            System.out.println("Input letter is: " + inputLetter);
            System.out.printf("%nDiamond:%n");
            diamond = printDiamond(inputLetter);
        }

        return diamond;
    }

    public boolean checkValidInput(String inputLetter){
        boolean isValidInput;
        try {
            if(inputLetter.length()!=1) {
                System.out.printf("Please enter a single letter:%n");
                throw new Exception("Invalid input");
            } else if (!inputLetter.matches("[A-Za-z]")){
                System.out.printf("Please only enter letters:%n");
                throw new Exception("Invalid input");
            }
            isValidInput = true;
        } catch (Exception e) {
            isValidInput = false;
        }
        return isValidInput;
    }

    public String printDiamond(String inputLetter){
        List<StringBuilder> diamond = new ArrayList<>();
        int inputLetterAsInt = inputLetter.charAt(0);
        int initialSpaceNum = (inputLetterAsInt - 'A');
        for(int i = 0; i <= initialSpaceNum; ++i) {
            StringBuilder diamondLine = new StringBuilder();
            diamondLine.append(" ".repeat(Math.max(0, initialSpaceNum-i)));
            diamondLine.append((char)('A' + i));
            diamondLine.append(" ".repeat(Math.max(0, i)));
            diamondLine.append(new StringBuilder(diamondLine.substring(0, diamondLine.length()-1)).reverse());
            diamond.add(diamondLine);
        }
        for(int i = diamond.size()-2; i >= 0; --i) {
            diamond.add(diamond.get(i));
        }
        return diamond.stream().map(Object::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }

}