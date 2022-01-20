import java.lang.Math;

public class Main {

    public static int[][][] cube = new int[9][9][10];
    public static int posX = 0;
    public static int posY = 0;

    public static void main(String args[]) {
        int randNumber = 0;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                randNumber = (int) (Math.random() * 9) + 1;
                posX = x;
                posY = y;
                insertAllBlockedNums();
                if (cube[x][y][randNumber] == 0) {
                    cube[x][y][0] = randNumber;
                } else {
                    for (int i = 1; i < 10; i++) {
                        if (cube[x][y][i] == 0) {
                            i = 10;
                            x -= 1;
                        } else if (i == 9 && cube[x][y][i] != 0) {
                            eraseNum();
                            if (x == 0) {
                                x = 7;
                                y -= 1;
                            } else {
                                x -= 2;
                            }
                        }
                    }
                }
            }
        }

        array2Dprint();
        clearCube();
        array3Dprint();
    }

    public static void insertAllBlockedNums() {
        int numRow = 0;
        int numCol = 0;
        int numSquare = 0;

        int x = posX;
        int y = posY;

        if ((x + 1) % 3 == 0) {
            x -= 2;
        } else if (x == 1 || x == 4 || x == 7) {
            x -= 1;
        }

        if ((y + 1) % 3 == 0) {
            y -= 2;
        } else if (y == 1 || y == 4 || y == 7) {
            y -= 1;
        }

        for (int j = y; j < (y + 3); j++) {
            for (int i = x; i < (x + 3); i++) {
                numSquare = cube[i][j][0];
                if (i == posX && j == posY) {
                    i = 9;
                    j = 9;
                } else {
                    cube[posX][posY][numSquare] = numSquare;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            numRow = cube[i][posY][0];
            numCol = cube[posX][i][0];
            if (numRow == 0 && numCol == 0) {
                i = 8;
            } else {
                cube[posX][posY][numRow] = numRow;
                cube[posX][posY][numCol] = numCol;
            }
        }
    }

    public static void eraseNum() {
        for (int i = 0; i < 10; i++) {
            cube[posX][posY][i] = 0;
        }
    }

    public static void clearCube() {
        for (int z = 1; z < 10; z++) {
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    cube[x][y][z] = 0;
                }
            }
        }
    }

    public static void array2Dprint() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print("  ");
                System.out.print(cube[x][y][0]);
                if ((x + 1) % 3 == 0) {
                    System.out.print(" ");
                }
            }
            System.out.print("\n");
            if ((y + 1) % 3 == 0) {
                System.out.print("\n");
            }
        }
    }

    public static void array3Dprint() {
        for (int z = 0; z < 10; z++) {
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    System.out.print("  ");
                    System.out.print(cube[x][y][z]);
                    if ((x + 1) % 3 == 0) {
                        System.out.print(" ");
                    }
                }
                System.out.print("\n");
                if ((y + 1) % 3 == 0) {
                    System.out.print("\n");
                }
            }
            System.out.print("\n");
        }
    }


}

