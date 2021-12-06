package Day04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    final static List<Day4Board> boards = new ArrayList<>();

    public static void main(String[] args) {
        String[] calledNumbersArray = args[0].split(",");
        List<Integer> numbersCalled = Arrays.stream(calledNumbersArray)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        initBoards(args);
        //playBingo1(numbersCalled);
        playBingo2(numbersCalled);
    }

    private static void initBoards(String[] args) {
        for (int argsCounter = 1; argsCounter < args.length; argsCounter += 25) {
            int[] newNumberArray = new int[25];
            for (int arrayCounter = 0; arrayCounter < 25; arrayCounter++) {
                newNumberArray[arrayCounter] = Integer.parseInt(args[argsCounter + arrayCounter]);
            }
            boards.add(new Day4Board(newNumberArray));
        }
    }

    private static void playBingo1(List<Integer> numbersCalled) {
        for (Integer number : numbersCalled) {
            for (Day4Board board : boards) {
                board.setSingleNumber(number);
                if (board.checkBoard()) {
                    System.out.println("BINGO! Score is: " + board.sumOfUnmarkedNumbers() * number);
                    return;
                }
            }
        }
    }

    private static void playBingo2(List<Integer> numbersCalled) {
        int winOrderCount = 1;
        for (Integer number : numbersCalled) {
            for (Day4Board board : boards) {
                if (!board.isWon()) {
                    board.setSingleNumber(number);
                    if (board.checkBoard()) {
                        board.setWon();
                        board.setWinOrder(winOrderCount);
                        board.setWinNumber(number);
                        winOrderCount++;
                    }
                }
            }
        }
        List<Day4Board> result = boards.stream()
                .filter(x -> x.getWinOrder()>0)
                .sorted(Comparator.comparingInt(Day4Board::getWinOrder).reversed())
                .collect(Collectors.toList());
        System.out.println(result.get(0).getWinOrder());
        System.out.println("BINGO: " + result.get(0).getWinNumber()*result.get(0).sumOfUnmarkedNumbers());
    }
}
