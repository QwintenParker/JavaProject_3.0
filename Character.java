import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Character {
    public File img1 = new File("failed.png");
    public double x;
    public double y;
    public double width;
    public double height;
    public double xRunningSpeed;
    public double yRunningSpeed;
    public int runningX;
    public int runningY;
    public double characterHealth;
    public boolean canHit;
    public boolean isMoving;
    public BufferedImage gameOverImage;
    public double dtX;
    public double dtY;


    public Character(double x, double y) throws IOException {
        this.x = x;
        this.y = y;
        this.width = 50;
        this.height = 50;
        this.xRunningSpeed = 0.2;
        this.yRunningSpeed = 0.2;
        this.runningX = 0;
        this.runningY = 0;
        this.characterHealth = 100;
        this.canHit = false;
        this.gameOverImage = ImageIO.read(img1);
        this.isMoving = false;
    }

    public void draw(Graphics g) {
        int imageX = (int) x;
        int imageY = (int) y;
        g.drawRect(imageX, imageY, (int) width, (int) height);
        g.drawString(String.valueOf(characterHealth), 20, 20);
    }

    public void drawGameOver(Graphics g) {
        if (characterHealth <= 0) {
            g.drawImage(this.gameOverImage, 0, 0, null);
            x = 999999999;
            y = 999999999;
        }
    }

    public void startRunningLeft() {
        runningX = -1;
    }

    public void startRunningRight() {
        runningX = 1;
    }

    public void startRunningDown() {
        runningY = 1;
    }

    public void startRunningUp() {
        runningY = -1;
    }

    public void stopRunningLeft() {
        if (runningX == -1) {
            runningX = 0;
        }
    }

    public void stopRunningRight() {
        if (runningX == 1) {
            runningX = 0;
        }
    }

    public void stopRunningDown() {
        if (runningY == 1) {
            runningY = 0;
        }
    }

    public void stopRunningUp() {
        if (runningY == -1) {
            runningY = 0;
        }
    }

    public void update(long dt) {

        dtX = runningX * xRunningSpeed * dt;
        dtY = runningY * yRunningSpeed * dt;

        x += dtX;
        y += dtY;

    }

    public void changeLocation(double x0, double y0, double xN, double yN, World walls) {
        if (x < x0) {
            walls.changeLocation(4);
            this.x = 999;
        }

        if (x > xN) {
            walls.changeLocation(2);
            this.x = 1;
        }

        if (y < y0) {
            walls.changeLocation(1);
            this.y = 999;
        }

        if (y > yN) {
            walls.changeLocation(3);
            this.y = 1;
        }
    }



    //public void update(long dt, Walls walls) {
    //    walls.wallsMoves(dt);
    //}

    //public void open(MouseEvent e, Walls walls) {
    //    walls.open(e);
    //}

    /*public void checkObjects(Wall wall) {
        if (x >= wall.x && x <= wall.x + wall.width && y + height - 7 >= wall.y && y + 7 <= wall.y + wall.height) {
            x = wall.x + wall.width;
            wallL = true;
            System.out.println("LLLLL");
            //this.wallL = true;
        }

        if (x + width >= wall.x && x + width <= wall.x + wall.width && y + height - 7 >= wall.y && y + 7 <= wall.y + height) {
            x = wall.x - 50;
            wallR = true;
            System.out.println("RRRRR");
            //this.wallR = true;
        }

        if (x + width - 7 >= wall.x && x + 7 <= wall.x + wall.width && y >= wall.y && y <= wall.y + wall.height) {
            y = wall.y + wall.height;
            wallU = true;
            //this.wallU = true;
            System.out.println("UUUUU");
        }

        if (x + width - 7 >= wall.x && x + 7 <= wall.x + wall.width && y + height >= wall.y && y + height <= wall.y + wall.height) {
            y = wall.y - 50;
            wallD = true;
            //this.wallD = true;
            System.out.println("DDDDD");
        }
    }*/


    //public void damage(Enemy enemy, MouseEvent e) {
    //    if (e.getX() >= enemy.x && e.getX() <= enemy.x + 40 && e.getY() >= enemy.y && e.getY() <= enemy.y + 40) {
    //        if ((x - 5 <= enemy.x + 35 && x + 55 >= enemy.x) && (y - 5 <= enemy.y + 35 && y + 55 >= enemy.y)) {
    //            enemy.enemyHealth -= 10;
    //            System.out.println("Yes");
    //        }
    //    }
    //}
}
