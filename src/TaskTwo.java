import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TaskTwo {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		//get k - books limit per day; m - book's reserve; d - day of the week
		String[] parameters = br.readLine().split(" ");
		
		int k = Integer.parseInt(parameters[0]);
		int m = Integer.parseInt(parameters[1]);
		int d = Integer.parseInt(parameters[2]);
		
	    int currentTask = 1;
	    int satisfied = 0;
	    
	    while(true) 
	    {
	    	//check day
	    	if(d<6) 
	    		m += k;
	    	//remove used books
	    	m -= currentTask;
	    	//if there is a negative value - means the amount wasn't enough to satisfy
	    	if(m<0) 
	    		break;
	    	
	    	satisfied++;
	    	currentTask += 1;
	    	
	    	//7%7+1=1
	    	d = (d%7)+1;
	    }
	    System.out.printf("%d\n", satisfied);
	}
}
