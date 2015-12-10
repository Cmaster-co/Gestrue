import java.util.ArrayList;
import java.util.List;

public class Authentication {
	//认证功能
	public boolean isUser(List a, List b){
		double[] ax = (double[]) a.get(0);
		double[] ay = (double[]) a.get(1);
		double[] az = (double[]) a.get(2);
		double[] bx = (double[]) b.get(0);
		double[] by = (double[]) b.get(1);
		double[] bz = (double[]) b.get(2);
		//识别点个数认证
		if(ax.length != bx.length || ay.length != by.length || az.length != bz.length)
		{
			System.out.println("length didn't match");
			return false;
		}
		int xl=ax.length;
		int yl=ay.length;
		int zl=az.length;
		//识别点具体认证
		for(int i=0; i < xl; i++)
		{
			if(ax[i] > bx[i] + 1 || ax[i] < bx[i] -1)
			{
				System.out.println("x didnt match");
				return false;
			}
		}
		for(int i=0; i < yl; i++)
		{
			if(ay[i] > by[i] + 1 || ay[i] < by[i] -1)
			{
				System.out.println("y didnt match");
				return false;
			}
		}
		for(int i=0; i < zl; i++)
		{
			if(az[i] > bz[i] + 1 || az[i] < bz[i] -1)
			{
				System.out.println("z didnt match");
				return false;
			}
		}
		System.out.println("all match");
		return true;
	}
	//整合x,y,z轴上的识别点
	public List getPeaks(double[] a, double[] b, double[] c){
		List list_out = new ArrayList();
		double[] x = recoveryPoint(a);
		double[] y = recoveryPoint(b);
		double[] z = recoveryPoint(c);
		System.out.println(x);
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
				if(flag == 1 && Math.abs(a[i] - a[i-n]) > 1)
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
				if(flag == -1 && Math.abs(a[i] - a[i-n]) > 1)
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
