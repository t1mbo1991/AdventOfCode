package Day01;

import java.util.Arrays;

public class Day1 {
    public static void main(String[] args) {
        int counter1=0;
        int counter2=0;
        counter1 = getCounter1(args, counter1);
        counter2 = getCounter2(args, counter2);
        System.out.println("Lösung Teil 1:" + counter1);
        System.out.println("Lösung Teil 2:" + counter2);
    }

    private static int getCounter2(String[] args, int counter) {
        int newMeasurment = Integer.parseInt(args[0])+Integer.parseInt(args[1])+Integer.parseInt(args[2]);
        int prevMeasurment = newMeasurment;
        for(int i = 3; i< args.length; i++) {
            newMeasurment += Integer.parseInt(args[i]);
            newMeasurment -= Integer.parseInt(args[i-3]);
            if(newMeasurment>prevMeasurment) {
                counter++;
            }
            prevMeasurment=newMeasurment;
        }
        return counter;
    }

    private static int getCounter1(String[] args, int counter) {
        int prevZahl = Integer.parseInt(args[0]);
        for (int i = 1; i< args.length; i++) {
            int actZahl = Integer.parseInt(args[i]);
            if(actZahl > prevZahl) counter++;
            prevZahl = actZahl;
        }
        return counter;
    }
}
