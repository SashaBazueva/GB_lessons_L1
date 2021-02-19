package base;

public abstract class Animal {
    protected int runLength;
    protected int swimLength;
    protected String name;

    public Animal(String name) {
        this.name = name;
    }


    public abstract void run(int runLength);

    public abstract void swim(int swimLength);

}