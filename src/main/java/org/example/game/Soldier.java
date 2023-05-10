package org.example.game;

import java.util.Scanner;

public class Soldier {
    private String name;
    private String weaponName;
    private int weaponPower;
    private String petName;
    private int petPower;
    private int hp = 200;
    int currentHP = hp;


    public void setName(String name) {
        this.name = name;
        System.out.println(" ");
        System.out.println(">> 입력하신 이름은 "+ this.name + "입니다.");
    }

    public void setWeapon(int weapon) {
        final String weapon1Name = "🗡️ 초보자의 무기 1 ";
        final int weapon1power = 17;
        final String weapon2Name = "🏹 초보자의 무기2";
        final int weapon2power = 30;

        switch (weapon){
            case 1:
                this.weaponName = weapon1Name;
                this.weaponPower = weapon1power;
                break;
            case 2:
                this.weaponName = weapon2Name;
                this.weaponPower = weapon2power;
                break;
            default:
                System.out.println("1 또는 2를 입력해주세요.");
                break;
        }
        System.out.println(" ");
        System.out.println(">> 선택한 무기는 " + this.weaponName + "입니다. ");
    }

    public void setPet(int pet) {
        final String pet1Name = "🐱 고양이";
        final int pet1Power = 5;
        final String pet2Name = "🐶 강아지";
        final int pet2Power = 3;

        switch (pet){
            case 1:
                this.petName = pet1Name;
                this.petPower = pet1Power;
                break;
            case 2:
                this.petName = pet2Name;
                this.petPower = pet2Power;
                break;
            case 3:
                this.petName = "(선택안함)";
                this.petPower = 0;
                break;
            default:
                System.out.println("1, 2, 3 중 하나를 입력해주세요.");
                break;
        }
        System.out.println(" ");
        System.out.println(">> 선택하신 펫은 " + this.petName + "입니다.");

    }

    public void setHp(int hp) {
        this.hp += hp;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public String getPetName() {
        return petName;
    }

    public void setWeaponPower(int weaponPower) {
        this.weaponPower += weaponPower;
    }

    public void setPetPower(int petPower) {
        this.petPower += petPower;
    }

    public void soldierStatus() {
        System.out.println(this.name + "의 hp는 " + this.hp + "입니다.");
        System.out.println(this.name + "의 현재 공격력은 " + (this.weaponPower + this.petPower) + "입니다.");
    }
    public void soldierAttackMessage() {
        System.out.println("몬스터에게 " + (petPower + weaponPower) + "데미지를 입혔습니다. 🩸");
    }
    public void soldierCurrentHP() {
        if (this.currentHP <= 0){
            System.out.println(this.name + "의 hp가 0이 되어 사망했습니다. ☠️");
            //System.out.println("메인 화면으로 돌아갑니다");
        } else{
            System.out.println(this.name + "의 남은 체력: " + this.currentHP);
        }
    }

    public int getWeaponPower() {
        return weaponPower;
    }

    public int getPetPower() {
        return petPower;
    }
}
