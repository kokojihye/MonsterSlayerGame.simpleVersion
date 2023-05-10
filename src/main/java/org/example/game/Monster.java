package org.example.game;

public class Monster {
    String monsterName;
    int monsterAttackPower;
    int monsterHP;
    int monsterCurrentHP;

    public Monster(String monsterName, int monsterAttackPower, int hp) {
        this.monsterName = monsterName;
        this.monsterAttackPower = monsterAttackPower;
        this.monsterHP = hp;
        this.monsterCurrentHP = hp;
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
        return monsterCurrentHP;
    }

    public void setMonsterAttackPower(int monsterAttackPower) {
        this.monsterAttackPower = monsterAttackPower;
    }

    public void setMonsterCurrentHP(int damage) {
        this.monsterCurrentHP -= damage;
    }

    public void monsterAppearNotice(Monster[] monsters, int i) {
        System.out.println("야생의 " + monsters[i].getMonsterName() + "이(가) 나타났다.");
    }

    public void monsterCurrentHP() {
        if (this.monsterHP <= 0){
            System.out.println(getMonsterName() + "이(가) 사망했습니다. ☠️");
        } else{
            System.out.println(System.out.println("HP[ " + getMonsterCurrentHP() + " / " + getMonsterHP()+ " ]");
        }
    }
}
