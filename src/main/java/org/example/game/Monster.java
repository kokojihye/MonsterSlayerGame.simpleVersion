package org.example.game;

public class Monster {
    String monsterName;
    int monsterAttackPower;
    int monsterHP;
    int monsterCurrentHP;
    int giveExperienceValueToWeapon;
    int giveExperienceValueToPet;

    public Monster(String monsterName, int monsterAttackPower, int hp, int giveExperienceValueToWeapon, int giveExperienceValueToPet) {
        this.monsterName = monsterName;
        this.monsterAttackPower = monsterAttackPower;
        this.monsterHP = hp;
        this.monsterCurrentHP = hp;
        this.giveExperienceValueToWeapon = giveExperienceValueToWeapon;
        this.giveExperienceValueToPet = giveExperienceValueToPet;
    }

    //Getter
    public String getMonsterName() {
        return monsterName;
    }

    public int getMonsterAttackPower() {
        return monsterAttackPower;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public int getMonsterCurrentHP() {
        if(this.monsterCurrentHP <= 0){
            return 0;
        } else {
            return monsterCurrentHP;
        }
    }

    public int getGiveExperienceValueToWeapon() {
        return giveExperienceValueToWeapon;
    }

    public int getGiveExperienceValueToPet() {
        return giveExperienceValueToPet;
    }


    //Setter
    public void setMonsterCurrentHP(int damage) {
        this.monsterCurrentHP -= damage;
    }

    //Method
    public void monsterAppearNotice(Monster[] monsters, int i) {
        System.out.println(" ");
        System.out.println(">> 야생의 " + monsters[i].getMonsterName() + "이(가) 나타났다.");
    }

    public void monsterCurrentHP() {
        if (this.monsterHP <= 0){
            System.out.println(getMonsterName() + "이(가) 사망했습니다. ☠️");
        } else{
            System.out.println(this.monsterName + "의 HP[ " + getMonsterCurrentHP() + " / " + getMonsterHP()+ " ]");
        }
    }
}
