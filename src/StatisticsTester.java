public class StatisticsTester {
	public static void main(String[] args) {
		
		int[] Arr = {1, 2, 20, 4, 6, 20};
		int[] Arr1 = {1, 3, 4, 5, 5};
		int[] Arr2 = {2, 3, 6, 5};
		int n = 10;
		int r = 4;
		int o = 12;
		int l = 5;
		int a = 8;
		int d = 2;
		double p = .125;
		
		Statistics stats = new Statistics();
		
		//Prints outputs of all methods in the Statistics Class
/*		System.out.println("The mean of array 1: " + stats.getMean(Arr));
		System.out.println("The median of array 1: " + stats.getMedian(Arr));
		System.out.println("The mode of array 1: " + stats.getMode(Arr));
		System.out.println("The standard deviation of array 1: " + stats.getStanDev(Arr));
		System.out.println("The variance of array 1: " + stats.getVariance(Arr));
		System.out.println("The union set of arrays 2 and 3: " + stats.getUnion(Arr1, Arr2));
		System.out.println("The intersection set of arrays 2 and 3: " + stats.getIntersection(Arr1, Arr2));
		System.out.println("The compliment of array 2 out of set 1-9: " + stats.getComplement(Arr1));
		System.out.println("The permutations possible of single 4 digit pin number: " + stats.getPermutation(n, r));
		System.out.println("The combinations possible of choosing teams of 4 out of 10 people: " + stats.getCombination(n, r));
*/
		System.out.println("Using binomial distribution, probability of getting an 4 5 times out of 12 rolls using a 8 sided die: " + stats.getBinomial(p, o, l) + "%");
		System.out.println("Using geometric distribution, probability of getting a '6' on the 5th roll of a 8 sided die: " + stats.getGeometric(p, l) + "%");
		System.out.println("Using hyper geometric distribution, with 5 red balls and 7 blue balls, probability of 4 being red balls out of 10 chosen : " + stats.getHyperGeo(l,o,n,r));
		System.out.println("Using poisson distribution, probability of exactly 10 customers coming in with the average customers being 12 : " + stats.getPoisson(o, n));
		System.out.println("Using chebychevs theorem, probability of exactly 10 customers coming in with the average customers being 12 : " + stats.getCheb(a, d, o, r));
		
		
	}
}
