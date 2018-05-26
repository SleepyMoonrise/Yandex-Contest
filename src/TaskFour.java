import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class TaskFour {
	
	static int colorArray[];
	
    static boolean bipartiteCheck(int G[][],int src,int vertexNumber)
    {
        colorArray = new int[vertexNumber];
        
        for (int i=0; i<vertexNumber; ++i)
            colorArray[i] = -1;
 
        // Assign first color to source
        colorArray[src] = 1;
 
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        queue.add(src);
 
        //until queue is empty
        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue
            int u = queue.poll();
            for (int v=0; v<vertexNumber; ++v)
            {
                if (G[u][v]==1 && colorArray[v]==-1)
                {
                    colorArray[v] = 1-colorArray[u];
                    queue.add(v);
                }
                else if (G[u][v]==1 && colorArray[v]==colorArray[u])
                    return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader (new InputStreamReader (System.in));
		
		//n m
		String[] parameters = br.readLine().split(" ");
		
		int n = Integer.parseInt(parameters[0]);
		int m = Integer.parseInt(parameters[1]);
		
		int [][] edges = new int[n][n];
		for (int u=0;u<n;u++)
		{
			for (int v=0;v<n;v++)
				if (u==v)
					edges[u][u]=0;
				else
					edges[u][v]=1;
		}
		for (int i=0; i<m;i++)
		{
			String[] edgeDot = br.readLine().split(" ");
			edges[Integer.parseInt(edgeDot[0])-1][Integer.parseInt(edgeDot[1])-1]=0;
			edges[Integer.parseInt(edgeDot[1])-1][Integer.parseInt(edgeDot[0])-1]=0;
		}
		
		if (bipartiteCheck(edges,0,n))
		{
			int count =0;
			for (int i=0;i<n;i++)
			{
				if (colorArray[i]==1)
					count++;
			}
			System.out.printf("%d\n", count);
			for (int i=0;i<n;i++)
			{
				if (colorArray[i]==1)
					System.out.printf("%d ", (i+1));
			}
			System.out.printf("\n");
			for (int i=0;i<n;i++)
			{
				if (colorArray[i]!=1)
					System.out.printf("%d ", (i+1));
			}
			System.out.printf("\n");
		}
		else
			System.out.printf("-1\n");
	}
}
