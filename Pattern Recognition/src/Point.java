import java.util.Comparator;
import edu.princeton.cs.algs4.StdDraw;


public class Point implements Comparable<Point> {
    private final int x;
    private final int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void draw(){
        StdDraw.point(x,y);
    }
    public void drawTo(Point that){
        StdDraw.line(this.x, this.y, that.x,that.y);
    }
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
    public int compareTo(Point that){
        if (this.y<that.y) return -1;
        else if (this.y==that.y && this.x<that.x) return -1;
        else if (this.y==that.y && this.x==that.x) return 0;
        else return 1;
    }
    public double slopeTo(Point that){
        if (compareTo(that)==0) return Double.NEGATIVE_INFINITY;
        else if (this.x==that.x) return Double.POSITIVE_INFINITY;
        else if (this.y==that.y) return +0.0;
        else{
            return  ((double)(this.y-that.y))/((double)(this.x-that.x));

        }
    }
    private class pointComparator implements Comparator<Point>{
        public int compare(Point a, Point b){
            if(Double.compare(slopeTo(a), slopeTo(b))<0) return -1;
            else if (Double.compare(slopeTo(a), slopeTo(b))>0) return 1;
            else return 0;
        }
    }
    public Comparator<Point> slopeOrder(){
        return new pointComparator();

    }
    public static void main(String args[]){
        Point a = new Point(10,0);
        Point b = new Point(20,10);
        Point c = new Point(30,20);
        System.out.println(a.slopeOrder().compare(b,c));
    }
}

