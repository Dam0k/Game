import java.util.Random;

public class Enemy {
    int hp;
    int mindmg;
    int maxdmg;
    private Random random = new Random();

    private Enemy(int hp, int mindmg, int maxdmg) {
        this.hp = hp;
        this.mindmg = mindmg;
        this.maxdmg = maxdmg;
    }

    public int attack() {
        return random.nextInt(maxdmg - mindmg + 1) + mindmg;
    }

    public void defend(Player player) {
        int attackStrength = player.attack();
        hp = (hp > attackStrength) ? hp - attackStrength : 0;
        System.out.printf(" Zasahl jsi skeletona za %d poskozeni (%s)\n", attackStrength, getStatus());
        if (hp == 0) {
            System.out.println("  " + "Zabil jsi skeletona!");
        }
    }

    public boolean isAlive() {
        return hp > 0;
    }

    public String getStatus() {
        return "HP nepritele: " + hp;
    }

    public static Enemy newEnemy() {
        return new Enemy(50, 8, 12);
    }


}

