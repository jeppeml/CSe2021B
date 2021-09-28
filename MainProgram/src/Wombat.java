public class Wombat {
    private String name;
    private int health;

    public Wombat(String name, int health){
        this.name = name;
        this.health = health;
    }

    public void live(){
        health--;
    }

    public int getHealth(){
        return health;
    }

    public String getName(){
        return name;
    }
}
