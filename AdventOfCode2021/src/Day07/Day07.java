package Day07;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

public class Day07 {
    public static void main(String[] args) {
        Part1(args[0]);
        Part2(args[0]);
    }

    private static void Part2(String arg) {
        List<Integer> input = Arrays.stream(arg.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer mittelwert = input.stream().mapToInt(x->x).sum()/input.size();

        int fuel = 0;
        for (Integer crap : input) {
            int abstand=Math.abs(crap - mittelwert);
            fuel += (abstand*(abstand+1))/2;

        }
        System.out.println("Part 2 " + fuel);
    }

    private static void Part1(String arg) {
        List<Integer> input = Arrays.stream(arg.split(","))
                .map(Integer::parseInt)
                .sorted()
                .collect(Collectors.toList());

        Integer median = input.get(input.size() / 2);

        int fuel = 0;
        for (Integer crap : input) {
            fuel += Math.abs(crap - median);
        }
        System.out.println("Fuel Part 1: " + fuel);
    }
}
