package oop.poly.player;

public class Mage extends Player {

    int mana;

    Mage(String name) {
        super(name);
        this.mana = 100;
    }
    
    public void blizzard(Player[] players) {
        System.out.printf("%s님이 눈보라 시전!!\n",this.name);
        this.mana -= 30;
        System.out.printf("30의 마나가 소모됩니다. 남은 마나: %d\n", this.mana);
        System.out.println("-----------------------------------------------");
        blizzardAtk(players);
    }
    
    public void blizzardAtk(Player[] players) {
//        for (int i = 0; i < players.length; i++) {
//            if(players[i] == this) continue;
//            int dmg = (int) (Math.random()*6 +10);;
//            players[i].hp -= dmg;
//            System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n", players[i].name, dmg, players[i].hp);
//        }
        for (Player p : players) {
            if(p == this) continue;
            int dmg = (int) (Math.random()*6 +10);;
            p.hp -= dmg;
            System.out.printf("%s님이 %d의 피해를 입었습니다. (남은 체력: %d)\n", p.name, dmg, p.hp);
        }
    }
    
    @Override
    void characterInfo() {
        super.characterInfo();
        System.out.println("# 마나: " + mana);
    }
}
