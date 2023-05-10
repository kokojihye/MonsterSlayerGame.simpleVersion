package org.example.game;

public class Monster {
    String name;
    int monsterAttackPower;
    int monsterHP;

    public Monster(String name, int monsterAttackPower, int hp) {
        this.name = name;
        this.monsterAttackPower = monsterAttackPower;
        this.monsterHP = hp;
    }


    public String getName() {
        return name;
    }

    public int getMonsterAttackPower() {
        return monsterAttackPower;
    }

    public int getMonsterHP() {
        return monsterHP;
    }


    public void setMonsterAttackPower(int monsterAttackPower) {
        this.monsterAttackPower = monsterAttackPower;
    }

    public void monsterAppearNotice(Monster[] monsters) {
        System.out.println("야생의 " + monsters[0].getName() + "이(가) 나타났다.");
    }
//    public void monsterAttackMessage() {
//        System.out.println("몬스터에게 " + this.attackPower + "만큼 데미지를 받았습니다. 🩸");
//    }
//    public void monsterCurrentHP() {
//        if (this.monsterHP <= 0){
//            System.out.println(this.name + "이(가) 사망했습니다. ☠️");
//        } else{
//            System.out.println(this.name + "의 남은 체력: " + this.monsterHP);
//        }
//    }
}
