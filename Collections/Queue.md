# Queue

---

## What is a Queue?

A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.

* The element inserted **first** is removed **first**.
* Elements are **added at the end** and **removed from the front**.

**Real-life example:**

* People standing in a line
* Printer job queue

---

## Queue Interface in Java

Java provides `Queue` as an **interface** in `java.util` package.

```java
public interface Queue<E> extends Collection<E>
```

Common implementations:

* `LinkedList`
* `PriorityQueue`
* `Deque`
* `ArrayBlockingQueue`
* `LinkedBlockingQueue`
* `PriorityBlockingQueue`
* `SynchronousQueue`
* `DelayQueue`
* `ConcurrentLinkedQueue`
* `ConcurrentLinkedDeque`

---

## Basic Queue Operations

| Operation | Method      | Behavior if Queue is Empty / Full |
| --------- | ----------- | --------------------------------- |
| Insert    | `add()`     | Returns true if element is added else Throws exception      |
| Insert    | `offer()`   | Returns true if element is added else false            |
| Remove    | `remove()`  | Returns the removed element, throws exception if empty         |
| Remove    | `poll()`    | Returns the removed element, or null if empty             |
| Peek      | `element()` | Throws exception if empty         |
| Peek      | `peek()`    | Returns null if empty             |

---

## Queue Using LinkedList

`LinkedList` implements the `Queue` interface.

### Characteristics:

* Follows FIFO
* Allows null values
* Not thread-safe

### Example:

```java
Queue<Integer> queue = new LinkedList<>();
queue.add(1);
queue.add(2);
queue.add(3);

queue.remove(); // removes 1
queue.peek();   // returns 2
```

---

## PriorityQueue

A `PriorityQueue` does **NOT** follow FIFO.

### Characteristics:

* Elements are ordered by **priority**
* Implemented using **Heap (Min-Heap by default)**
* Custom comparator can also be provided for custom odering
* Null elements not allowed

### Example (Min Heap):

```java

PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);

System.out.println(pq.peek()); // output : 1

```

Output priority:

```
1 → 3 → 5
```

### Max Heap using Comparator:

```java
// PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());// comparator for custom ordering

//or

PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

maxHead.add(5);
maxHeap.add(1);
maxHeap.add(10);

System.out.println(maxHeap.peek()); // output : 10
```

### Time Complexity:

* Insert: O(log n)
* Delete: O(log n)

---

## Deque (Double Ended Queue)

`Deque` allows insertion and removal from **both ends**.

### Implementations:

* `ArrayDeque`
* `LinkedList`

### Advantages of ArrayDeque:

* Faster than LinkedList
* No null elements
* Less memory overhead

---

## Deque Methods

### Insertion:

* `addFirst()` Throws Exception if fails
* `addLast()` Throws Exception if fails
* `offerFirst()` Returns false if fails
* `offerLast()` Returns false if fails

### Deletion:

* `removeFirst()` removes and returns the first element of this deque. throws exception if deque is empty
* `removeLast()` throws exception if deque is empty
* `pollFirst()` returns null if deque is empty
* `pollLast()` returns null if deque is empty

### Peek:

* `getFirst()` throws exception if deque is empty
* `getLast()` throws exception if deque is empty
* `peekFirst()` returns null if deque is empty
* `peekLast()` returns null if deque is empty

```java
//Deque<Integer> deque1 = new ArrayDeque<>();
Deque<Integer> deque1 = new LinkedList<>();

deque1.addFirst(1);
deque1.addLast(2);
deque1.offerFirst(0);
deque1.offerLast(3);

System.out.println(deque1); // [0, 1, 2, 3]

deque1.removeFirst();// 0
deque1.pollLast();// 3

System.out.println(deque1); // [1, 2]

for(int num:deque1){
  System.out.println(num);
}   

```

---


## BlockingQueue

A **thread-safe** queue used in **multithreading**.

### Key Features:

* Waits if queue is empty or full
* Solves Producer–Consumer problem

### Important Methods:

