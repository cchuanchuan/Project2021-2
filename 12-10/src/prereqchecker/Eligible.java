package prereqchecker;

import java.util.*;

/**
 * 
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
 * EligibleInputFile name is passed through the command line as args[1]
 * Read from EligibleInputFile with the format:
 * 1. c (int): Number of courses
 * 2. c lines, each with 1 course ID
 * 
 * Step 3:
 * EligibleOutputFile name is passed through the command line as args[2]
 * Output to EligibleOutputFile with the format:
 * 1. Some number of lines, each with one course ID
 */
public class Eligible {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.prereqchecker.Eligible <adjacency list INput file> <eligible INput file> <eligible OUTput file>");
            return;
        }

        Map<String, List<String>> map = AdjList.readMap(args[0]);
        Map<String,Integer> visited = new HashMap<>();
        Queue<String> learnd = new LinkedList<>();

        StdIn.setFile(args[1]);
        int num = Integer.parseInt(StdIn.readLine());
        for (int i = 0; i < num; i++) {
            String course = StdIn.readLine().trim();
            visited.put(course,1);
            learnd.add(course);
        }

        while (!learnd.isEmpty()) {
            String course = learnd.poll();
            for (String s: map.get(course)) {
                if (visited.get(s) == null){
                    learnd.add(s);
                    visited.put(s,1);
                }
            }
        }

        List<String> eligible = new ArrayList<>();

        for (Map.Entry<String, List<String>> entry: map.entrySet()) {
            boolean has = true;
            if (visited.get(entry.getKey()) == null){
                for (String s: entry.getValue()){
                    if (visited.get(s) == null){
                        has = false;
                        break;
                    }
                }
                if (has){
                    eligible.add(entry.getKey());
                }
            }
        }

        StdOut.setFile(args[2]);
        for (String s :
                eligible) {
            StdOut.println(s);

        }


	// WRITE YOUR CODE HERE
    }
}
