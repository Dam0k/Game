import java.util.Random;

public class Player {
    private int hp;
    private int mindmg;
    private int maxdmg;
    private Random random = new Random();

    public void setMindmg(int mindmg) {
        this.mindmg = mindmg;
    }

    public void setMaxdmg(int maxdmg) {
        this.maxdmg = maxdmg;
    }

    Player(int hp, int mindmg, int maxdmg) {
        this.hp = hp;
        this.mindmg = mindmg;
        this.maxdmg = maxdmg;
    }

    public int attack() {
        return random.nextInt(maxdmg - mindmg + 1) + mindmg;
    }

    public void defend(Enemy enemy) {
        int attackpower = enemy.attack();
        hp = (hp > attackpower) ? hp - attackpower : 0;
        System.out.printf("  " + "Byl jsi zasazen za %d poskozeni (%s)\n", attackpower, getStatus());
        if (hp == 0) {
            System.out.println("Byl jsi zabit.");
        }
    }


    public boolean isAlive() {
        return hp > 0;
    }

    public String getStatus() {
        return "HP hrace: " + hp;
    }

    public static Player newPlayer() {
        return new Player(40, 8, 12);
    }
}
