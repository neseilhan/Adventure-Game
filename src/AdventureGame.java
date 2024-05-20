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
        Location location = null;
        while (true) {
//            player.printInfo();
            System.out.println();
            System.out.println("----- Bölgeler -----");
            System.out.println();
            System.out.println("1- Güvenli Ev => Burası sizin için güvenli bir ev, düşman yok!");
            System.out.println("2- Eşya Dükkanı => Silah veya zırh satın alabilirsin!");
            System.out.println("3- Mağara => Mağaraya git, dikkatli ol 'zombi' çıkabilir ! / Ödül <Yemek>");
            System.out.println("4- Orman => Ormana git, dikkatli ol 'vampir' çıkabilir ! / Ödül <Odun>");
            System.out.println("5- Nehir => Nehire git, dikkatli ol 'ayı' çıkabilir ! / Ödül <Su>");
            System.out.println("6- Maden => Madene git, dikkatli ol 'yılan' çıkabilir ! / Ödül <Para, Silah veya Zırh>");

            System.out.println("0 - Çıkış Yap --> Oyunu sonlandır");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            int selectLoc = inp.nextInt();

            switch (selectLoc) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
//                case 3:
//                    location = new Cave(player);
//                    break;
//                case 4:
//                    location = new Forest(player);
//                    break;
//                case 5:
//                    location = new River(player);
//                    break;
//                case 6:
//                    location = new Mine(player);
//                    break;

                default:
                    System.out.println("Lütfen geçerli bir bölge giriniz !");
            }

            if (location == null) {
                System.out.println("Bu karanlık adadan çabuk vazgeçtin!");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Canınız kalmadı! GAME OVER:(");
                break;
            }
        }




    }
}
