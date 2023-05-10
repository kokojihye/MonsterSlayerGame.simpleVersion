package org.example.game;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.example.game.Monster;

public class Game {
    Scanner sc = new Scanner(System.in);

    //몬스터 객체 생성과 동시에 값 지정(몬스터는 유저에게 입력받지 않기 때문)
    Monster monster1 = new Monster("초보 몬스터 🧟‍", 20, 100);
    Monster monster2 = new Monster("중급 몬스터 🧟", 30, 300);
    Monster bossMonster = new Monster("보스 몬스터 🧟", 50, 700);

    //용사 객체 생성
    Soldier soldier = new Soldier();

    //용사 정보 입력 받기
    public void setSoldierInformation(){

        //용사 이름 입력
        System.out.println("[ 이름 입력 ] ");
        System.out.print("용사의 이름을 입력하세요 🦹🏻: ");
        soldier.setName(sc.nextLine());
        System.out.println(" ");

        //용사 무기 선택
        System.out.println("[ 무기 선택 옵션 ]");
        System.out.println("옵션1. 초보자의 무기 1을 선택하려면 숫자 1을 눌러주세요.");
        System.out.println("옵션2. 초보자의 무기 2를 선택하려면 숫자 2를 눌러주세요.");
        System.out.print("용사가 사용할 무기를 선택하세요 ⚔️: ");
        soldier.setWeapon(sc.nextInt());
        System.out.println(" ");

        //용사 펫 선택
        System.out.println("[ 펫 선택 ] ");
        System.out.println("옵션 1. 고양이와 함께하려면 숫자 1을 눌러주세요. 🐱");
        System.out.println("옵션 2. 강아지와 함께하려면 숫자 2를 눌러주세요. 🐶");
        System.out.println("옵션 3. 홀로 몬스터와 싸우려면 숫자 3을 눌러주세요. 😿");
        System.out.print("용사와 함께할 펫을 선택하세요: ");
        soldier.setPet(sc.nextInt());
        System.out.println(" ");
    }

    public void monster1Appears() throws InterruptedException {
        monster1.monsterAppearNotice();
        //boolean isSoldierWin = false;
        int countAttack = 1;

        while (true) {
            //몬스터1 VS 용사
            System.out.println(" ");
            System.out.println(countAttack + "번째 전투입니다.");
            countAttack++;

            System.out.println("⚔️ . . . 몬스터와 " + soldier.getName() + "이(가) 전투중입니다 . . . ⚔️");
            TimeUnit.SECONDS.sleep(3);

            this.soldier.soldierAttackMessage(); //용사 선공
            this.monster1.monsterHP -= this.soldier.getWeaponPower(); //몬스터 체력 = 몬스터 체력 - 용사 공격력
            this.monster1.monsterHP -= this.soldier.getPetPower(); //몬스터 체력 = 몬스터 체력 - 펫 공격력
            this.monster1.monsterCurrentHP();
            System.out.println(" ");

            this.monster1.monsterAttackMessage(); //몬스터 후공
            this.soldier.currentHP -= this.monster1.attackPower; //용사 체력 = 용사체력 - 몬스터 공격력
            this.soldier.soldierCurrentHP();


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

    public void monster2Appears() throws InterruptedException {
        monster2.monsterAppearNotice();
        int countAttack = 1;
        while (true) {
            System.out.println(" ");
            System.out.println(countAttack + "번째 전투입니다.");
            countAttack++;
            //몬스터2 VS 용사

            System.out.println("⚔️ . . . 몬스터와 " + soldier.getName() + "이(가) 전투중입니다 . . . ⚔️");
            TimeUnit.SECONDS.sleep(3);

            this.soldier.soldierAttackMessage(); //용사 선공
            this.monster2.monsterHP -= this.soldier.getWeaponPower(); //몬스터 체력 = 몬스터 체력 - 용사 공격력
            this.monster2.monsterHP -= this.soldier.getPetPower(); //몬스터 체력 = 몬스터 체력 - 펫 공격력
            this.monster2.monsterCurrentHP();
            System.out.println(" ");

            this.monster2.monsterAttackMessage(); //몬스터 후공
            this.soldier.currentHP -= this.monster2.attackPower; //용사 체력 = 용사체력 - 몬스터 공격력
            this.soldier.soldierCurrentHP();

            if (this.soldier.currentHP <= 0) {
                System.out.println(" ");
                System.out.println(this.monster2.name + "에게 목숨을 잃었습니다.");
                System.out.println("============== GAME OVER ==============");
                return;
                //System.exit(0);
            } else if (this.monster2.monsterHP <= 0) {
                System.out.println(" ");
                System.out.println("축하합니다!🎉" + this.monster2.name + "을(를) 해치웠습니다.");
                TimeUnit.SECONDS.sleep(1);

                System.out.println("축하합니다!🎉" + soldier.getName() + "의 hp가 +150만큼 증가했습니다.");
                this.soldier.setHp(150);

                System.out.println("축하합니다!🎉" + soldier.getName() + "의 공격력이 +20만큼 증가했습니다.");
                this.soldier.setWeaponPower(20);

                System.out.println("축하합니다!🎉 펫" + this.soldier.getPetName() + "의 공격력이 +10만큼 증가했습니다.");
                this.soldier.setPetPower(10);


                this.soldier.currentHP = this.soldier.getHp();
                System.out.println(" ");
                System.out.println("🌳 🌳 🌳 . . 모험을 계속 진행합니다 . . 🌳 🌳 🌳");
                break;
            }
        }
    }

    public void bossMonsterAppears() throws InterruptedException {
        bossMonster.monsterAppearNotice();
        int countAttack = 1;
        while (true) {
            System.out.println(" ");
            System.out.println(countAttack + "번째 전투입니다.");
            countAttack++;
            //보스몹 VS 용사

            System.out.println("⚔️ . . . 몬스터와 " + soldier.getName() + "이(가) 전투중입니다 . . . ⚔️");
            TimeUnit.SECONDS.sleep(3);

            this.soldier.soldierAttackMessage(); //용사 선공
            this.bossMonster.monsterHP -= this.soldier.getWeaponPower(); //몬스터 체력 = 몬스터 체력 - 용사 공격력
            this.bossMonster.monsterHP -= this.soldier.getPetPower(); //몬스터 체력 = 몬스터 체력 - 펫 공격력
            this.bossMonster.monsterCurrentHP();
            System.out.println(" ");

            this.bossMonster.monsterAttackMessage(); //몬스터 후공
            this.soldier.currentHP -= this.bossMonster.attackPower; //용사 체력 = 용사체력 - 몬스터 공격력
            this.soldier.soldierCurrentHP();

            if (this.soldier.currentHP <= 0) {
                System.out.println(" ");
                System.out.println(this.bossMonster.name + "에게 목숨을 잃었습니다.");
                System.out.println("============== GAME OVER ==============");
                //System.exit(0);
                return;
            } else if (this.bossMonster.monsterHP <= 0) {
                System.out.println(" ");
                System.out.println("축하합니다!🎉" + this.bossMonster.name + "을(를) 해치웠습니다.👏🏻");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> 중급자의 무기을(를) 획득했습니다.👏🏻");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> 용맹한 용사 칭호을(를) 획득했습니다.👏🏻");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> " + this.soldier.getPetName() + "도 집으로 무사히 돌아갔습니다.👏🏻");
                TimeUnit.SECONDS.sleep(2);
                System.out.println(" >> 마을에 평화가 찾아왔습니다.👏🏻");
                System.out.println("============== HAPPY ENDING ==============");
                System.exit(0);
            }
        }
    }
}


