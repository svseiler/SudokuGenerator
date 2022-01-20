public class General {

    //Setzt auf der Z-Achse alle Nummern die nicht möglich sind
    protected void insertAllBlockedNums(int[][][] cube, int posX, int posY, boolean solver) {
        int numRow, numCol, numField;

        int x = posX;
        int y = posY;

        if (solver) {
            for (int z = 0; z < 10; z++) {
                cube[x][y][z] = 0;
            }
        }

        //Setzt die Ausgangsposition zum Anfang des aktuellen 3x3 Feldes
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

        //Übernimmt alle Zahlen des 3X3 Feldes in die Z-Achse
        for (int j = y; j < (y + 3); j++) {
            for (int i = x; i < (x + 3); i++) {
                numField = cube[i][j][0];
                if (i == posX && j == posY && !solver) {
                    i = 9;
                    j = 9;
                } else {
                    cube[posX][posY][numField] = numField;
                }
            }
        }

        //Übernimmt alle Zahlen der Reihe und Spalte in die Z-Achse
        for (int i = 0; i < 9; i++) {
            numRow = cube[i][posY][0];
            numCol = cube[posX][i][0];
            if (numRow == 0 && numCol == 0 && !solver) {
                i = 8;
            } else {
                cube[posX][posY][numRow] = numRow;
                cube[posX][posY][numCol] = numCol;
            }
        }
    }

    //Gibt die gewünschte Ebene aus
    protected void array2Dprint(int[][][] cube, int level) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print("  ");
                System.out.print(cube[x][y][level]);
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

    //Gibt alle Ebenen des Würfels aus
    protected void array3Dprint(int[][][] cube) {
        for (int z = 0; z < 13; z++) {
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
