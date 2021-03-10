import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

public class MyPanel extends JPanel implements MouseListener {

    public Character character;
    public double x0;
    public double y0;
    public double xN;
    public double yN;
    private long previousWorldUpdateTime;
    private double frameWidth;
    private double frameHeight;
    public World world;

    public MyPanel(double x, double y) throws IOException {
        this.frameWidth = x;
        this.frameHeight = y;
        this.x0 = 0;
        this.y0 = 0;
        this.xN = x;
        this.yN = y;
        this.character = new Character(frameWidth/2 - 50, frameHeight/2 - 50);
        this.world = new World(character);
        this.previousWorldUpdateTime = System.currentTimeMillis();
        this.addMouseListener(this);
        world.createTestWorld();
        world.createEnemies();
        System.out.println(x0 + ", " + y0 + " : " + xN + ", " + yN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        world.drawWalls(g);
        character.draw(g);
        world.drawEnemies(g);

    }

    public void updateWorldPhysics() {
        long currentTime = System.currentTimeMillis();
        long dt = currentTime - previousWorldUpdateTime;

        world.checkEnemyWalls();

        character.update(dt);
        world.updateEnemies(dt);
        character.changeLocation(x0, y0, xN, yN, world);
        //walls0.update(dt);

        previousWorldUpdateTime = currentTime;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        world.updateCharacterDamage(e);
        //character.open(e, walls0);
        //character.damage(enemy1, e);
        //character.damage(enemy2, e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
