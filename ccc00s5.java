
// Credit to http://mmhs.ca/ccc/2000/S5SheepandCoyotes.txt

import java.util.*;
public class ccc00s5
{
    
    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
	
    	Point sheep [] = new Point [100];
    	int eaten [] = new int [100]; // list of possibly eaten sheep
    	
    
    	int n = sc.nextInt();
    	for (int i = 0 ; i < n ; i++) {
    		sheep[i] = new Point (sc.nextDouble(), sc.nextDouble ());
    	}
    	
    	int ne, s;
    	double dist, m;
    	boolean dup;
    	ne = 0;
    	
    	
    	for (double x = 0 ; x <= 1000.0 ; x = x + 0.01)
    	{
    	    s = 0;
    	    m = Double.MAX_VALUE;
    	    for (int i = 0 ; i < n ; i++)
    	    {
        		dist = distance (sheep[i], x);
        		if (dist < m)
        		{
        		    m = dist;
        		    s = i;
        		}
    	    }
    
    	    dup = false;
    	    for (int j = 0 ; j < ne ; j++) {
	    		if (s == eaten[j]) {
	    		    dup = true;
	    		}
    	    }
    	    
	    	if (!dup) {
	    		eaten[ne++] = s;
	    	}
    		
    	}
    	
    	for (int j = 0 ; j < ne ; j++)
    	{
    		
    	    System.out.println ("The sheep at (" + String.format("%.2f", sheep[eaten[j]].x) + ", " + String.format("%.2f", sheep[eaten[j]].y) + ") might be eaten.");
    	}

    }


    public static double distance (Point p, double x)
    {
	    return (p.x - x) * (p.x - x) + p.y * p.y;
    }
}

class Point
{
    public double x, y;
    public Point (double a, double b)
    {
    	x = a;
    	y = b;
    }
}
