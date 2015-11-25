import java.util.ArrayList;
import java.util.List;

public class Authentication {
	//认证功能
	public boolean isUser(List a, List b){
		return false;
	}
	//整合x,y,z轴上的识别点
	public List getPeaks(double[] a, double[] b, double[] c){
		List list_out = new ArrayList();
		double[] x = recoveryPoint(a);
		double[] y = recoveryPoint(b);
		double[] z = recoveryPoint(c);
		list_out.add(x);
		list_out.add(y);
		list_out.add(z);
		return list_out;
	}
	//取出识别点（波峰与波谷）
	public double[] recoveryPoint(double[] a){
		int length = a.length;
		List list_out = new ArrayList();
		int n=5;
		int flag=0;
		for(int i= n; i < length-n; i++)
		{
			//判断波谷
			for(int k =0; k < n; k++)
			{
				if(a[i-n+k] > a[i-n+k+1])
				{
					flag = -1;
				}
				else
				{
					flag = 0;
					break;
				}
			}
			if(flag == -1)
			{
				for(int k =0; k < n; k++)
				{
					if(a[i+k] < a[i+k+1])
					{
						flag = 1;
					}
					else
					{
						flag = 0;
						break;
					}
				}
				if(flag == 1)
					list_out.add(a[i]);
			}
			//判断波峰
			for(int k =0; k < n; k++)
			{
				if(a[i-n+k] < a[i-n+k+1])
				{
					flag = 1;
				}
				else
				{
					flag = 0;
					break;
				}
			}
			if(flag == 1)
			{
				for(int k =0; k < n; k++)
				{
					if(a[i+k] > a[i+k+1])
					{
						flag = -1;
					}
					else
					{
						flag = 0;
						break;
					}
				}
				if(flag == -1)
					list_out.add(a[i]);
			}
		}
		
		double[] b = new double[list_out.size()];
		for(int i=0; i < list_out.size(); i++)
		{
			b[i]=(Double) list_out.get(i);
		}
		return b;
	}
	
}
