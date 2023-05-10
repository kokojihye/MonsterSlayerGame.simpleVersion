package org.example.game;

public class Weapon {
    String weaponName;  //무기 이름
    int weaponAttackPower; //무기 공격력

    public Weapon(String weaponName, int weaponAttackPower){
        this.weaponName = weaponName;
        this.weaponAttackPower = weaponAttackPower;
    }

    Weapon weapons[] = {
            new Weapon(" 🗡️초보자의 칼", 16),
            new Weapon(" 🏹초보자의 활", 20),
            new Weapon(" 🗡️중급자의 칼", 24),
            new Weapon(" 🏹중급자의 활", 30),
            new Weapon(" 🗡️상급자의 칼", 32),
            new Weapon(" 🏹상급자의 활", 40),
            new Weapon(" 🗡️마스터의 칼", 100),
            new Weapon(" 🏹마스터의 활", 111)
    };

    public String getWeaponName() {
        return weaponName;
    }

    public int getWeaponAttackPower() {
        return weaponAttackPower;
    }

    public Weapon[] getWeapons() {
        return weapons;
    }

    public void setWeaponAttackPower(int weaponAttackPower) {
        this.weaponAttackPower += weaponAttackPower;
    }
}
