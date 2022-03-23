import java.util.ArrayList;
import java.util.Arrays;
public class FastCollinearPoints {

    private ArrayList<LineSegment> jSegments = new ArrayList<>();


    public FastCollinearPoints(Point[] points) {
        if (points == null) { throw new IllegalArgumentException(); }
        for (int i = 0; i < points.length; i++){
            if (points[i] == null) {throw new IllegalArgumentException();}}
    Point[] copy = points.clone();
    Arrays.sort(copy);

    for (int i = 0; i<copy.length-3; i++){
        Arrays.sort(copy);
        Arrays.sort(copy, copy[i].slopeOrder());
        for (int p = 0, first = 1 , last = 2; last <copy.length; last++) {
            while (last <copy.length && copy[p].slopeTo(copy[first]) == copy[p].slopeTo(copy[last])) {
                last++;
            }
            if (last-first >= 3 && copy[p].compareTo(copy[first]) < 0) { jSegments.add(new LineSegment(copy[p], copy[last-1])); }
            first =last;
        }
    }
    }      // finds all line segments containing 4 or more points


    public           int numberOfSegments() {
        return jSegments.size();
    }       // the number of line segments


    public LineSegment[] segments()     {
        return jSegments.toArray(new LineSegment[jSegments.size()]);
    }          // the line segments


    /*private boolean hasDuplicate(Point[] points){
        for (int i=0 ; i<points.length; i++){
            if (points[i].compareTo(points[i+1])==0){
            return true;
            }
        }return false;
    }*/
}