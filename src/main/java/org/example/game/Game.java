package org.example.game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {
    Scanner sc = new Scanner(System.in);

    //몬스터 객체 생성
    Monster[] monsters = {
            new Monster("🐌파란 달팽이", 20, 100, 5, 1),
            new Monster("🐌빨간 달팽이", 30, 150, 6, 1),
            new Monster("🐌초록 슬라임", 50, 200, 8, 2),
            new Monster("🐷리본 돼지", 70, 250, 10, 3),
            new Monster("🍄주황 버섯", 100, 400, 12, 4),
            new Monster("🍄초록 버섯", 120, 600, 13, 5),
            new Monster("🧟‍보스몹", 300, 1000, 100, 20)
    };

    public Monster[] getMonsters() {
        return monsters;
    }

    //무기 객체 생성
    Weapon[] weapons = {
            new Weapon(1, "🗡️초보자의 칼", 16),
            new Weapon(2, "🏹초보자의 활", 20),
            new Weapon(3, "🗡️중급자의 칼", 24),
            new Weapon(4, "🏹중급자의 활", 30),
            new Weapon(5, "🗡️상급자의 칼", 32),
            new Weapon(6, "🏹상급자의 활", 40),
            new Weapon(7, "🗡️마스터의 칼", 100),
            new Weapon(8, "🏹마스터의 활", 111)
    };

    //펫 객체 생성
    Pet[] pets = {
            //후보생: 🐯(+10) 🐭(-1)
            new Pet(1, "🐹햄스터", 3),
            new Pet(3, "🐰토끼", 4),
            new Pet(2, "🐶강아지", 5),
            new Pet(4, "🐱고양이", 7)
    };

    //용사 객체 생성
    Soldier soldier = new Soldier();

    //용사 정보 입력 받기
    public void setSoldierInformation() {
        //용사 이름 입력
        System.out.println("[ :: 이름 입력 :: ] ");
        System.out.print(">> 용사의 이름을 입력하세요 🦹🏻: ");
        soldier.setSoldierName(sc.nextLine());
        System.out.println(" ");

        //용사 무기 선택
        int weaponOptionNum;
        System.out.println("[ :: 무기 선택 옵션 :: ]");
        for (int i = 0; i < 2; i++) { //초보자의 무기만 선택 가능하도록 2번만 반복하도록 조건 걸어둠
            System.out.println(">> " + weapons[i].getWeaponName() + "을(를) 선택하려면 숫자" + (i + 1) + "를 입력하세요.");
        }
        System.out.print("용사가 사용할 무기를 선택하세요️: ");
        weaponOptionNum = sc.nextInt();
        for (Weapon weapon : weapons) {
            if (weaponOptionNum == weapon.weaponNum) {
                soldier.setCurrentWeaponName(weapon.getWeaponName()); //용사가 사용하는 무기명 용사 객체에 저장
                soldier.setCurrentWeaponNum(weapon.getWeaponNum() - 1); //용사가 사용하는 무기 인덱스 번호 용사 객체에 저장
                System.out.println("당신이 사용할 무기는 >>" + weapon.getWeaponName() + "<< 입니다.");
            }
        }
        System.out.println(" ");

        //용사 펫 선택
        int petOptionNum;
        System.out.println("[ :: 펫 선택 :: ] ");
        for (int i = 0; i < pets.length; i++) {
            System.out.println(">> " + pets[i].getPetName() + "을 선택하려면 숫자" + (i + 1) + "를 입력하세요.");
        }
        System.out.print("용사와 함께할 펫을 선택하세요: ");
        petOptionNum = sc.nextInt();
        for (Pet pet : pets) {
            if (petOptionNum == pet.getPetNum()) {
                soldier.setCurrentPetName(pet.getPetName());
                soldier.setCurrentPetNum(pet.getPetNum() - 1); //솔저 객체 펫 번호는 인덱스 번호
                System.out.println("당신과 함께할 펫은 >>" + pet.getPetName() + "<< 입니다.");
            }
        }
        System.out.println(" ");
    }


    public void soldierAttackMessage(int weaponNum, int petNum) {
        System.out.println("몬스터에게 "
                + (weapons[weaponNum].getWeaponAttackPower() + pets[petNum].getPetAttackPower())
                + "만큼 데미지를 주었습니다. 🩸");
    }


    public void monsterAttackMessage(int i) {
        System.out.println(monsters[i].getMonsterName()
                + "에게 " + monsters[i].getMonsterAttackPower() + "만큼 데미지를 받았습니다. 🩸");
    }

    public void monsterAppears(int i) {
        monsters[i].monsterAppearNotice(monsters, i);
        //engageInBattle(i);
    }

    public void engageInBattle(int i) throws InterruptedException {
        System.out.println("배틀을 시작합니다.");
        int countAttack = 1;
        soldier.fillSoldierCurrentHP(soldier.getSoldierHP());

        while (true) {
            System.out.println(" ");
            System.out.println(countAttack + "번째 전투입니다.");
            countAttack++;

            System.out.println("⚔️ . . . 몬스터와 " + soldier.getSoldierName() + "이(가) 전투중입니다 . . . ⚔️");
            TimeUnit.SECONDS.sleep(3);

            //몬스터 체력 차감: 무기
            monsters[i].setMonsterCurrentHP(weapons[soldier.getCurrentWeaponNum()].getWeaponAttackPower());
            //몬스터 체력 차감: 펫
            monsters[i].setMonsterCurrentHP(pets[soldier.getCurrentPetNum()].getPetAttackPower());
            //용사 선공: 몬스터에게 입힌 데미지 출력
            soldierAttackMessage(soldier.getCurrentWeaponNum(), soldier.getCurrentPetNum());
            //몬스터 hp 출력
            monsters[i].monsterCurrentHP();

            if (monsters[i].getMonsterCurrentHP() <= 0) { //몬스터의 피가 0 이하가 된 경우
                System.out.println("축하합니다!🎉" + monsters[i].getMonsterName() + "을(를) 해치웠습니다.");
                TimeUnit.SECONDS.sleep(2);

                System.out.println("축하합니다!🎉" + soldier.getSoldierName() + "의 hp가 +50만큼 증가했습니다.");
                soldier.setSoldierHP(50); //기존 체력 + 50
                soldier.setSoldierCurrentHP(soldier.getSoldierHP()); //변경된 hp값만큼 풀피로 채워줌
                TimeUnit.SECONDS.sleep(2);

                System.out.println("축하합니다!🎉" + soldier.getSoldierName() + "의 공격력이 +" + monsters[i].getGiveExperienceValueToWeapon() + "만큼 증가했습니다.");
                weapons[soldier.getCurrentWeaponNum() - 1].setWeaponAttackPower(monsters[i].getGiveExperienceValueToWeapon()); //기존 무기 공격력 + n
                TimeUnit.SECONDS.sleep(2);

                System.out.println("축하합니다!🎉펫 " + this.soldier.getCurrentPetName() + "의 공격력이 +" + monsters[i].getGiveExperienceValueToPet() + "만큼 증가했습니다.");
                pets[soldier.getCurrentPetNum()].setPetAttackPower(monsters[i].getGiveExperienceValueToPet()); //기존 펫 공격력 + n;

                //잡은 몬스터가 보스몹인 경우
                if (monsters[i].getMonsterName().equals("🧟‍보스몹")) {
                    System.out.println("축하합니다!🎉" + monsters[i].getMonsterName() + "을(를) 해치웠습니다.👏🏻");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" >> " + weapons[2].getWeaponName() + "을(를) 획득했습니다.👏🏻");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" >> " + weapons[3].getWeaponName() + "을(를) 획득했습니다.👏🏻");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" >> 🦹🏻용맹한 용사 칭호을(를) 획득했습니다.👏🏻");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" >> " + pets[soldier.getCurrentPetNum()].getPetName() + "도 집으로 무사히 돌아갔습니다.👏🏻");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(" >> 마을에 평화가 찾아왔습니다.👏🏻");
                    System.out.println("============== HAPPY ENDING ==============");
                    System.exit(0);
                }
                break;
            }

            //몬스터 후공
            monsterAttackMessage(i);
            //용사 체력 차감: 몬스터 공격력
            soldier.setSoldierCurrentHP(monsters[i].getMonsterAttackPower());
            //용사 hp 출력
            soldier.soldierCurrentHP();

            if (soldier.getSoldierCurrentHP() <= 0) { //용사의 피가 0 이하가 된 경우
                System.out.println(monsters[i].getMonsterName() + "에게 목숨을 잃었습니다.");

                System.out.println(" >> " + soldier.getCurrentWeaponName() + "을(를) 잃어버렸습니다.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> 🦹🏻사망한 용사 칭호을(를) 획득했습니다.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> " + pets[soldier.getCurrentPetNum()].getPetName() + "은(는) 옆 마을로 도망갔습니다.");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> 몬스터들이 마을 사람들을 모두 잡아먹었습니다. 🧟");
                System.out.println("============== BAD ENDING ==============");
                System.exit(0);
            }

        }
        System.out.println(" ");
        System.out.println("  . . 모험을 계속 진행합니다 . . ");
        TimeUnit.SECONDS.sleep(3);
        System.out.println(" ");
    }
}