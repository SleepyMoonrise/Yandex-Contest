import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TaskSix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		//n 
		int n = Integer.parseInt(br.readLine());
		//A
		String[] parameterA = br.readLine().split(" ");
		//B
		String[] parameterB = br.readLine().split(" ");
		//m 
		int m = Integer.parseInt(br.readLine());
		
		int[] arrayA = new int[n];
		int[] arrayB = new int[n];
		int[][] arrayArrangedId = new int[n][3];
		
		for (int i=0;i<n;i++)
		{
			arrayA[i]=Integer.parseInt(parameterA[i]);
			arrayB[i]=Integer.parseInt(parameterB[i]);
			arrayArrangedId[i][0]=arrayA[i]-arrayB[i];
			arrayArrangedId[i][1]=1;
			arrayArrangedId[i][2]=i;
		}
		
		Arrays.sort(arrayArrangedId, (a, b) -> Integer.compare(a[0], b[0]));
		
		for (int i=0; i<n/2; i++)
		{
			arrayArrangedId[i][1]=2;
		}
		
		for (int i=0;i<m;i++)
		{
			String[] parameters = br.readLine().split(" ");
			
			int numberInd=Integer.parseInt(parameters[0])-1;
			int type=Integer.parseInt(parameters[1]);
			int value=Integer.parseInt(parameters[2]);
			int bufNumberInd;
			for(bufNumberInd=0; bufNumberInd<n;bufNumberInd++)
			{
				if (arrayArrangedId[bufNumberInd][2]==numberInd)
					break;
					
			}
			if (type==1)
			{
				arrayArrangedId[bufNumberInd][0]+=value;
				arrayA[numberInd]+=value;
			}
			else
			{
				arrayArrangedId[bufNumberInd][0]-=value;
				arrayB[numberInd]+=value;
			}
			
			if(arrayArrangedId[bufNumberInd][1]!=type)
			{
				if (arrayArrangedId[bufNumberInd][1] == 2)
				{
					int min =0;
					int minInd =0;
					
					for (int s=0;s<n;s++)
					{
						if (arrayArrangedId[s][1]==1)
						{
							minInd=s;
							min=arrayArrangedId[s][0];
							break;
						}
					}
					for (int s=0; s<n;s++)
						if (arrayArrangedId[s][1]==1)
							if (arrayArrangedId[s][0]<min)
							{
								minInd=s;
								min=arrayArrangedId[s][0];
							}
					
					if (min<arrayArrangedId[bufNumberInd][0])
					{
						arrayArrangedId[bufNumberInd][1]=1;
						arrayArrangedId[minInd][1]=2;
					}
				}
				else
				{
					int max =0;
					int maxInd =0;
					
					for (int s=0;s<n;s++)
					{
						if (arrayArrangedId[s][1]==2)
						{
							maxInd=s;
							max=arrayArrangedId[s][0];
							break;
						}
					}
					for (int s=0; s<n;s++)
						if (arrayArrangedId[s][1]==2)
							if (arrayArrangedId[s][0]>max)
							{
								maxInd=s;
								max=arrayArrangedId[s][0];
							}
					if (max>arrayArrangedId[bufNumberInd][0])
					{
						arrayArrangedId[bufNumberInd][1]=2;
						arrayArrangedId[maxInd][1]=1;
					}
				}
			}
			int sum =0;
			for (int ii=0;ii<n;ii++)
			{
				if (arrayArrangedId[ii][1]==1)
					sum+=arrayA[arrayArrangedId[ii][2]];
				else
					sum+=arrayB[arrayArrangedId[ii][2]];
			}
			System.out.printf("%d\n", sum);
		}
	}

}
