/**

Given two overlapping rectangles on a plane. We are given bottom left and top right points of the two rectangles. We need to find the total area 

Input : Point l1 = {2, 2}, r1 = {5, 7};
        Point l2 = {3, 4}, r2 = {6, 9};
Output :Total Area = 24 

Input : Point l1 = {2, 1}, r1 = {5, 5};
        Point l2 = {3, 2}, r2 = {5, 7};
Output :Total Area = 16


Total Area = (Area of 1st rectangle + 
              Area of 2nd rectangle) - 
              Area of Intersecting part


**/


public class TotalAreaOfOverlappingRectangles{

	static class Point{
		int x, y;
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public int overlappingArea(Point l1, Point l2, Point r1, Point r2){
		int area1
            = Math.abs(l1.x - r1.x) 
              * Math.abs(l1.y - r1.y);

		int area2
            = Math.abs(l2.x - r2.x) 
              * Math.abs(l2.y - r2.y);

		int x_dist = (Math.min(r1.x, r2.x) 
                      - Math.max(l1.x, l2.x));
        int y_dist = (Math.min(r1.y, r2.y)
                 - Math.max(l1.y, l2.y));

		int areaInter = 0;

		if(x_dist>0 && y_dist>0){
			areaInter = x_dist * y_dist;
		}
		return (area1 + area2 - areaInter);
	}

	public static void main(String[] args) {
		TotalAreaOfOverlappingRectangles to = new TotalAreaOfOverlappingRectangles();
		Point l1 = new Point(2, 2);
		Point l2 = new Point(3, 4);
		Point r1 = new Point(5, 7);
		Point r2 = new Point(6, 9);

		System.out.println("Total Overlapping Area of Rectangles :"+to.overlappingArea(l1, r1, l2, r2));
	}
}