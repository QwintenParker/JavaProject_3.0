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
