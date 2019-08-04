import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        //int[][] arr = insert ( new int[][] {{1,2},{3,5},{6,7},{8,10},{12,16}} , new int[] {4,8} );

        //int[][] arr = insert ( new int[][] {{1,5}}, new int[]{2,7} );

        //int[][] arr = insert ( new int[][] {{1,5}}, new int[]{6,8} );

        //int[][] arr = insert ( new int[][] {{1,5}}, new int[]{0,0} );

        //int[][] arr = insert ( new int[][] {{1,5}}, new int[]{0,6} );

        //int[][] arr = insert ( new int[][] {{2,5},{6,7},{8,9}} ,  new int[]{0,1} );

        //int[][] arr = insert ( new int[][] {{1,5},{10,11},{15,2147483647}} , new int[] {5,7} );

        //int[][] arr = insert ( new int[][] {{1,5}} , new int[] {1,7} );

        //int[][] arr = insert ( new int[][] {{1,5}} , new int[] {0,3} );

        //int[][] arr = insert ( new int[][] {{1,5}} , new int[] {0,5} );

        //int[][] arr = insert ( new int[][] {{1,5}} , new int[] {1,5} );

        //int[][] arr = insert ( new int[][] {{0,3},{5,8},{9,11}}, new int[] {9,18} );

        int[][] arr = insert ( new int[][] { {1,2},{3,5},{6,7},{8,10},{12,16}} , new int[] {4,8} );

        for(int i = 0 ; i < arr.length ; i++){
            for( int j=0 ; j < arr[0].length ; j++) {
                System.out.println(arr[i][j]);
            }
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

                // init data
                int newStart = newInterval[0];
                int newEnd = newInterval[1];

                int idx = 0, n = intervals.length;
                LinkedList<int[]> output = new LinkedList<>();

                // add all intervals starting before newInterval
                while (idx < n && newStart > intervals[idx][0])
                    output.add(intervals[idx++]);

                // add newInterval
                int[] interval = new int[2];

                // if there is no overlap, just add the interval
                if (output.isEmpty() || output.getLast()[1] < newStart)
                    output.add(newInterval);

                // if there is an overlap, merge with the last interval
                else {
                    interval = output.removeLast();
                    interval[1] = Math.max(interval[1], newEnd);
                    output.add(interval);
                }


                // add next intervals, merge with newInterval if needed
                while (idx < n) {


                    interval = intervals[idx++];
                    int start = interval[0], end = interval[1];
                    // if there is no overlap, just add an interval
                    if (output.getLast()[1] < start) output.add(interval);
                    // if there is an overlap, merge with the last interval
                    else {
                        interval = output.removeLast();
                        interval[1] = Math.max(interval[1], end);
                        output.add(interval);
                    }


                }

                return output.toArray(new int[output.size()][2]);

            }


//            public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//
//                List<Interval> result = new ArrayList<>();
//                int i = 0;
//                int start = newInterval.start;
//                int end = newInterval.end;
//
//
//                while (i < intervals.size() && intervals.get(i).end < start) {
//                    result.add(intervals.get(i++));
//                }
//
//                while (i < intervals.size() && intervals.get(i).start <= end) {
//                    start = Math.min(start, intervals.get(i).start);
//                    end = Math.max(end, intervals.get(i).end);
//                    i++;
//                }
//                result.add(new Interval(start,end));
//
//                while (i < intervals.size()) result.add(intervals.get(i++));
//                return result;
//            }


//            public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//                List<Interval> result = new LinkedList<>();
//                int i = 0;
//                // add all the intervals ending before newInterval starts
//                while (i < intervals.size() && intervals.get(i).end < newInterval.start)
//                    result.add(intervals.get(i++));
//                // merge all overlapping intervals to one considering newInterval
//                while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
//                    newInterval = new Interval( // we could mutate newInterval here also
//                            Math.min(newInterval.start, intervals.get(i).start),
//                            Math.max(newInterval.end, intervals.get(i).end));
//                    i++;
//                }
//                result.add(newInterval); // add the union of intervals we got
//                // add all the rest
//                while (i < intervals.size()) result.add(intervals.get(i++));
//                return result;
//            }

//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> list = new LinkedList<>();
//        Interval pre = newInterval;
//        for(Interval curr: intervals){
//            if(pre.end < curr.start) {
//                list.add(pre);
//                pre = curr;
//            } else if (curr.end < pre.start) {   //Here is the difference.
//                list.add(curr);
//            }
//            else {
//                pre.start = Math.min(pre.start, curr.start);
//                pre.end = Math.max(pre.end, curr.end);
//            }
//        }
//        list.add(pre);
//        return list;
//    }

        }
