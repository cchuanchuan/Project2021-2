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
 * AdjListOutputFile name is passed through the command line as args[1]
 * Output to AdjListOutputFile with the format:
 * 1. c lines, each starting with a different course ID, then 
 *    listing all of that course's prerequisites (space separated)
 */
public class AdjList {
    public static void main(String[] args) {

        if ( args.length < 2 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.prereqchecker.AdjList <adjacency list INput file> <adjacency list OUTput file>");
            return;
        }

        Map<String, List<String>> map = readMap(args[0]);

        String res = "";
        for (Map.Entry<String, List<String>> entry: map.entrySet()){
            String out = entry.getKey();
            for (String s :
                    entry.getValue()) {
                out+=" "+s;
            }
            res+=out+"\n";
        }
        StdOut.setFile(args[1]);
        StdOut.print(res.trim());

	// WRITE YOUR CODE HERE
    }

    public static Map<String, List<String>> readMap(String fileName){
        Map<String, List<String>> map = new HashMap<>();
        StdIn.setFile(fileName);

        int num = Integer.parseInt(StdIn.readLine());
        for (int i = 0; i < num ; i++) {
            map.put(StdIn.readLine().trim(),new ArrayList<>());
        }
        num = Integer.parseInt(StdIn.readLine());
        for (int i = 0; i < num; i++) {
            String line = StdIn.readLine();
            String strs[] = line.split(" ");
            map.get(strs[0]).add(strs[1]);
        }
        return map;
    }
}