| Method    | Behavior             |
| --------- | -------------------- |
| `put()`   | Waits if full - Blocks forever       |
| `take()`  | Waits if empty - Blocks forever       |
| `offer(E e, long time, TimeUnit unit)` | Waits for given time |
| `poll(long time, TimeUnit unit)`  | Waits for given time |


---
## ArrayBlockingQueue

### Characteristics:

* Bounded
* Backed by Circular Array
* Low memory overhead
* Uses a single lock for both enqueue and dequeue operations
* more threads -> problem

```java
BlockingQueue<Integer>queue = new ArrayBlockingQueue<>(5);
queue.put(10);
queue.put(11);
queue.put(2);
		
queue.take();
		
System.out.println(queue.peek()); // output : 11


```

##  LinkedBlockingQueue

### Characteristics:

* Optionally bounded (if capacity is not provided it creates a capacity of Integer.MAX_VALUE)
* Backed by Linked nodes
* Uses **two locks** (higher concurrency) leads to less waiting time

```java
BlockingQueue<Integer>queue = new LinkedBlockingQueue<>(); // unbounded
BlockingQueue<Integer>queue = new LinkedBlockingQueue<>(5); // bounded by size 5
```

Best choice for **high producer-consumer throughput**.

---

##  LinkedBlockingDeque

### Characteristics:

* Optionally bounded (if capacity is not provided it creates a capacity of Integer.MAX_VALUE)
* Backed by Linked nodes
* Uses **two locks** (higher concurrency) leads to less waiting time

```java
BlockingQueue<Integer>deque = new LinkedBlockingDeque<>(); // unbounded -
BlockingQueue<Integer>deque = new LinkedBlockingDeque<>(5); // bounded by size 5
```

### Additional Deque Methods

* `putFirst(e)` Waits if full
* `putLast(e)` Waits if full
* `takeFirst()` Waits if empty
* `takeLast()` Waits if empty

Similarly offerFirst(), offerLast(), pollFirst(), pollLast() ...

---

## PriorityBlockingQueue

* Thread-safe version of PriorityQueue
* Unbounded
* Elements ordered by priority
* Initial Capacity of 11
* Binary Heap as array is used and can grow dynamically
* `put()` does NOT block since unbounded

### Example:
```java
BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(); // uses natural odering 
BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10); // with initial capacity although its not limited
```
```java
BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(5,Comparator.reverseOrder());//Ordering controlled by comparator

queue.put(10);
queue.put(11);
queue.put(2);
		
System.out.println(queue.peek());// output : 11

queue.take();
		
System.out.println(queue.peek());// output : 10
```

---

## SynchronousQueue

A blocking queue in which each insert operation must wait for a corresponding remove operation by another thread, and vice versa

### Characteristics:

* No internal storage
* Each `put()` waits for a `take()`
* Used in handoff designs

```java

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new SynchronousQueue<>();

        Thread producer = new Thread(() -> {
            try {
                System.out.println("Producer: Trying to put...");
                queue.put(1); // BLOCKS here
                System.out.println("Producer: Put completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(3000); // delay consumer
                System.out.println("Consumer: Trying to take...");
                int val = queue.take();
                System.out.println("Consumer: Took " + val);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
/**
Output: 
Producer: Trying to put...
Consumer: Trying to take...
Producer: Put completed
Consumer: Took 1
*/

```

---

## DelayQueue

A queue where elements become available **only after delay expires**.

### Characteristics:

* Unbounded
* Thread-safe
* Internally PriorityQueue

### Use cases:

* Task scheduling
* Cache expiration

Elements must implement `Delayed` interface.

