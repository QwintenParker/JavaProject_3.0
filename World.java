import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class World {

    public ArrayList<Wall> walls = new ArrayList<Wall>();
    public ArrayList<Enemy> enemies = new ArrayList<>();
    //public ArrayList<Objects> objects = new ArrayList<>();
    public Character character;
    public int runningX;
    public int runningY;
    public World(Character character) {
        this.character = character;
        this.runningX = 0;
        this.runningY = 0;
    }

    public void createWallsSquare() {

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(100, i, character, 10, 50));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(790, i, character, 10, 50));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(i, 100, character, 50 ,10));
            i = i + 50;
        }

        for (double i = 100; i <= 750;) {
            walls.add(new Wall(i, 790, character, 50, 10));
            i = i + 50;
        }
    }

    public void createEnemies() {
        enemies.add(new Enemy(200, 700, character));
        enemies.add(new Enemy(-1500, 400, character));
        enemies.add(new Enemy(400, 100, character));
    }

    //public void createObjects() {
    //    objects.add(new Objects(200, 300, character));
    //    objects.add(new Objects(400, 600, character));
    //    objects.add(new Objects(475, 400, character));
    //}


    public void drawWalls(Graphics g) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).draw(g);
        }
    }

    public void drawEnemies(Graphics g) {
        for (int i = 0; i < enemies.size(); i++) {
            (enemies.get(i)).draw(g);
        }
    }

    public void updateEnemies(long dt) {
        for (int i = 0; i < enemies.size(); i++) {
            (enemies.get(i)).update(dt);
            (enemies.get(i)).updateDamage();
        }
    }

    public void updateCharacterDamage(MouseEvent e) {
        for (int i = 0; i < enemies.size(); i++) {
            (enemies.get(i)).characterDamage(e);
        }
    }

    public void changeLocation(int x) {
        for (int i = 0; i < walls.size(); i++) {
            (walls.get(i)).changeLocation(x);
        }

        for (int i = 0; i < enemies.size(); i++) {
            (enemies.get(i)).changeLocation(x);
        }
    }

    public void checkEnemyWalls() {
        for (int i = 0; i < walls.size(); i++) {
            for (int j = 0; j < enemies.size() ; j++) {
                (walls.get(i)).checkObjects(enemies.get(j));
            }
        }
    }

    //public void drawObjects(Graphics g) {
    //    for (int i = 0; i < objects.size(); i++) {
    //        (objects.get(i)).draw(g);
    //    }
    //}


    public void createTestWorld() {
        for (double i = 300; i <= 650;) {
            walls.add(new Wall(i, 200, character, 25, 25));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(300, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 200; i <= 650;) {
            walls.add(new Wall(650, i, character, 25, 25));
            i = i + 25;
        }

        for (double i = 1500; i <= 1875;) {
            walls.add(new Wall(i, 500, character, 25, 25));
            i = i + 25;
        }

        for (double i = -500; i >= -875;) {
            walls.add(new Wall(i, -500, character, 25, 25));
            i = i - 25;
        }
    }


}
