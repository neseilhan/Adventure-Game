public class ToolStore extends NormalLoc {
    public ToolStore(Player player) {
        super(player, "Magaza");
    }
    @Override
   public boolean onLocation() { //oyundaki esyalarin listelendigi alan
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
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("----- Tekrar Görüşmek Üzere!! -----");
                    showMenu = false;
                    break;
            }
        }
        return true;


    }
    public void printWeapon() { //silahlari yazdirma
        System.out.println();
        System.out.println("----- Silahlar -----");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + " - " + w.getName() +
                    " < Para : " + w.getPrice() +
                    " , Hasar : " + w.getDamage() + " >");

        }
        System.out.println("0 - Çıkış yap! ");
    }

    public void buyWeapon() {

        System.out.print("Bir silah seçiniz: ");
        int selectWeaponID = inp.nextInt();
        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.print(" Geçersiz değer, tekrar giriniz: ");
            selectWeaponID = Location.inp.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);

            if (selectedWeapon != null) { //para kontrolü
                if (selectedWeapon.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paranız bulunmamaktadır !");
                } else {
                    //Satın alma eylemi
                    System.out.println(selectedWeapon.getName() + "silahını satın aldınız !");
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız: " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);

                }


            }
        }
    }
    public void printArmor() {
        System.out.println();
        System.out.println("----- Zırhlar -----");
        for (Armor a : Armor.armors()) {
            System.out.println(a.getId() + " - " + a.getName() +
                    " < Para: " + a.getPrice() +
                    ", Zırh:" + a.getBlock() + " >");
        }
        System.out.println("0 - Çıkış Yap");

    }

    public void buyArmor() {
        System.out.print("Bir zırh seçiniz: ");
        int selectArmorID = inp.nextInt();
        while (selectArmorID < 1 || selectArmorID > Armor.armors().length) {
            System.out.print(" Geçersiz değer, tekrar giriniz: ");
            selectArmorID = Location.inp.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorObjByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {
                    System.out.println("Yeterli paraniz bulunmamaktadır !");

                } else {
                    System.out.println(selectedArmor.getName() + " zırhını satın aldınız !");
                    this.getPlayer().setMoney(this.getPlayer().getMoney() - selectedArmor.getPrice());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Kalan paraniz: " + this.getPlayer().getMoney());

                }
            }

        }
    }

}


