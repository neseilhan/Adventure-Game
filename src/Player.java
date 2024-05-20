import java.lang.invoke.VarHandle;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner inp = new Scanner(System.in);

    public Player(String name){
        this.name = name;
    }
    public void selectChar(){
       GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        System.out.println( "--------------------------------------");
        for(GameChar gamechar : charList){
            System.out.println("ID : "+gamechar.getId()+
                    " Karakter : " +gamechar.getName() +
                    "\t Hasar : " +gamechar.getDamage()+
                    "\t Saglik :"+gamechar.getHealth() +
                    "\t Para : " + gamechar.getMoney());
        }
        System.out.println("Lutfen bir karakter seciniz : ");
        int selectChar = inp.nextInt();
        switch(selectChar){
            case 1 :
                initPlayer(new Samurai());
                break;
            case 2 :
                initPlayer(new Archer());
                break;
            case 3 :
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter : "+ this.getCharName()+
                ", Hasar :"+this.getDamage()+
                ", Saglik : " +this.getHealth()+
                ", Para : " +this.getMoney());

    }
    public void selectLoc(){
        Location location = null;
        System.out.println("Bolgeler");
        System.out.println("1- Guvenli Ev");
        System.out.println("2- Magaza");
        System.out.println("Lutfen gitmek istedginiz bolgeyi seciniz : ");
        int selectLoc = inp.nextInt();
        switch(selectLoc){
            case 1 :
                location = new SafeHouse(this);
                break;
            case 2 :
                location = new ToolStore(this);
                break;
            default:
                location = new SafeHouse(this);
        }
        location.onLocation();
    }
    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
