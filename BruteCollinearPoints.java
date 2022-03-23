import java.util.ArrayList;
import java.util.Arrays;
public class BruteCollinearPoints {

    private ArrayList<LineSegment> jSegments = new ArrayList<>();


    public BruteCollinearPoints(Point[] points) {

        if (points == null) { throw new IllegalArgumentException(); }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) { throw new IllegalArgumentException(); } }

             Point[] seg;
            seg = new Point[4];
            for (int i = 0; i < points.length-3; i++) {
                for (int j = i + 1; j < points.length-2; j++) {
                    for (int l = j + 1; l < points.length-1; l++) {
                        for (int k = l + 1; k < points.length; k++) {
                            if (i != j && j != l && i != k && k != l && k != j && l != i) {

                                if (points[i].slopeOrder().compare(points[k], points[l]) == 0
                                        && points[j].slopeOrder().compare(points[k], points[l])
                                        == 0) {
                                    seg[0] = points[i];
                                    seg[1] = points[j];
                                    seg[2] = points[k];
                                    seg[3] = points[l];
                                    Arrays.sort(seg);
                                    jSegments.add(new LineSegment(seg[0], seg[3]));
                                }
                            }
                        }

                    }
                }
            }
        }

    // finds all line segments containing 4 points



    public int numberOfSegments() { return jSegments.size(); }       // the number of line segments
    public LineSegment[] segments() {
            return jSegments.toArray(new LineSegment[jSegments.size()]);
    } // the line segments
}