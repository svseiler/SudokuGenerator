public class Generator {

    //Generiert ein fertiges Sudoku Feld
    protected int[][][] generateFullSudokuField(int[][][] cube) {
        General general = new General();
        int randNumber;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                randNumber = (int) (Math.random() * 9) + 1;
                general.insertAllBlockedNums(cube, x, y, false);
                if (cube[x][y][randNumber] == 0) {
                    cube[x][y][0] = randNumber;
                } else {
                    for (int i = 1; i < 10; i++) {
                        if (cube[x][y][i] == 0) {
                            i = 10;
                            x -= 1;
                        } else if (i == 9 && cube[x][y][i] != 0) {
                            eraseNum(cube, x, y);
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

        clearCube(cube);

        return cube;
    }

    //Generiert aus dem fertigen Sudoku Feld ein lösbares Feld
    protected void generateFinalSuduokuField(int[][][] cube) {
        Solver solver = new Solver();

        int counter = 0;
        int posX = 0;
        int posY = 0;
        int oldNum = 0;

        while (counter < 81) {
                if(counter < 75) {
                    while (cube[posX][posY][12] == 1) {
                        posX = (int) (Math.random() * 9);
                        posY = (int) (Math.random() * 9);
                    }
                } else {
                    for (int y = 0; y < 9; y++) {
                        for (int x = 0; x < 9; x++) {
                            if (cube[x][y][12] == 0) {
                                posX = x;
                                posY = y;
                            }
                        }
                    }
                }
                oldNum = cube[posX][posY][0];

                cube[posX][posY][0] = 0;
                cube[posX][posY][10] = 0;

                if (!solver.sudokuSolver(cube)) {
                    cube[posX][posY][10] = oldNum;
                }
                cube[posX][posY][12] = 1;

            counter = 0;
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    if (cube[x][y][12] == 1) {
                        counter++;
                    }
                }
            }
        }
    }

    //Löscht alle nummern eines Feldes auf der Z-Achse
    private void eraseNum(int[][][] cube, int posX, int posY) {
        for (int i = 0; i < 10; i++) {
            cube[posX][posY][i] = 0;
        }
    }

    //Überschreibt alles im Würfel und verschiebt die erste Ebene in die zweit Letzte
    private void clearCube(int[][][] cube) {
        for (int z = 0; z < 10; z++) {
            for (int y = 0; y < 9; y++) {
                for (int x = 0; x < 9; x++) {
                    cube[x][y][10] = cube[x][y][0];
                    cube[x][y][11] = cube[x][y][0];
                    if (z != 0) {
                        cube[x][y][z] = 0;
                    }
                }
            }
        }
    }


}
