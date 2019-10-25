package lab2;

import org.jcp.xml.dsig.internal.dom.DOMUtils;
import org.uncommons.watchmaker.framework.EvolutionaryOperator;

import java.util.List;
import java.util.Random;

public class MyMutation implements EvolutionaryOperator<double[]> {

    double counter = 0;
    double sigma = 1.0;

    public List<double[]> apply(List<double[]> population, Random random) {
        // initial population
        // need to change individuals, but not their number!

        counter++;
        double must_probability = 0.8;
        double must_strength = (population.size()); //number of value to change
        sigma = calcSigma(counter, sigma);
        System.out.print("count == " + counter + "\n");
        System.out.print("sigma == " + sigma + "\n");
        for (double[] individuals: population) {
            if (random.nextDouble() < must_probability) {
                for (int i = 0; i < individuals.length; i++) {
                    if (random.nextDouble() < must_strength)
                        individuals[i] = random.nextGaussian() * sigma;
                }
            }

        }
        // your implementation:

        //result population
        return population;
    }

    private double calcSigma(double counter, double sigma) {
        double result = sigma - 0.1;
        if (result > 0)
            return result;
        return 1;
    }
}
