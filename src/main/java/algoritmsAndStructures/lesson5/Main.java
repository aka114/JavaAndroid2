package algoritmsAndStructures.lesson5;

public class Main {

    public static void main(String[] args) {
        System.out.println(exponentiation(2,2));

        ChessKnight ck = new ChessKnight();
        ck.start(2, 2);
    }

    private static int exponentiation(int base, int exp) {
        if (exp > 1) {
            return base * exponentiation(base, --exp);
        } else {
            return base;
        }
    }

    private static class ChessKnight {

        private static final int[][] chessBoard = new int[5][5];
        private static int x;
        private static int y;


        private void start(int x, int y) {
            this.x = x;
            this.y = y;
            chessBoard[x][y] = 1;
            boolean result = fillChessBoard();
            System.out.println(this);
            System.out.println(result);
        }

        private boolean fillChessBoard() {
            int preX = x;
            int preY = y;
            for (int i = 0; i < 8; i++) {
                if (setCoordForStep(i)) {
                    if (fillChessBoard() || chessBoard[x][y] == chessBoard[0].length * chessBoard.length) {
                        return true;
                    }
                    chessBoard[x][y] = 0;
                    x = preX;
                    y = preY;
                }
            }
            return false;
        }

        private boolean setCoordForStep(int i) {
            int tempx = x;
            int tempy = y;
            if (i == 0) {
                    tempx++;
                    tempy -= 2;
            } else if (i == 1) {
                    tempx += 2;
                    tempy--;
            } else if (i == 2) {
                    tempx += 2;
                    tempy++;
            } else if (i == 3) {
                    tempx++;
                    tempy += 2;
            } else if (i == 4) {
                    tempx--;
                    tempy += 2;
            } else if (i == 5) {
                    tempx -= 2;
                    tempy++;
            } else if (i == 6) {
                    tempx -= 2;
                    tempy--;
            } else if (i == 7) {
                    tempx--;
                    tempy -= 2;
            }
            if (tempx > chessBoard.length - 1 || tempx < 0 || tempy >chessBoard[0].length - 1 || tempy < 0 || chessBoard[tempx][tempy] != 0) {
                return false;
            }
            chessBoard[tempx][tempy] = chessBoard[x][y] + 1;
            x = tempx;
            y = tempy;
            return true;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int[] a:chessBoard
                 ) {
                for (int j : a) {
                    sb.append(j).append("\t");
                }
                sb.append("\n");
            }
            return sb.toString();
        }
    }

}
