
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(String name, Player player,Obstacle obstacle,String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol ! Burada " + obsNumber + " tane " + this.getObstacle().getName()  + " yaşıyor! " );
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = inp.nextLine().toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)) {
            System.out.println(this.getName() + " bölgesindeki tüm düşmanları yendiniz!" );
            return true;
        }

        if(this.getPlayer().getHealthy() <= 0) {
            System.out.println(" Öldünüz !");
            return false;
        }
        return true;
    }

    public abstract boolean allEnemiesDefeated();

    public boolean combat(int obsNumber){
        Random rand = new Random();

        for (int i = 1; i <= obsNumber; i++) {
            this.getObstacle().setHealth(this.getObstacle().getOrjinalHealth());
            playerStats();
            obstacleStats(i);

            boolean playerStarts = rand.nextBoolean(); // %50 şans ile oyuncu veya canavar başlar

            while (this.getPlayer().getHealthy() > 0 && this.getObstacle().getHealth() > 0) {
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat = inp.nextLine().toUpperCase();

                if (selectCombat.equals("V")) {
                    if (playerStarts) {
                        // Oyuncu vurur
                        System.out.println("Siz vurdunuz!");
                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();

                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println("Canavar size vurdu!");
                            int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                            if (obstacleDamage < 0) {
                                obstacleDamage = 0;
                            }
                            this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                            afterHit();
                        }
                    } else {
                        // Canavar vurur
                        System.out.println("Canavar size vurdu!");
                        int obstacleDamage = this.getObstacle().getDamage() - this.getPlayer().getInventory().getArmor().getBlock();
                        if (obstacleDamage < 0) {
                            obstacleDamage = 0;
                        }
                        this.getPlayer().setHealthy(this.getPlayer().getHealthy() - obstacleDamage);
                        afterHit();

                        if (this.getPlayer().getHealthy() > 0) {
                            System.out.println("Siz vurdunuz!");
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                    // Bir sonraki turda ilk hamleyi diğer taraf yapar
                    playerStarts = !playerStarts;
                } else {
                    return false; // Kaçmayı seçti
                }
            }

            if (this.getObstacle().getHealth() < this.getPlayer().getHealthy()) {
                System.out.println("Düşmanı yendiniz!");
                System.out.println(this.getObstacle().getAward() + " para kazandınız!");
                this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getAward());
                System.out.println("Güncel Paranız: " + this.getPlayer().getMoney());
            } else {
                return false; // Oyuncu öldü
            }

            // Döngü bittiğinde kullanıcıya savaşa devam etmek isteyip istemediğini sormalıyız
            System.out.print("Savaşa devam etmek istiyor musunuz? (E/H): ");
            String devamEt = inp.nextLine().toUpperCase();
            if (!devamEt.equals("E")) {
                return true; // Kullanıcı savaşa devam etmek istemiyor
            }
        }

        return true; // Tüm canavarlar yenildi
    }

    public void afterHit(){
        System.out.println("Canınız :" + this.getPlayer().getHealthy());
        System.out.println(this.getObstacle().getName() + " Canı: " + this.getObstacle().getHealth());
        System.out.println("===========================");
    }


    public void playerStats() {
        System.out.println("Oyuncu değerleri");
        System.out.println("============================");
        System.out.println("Sağlık :" + this .getPlayer().getHealthy());
        System.out.println("Hasar :" + this .getPlayer().getTotalDamage());
        System.out.println("Para :" + this.getPlayer().getMoney());
        System.out.println("Silah :" + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh :" + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama :" + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println();
    }

    public boolean isPlayerAlive() {
        return this.getPlayer().getHealthy() > 0;
    }

    public void obstacleStats(int i){
        System.out.println(i + ". " + this.getObstacle().getName() + " Değerleri");
        System.out.println("===============================");
        System.out.println("Sağlık :" + this.getObstacle().getHealth());
        System.out.println("Hasar :" + this.getObstacle().getDamage());
        System.out.println("Ödül :" + this.getObstacle().getAward());
        System.out.println();

    }

    public int randomObstacleNumber(){
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
}