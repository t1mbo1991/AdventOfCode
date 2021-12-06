package Day04;

public class Day4Board {
    int[] numbers = new int[25];
    boolean[] checked = new boolean[25];
    int winOrder =0;
    int winNumber=0;
    boolean won = false;

    public Day4Board(int[] numbers) {
        this.numbers = numbers;
        for (int i = 0; i < 25; i++) {
            checked[i] = false;
        }
    }

    public void setSingleNumber(int number) {
        for (int i = 0; i < 25; i++) {
            if (number == numbers[i]) checked[i] = true;
        }
    }

    public boolean checkBoard() {
        for (int i = 0; i < 5; i += 5) {
            if (checked[i] && checked[i + 1] && checked[i + 2] && checked[i + 3] && checked[i + 4]) return true;
        }
        for (int i = 0; i < 5; i++) {
            if (checked[i] && checked[i + 5] && checked[i + 10] && checked[i + 15] && checked[i + 20]) return true;
        }
        return false;
    }

    public int sumOfUnmarkedNumbers() {
        int sum = 0;
        for (int i = 0; i < 25; i++) {
            if (!checked[i]) sum += numbers[i];
        }
        return sum;
    }

    void printBoard() {
        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2] + " " + numbers[3] + " " + numbers[4]);
        System.out.println(numbers[5] + " " + numbers[6] + " " + numbers[7] + " " + numbers[8] + " " + numbers[9]);
        System.out.println(numbers[10] + " " + numbers[11] + " " + numbers[12] + " " + numbers[13] + " " + numbers[14]);
        System.out.println(numbers[15] + " " + numbers[16] + " " + numbers[17] + " " + numbers[18] + " " + numbers[19]);
        System.out.println(numbers[20] + " " + numbers[21] + " " + numbers[22] + " " + numbers[23] + " " + numbers[24]);
        System.out.println("------------");
    }
    public boolean isWon() {
        return won;
    }
    public void setWon() {
        won = true;
    }
    public int getWinOrder() {
        return winOrder;
    }
    public void setWinOrder(int winOrder) {
        this.winOrder =winOrder;
    }
    public int getWinNumber() {
        return winNumber;
    }
    public void setWinNumber(Integer number) {
        this.winNumber = number;
    }

}
