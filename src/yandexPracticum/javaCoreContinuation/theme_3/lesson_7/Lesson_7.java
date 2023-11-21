package yandexPracticum.javaCoreContinuation.theme_3.lesson_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static helpers.Helpers.printSection;
import static helpers.Helpers.printSectionEnding;

public class Lesson_7 {
    public static void lesson_7() {
        printSection("Lesson_7. ");

        List<Potato> potatoes = List.of(
                new Potato(1, 30, 30, 30),
                new Potato(2, 35, 31, 35),
                new Potato(3, 40, 35, 44),
                new Potato(4, 28, 44, 41),
                new Potato(5, 33, 23, 30),
                new Potato(6, 35, 33, 33),
                new Potato(7, 38, 41, 24)
        );

        List<Potato> fourUnderExperiment = findPotatoesForExperiment(potatoes);

        System.out.println("Картофелины для эксперимента: " + fourUnderExperiment);

        printSectionEnding();
    }

    private static List<Potato> findPotatoesForExperiment(List<Potato> potatoes) {
				/* Вычислите две самые большие и две самые маленькие картофелины,
           а затем выведите их в порядке от самых маленьких до самых больших.*/
        potatoes = new ArrayList<>(potatoes);
        Collections.sort(potatoes);

        return new ArrayList<>(List.of(
                potatoes.get(0),
                potatoes.get(1),
                potatoes.get(potatoes.size() - 2),
                potatoes.get(potatoes.size() - 1)
        ));
    }


}

class Potato implements Comparable<Potato> {

    public final int id;

    /**
     * Масса
     */
    public final int weight;

    /**
     * Длина
     */
    public final int length;

    /**
     * Ширина
     */
    public final int girth;

    public Potato(int id, int weight, int length, int girth) {
        this.id = id;
        this.weight = weight;
        this.length = length;
        this.girth = girth;
    }

    @Override
    public int compareTo(Potato o) {
        return this.calculateAlpha() - o.calculateAlpha();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Potato potato = (Potato) o;
        return id == potato.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Potato{" +
                "id=" + id +
                ", weight=" + weight +
                ", length=" + length +
                ", girth=" + girth +
                ", alpha=" + calculateAlpha() +
                '}' + '\n';
    }

    public int calculateAlpha() {
        return (int) (this.weight*0.5 + this.length*0.65 + this.girth*0.8);
    }

}
