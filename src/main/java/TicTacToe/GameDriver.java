package TicTacToe;

import java.security.cert.TrustAnchor;
import java.util.Random;
import java.util.Scanner;

public class GameDriver {

    final static int MAP_SIZE = 3;
    final static int WIN_LENGTH = 3;
    static final String START_SIGN = "\\";
    static Scanner scanner = new Scanner(System.in);
    static final char HUMAN_SIGN = 'X';
    static final char AI_SIGN = 'O';
    static final char EMPTY_SIGN = '*';
    static final String SPACE = " ";
    static final Random RND = new Random();

    static final char[][] MAP = new char[MAP_SIZE][MAP_SIZE];

    public static void main(String[] args) {
        while (true) {
            if (playTheGame()) {

                if (!playAnotherGame()) {
                    break;
                }
            }

        }
        System.out.println("Игра закончена.");
    }

    private static boolean playAnotherGame() {
        System.out.println("Играть заново? (y/n)");
        String answer = scanner.next();
        return switch (answer) {
            case "y", "Y" -> true;
            default -> false;
        };
    }

    private static boolean playTheGame() {
        initialize();
        while (true) {
            if (humanMadeFinalMove() || aiMadeFinalMove()) {
                return true;
            }
        }
    }

    private static boolean humanMadeFinalMove() {
        int row;
        int col;
        while (true) {
            row = inputFromScanner("Введите номер строки (1-" + MAP_SIZE + "):");
            col = inputFromScanner("Введите номер столбца (1-" + MAP_SIZE + "):");
            if (MAP[row][col] != EMPTY_SIGN) {
                System.out.println("Ячейка занята!");
            } else {
                MAP[row][col] = HUMAN_SIGN;
                printMap();
                break;
            }
        }
        return checkForWinOrDraw(row, col, HUMAN_SIGN);
    }

    private static boolean aiMadeFinalMove() {
        int row;
        int col;
        while (true) {
            row = RND.nextInt(1, MAP_SIZE + 1);
            col = RND.nextInt(1, MAP_SIZE + 1);
            if (MAP[row - 1][col - 1] == EMPTY_SIGN) {
                MAP[row - 1][col - 1] = AI_SIGN;
                System.out.println("Ход AI...");
                printMap();
                break;
            }
        }
        return checkForWinOrDraw(row - 1, col - 1, AI_SIGN);
    }

    private static boolean checkForWinOrDraw(int row, int col, char sign) {
        return checkForWin(row, col, sign) || checkForDraw();
    }

    private static boolean checkForWin(int row, int col, char sign) {
        boolean win = checkForWinHorizontal(row, col, sign)
                || checkForWinVertical(row, col, sign)
                || checkForWinDiagonalUp(row, col, sign)
                || checkForWinDiagonalDown(row, col, sign);
        if (win) {
            if (sign == HUMAN_SIGN) {
                System.out.println("Вы выиграли!!!");
            } else {
                System.out.println("AI выиграл!!!");
            }
            return true;
        }
        return false;
    }

    private static boolean checkForWinDiagonalDown(int row, int col, char sign) {
        int startOffset = Math.max(Math.max(-row, -WIN_LENGTH), Math.max(-col, -WIN_LENGTH));
        int finishOffset = Math.min(Math.min(WIN_LENGTH, MAP_SIZE - 1 - row), Math.min(WIN_LENGTH, MAP_SIZE - 1 - col));
        int continuousLenght = 0;
        for (int i = startOffset; i <= finishOffset; i++) {
            if (MAP[row + i][col + i] == sign) {
                continuousLenght++;
                if (continuousLenght == WIN_LENGTH) {
                    return true;
                }
            } else {
                continuousLenght = 0;
            }
        }
        return false;
    }

    private static boolean checkForWinDiagonalUp(int row, int col, char sign) {
        int startOffset = Math.max(Math.max(row - WIN_LENGTH -1, -MAP_SIZE + 1 + row), Math.max(-col, -WIN_LENGTH));
        int finishOffset = Math.min(row, Math.min(WIN_LENGTH, MAP_SIZE - 1 - col));
        int continuousLenght = 0;
        for (int i = startOffset; i <= finishOffset; i++) {
            if (MAP[row - i][col + i] == sign) {
                continuousLenght++;
                if (continuousLenght == WIN_LENGTH) {
                    return true;
                }
            } else {
                continuousLenght = 0;
            }
        }
        return false;
    }

    private static boolean checkForWinVertical(int row, int col, char sign) {
        int minIndex = Math.max(0, row - WIN_LENGTH);
        int maxIndex = Math.min(MAP_SIZE - 1, row + WIN_LENGTH - 1);
        int continuousLenght = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (MAP[i][col] == sign) {
                continuousLenght++;
                if (continuousLenght == WIN_LENGTH) {
                    return true;
                }
            } else {
                continuousLenght = 0;
            }
        }
        return false;
    }

    private static boolean checkForWinHorizontal(int row, int col, char sign) {
        int minIndex = Math.max(0, col - WIN_LENGTH);
        int maxIndex = Math.min(MAP_SIZE - 1, col + WIN_LENGTH - 1);
        int continuousLenght = 0;
        for (int i = minIndex; i <= maxIndex; i++) {
            if (MAP[row][i] == sign) {
                continuousLenght++;
                if (continuousLenght == WIN_LENGTH) {
                    return true;
                }
            } else {
                continuousLenght = 0;
            }
        }
        return false;
    }

    private static boolean checkForDraw() {
        for (int i = 0; i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                if (MAP[i][j] == EMPTY_SIGN) {
                    return false;
                }
            }
        }
        System.out.println("Ничья");
        return true;
    }

    private static int inputFromScanner(String message) {
        int value;
        do {
            System.out.println(message);
            value = scanner.nextInt() - 1;
        } while (value >= MAP_SIZE);
        return value;
    }

    private static void initialize() {
        fillMapByDefault();
        printMap();
    }

    private static void printMap() {
        printMapHead();
        for (int i = 0;i < MAP_SIZE; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < MAP_SIZE; j++) {
                    System.out.print(SPACE + MAP[i][j]);
                }
            System.out.println();
            }
        }

    private static void printMapHead() {
        System.out.print(START_SIGN);
        for (int i = 0;i < MAP_SIZE; i++) {
            System.out.print(SPACE + (i + 1));
        }
        System.out.println();
    }

    private static void fillMapByDefault() {
        for (int i = 0;i < MAP_SIZE; i++) {
            for (int j = 0; j < MAP_SIZE; j++) {
                MAP[i][j] = EMPTY_SIGN;
            }
        }
    }
}
