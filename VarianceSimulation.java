package jw4647;

import java.util.ArrayList;
import java.util.Random;

public class VarianceSimulation {

	public static ArrayList<Double> getRandGaussianNums (int k){
		ArrayList<Double> randUs = new ArrayList<>();
		Random rand = new Random();
		double x;
		double z;
		double u;
		for (int i = 0; i < k; i++) {
			x = rand.nextGaussian();
			z = rand.nextGaussian();
			u = (x)/(1+Math.pow(z, 2.0));
			randUs.add(u);
			
		}
		return randUs;
		
	}
	
	public static double computeMean (ArrayList<Double> Nums) {
		double sum = 0;
		int counter = 0;
		for (int i = 0; i<Nums.size();i++) {
			sum += Nums.get(i);
			counter++;
		}
		
		return (sum/counter);
	}
	
	public static double computeVariance(ArrayList<Double> Nums) {
		double mean = computeMean(Nums);
		double squaredDifference = 0.0;
		double sumOfSquaredDifference = 0.0;
		
		for (int i = 0; i<Nums.size();i++) {
			squaredDifference = Math.pow(Nums.get(i)-mean, 2);
			sumOfSquaredDifference += squaredDifference;
		}
		
		return (sumOfSquaredDifference/(Nums.size()-1));//unbiased sample variance
		
	}
	
	public static void main(String[] args) {
		
		double meanEstimator = 0.0;
		double varianceEstimator = 0.0;
		double simulatedSampleMean;
		double simulatedSampleVariance;
		ArrayList<Double> randomGaussianNums = new ArrayList<>();
		
		for (int i = 0; i< 100;i++) {
			randomGaussianNums = getRandGaussianNums(1000000);
			simulatedSampleMean = computeMean(randomGaussianNums);
			simulatedSampleVariance = computeVariance(randomGaussianNums);
			System.out.println("Random Sample #" + (i+1) + " Simulated Sample Mean: " + simulatedSampleMean);
			System.out.println("Random Sample #" + (i+1) + " Simulated Sample Variance: " + simulatedSampleVariance + "\n");
			meanEstimator += simulatedSampleMean;
			varianceEstimator += simulatedSampleVariance;
		}
		
		meanEstimator = (meanEstimator/100);
		varianceEstimator = (varianceEstimator/100);
		
		System.out.println("The estimated mean is: " + meanEstimator);
		System.out.println("The estimated variance is: " + varianceEstimator + "\n");
		

	}

}
