package org.example.game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.example.game.*;

public class Game {
    Scanner sc = new Scanner(System.in);

    //몬스터 객체 생성
    Monster monsters[] = {
            new Monster("파란 달팽이", 20, 100),
            new Monster("빨간 달팽이", 30, 120),
            new Monster("슬라임", 40, 150),
            new Monster("리본 돼지", 50, 170),
            new Monster("주황 버섯", 70, 200),
            new Monster("초록 버섯", 80, 220)
    };
    //무기 객체 생성
    Weapon weapons[] = {
            new Weapon(1, " 🗡️초보자의 칼", 16),
            new Weapon(2, " 🏹초보자의 활", 20),
            new Weapon(3, " 🗡️중급자의 칼", 24),
            new Weapon(4, " 🏹중급자의 활", 30),
            new Weapon(5, " 🗡️상급자의 칼", 32),
            new Weapon(6, " 🏹상급자의 활", 40),
            new Weapon(7, " 🗡️마스터의 칼", 100),
            new Weapon(8, " 🏹마스터의 활", 111)
    };

    //펫 객체 생성
    Pet[] pets = {
            //후보생: 🐯(+10) 🐭(-2)
            new Pet(1, "🐹햄스터", 3),
            new Pet(3, "🐰토끼", 4),
            new Pet(2, "🐶강아지", 5),
            new Pet(4, "🐱고양이", 7)
    };

    //용사 객체 생성
    Soldier soldier = new Soldier();

    //용사 정보 입력 받기
    public void setSoldierInformation(){
        //용사 이름 입력
        System.out.println("[ 이름 입력 ] ");
        System.out.print("용사의 이름을 입력하세요 🦹🏻: ");
        soldier.setSoldierName(sc.nextLine());
        System.out.println(" ");

        //용사 무기 선택
        int weaponOptionNum;
        System.out.println("[ 무기 선택 옵션 ]");
        for (int i = 0; i < 2; i++) { //초보자의 무기만 선택 가능하도록 i < 2 조건 걸어둠
            System.out.println("옵션 " + (i + 1) + ". " + weapons[i] + "을 선택하려면 숫자" + (i + 1) + "를 입력하세요.");
        }
        System.out.print("용사가 사용할 무기를 선택하세요 ⚔️: ");
        weaponOptionNum = sc.nextInt();
        for (int i = 0; i < weapons.length; i++) {
            if (weaponOptionNum == weapons[i].weaponNum){
                soldier.setCurrentWeapon(weapons[i-1].getWeaponName());
                System.out.println("당신이 사용할 무기는 " + weapons[i].getWeaponName()+ "입니다.");
            }
        }
        System.out.println(" ");

        //용사 펫 선택
        int petOptionNum;
        System.out.println("[ 펫 선택 ] ");
        for (int i = 0; i < pets.length; i++) {
            System.out.println("옵션" + (i + 1) +  pets[i].petName + "을 선택하려면 숫자" + (i + 1) + "를 입력하세요.");
        }
        System.out.print("용사와 함께할 펫을 선택하세요: ");
        petOptionNum = sc.nextInt();
        for (int i = 0; i < pets.length; i++) {
            if (weaponOptionNum == pets[i].petNum){
                soldier.setCurrentWeapon(pets[i].getPetName());
                System.out.println("당신과 함께할 펫은 " + pets[i].getPetName()+ "입니다.");
            }
        }
        System.out.println(" ");
    }
    public void soldierAttackMessage(int weaponNum) {
        System.out.println("몬스터에게 " + weapons[weaponNum - 1].getWeaponAttackPower()+ "만큼 데미지를 주었습니다. 🩸");
    }
    public void monsterAttackMessage(Monster[] monster, int i) {
        System.out.println(monster[i].getMonsterName() + "에게 " + monster[i].getMonsterAttackPower()+ "만큼 데미지를 받았습니다. 🩸");
    }

