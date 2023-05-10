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

    Monster monsters[] = {
            new Monster("파란 달팽이", 20, 100),
            new Monster("빨간 달팽이", 30, 120),
            new Monster("슬라임", 40, 150),
            new Monster("리본 돼지", 50, 170),
            new Monster("주황 버섯", 70, 200),
            new Monster("초록 버섯", 80, 220)
    };


    public String getName() {
        return name;
    }

    public int getMonsterAttackPower() {
        return monsterAttackPower;
    }

    public int getMonsterHP() {
        return monsterHP;
    }

    public Monster[] getMonsters() {
        return monsters;
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
