package prereqchecker;

import java.util.*;

/**
 * Steps to implement this class main method:
 * 
 * Step 1:
 * AdjListInputFile name is passed through the command line as args[0]
 * Read from AdjListInputFile with the format:
 * 1. a (int): number of courses in the graph
 * 2. a lines, each with 1 course ID
 * 3. b (int): number of edges in the graph
 * 4. b lines, each with a source ID
 * 
 * Step 2:
 * ValidPreReqInputFile name is passed through the command line as args[1]
 * Read from ValidPreReqInputFile with the format:
 * 1. 1 line containing the proposed advanced course
 * 2. 1 line containing the proposed prereq to the advanced course
 * 
 * Step 3:
 * ValidPreReqOutputFile name is passed through the command line as args[2]
 * Output to ValidPreReqOutputFile with the format:
 * 1. 1 line, containing either the word "YES" or "NO"
 */
public class ValidPrereq {

    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.prereqchecker.ValidPrereq <adjacency list INput file> <valid prereq INput file> <valid prereq OUTput file>");
            return;
        }

        Map<String, List<String>> map = AdjList.readMap(args[0]);
        Map<String,Integer> visited = new HashMap<>();

        StdIn.setFile(args[1]);
        String line1 = StdIn.readLine();
        String line2 = StdIn.readLine();
        map.get(line1).add(line2);

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            if (entry.getValue().size() == 0){
                visited.put(entry.getKey(),1);
            }
        }
        boolean hasChange = true;
        while (hasChange){
            hasChange = false;
            for (Map.Entry<String, List<String>> entry: map.entrySet()) {
                boolean changed = true;
                if (visited.get(entry.getKey()) == null){
                    for (String s: entry.getValue()){
                        if (visited.get(s) == null){
                            changed = false;
                            break;
                        }
                    }
                    if (changed){
                        visited.put(entry.getKey(),1);
                        hasChange = true;
                    }
                }
            }
        }

        boolean res = visited.size() == map.size()?true:false;

        StdOut.setFile(args[2]);
        if (res) {
            StdOut.print("YES");
        }else {
            StdOut.print("NO");
        }


	// WRITE YOUR CODE HERE
    }

}
