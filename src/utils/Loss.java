package utils;

public interface Loss{
	public static final Loss squared = (x, t) -> {
		double[] result = new double[1];
		for(int i = 0; i < t.length; i++){
			result[0] += Math.pow(t[i] - x[i], 2.0);
		}
		return result;
	};
	
	public static final Loss crossEntropy = (x, t) -> {
		return new double[]{-Math.log(x[UtilMethods.argMax(t)])};
	};
	
	public static final Loss squaredP = (x, t) -> {
		double[] result = new double[t.length];
		for(int i = 0; i < t.length; i++){
			result[i] = x[i] - t[i];
		}
		return result;
	};
	
	public static final Loss crossEntropyP = (x, t) -> {
		double[] result = new double[t.length];
		for(int i = 0; i < t.length; i++){
			result[i] = x[i] - t[i];
		}
		return result;
	};
	
	public double[] loss(double[] x, double[] t);
}
