
public class DataSmooting {
	public double average(double[] a){
		int length = a.length;
		double sum = 0;
		double average = 0;
		if (length == 0)
			return 0;
		for(int i=0; i < length; i++)
		{
			sum += a[i];
		}
		average = sum / length;
		return average;
	}
}
