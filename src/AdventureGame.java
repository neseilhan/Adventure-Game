import java.util.Scanner;
public class AdventureGame {
    private  Scanner inp = new Scanner(System.in);
    public void start(){
        System.out.println("Macera oyununa hosgeldiniz!");
        System.out.println("Lutfen bir isim giriniz : ");
        String playerName = inp.nextLine();
        Player player = new Player(playerName);
        System.out.println("Sayin " + player.getName() +" Hosgeldiniz! ");
        player.selectChar();
        player.selectLoc();




    }
}
