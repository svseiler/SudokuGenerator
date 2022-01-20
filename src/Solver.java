public class Solver {

    //Prüft ob das aktuelle Suduko lösbar ist
    protected boolean sudokuSolver(int[][][] cube) {
        General general = new General();
        int foundZeros = 0;
        int foundZeros2 = 0;
        boolean solved = false;
        boolean solving = true;
        copyLevel10(cube);

        while(solving) {
            foundZeros = 0;
            for (int x = 0; x < 9; x++) {
                for (int y = 0; y < 9; y++) {
                    if (cube[x][y][0] == 0) {
                        general.insertAllBlockedNums(cube, x, y, true);
                        setFinalNum(cube, x, y);
                        foundZeros++;
                    }
                }
            }
            if(foundZeros == 0){
                solving = false;
                solved = true;
            } else if (foundZeros == foundZeros2){
                solving = false;
            }
            foundZeros2 = foundZeros;
        }
        return solved;
    }

    //Kopiert das aktuelle Sudoku Feld in die oberste Ebene
    private void copyLevel10 (int[][][] cube){
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                cube[x][y][0] = cube[x][y][10];
            }
        }
    }

    //Setzt die Nummer im Feld ein wen sie erlaubt ist
    private void setFinalNum(int[][][] cube, int posX, int posY) {
        int possibleNums = 0;
        int lastNum = 0;

        for (int z = 1; z < 10; z++) {
            if (cube[posX][posY][z] == 0) {
                possibleNums++;
                lastNum = z;
            }
        }
        if (possibleNums == 1) {
            cube[posX][posY][0] = lastNum;
        }
    }


}
