package ga.crossover;

import ga.Cell;
import ga.GA;

public class TwoPointCrossover implements Crossover {

    public Cell[] execute(Cell c1, Cell c2) {

        int length = c1.getGenes().length;

        float[] genesOffspring1 = new float[length];
        float[] genesOffspring2 = new float[length];

        int splitPoint1 = GA.getRandomNumber(1, length - 2);
        int splitPoint2 = GA.getRandomNumber(splitPoint1, length - 1);

        for (int i = 0; i < length; i++) {

            if (i < splitPoint1) {
                genesOffspring1[i] = c1.getGenes()[i];
                genesOffspring2[i] = c2.getGenes()[i];
            } else if (i < splitPoint2) {
                genesOffspring2[i] = c1.getGenes()[i];
                genesOffspring1[i] = c2.getGenes()[i];
            } else {
                genesOffspring1[i] = c1.getGenes()[i];
                genesOffspring2[i] = c2.getGenes()[i];
            }
        }

        Cell[] offspring = {new Cell(genesOffspring1), new Cell(genesOffspring2)};

        return offspring;
    }
}
