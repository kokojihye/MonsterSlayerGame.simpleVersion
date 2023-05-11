package org.example.game;

public class Weapon {
    int weaponNum;
    String weaponName;  //무기 이름
    int weaponAttackPower; //무기 공격력

    public Weapon(int weaponNum, String weaponName, int weaponAttackPower){
        this.weaponNum = weaponNum;
        this.weaponName = weaponName;
        this.weaponAttackPower = weaponAttackPower;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public int getWeaponAttackPower() {
        return weaponAttackPower;
    }

    public int getWeaponNum() {
        return weaponNum;
    }

    public void setWeaponAttackPower(int weaponAttackPower) {
        this.weaponAttackPower += weaponAttackPower;
    }
}
