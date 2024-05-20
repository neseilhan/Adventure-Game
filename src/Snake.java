import java.util.Random;

public class Snake  extends Obstacle{
    private static final int MIN_DAMAGE = 3;
    private static final int MAX_DAMAGE = 6;

    public Snake() {
        super(4, "Yilan", getRandomDamage(), 12, 0);
    }

    private static int getRandomDamage() {
        Random rand = new Random();
        return rand.nextInt(MAX_DAMAGE - MIN_DAMAGE + 1) + MIN_DAMAGE;
    }
}