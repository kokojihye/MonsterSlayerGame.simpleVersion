package org.example.game;

public class Pet {
    String petName;
    int petAttackPower;

    public Pet(String petName, int petAttackPower){
        this.petName = petName;
        this.petAttackPower = petAttackPower;
    }

    Pet[] pets = {
            new Pet("햄스터", 5),
            new Pet("강아지", 5),
            new Pet("토끼", 6),
            new Pet("고양이", 7)
    };

    public String getPetName() {
        return petName;
    }

    public int getPetAttackPower() {
        return petAttackPower;
    }

    public Pet[] getPets() {
        return pets;
    }

    public void setPetAttackPower(int petAttackPower) {
        this.petAttackPower += petAttackPower;
    }
}
