package programmers_CT.test4;

import java.util.ArrayDeque;
import java.util.Queue;

public class ProgrammersTest2 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        //sum Of fromQueue > sum of toQueue
        CustomQueue fromQueue = new CustomQueue(queue1);
        CustomQueue toQueue = new CustomQueue(queue2);

        int limitCount = fromQueue.integerQueue.size() * 2;

        while (!fromQueue.checkEndCondition(toQueue)
            && answer <= limitCount) {

            if (fromQueue.sumOfQueue < toQueue.sumOfQueue) {
                CustomQueue tmp = fromQueue;
                fromQueue = toQueue;
                toQueue = tmp;
            }

            fromQueue.popInsert(toQueue);
            answer += 1;
        }

        if (answer > limitCount) {
            return -1;
        }
        return answer;
    }
}

class CustomQueue {
    Queue<Integer> integerQueue;
    long sumOfQueue;

    public CustomQueue(int[] numArr) {
        this.integerQueue = new ArrayDeque<>();
        for (int i = 0; i < numArr.length; i++) {
            int numData = numArr[i];
            sumOfQueue += numData;
            this.integerQueue.add(numData);
        }
    }

    public void popInsert(CustomQueue toQueue) {
        Integer poll = this.integerQueue.poll();
        toQueue.integerQueue.add(poll);

        this.sumOfQueue -= poll;
        toQueue.sumOfQueue += poll;
    }

    public boolean checkEndCondition(CustomQueue toQueue) {
        if (this.sumOfQueue == toQueue.sumOfQueue) {
            return true;
        }

        return false;
    }
}
