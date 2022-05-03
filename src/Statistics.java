import java.util.Arrays;
import java.util.ArrayList;
import java.math.BigInteger;
import java.lang.Math;

public class Statistics {
	
	//Initialized Variables
	int mean, mode, median, var, count, maxCount;
	double stand;
	
	//Creates ArrayLists used for Standard Deviation, Union, Intersection, and Compliment methods
	ArrayList<Integer> StaDev = new ArrayList<Integer>();
	ArrayList<Integer> union = new ArrayList<Integer>();
	ArrayList<Integer> intersection = new ArrayList<Integer>();
	ArrayList<Integer> compPl = new ArrayList<Integer>();
	ArrayList<Integer> compliment = new ArrayList<Integer>();
	
	public Statistics() {
		
	}
	
	
	//Mean (Averaging) Method
	public int getMean(int[] meSet) {
		mean = 0;
		
		//Loops through given array J and adds all numbers into a initialized variable mean
		for(int i=0;i<meSet.length;i++) {
			mean = mean+meSet[i];
		}
		
		//Divides mean by length of array J
		mean = mean/(meSet.length);
		
		return mean;
	}
	
	//Median (Middle) Method
	public int getMedian(int[] mdSet) {
		
		//Sorts the given array J
		Arrays.sort(mdSet);
		
		//Returns Average of the two numbers in the middle of the array if even
		if(mdSet.length%2==0) {
			median = (mdSet[mdSet.length/2-1]+mdSet[mdSet.length/2])/2;
		}
		//Returns middle number of sorted array if odd
		else
			median = mdSet[mdSet.length/2+1];
		
		return median;
	}

	//Mode Method
	public int getMode(int[] moSet) {

		//Looks for the highest counted variable by going through array J with a nested for loop
		for(int i = 0; i < moSet.length; i++) {
			
			//resets maxCount and count every time the inner for loop finishes
			maxCount = 0;
			count = 0;
			
			for(int k = 0; k < moSet.length; k++) {
				if(moSet[i]==moSet[k]) {
					count++;
				}
				
				//Checks for a higher count and sets the current maxCount to it
				if(maxCount < count) {
					maxCount = count;
					mode = moSet[i];
				}
			}
		}

		
		return mode;
	}
	
	//Standard Deviation Method
	public double getStanDev(int[] sDSet) {
		
		//Returns the square root of array j passed through the getVariance Method
		return Math.sqrt(getVariance(sDSet));
	}
	
	//Variance Method
	public int getVariance(int[] vSet) {
		
		var = 0;
		
		//Uses a for loop to add the square of the current value i with the average of array J to the initialized variable var
		for(int i=0;i<vSet.length;i++) {
			var += (vSet[i] - getMean(vSet))*(vSet[i]-getMean(vSet));
		}
		
		//divides var by the length of j-1 
		var /= vSet.length-1;
		
		return var;
	}
	
	//Union Method
	public ArrayList<Integer> getUnion(int[] j, int[] k) {
		
		//Adds all values of j into the union ArrayList if the ArrayList does not already contain the value
		for(int i=0;i<j.length;i++) {
			if(!union.contains(j[i])) {
			union.add(j[i]);
			}
		}

		//Adds all values of k into the union ArrayList if the ArrayList does not already contain the value
		for(int i=0;i<k.length;i++) {
			if(!union.contains(k[i])) {
				union.add(k[i]);
			}
		}
		
		return union;
	}
	
	//Intersection Method
	public ArrayList<Integer> getIntersection(int[] j, int[] k) {
		
		//Uses a for loop to iterate through both arrays and adds them to ArrayList intersection if there is a matching value in both
		for(int i=0;i<j.length;i++) {
			for(int l=0;l<k.length;l++) {
				if(!intersection.contains(k[l]) && j[i] == k[l]) {
					intersection.add(k[l]);
				}
			}
		}
		
		return intersection;
	}

	//Compliment Method
	public ArrayList<Integer> getComplement(int[] j) {
	
		//Creates a base set to compare the given array to
		int[] set = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		
		//Adds all of array J to compPl
		for(int i=0;i<j.length;i++) {
			compPl.add(j[i]);
		}
		
		//Creates an ArrayList by adding numbers in the base set that are not in compPl
		for(int i=0;i<set.length;i++) {
			if(!compPl.contains(set[i])) {
				compliment.add(set[i]);
			}
		}
	
		return compliment;
	}
	
	//Factorial Method
	static BigInteger getFactorial(int j) {
		
		BigInteger big = BigInteger.valueOf(j);
		
		//If the given int is greater than 0, recursion is used to find that num * num -1 until num = 0
		if(j>=1) 
			return big.multiply(getFactorial(j-1));
		else
			return BigInteger.valueOf(1);
	}
	
	//Permutation Method
	public BigInteger getPermutation(int j, int k) {
		
		//Returns the Factorial of int J divided by the factorial of int j-k
		return getFactorial(j).divide(getFactorial(j-k));
	}
	
	public BigInteger getCombination(int j, int k) {
		
		//Returns the Factorial of int J divided by the factorial of int k * factorial of int j-k
		return getFactorial(j).divide((getFactorial(k).multiply(getFactorial(j-k))));
	}
	
	public double getBinomial(double p, int j, int k) {
		
		//k = number of times a specific outcome happens, j = number of times the experiment is carried
		return getCombination(j,k).doubleValue()*Math.pow(p,k)*Math.pow((1-p),(j-k))*100;
	}
	
	public double getGeometric(double p, int j) {
		
		// j = game in which we expect outcome of p to occur
		return (Math.pow((1-p),(j-1))*(p))*100;
	}

	public double getHyperGeo(int k, int x, int bigN, int littlen) {
		
		//littlen = subset of sample group , BigN = total sample group size
		//k = total amount chosen out of the group, x = amount chosen that are within the subset
		return ((getCombination(k,x).multiply(getCombination((bigN-k),(littlen-x)))).doubleValue()/(getCombination(bigN,littlen)).doubleValue())*100;
	}

	public double getPoisson(int j, int k) {
	
		return (((Math.pow(j,k))/(getFactorial(k)).doubleValue())*Math.exp(-j))*100;
	}

	public double getCheb(double j, double k, double i, double n) {
		
		//j = average, k = standard dev, i = upper bound, n = lower bound

		return (1-(1/Math.pow(((i-j)/k),2)))*100;
	}
	
	public double getUniform(int j, int k, int x) {
		if(j <= x && x <= k) {
			return (1/(double)(k-j));
		}
		else {
			return 0;
		}
			
	}


}