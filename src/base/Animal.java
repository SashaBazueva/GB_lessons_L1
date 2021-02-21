package base;

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }


    public abstract void run(int runLength);

    public abstract void swim(int swimLength);

    public String getName() {
        return name;
    }
}
