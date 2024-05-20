public class River extends BattleLoc{
    public River(Player player) {
        super("Nehir" , player , new Bear(), "su",2);
    }

    @Override
    public boolean allEnemiesDefeated() {
        return false;
    }
}