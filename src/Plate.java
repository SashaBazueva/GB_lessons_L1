public class Plate {
    private int fullness;

    public Plate(int fullness) {
        this.fullness = fullness;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int fullness) {
        this.fullness = fullness;
    }

    public void addFood(int food) {
        setFullness(getFullness() + food);
    }
}