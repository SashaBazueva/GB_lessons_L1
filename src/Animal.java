public abstract class Animal {
    private String name;
    private String category;
    private boolean satiety;
    private static int count;


    public Animal(String name, String category) {
        this.category = category;
        this.name = name;
        count++;
    }


    public abstract void run(int runLength);

    public abstract void swim(int swimLength);

    public abstract void eat(Plate plateOfFood);

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public static int getCount() {
        return count;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

}