import java.util.ArrayList;
import java.util.Scanner;

public class Game {
    private Player player = Player.newPlayer();
    private Enemy enemy = Enemy.newEnemy();

    public void play() {
        String name;
        int type1;
        int weapons1 = 0;
        int spells1 = 0;
        int bows1 = 0;

        System.out.println("Vitej!");

        var Name = new Scanner(System.in);
        System.out.println("Vyber si jmeno: ");
        name = Name.nextLine();

        ArrayList<String> type = new ArrayList<>();
        type.add("1. Warrior");
        type.add("2. Mage");
        type.add("3. Archer");
        type.add("4. Peasant");

        ArrayList<String> weapons = new ArrayList<>();
        weapons.add("1. sword");
        weapons.add("2. axe");
        weapons.add("3. spear");

        ArrayList<String> spells = new ArrayList<>();
        spells.add("1. fireball");
        spells.add("2. frostbolt");
        spells.add("3. lightning bolt");

        ArrayList<String> bows = new ArrayList<>();
        bows.add("1. crossbow");
        bows.add("2. longbow");
        bows.add("3. shortbow");

        var Type = new Scanner(System.in);
        System.out.println("Vyber si povolani: ");
        System.out.println(type);
        type1 = Type.nextInt();

        switch (type1) {
            case 1:
                System.out.println("Vybral sis valecnika s jmenem " + name);
                System.out.println("Vyber si zbran: ");
                System.out.println(weapons);
                var Weapons = new Scanner(System.in);
                weapons1 = Weapons.nextInt();
                System.out.println("Zbran vybavena!");
                break;
            case 2:
                System.out.println("Vybral sis kouzelnika s jmenem " + name);
                System.out.println("Vyber si kouzlo: ");
                System.out.println(spells);
                var Spells = new Scanner(System.in);
                spells1 = Spells.nextInt();
                System.out.println("Kouzlo nauceno!");
                break;
            case 3:
                System.out.println("Vybral sis Archera s jmenem " + name);
                System.out.println("Vyber si luk: ");
                System.out.println(bows);
                var Bows = new Scanner(System.in);
                bows1 = Bows.nextInt();
                System.out.println("Luk vybaven!");
                break;
            case 4:
                System.out.println("Ses peasant a jmenujes se " + name);
                break;
        }
        switch (weapons1){
            case 1:
                player.setMindmg(9);
                player.setMaxdmg(13);
                break;
            case 2:
            case 3:
                player.setMindmg(10);
                player.setMaxdmg(14);
                break;
        }

        switch (spells1){
            case 2:
                player.setMindmg(9);
                player.setMaxdmg(13);
                break;
            case 1:
            case 3:
                player.setMindmg(10);
                player.setMaxdmg(14);
                break;
        }

        switch (bows1){
            case 3:
                player.setMindmg(9);
                player.setMaxdmg(13);
                break;
            case 1:
            case 2:
                player.setMindmg(10);
                player.setMaxdmg(14);
                break;
        }
    }

    public void fight() {
        String choice;

        System.out.println("Narazil jsi na skeletona" + ": " + "\n");
        System.out.println("Souboj se skeletonem" + " zacina (" + player.getStatus() + ", " + enemy.getStatus() + ")");

        var Choice = new Scanner(System.in);
        System.out.print("Zautocit (a) nebo odejit (x)?");
        choice = Choice.nextLine();
        while (player.isAlive() && enemy.isAlive()) {
            if (choice.equals("a")) {
                enemy.defend(player);
            } else if (choice.equals("x")) {
                System.out.println("Utekl jsi ze souboje a hra konci.");
                System.exit(0);
            }
            if (enemy.isAlive()) {
                player.defend(enemy);
            }
        }
    }


    public static void main(String[] args) {
        Game game = new Game();
        game.play();
        game.fight();
    }
}
