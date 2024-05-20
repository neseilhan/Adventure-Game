
public class Forest extends BattleLoc {

    public Forest (Player player) {
        super("Orman" , player , new Vampire(), "odun",3);
    }

    @Override
    public boolean allEnemiesDefeated() {
        return false;
    }
}