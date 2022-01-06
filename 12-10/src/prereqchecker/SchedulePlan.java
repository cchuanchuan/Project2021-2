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
 * SchedulePlanInputFile name is passed through the command line as args[1]
 * Read from SchedulePlanInputFile with the format:
 * 1. One line containing a course ID
 * 2. c (int): number of courses
 * 3. c lines, each with one course ID
 * 
 * Step 3:
 * SchedulePlanOutputFile name is passed through the command line as args[2]
 * Output to SchedulePlanOutputFile with the format:
 * 1. One line containing an int c, the number of semesters required to take the course
 * 2. c lines, each with up to 3 space separated course ID's
 */
public class SchedulePlan {
    public static void main(String[] args) {

        if ( args.length < 3 ) {
            StdOut.println("Execute: java -cp bin prereqchecker.prereqchecker.SchedulePlan <adjacency list INput file> <schedule plan INput file> <schedule plan OUTput file>");
            return;
        }

        Map<String, List<String>> map = AdjList.readMap(args[0]);
        Map<String,Integer> visited = new HashMap<>();
        Queue<String> learnd = new LinkedList<>();

        StdIn.setFile(args[1]);
        String needLearn = StdIn.readLine();
        int num = Integer.parseInt(StdIn.readLine());
        for (int i = 0; i < num; i++) {
            String course = StdIn.readLine().trim();
            visited.put(course,1);
            learnd.add(course);
        }

        //找到已学习的
        while (!learnd.isEmpty()) {
            String course = learnd.poll();
            for (String s: map.get(course)) {
                if (visited.get(s) == null){
                    learnd.add(s);
                    visited.put(s,1);
                }
            }
        }
//        System.out.println("Has learned:" + visited);

        // 找到需要学习的
        Queue<String> needQueue = new LinkedList<>();
        needQueue.add(needLearn);
        List<String> needList = new ArrayList<>();

        while (!needQueue.isEmpty()) {
            String course = needQueue.poll();
            for (String s : map.get(course)) {
                if (visited.get(s) == null && !needList.contains(s)){
                    needQueue.add(s);
                    needList.add(s);
//                    visited.put(s,1);
                }
            }
        }

//        System.out.println("Need learn:"+needList);

        List<List<String>> learnPlan = new ArrayList<>();
        while (needList.size()>0){
            List<String> eligible = new ArrayList<>();
//            System.out.println("need loop");
            for (String course: needList) {
                boolean has = true;
                if (visited.get(course) == null) {
                    for (String s: map.get(course)){
                        if (visited.get(s) == null){
                            has = false;
                            break;
                        }
                    }
                    if (has){
                        eligible.add(course);
                        if (eligible.size() == 3){
                            break;
                        }
                    }
                }
            }
            if (eligible.size() == 0){
//                System.out.println("break");
                break;
            }
            needList.removeAll(eligible);
            learnPlan.add(eligible);
            for (String s:
                 eligible) {
                visited.put(s,1);
            }
        }
        StdOut.setFile(args[2]);
        StdOut.print(learnPlan.size());
        StdOut.println();
        for (List<String> list :
                learnPlan) {
            for (String s : list) {
                StdOut.print(s+" ");
            }
            StdOut.println();
        }









	// WRITE YOUR CODE HERE

    }
}
