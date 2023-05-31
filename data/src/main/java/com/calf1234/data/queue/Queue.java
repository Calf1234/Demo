package com.calf1234.data.queue;

/**
 * 队列：先进先出表。插入数据的一端是队尾，取数据的一端则是队头。
 *
 * 循环队列：把队列的这种头尾相连的存储结构。解决假溢出问题。
 *  假设循环队列总容量为N，并且预留一个空的位置作为队列空，满，长度判断标志：
 *  队列空：front==rear;
 *  队列满：(rear+1)%N==front;
 *  队列元素个数：（rear – front + N)%N
 */
public class Queue {
    /* 队列相关 算法题
    https://leetcode.com/problems/number-of-recent-calls/

    https://leetcode.com/problems/design-circular-deque/

    https://leetcode.com/problems/task-scheduler/
     */


}
