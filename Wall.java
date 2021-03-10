import java.awt.*;
import java.util.ArrayList;

public class Wall {

    public double x;
    public double y;
    public double width;
    public double height;
    public Character character;
    public long previousWorldUpdateTime;
    public double speedX;
    public double speedY;
    public boolean wallL;
    public boolean wallR;
    public boolean wallU;
    public boolean wallD;

    public Wall(double x, double y, Character character, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.character = character;
        this.speedX = 0.2;
        this.speedY = 0.2;
        this.wallL = false;
        this.wallR = false;
        this.wallU = false;
        this.wallD = false;
        this.previousWorldUpdateTime = System.currentTimeMillis();
    }

    public void checkObjects() {

            if (character.x >= this.x && character.x <= this.x + width && character.y + character.height - 7 >= this.y && character.y + 7 <= this.y + height) {
                character.x = x + width;
            }

            if (character.x + character.width >= this.x && character.x + character.width <= this.x + width && character.y + character.height - 7 >= this.y && character.y + 7 <= this.y + height) {
                character.x = x - 50;
            }

            if (character.x + character.width - 7 >= this.x && character.x + 7 <= x + width && character.y >= y && character.y <= y + height) {
                character.y = y + height;
            }

            if (character.x + character.width - 7 >= this.x && character.x + 7 <= this.x + width && character.y + character.height >= this.y && character.y + character.height <= this.y + height) {
                character.y = y - 50;
            }
    }

    public void checkObjects(Enemy enemy) {

        if (enemy.x >= this.x && enemy.x <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
            enemy.x = x + width;
            enemy.xH = enemy.x + 5;
        }

        if (enemy.x + enemy.width >= this.x && enemy.x + enemy.width <= this.x + width && enemy.y + enemy.height - 7 >= this.y && enemy.y + 7 <= this.y + height) {
            enemy.x = x - 40;
            enemy.xH = enemy.x + 5;
        }

        if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= x + width && enemy.y >= y && enemy.y <= y + height) {
            enemy.y = y + height;
            enemy.yH = enemy.y - 10;
        }

        if (enemy.x + enemy.width - 7 >= this.x && enemy.x + 7 <= this.x + width && enemy.y + enemy.height >= this.y && enemy.y + enemy.height <= this.y + height) {
            enemy.y = y - 40;
            enemy.yH = enemy.y - 10;
        }
    }

    /*public void update(long dt) {
        if (character.isMoving) {
            //x -= character.dtX;
            //y -= character.dtY;
        }
    }*/

    public void changeLocation(int x) {
        if (x == 1) {
            this.y = this.y + 1000;
        } else if (x == 2) {
            this.x = this.x - 1000;
        } else if (x == 3) {
            this.y = this.y - 1000;
        } else if (x == 4) {
            this.x = this.x + 1000;
        }
    }



    public void draw(Graphics g) {
        g.drawRect((int) x, (int) y, (int) width, (int) height);
        this.checkObjects();
    }

}
