package org.example.game;

public class Pet {
    int petNum;
    String petName;
    int petAttackPower;

    public Pet(int petNum, String petName, int petAttackPower){
        this.petNum = petNum;
        this.petName = petName;
        this.petAttackPower = petAttackPower;
    }
    public String getPetName() {
        return petName;
    }

    public int getPetAttackPower() {
        return petAttackPower;
    }

    public void setPetAttackPower(int petAttackPower) {
        this.petAttackPower += petAttackPower;
    }
}
