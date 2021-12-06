package Day06;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Day06 {

    static List<Lanternfish> fish = new LinkedList<>();
    static int days=80;

    public static void main(String[] args) {

        fish = Arrays.stream(args[0].split(","))
                .mapToInt(Integer::parseInt)
                .mapToObj(x -> new Lanternfish(x))
                .collect(Collectors.toList());

        for(int i=0; i<days; i++) {
            for (int j = 0; j < fish.size(); j++) {
                Lanternfish lanterns = fish.get(j);
                if (lanterns.getFish() == 0) {
                    lanterns.setFish(6);
                    fish.add(new Lanternfish(8));
                } else lanterns.reduceOneDay();
            }
        }
        System.out.println(fish.size());
    }


}
