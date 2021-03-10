import java.awt.*;
import java.awt.event.MouseEvent;

public class Enemy {

    public double x;
    public double y;
    public double width;
    public double height;
    private double enemySpeedX;
    private double enemySpeedY;
    public Character character;
    private int enemyGoX;
    private int enemyGoY;
    public double xH;
    public double yH;
    public int startEnemy;
    public double enemyHealth;
    public boolean canHit;
    public boolean drawHealth;
    public boolean drawEnemy;
    public boolean go;
    private long previousWorldUpdateTime;

    public Enemy(double x, double y, Character character) {
        this.x = x;
        this.y = y;
        this.width = 40;
        this.height = 40;
        this.xH = x + 5;
        this.yH = y - 10;
        this.enemySpeedX = 0.1;
        this.enemySpeedY = 0.1;
        this.character = character;
        this.enemyGoX = 0;
        this.enemyGoY = 0;
        this.startEnemy = 0;
        this.enemyHealth = 100;
        this.canHit = true;
        this.drawHealth = false;
        this.drawEnemy = true;
        previousWorldUpdateTime = System.currentTimeMillis();

    }

    public void draw(Graphics g) {
        if (drawEnemy) {
            g.setColor(Color.MAGENTA);
            g.fillRect((int) x, (int) y, (int) width, (int) height);
            if (drawHealth) {
                g.drawString(String.valueOf(enemyHealth), (int) xH, (int) yH);
            }
        }

    }


    public void update(long dt) {

        if (drawEnemy) {
            if (enemyHealth <= 0) {
                //x = 1500;
                //y = 500;
                //xH = x + 10;
                //yH = y - 10;
                drawHealth = false;
                drawEnemy = false;
                canHit = false;
                //enemyHealth = 100;
            }

            if (x >= character.x - 40 && x + width <= character.x + 90 && y >= character.y - 40 && y + height <= character.y + 90) {
                enemyGoX = 0;
                enemyGoY = 0;
                go = false;
            } else {
                go = true;
            }


            if (go) {
                if (character.x + 55 > x + 35) {
                    enemyGoX = 1;
                } else if (character.x - 20 < x) {
                    enemyGoX = -1;
                } else if (character.x + 55 <= x + 35 && character.x - 20 >= x) {
                    enemyGoX = 0;
                }
            }


            if (go) {
                if (character.y + 55 > y + 35) {
                    enemyGoY = 1;
                } else if (character.y - 20 < y) {
                    enemyGoY = -1;
                } else if (character.y + 55 <= y + 35 && character.y - 20 >= y) {
                    enemyGoY = 0;
                }
            }


            if (character.x > x - 200 && character.x < x + 240 && character.y > y - 200 && character.y < y + 240) {
                x += enemyGoX * enemySpeedX * dt;
                y += enemyGoY * enemySpeedY * dt;
                xH += enemyGoX * enemySpeedX * dt;
                yH += enemyGoY * enemySpeedY * dt;
                drawHealth = true;

            }
        }
    }

    public void changeLocation(int x) {
        if (x == 1) {
            this.y = this.y + 1000;
            this.yH = this.yH + 1000;
        } else if (x == 2) {
            this.x = this.x - 1000;
            this.xH = this.xH - 1000;
        } else if (x == 3) {
            this.y = this.y - 1000;
            this.yH = this.yH - 1000;
        } else if (x == 4) {
            this.x = this.x + 1000;
            this.xH = this.xH + 1000;
        }
    }

    public void updateDamage() {
        if (canHit) {
            long currentTime = System.currentTimeMillis();
            if ((character.x - 5 <= x + 35 && character.x + 55 >= x) && (character.y - 5 <= y + 35 && character.y + 55 >= y)) {

                if ((currentTime - previousWorldUpdateTime) >= 1200) {
                    previousWorldUpdateTime = currentTime;
                    character.characterHealth -= 10;
                    System.out.println("HIT");
                }
            }
        }
    }

    public void characterDamage(MouseEvent e) {
        if (canHit) {
            if (e.getX() >= this.x && e.getX() <= this.x + 40 && e.getY() >= this.y && e.getY() <= this.y + 40) {
                if ((character.x - 5 <= this.x + 35 && character.x + 55 >= this.x) && (character.y - 5 <= this.y + 35 && character.y + 55 >= this.y)) {
                    this.enemyHealth -= 10;
                    System.out.println("Yes");
                }
            }
        }
    }
}
