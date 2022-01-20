import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        General general = new General();
        Generator generator = new Generator();
        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viele Sudokus möchten Sie generieren?");
        int anzahlSudkous = sc.nextInt() + 1;

        //Generiert die gewünschte Sudoku Anzahl
        for (int i = 1; i < anzahlSudkous; i++) {
            int[][][] cube = new int[9][9][13];
            cube = generator.generateFullSudokuField(cube);
            generator.generateFinalSuduokuField(cube);
            System.out.println("Sudoku Feld(" + i + "):");
            general.array2Dprint(cube, 10);
            System.out.println("Lösung:");
            general.array2Dprint(cube, 11);
        }
    }
}

