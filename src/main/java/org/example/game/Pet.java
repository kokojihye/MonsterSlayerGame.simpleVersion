package org.example.game;

public class Pet {
    private int petNum;
    private String petName;
    private int petAttackPower;

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

    public int getPetNum() {
        return petNum;
    }

    public void setPetAttackPower(int petAttackPower) {
        this.petAttackPower += petAttackPower;
    }
}
