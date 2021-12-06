package Day06;

public class Lanternfish {
    int fish;

    public Lanternfish(int fish) {
        this.fish = fish;
    }

    public int getFish() {
        return fish;
    }

    public void setFish(int fish) {
        this.fish = fish;
    }

    @Override
    public String toString() {
        return "Lanternfish{" +
                "fish=" + fish +
                '}';
    }

    public void reduceOneDay() {
        fish--;
    }
}
