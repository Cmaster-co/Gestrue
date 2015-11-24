import java.util.ArrayList;
import java.util.List;

public class DataSmooting {
	//求传入数组的平均值
	public double average(List<Double> a){
		int length = a.size();
		double sum = 0;
		double average = 0;
		if (length == 0)
			return 0;
		for(double each : a)
		{
			sum += each;
		}
		average = sum / length;
		return average;
	}
	//邻域平滑滤波
	public double[] Gaussian(double[] a, int n){
		int length = a.length;
		double average = 0 ;
		List list_out = new ArrayList();
		if (length == 0)
			return null;
		for(int i=0; i < length; i++)
		{
			List temp = new ArrayList();
			for(int j=i-n; j < i+n; j++)
			{
				if(j >= 0 && j < length)
				{
					temp.add(a[j]);
				}
			}
			average = average(temp);
			list_out.add(average);
		}
		double[] b = new double[list_out.size()];
		for(int i=0; i < list_out.size(); i++)
		{
			b[i]=(Double) list_out.get(i);
		}
		return b;
	}
}
