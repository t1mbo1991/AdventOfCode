package Day03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day3 {
    public static void main(String[] args) {
        part1(args);
        part2(args);
    }

    private static void part1(String[] input) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        char notC = '0';
        List<String> inputList = Arrays.stream(input).toList();
        for (int i = 0; i < input[0].length(); i++) {
            char c = commonBit(inputList, i);
            gamma.append(c);
            if(c=='0') notC='1';
            else notC='0';
            epsilon.append(notC);
        }
        int gammaInt = Integer.parseInt(gamma.toString(), 2);
        int epsilonInt = Integer.parseInt(epsilon.toString(), 2);
        System.out.println(gammaInt * epsilonInt);
    }
    private static char commonBit(List<String> list, int i) {
        int counterOfZero=0;
        int counterOfOne=0;
        for (String s : list) {
            if (s.charAt(i) == '0') counterOfZero++;
            if (s.charAt(i) == '1') counterOfOne++;
        }
        if(counterOfZero<=counterOfOne) return '1';
        else return '0';
    }
    private static void part2(String[] input) {
        List<String> List1 = Arrays.stream(input).collect(Collectors.toList());
        List<String> List2 = new ArrayList<>(List1);
        String oxygenRating = findOxygenRating(List1);
        String co2Rating = findCO2ScrubberRating(List2);
        int ox= Integer.parseInt(oxygenRating,2);
        int co2= Integer.parseInt(co2Rating,2);
        System.out.println(ox*co2);
    }
    private static String findOxygenRating(List<String> input) {
        for (int bitPosition = 0; input.size()>1; bitPosition++) {
            char commonBit = commonBit(input, bitPosition);
            for (int listPosition=0; listPosition<input.size(); listPosition++) {
                String numberAsBinaryString = input.get(listPosition);
                if(numberAsBinaryString.charAt(bitPosition) != commonBit) {
                    input.remove(listPosition);
                    listPosition--;
                }
            }
        }
        return input.get(0);
    }
    private static String findCO2ScrubberRating(List<String> input) {
        for (int bitPosition = 0; input.size()>1; bitPosition++) {
            char commonBit = commonBit(input, bitPosition);
            for (int listPosition=0; listPosition<input.size() ; listPosition++) {
                String numberAsBinaryString = input.get(listPosition);
                if(numberAsBinaryString.charAt(bitPosition) == commonBit) {
                    input.remove(listPosition);
                    listPosition--;
                }
            }
        }
        return input.get(0);
    }

}