    public void monsterAppears(Monster[] monster, int i) throws InterruptedException {
        monster[i].monsterAppearNotice(monster, i);
        int countAttack = 1;

        while(true){
            System.out.println(" ");
            System.out.println(countAttack + "번째 전투입니다.");
            countAttack++;

            System.out.println("⚔️ . . . 몬스터와 " + soldier.getSoldierName() + "이(가) 전투중입니다 . . . ⚔️");
            TimeUnit.SECONDS.sleep(3);

            //용사 선공
            soldierAttackMessage(soldier.getCurrentWeaponNum());
            //몬스터 체력 차감: 무기
            //monster[i].setMonsterCurrentHP(weapons[weaponNum - 1]);
            //몬스터 체력 차감: 펫
            //monster[i].setMonsterCurrentHP();
            //몬스터 체력 출력
            monster[i].monsterCurrentHP();

            //몬스터 후공
            monsterAttackMessage(monster, i);
            //용사 체력 차감: 몬스터 공격력
            //soldier.setSoldierCurrentHP();
            //용사 체력 출력
            soldier.soldierCurrentHP();

        }
    }

    public void monster1Appears() throws InterruptedException {
        monster1.monsterAppearNotice();
        //boolean isSoldierWin = false;
        int countAttack = 1;

        while (true) {
            //몬스터1 VS 용사
            if (this.soldier.currentHP <= 0) {
                System.out.println(" ");
                System.out.println(this.monster1.name + "에게 목숨을 잃었습니다.");
                System.out.println("============== GAME OVER ==============");
                //System.exit(0);
                return;
            } else if (this.monster1.monsterHP <= 0) {
                System.out.println(" ");
                System.out.println("축하합니다!🎉" + this.monster1.name + "을(를) 해치웠습니다.");

                System.out.println("축하합니다!🎉" + soldier.getName() + "의 hp가 +50만큼 증가했습니다.");
                this.soldier.setHp(50); //기존 체력 + 50

                System.out.println("축하합니다!🎉" + soldier.getName() + "의 공격력이 +50만큼 증가했습니다.");
                this.soldier.setWeaponPower(50); //기존 공격력 + 50

                System.out.println("축하합니다!🎉 펫" + this.soldier.getPetName() + "의 공격력이 +5만큼 증가했습니다.");
                this.soldier.setPetPower(5);

                this.soldier.currentHP = this.soldier.getHp(); //hp 채우기

                TimeUnit.SECONDS.sleep(3);
                System.out.println("🌳 🌳 🌳 . . 모험을 계속 진행합니다 . . 🌳 🌳 🌳");
                System.out.println(" ");
                break;
            }
        }
    }


//    public void bossMonsterAppears() throws InterruptedException {
//        bossMonster.monsterAppearNotice();
//        int countAttack = 1;
//        while (true) {
//            System.out.println(" ");
//            System.out.println(countAttack + "번째 전투입니다.");
//            countAttack++;
//            //보스몹 VS 용사
//
//            System.out.println("⚔️ . . . 몬스터와 " + soldier.getName() + "이(가) 전투중입니다 . . . ⚔️");
//            TimeUnit.SECONDS.sleep(3);
//
//            this.soldier.soldierAttackMessage(); //용사 선공
//            this.bossMonster.monsterHP -= this.soldier.getWeaponPower(); //몬스터 체력 = 몬스터 체력 - 용사 공격력
//            this.bossMonster.monsterHP -= this.soldier.getPetPower(); //몬스터 체력 = 몬스터 체력 - 펫 공격력
//            this.bossMonster.monsterCurrentHP();
//            System.out.println(" ");
//
//            this.bossMonster.monsterAttackMessage(); //몬스터 후공
//            this.soldier.currentHP -= this.bossMonster.attackPower; //용사 체력 = 용사체력 - 몬스터 공격력
//            this.soldier.soldierCurrentHP();
//
//            if (this.soldier.currentHP <= 0) {
//                System.out.println(" ");
//                System.out.println(this.bossMonster.name + "에게 목숨을 잃었습니다.");
//                System.out.println("============== GAME OVER ==============");
//                //System.exit(0);
//                return;
//            } else if (this.bossMonster.monsterHP <= 0) {
//                System.out.println(" ");
//                System.out.println("축하합니다!🎉" + this.bossMonster.name + "을(를) 해치웠습니다.👏🏻");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(" >> 중급자의 무기을(를) 획득했습니다.👏🏻");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(" >> 용맹한 용사 칭호을(를) 획득했습니다.👏🏻");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(" >> " + this.soldier.getPetName() + "도 집으로 무사히 돌아갔습니다.👏🏻");
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(" >> 마을에 평화가 찾아왔습니다.👏🏻");
//                System.out.println("============== HAPPY ENDING ==============");
//                System.exit(0);
//            }
//        }
//    }
}


