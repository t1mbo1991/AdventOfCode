package Day06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day06_2ndPart {
    static long[] daysLeft = new long[9];
    static int days=256;

    public static void main(String[] args) {
        init(args[0]);
        for(int i = 0; i< days; i++) {
            populationCycle();
        }
        calcPopulation();
    }

    private static void init(String arg) {
        List<Lanternfish> fish = Arrays.stream(arg.split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(x -> new Lanternfish(x))
                .collect(Collectors.toList());

        for (Lanternfish lanternfish : fish) {
            for(int i=0;i<9;i++) {
                if (lanternfish.getFish() == i) {
                    daysLeft[i]++;
                }
            }
        }
    }

    private static void populationCycle() {
        long zwischenSpeicher = daysLeft[0];
        daysLeft[0]=daysLeft[1];
        daysLeft[1]=daysLeft[2];
        daysLeft[2]=daysLeft[3];
        daysLeft[3]=daysLeft[4];
        daysLeft[4]=daysLeft[5];
        daysLeft[5]=daysLeft[6];
        daysLeft[6]=daysLeft[7]+zwischenSpeicher;
        daysLeft[7]=daysLeft[8];
        daysLeft[8]=zwischenSpeicher;
    }

    private static void calcPopulation() {
        long summe=daysLeft[0];
        for(int i=1;i<9;i++){
            summe+=daysLeft[i];
        }

        System.out.println(summe);
    }

}
