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
* `ArrayDeque`
* `ArrayBlockingQueue`
* `LinkedBlockingQueue`

---

## Basic Queue Operations

| Operation | Method      | Behavior if Queue is Empty / Full |
| --------- | ----------- | --------------------------------- |
| Insert    | `add()`     | Returns true if element is added else Throws exception      |
| Insert    | `offer()`   | Returns true if element is added else false            |
| Remove    | `remove()`  | Return true if element is removed else Throws exception if empty         |
| Remove    | `poll()`    | Returns true if element is removed else null if empty             |
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

## 8. Deque Methods

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

---

## 9. BlockingQueue

A **thread-safe** queue used in **multithreading**.

### Key Features:

* Waits if queue is empty or full
* Solves Producer–Consumer problem

### Important Methods:

| Method    | Behavior             |
| --------- | -------------------- |
| `put()`   | Waits if full        |
| `take()`  | Waits if empty       |
| `offer()` | Waits for given time |
| `poll()`  | Waits for given time |

---

## 10. Producer–Consumer Example

### Producer:

* Produces data
* Inserts into queue using `put()`

### Consumer:

* Consumes data
* Removes using `take()`

BlockingQueue handles synchronization automatically.

---

## 11. LinkedBlockingQueue

### Characteristics:

* Optionally bounded
* Backed by LinkedList
* Uses **two locks** (higher concurrency)

Best choice for **high producer-consumer throughput**.

---

## 12. PriorityBlockingQueue

* Thread-safe version of PriorityQueue
* Unbounded
* Elements ordered by priority
* `put()` does NOT block

### Example:

```java
BlockingQueue<String> pq = new PriorityBlockingQueue<>(11, Comparator.reverseOrder());
```

---

## 13. SynchronousQueue

### Characteristics:

* No internal storage
* Each `put()` waits for a `take()`
* Used in handoff designs

---

## 14. DelayQueue

A queue where elements become available **only after delay expires**.

### Characteristics:

* Unbounded
* Thread-safe
* Internally PriorityQueue

### Use cases:

* Task scheduling
* Cache expiration

Elements must implement `Delayed` interface.

---

## 15. ConcurrentLinkedQueue

A **non-blocking**, **lock-free**, thread-safe queue.

### Characteristics:

* Uses CAS (Compare-And-Swap)
* High performance
* No blocking

### Best for:

* High throughput systems

---

## 16. ConcurrentLinkedDeque

Thread-safe **double-ended** non-blocking queue.

### Features:

* Add/remove from both ends
* Uses CAS
* No locks

---

## 17. Queue vs BlockingQueue vs Deque

| Feature      | Queue | BlockingQueue | Deque    |
| ------------ | ----- | ------------- | -------- |
| Thread-safe  | ❌     | ✅             | ❌ / ✅    |
| Blocking     | ❌     | ✅             | ❌        |
| FIFO         | ✅     | ✅             | Optional |
| Double-ended | ❌     | ❌             | ✅        |

---

## 18. When to Use Which Queue?

* **LinkedList** → Simple FIFO
* **ArrayDeque** → Stack or Deque
* **PriorityQueue** → Priority-based processing
* **BlockingQueue** → Multithreading
* **DelayQueue** → Scheduling
* **ConcurrentLinkedQueue** → High concurrency

---

## 19. Summary

* Queue is FIFO-based
* Java provides multiple implementations
* Blocking queues simplify concurrency
* Choose queue based on **ordering**, **thread safety**, and **performance**

---

✅ **Perfect for interviews and presentations**
