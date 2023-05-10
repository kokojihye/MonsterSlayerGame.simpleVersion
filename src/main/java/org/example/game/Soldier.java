package org.example.game;

import java.util.Scanner;

public class Soldier {
    private String soldierName;
    private int soldierHP = 200;
    private int soldierCurrentHP;

    public void setSoldierName(String soldierName) {
        this.soldierName = soldierName;
    }

    public void setSoldierHP(int soldierHP) {
        this.soldierHP = soldierHP;
    }

    public void setSoldierCurrentHP(int soldierCurrentHP) {
        this.soldierCurrentHP = soldierCurrentHP;
    }

    public void showCurrentHP() {
        System.out.println("HP( " + this.soldierCurrentHP + " / " + this.soldierHP + " )");
    }

//    public void soldierCurrentHP() {
//        if (this.currentHP <= 0){
//            System.out.println(this.name + "의 hp가 0이 되어 사망했습니다. ☠️");
//            //System.out.println("메인 화면으로 돌아갑니다");
//        } else{
//            System.out.println(this.name + "의 남은 체력: " + this.currentHP);
//        }
//    }
}
