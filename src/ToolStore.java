public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Magaza");
    }
    @Override
   public boolean onLocation() {
        System.out.println("Magazaya hosgeldiniz.");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3- Çıkış Yap");
            System.out.print("Seçiminiz: ");
            int selectCase = Location.inp.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.print(" Geçersiz değer, tekrar giriniz: ");
                selectCase = Location.inp.nextInt();
            }
            switch (selectCase) {
//                case 1:
//                    printWeapon();
//                    buyWeapon();
//                    break;
//                case 2:
//                    printArmor();
//                    buyArmor();
//                    break;
                case 3:
                    System.out.println("----- Tekrar Görüşmek Üzere!! -----");
                    showMenu = false;
                    break;
            }
        }
        return true;


    }

}
