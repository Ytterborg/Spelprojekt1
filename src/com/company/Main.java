
package com.company;


import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Terminal terminal = TerminalFacade.createTerminal(System.in, System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();

        int[][] board = new int[20][20];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                int color = board[i][j];


                terminal.moveCursor(i, j);

                terminal.applyForegroundColor(color, color, color);
                terminal.putCharacter('\u2588');
                terminal.applyBackgroundColor(color, color, color);

            }
        }

        int positionX = 10;
        int positionY = 10;
        terminal.applyForegroundColor(Terminal.Color.GREEN);
        terminal.moveCursor(positionX, positionY);
        terminal.putCharacter('H');

        int monsterPosition1X = 0;
        int monsterPosition1Y = 0;
        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
        terminal.putCharacter('A');

        int monsterPosition2X = 0;
        int monsterPosition2Y = 19;
        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
        terminal.putCharacter('B');

        int monsterPosition3X = 19;
        int monsterPosition3Y = 0;
        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
        terminal.putCharacter('C');

        int monsterPosition4X = 19;
        int monsterPosition4Y = 19;
        terminal.applyForegroundColor(Terminal.Color.RED);
        terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
        terminal.putCharacter('D');

        boolean gameOver = false;
        int score = 0;

        while (!gameOver) { //Vänta på en key press.
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();

            }
            while (key == null);
            switch (key.getKind()) {
                case ArrowDown:
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(positionX, positionY++);
                    terminal.putCharacter('\u2588');
                    if (positionY == 20) {
                        positionY = 19;
                    }
                    terminal.applyForegroundColor(Terminal.Color.GREEN);
                    terminal.moveCursor(positionX, positionY);
                    terminal.putCharacter('H');

                    break;
                case ArrowUp:
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(positionX, positionY--);
                    terminal.putCharacter('\u2588');
                    if (positionY == -1) {
                        positionY = 0;
                    }
                    terminal.applyForegroundColor(Terminal.Color.GREEN);
                    terminal.moveCursor(positionX, positionY);
                    terminal.putCharacter('H');
                    break;
                case ArrowLeft:
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(positionX--, positionY);
                    terminal.putCharacter('\u2588');
                    if (positionX == -1) {
                        positionX = 0;
                    }
                    terminal.applyForegroundColor(Terminal.Color.GREEN);
                    terminal.moveCursor(positionX, positionY);
                    terminal.putCharacter('H');
                    break;
                case ArrowRight:
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(positionX++, positionY);
                    terminal.putCharacter('\u2588');
                    if (positionX == 20) {
                        positionX = 19;
                    }
                    terminal.applyForegroundColor(Terminal.Color.GREEN);
                    terminal.moveCursor(positionX, positionY);
                    terminal.putCharacter('H');
                    break;
                default:
                    System.out.println("Allowed keys are: \n" +
                            "ArrowDown\n" +
                            "ArrowRight\n" +
                            "ArrowLeft\n" +
                            "ArrowUp");
            }

            //monster 1
            if (Math.abs(monsterPosition1X - positionX) >= Math.abs(monsterPosition1Y - positionY)) {
                if ((positionX - monsterPosition1X) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition1X--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('A');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition1X++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('A');
                }
            } else {
                if ((positionY - monsterPosition1Y) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition1Y--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('A');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition1Y++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition1X, monsterPosition1Y);
                    terminal.putCharacter('A');
                }
            }
            //monster 2
            if (Math.abs(monsterPosition2X - positionX) >= Math.abs(monsterPosition2Y - positionY)) {
                if ((positionX - monsterPosition2X) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition2X--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('B');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition2X++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('B');
                }
            } else {
                if ((positionY - monsterPosition2Y) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition2Y--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('B');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition2Y++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition2X, monsterPosition2Y);
                    terminal.putCharacter('B');
                }
            }
            //monster 3
            if (Math.abs(monsterPosition3X - positionX) >= Math.abs(monsterPosition3Y - positionY)) {
                if ((positionX - monsterPosition3X) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition3X--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('C');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition3X++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('C');
                }
            } else {
                if ((positionY - monsterPosition3Y) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition3Y--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('C');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition3Y++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition3X, monsterPosition3Y);
                    terminal.putCharacter('C');
                }
            }
                //monster 4
            if (Math.abs(monsterPosition4X - positionX) >= Math.abs(monsterPosition4Y - positionY)) {
                if ((positionX - monsterPosition4X) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition4X--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('D');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition4X++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('D');
                }
            } else {
                if ((positionY - monsterPosition4Y) <= 0) {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition4Y--;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('D');
                } else {
                    terminal.applyForegroundColor(0, 0, 0);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('\u2588');
                    monsterPosition4Y++;
                    terminal.applyForegroundColor(Terminal.Color.RED);
                    terminal.moveCursor(monsterPosition4X, monsterPosition4Y);
                    terminal.putCharacter('D');
                }
            }
            if (monsterPosition1X == positionX && monsterPosition1Y == positionY ||
                    monsterPosition2X == positionX && monsterPosition2Y == positionY ||
                    monsterPosition3X == positionX && monsterPosition3Y == positionY ||
                    monsterPosition4X == positionX && monsterPosition4Y == positionY) {
                gameOver = true;
            }
            score++;
        }
        int gameOverPositionX = 5;
        int gameOverPositionY = 5;
        terminal.moveCursor(gameOverPositionX, gameOverPositionY);
        terminal.putCharacter('G');
        terminal.putCharacter('A');
        terminal.putCharacter('M');
        terminal.putCharacter('E');
        terminal.putCharacter(' ');
        terminal.putCharacter('O');
        terminal.putCharacter('V');
        terminal.putCharacter('E');
        terminal.putCharacter('R');

        System.out.println(score);
    }
}

