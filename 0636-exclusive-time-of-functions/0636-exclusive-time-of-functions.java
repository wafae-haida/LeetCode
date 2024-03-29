class Execution {
        int id;
        boolean isEnd;
        int time;

        public Execution(String log) {
            String[] execution = log.split(":");
            this.id = Integer.parseInt(execution[0]);
            this.isEnd = execution[1].equals("end");
            this.time = Integer.parseInt(execution[2]);
        }

    }
class Solution{
    int[] exclusiveTime(int n, List<String> logs) {
        Stack<Execution> callStack = new Stack<>();
        for (String log : logs) {
            callStack.push(new Execution(log));
        }

        int[] solution = new int[n];

        Stack<Execution> backgroundExecution = new Stack<>();

        while (!callStack.isEmpty()) {
            Execution executing = callStack.pop();
            if (callStack.peek().isEnd) {
                //send the current execution to background because something executed between its start and end
                backgroundExecution.push(executing);
            } else {
                //execution Stack will be a start, so we calculate how long it took
                int executionTime = 1 + (executing.time - callStack.pop().time);
                //update solution after processing
                solution[executing.id] += executionTime;
                //clean the background and update the time removing the subprocess execution time
                while (!backgroundExecution.isEmpty()) {
                    Execution toExecute = backgroundExecution.pop();
                    toExecute.time -= executionTime;
                    callStack.push(toExecute);
                }
            }
        }

        return solution;
    }


}
