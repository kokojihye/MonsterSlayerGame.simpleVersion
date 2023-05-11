package org.example.game;

import java.util.Scanner;

public class Soldier {
    private String soldierName;
    private int soldierHP = 200; //용사의 초기 체력은 200으로 설정
    private int soldierCurrentHP;
    private String currentWeaponName;
    private int currentWeaponNum;
    private String currentPetName;
    private int currentPetNum;

    //Setter
    public void setSoldierName(String soldierName) {
        this.soldierName = soldierName;
    }

    public void setSoldierHP(int soldierHP) {
        this.soldierHP += soldierHP;
    }

    public void fillSoldierCurrentHP(int hp){
        this.soldierCurrentHP = hp;
    }

    public void setSoldierCurrentHP(int damage) {
        this.soldierCurrentHP -= damage;
    }

    public void setCurrentWeaponName(String currentWeaponName) {
        this.currentWeaponName = currentWeaponName;
    }

    public void setCurrentPetName(String currentPetName) {
        this.currentPetName = currentPetName;
    }

    public void setCurrentWeaponNum(int currentWeaponNum) {
        this.currentWeaponNum = currentWeaponNum;
    }

    public void setCurrentPetNum(int currentPetNum) {
        this.currentPetNum = currentPetNum;
    }

    //Getter
    public String getSoldierName() {
        return soldierName;
    }

    public int getSoldierHP() {
        return soldierHP;
    }

    public int getSoldierCurrentHP() {
        return soldierCurrentHP;
    }

    public String getCurrentWeaponName() {
        return currentWeaponName;
    }

    public String getCurrentPetName() {
        return currentPetName;
    }

    public int getCurrentWeaponNum() {
        return currentWeaponNum;
    }

    public int getCurrentPetNum() {
        return currentPetNum;
    }

    public void soldierCurrentHP() {
        if (this.soldierCurrentHP <= 0){
            System.out.println(this.soldierName + "의 hp가 0이 되어 사망했습니다. ☠️");
            //System.out.println("메인 화면으로 돌아갑니다");
        } else{
            System.out.println("❤️" + this.soldierName + "의 HP[ " + this.soldierCurrentHP + " / " + this.soldierHP + " ]");
        }
    }


}