```java

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueDemo {
    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<DelayedTask> delayQueue = new DelayQueue<>();
        delayQueue.put(new DelayedTask("Task1", 5, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task2", 3, TimeUnit.SECONDS));
        delayQueue.put(new DelayedTask("Task3", 10, TimeUnit.SECONDS));

        while (!delayQueue.isEmpty()) {
            DelayedTask task = delayQueue.take(); // Blocks until a task's delay has expired
            System.out.println("Executed: " + task.getTaskName() + " at " + System.currentTimeMillis());
        }
    }

}

class DelayedTask implements Delayed {

    private final String taskName;
    private final long startTime;

    public DelayedTask(String taskName, long delay, TimeUnit unit) {
        this.taskName = taskName;
        this.startTime = System.currentTimeMillis() + unit.toMillis(delay);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.currentTimeMillis();
        return unit.convert(remaining, TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        if (this.startTime < ((DelayedTask) o).startTime) {
            return -1;
        }
        if (this.startTime > ((DelayedTask) o).startTime) {
            return 1;
        }
        return 0;
    }

    public String getTaskName() {
        return taskName;
    }
}
```

---

## ConcurrentLinkedQueue

A **non-blocking**, **lock-free**, thread-safe queue.

### Characteristics:

* Uses CAS (Compare-And-Swap)
* High performance
* No blocking
  
```java
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Demo {
    public static void main(String[] args) {

        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        Runnable task = () -> {
            for (int i = 0; i < 5; i++) {
                queue.offer(i);
                System.out.println(Thread.currentThread().getName() +
                        " added " + i);
            }
        };

        new Thread(task).start();
        new Thread(task).start();
    }
}
/**
Output: (Both Threading are putting simulatenously)
Thread-1 added 0
Thread-0 added 0
Thread-0 added 1
Thread-0 added 2
Thread-0 added 3
Thread-0 added 4
Thread-1 added 1
Thread-1 added 2
Thread-1 added 3
Thread-1 added 4
*/
```

---
### Best for:

* High throughput systems

---

## ConcurrentLinkedDeque

Thread-safe **double-ended** non-blocking queue.

### Features:

* Add/remove from both ends
* Uses Compare And Swap technique
* No locks



---

## LinkedTransferQueue

An unbounded, thread-safe queue that supports both normal enqueuing and direct handoff of elements.

### Important Methods:

| Method    | Behavior             |
| --------- | -------------------- |
| `transfer(E e)`   | Waits until a consumer receives the element      |
| `tryTransfer(E e)`  | Transfers only if a consumer is already waiting returns true or false      |
| `tryTransfer(E e, long timeout, TimeUnit unit)` | Waits up to timeout for a consumer. |
| `getWaitingConsumerCount()`  | Approximate number of waiting consumers. |
| `hasWaitingConsumer()`  | Checks if any consumer is waiting returns true or false |


## Summary

| Data Structure | Thread-Safe | Blocking | Bounded | Ordering | Null Allowed | Use Case |
|---------------|------------|----------|---------|----------|--------------|----------|
| LinkedList | ❌ No | ❌ No | ❌ No | FIFO | ✅ Yes | Basic single-thread queue |
| PriorityQueue | ❌ No | ❌ No | ❌ No | Priority | ❌ No | Single-thread priority handling |
| Deque (ArrayDeque) | ❌ No | ❌ No | ❌ No | FIFO / LIFO | ❌ No | Fast stack/queue (single-thread) |
| ArrayBlockingQueue | ✅ Yes | ✅ Yes | ✅ Yes | FIFO | ❌ No | Fixed-size producer-consumer |
| LinkedBlockingQueue | ✅ Yes | ✅ Yes | ✅ / ❌ | FIFO | ❌ No | High-throughput producer-consumer |
| PriorityBlockingQueue | ✅ Yes | ⚠️ Partial | ❌ No | Priority | ❌ No | Concurrent priority tasks |
| SynchronousQueue | ✅ Yes | ✅ Yes | ✅ (0) | FIFO / LIFO | ❌ No | Direct thread handoff |
| DelayQueue | ✅ Yes | ✅ Yes | ❌ No | Delay-based | ❌ No | Scheduled / delayed tasks |
| ConcurrentLinkedQueue | ✅ Yes | ❌ No | ❌ No | FIFO | ❌ No | Lock-free high-throughput queue |
| ConcurrentLinkedDeque | ✅ Yes | ❌ No | ❌ No | FIFO / LIFO | ❌ No | Lock-free double-ended queue |

---

