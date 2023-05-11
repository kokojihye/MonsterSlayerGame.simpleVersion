package org.example.main;

import java.util.*;
import org.example.game.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.setSoldierInformation();

        //게임 시작
        System.out.println(" 🌳 🌳 🌳 . . 모험을 시작합니다 . . 🌳 🌳 🌳");
        System.out.println(" ");
        game.monsterAppears(0);
        game.engageInBattle(0);

        game.monsterAppears(1);
        game.engageInBattle(1);
    }
}
