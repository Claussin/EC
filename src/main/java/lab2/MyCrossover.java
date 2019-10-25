package lab2;

import org.uncommons.watchmaker.framework.operators.AbstractCrossover;

import java.lang.reflect.Array;
import java.util.*;

public class MyCrossover extends AbstractCrossover<double[]> {
    protected MyCrossover() {
        super(1);
    }

    protected List<double[]> mate(double[] p1, double[] p2, int breakpoint, Random random) {

        ArrayList children = new ArrayList();

        double[] child1 = new double[p1.length];
        double[] child2 = new double[p2.length];


        for (int i = 0; i < p1.length; i++) {
            child1[i] = (i < breakpoint) ? p2[i] : p1[i];
            child2[i] = (i < breakpoint) ? p1[i] : p2[i];
        }

        children.add(child1);
        children.add(child2);
        return children;
    }
}
