import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class TaskOne {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		//get n
		int n = Integer.parseInt(br.readLine());
		
		//instead of two arrays better to make one and store a[i]*b[i] info
		int[] arrayAbsChance = new int[n];
		
		String[] parameters;
		int sum = 0;
		for (int i=0; i<n; i++)
		{
			parameters = br.readLine().split(" ");
			arrayAbsChance[i] = Integer.parseInt(parameters[0])*Integer.parseInt(parameters[1]);
			sum+=arrayAbsChance[i];
		}
		for(int i = 0; i< n;++i)
		{
			//12 decimal places in the example
			System.out.printf(String.format(Locale.ROOT, "%.12f", (double)arrayAbsChance[i]/sum)+"\n");
		}
	}

}
