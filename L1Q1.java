import java.util.*;



public class L1Q1 {

	public static class Area {

        int length;
        int breadth;

        public Area(int length, int breadth) {
            this.length = length;
            this.breadth = breadth;
        }
        
        public void setDim(int length, int breadth) {
        	this.length = length;
            this.breadth = breadth;
        }
        
        public int getArea(){
            return length * breadth;
        }
    }
	
	public Student() {
		
	}


	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt();
        int breadth = scan.nextInt();

        Area porch = new Area(length, breadth);
        porch.getArea();

    }

}