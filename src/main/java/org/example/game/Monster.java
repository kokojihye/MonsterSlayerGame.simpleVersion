package org.example.game;

public class Monster {
    String name;
    int attackPower;
    int monsterHP;

    public Monster(String name, int attackPower, int hp) {
        this.name = name;
        this.attackPower = attackPower;
        this.monsterHP = hp;
    }
    public void monsterAppearNotice() {
        System.out.println("야생의 " + this.name + "이(가) 나타났다.");
    }
    public void monsterAttackMessage() {
        System.out.println("몬스터에게 " + this.attackPower + "만큼 데미지를 받았습니다. 🩸");
    }
    public void monsterCurrentHP() {
        if (this.monsterHP <= 0){
            System.out.println(this.name + "이(가) 사망했습니다. ☠️");
        } else{
            System.out.println(this.name + "의 남은 체력: " + this.monsterHP);
        }
    }
}
