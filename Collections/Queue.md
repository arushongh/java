# Queue

---

## 1. What is a Queue?

A **Queue** is a linear data structure that follows the **FIFO (First In, First Out)** principle.

* The element inserted **first** is removed **first**.
* Elements are **added at the end** and **removed from the front**.

**Real-life example:**

* People standing in a line
* Printer job queue

---

## 2. Queue Interface in Java

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

## 3. Basic Queue Operations

| Operation | Method      | Behavior if Queue is Empty / Full |
| --------- | ----------- | --------------------------------- |
| Insert    | `add()`     | Throws exception if fails         |
| Insert    | `offer()`   | Returns false if fails            |
| Remove    | `remove()`  | Throws exception if empty         |
| Remove    | `poll()`    | Returns null if empty             |
| Peek      | `element()` | Throws exception if empty         |
| Peek      | `peek()`    | Returns null if empty             |

---

## 4. Queue Using LinkedList

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

## 5. ArrayBlockingQueue

A **bounded**, **thread-safe** blocking queue backed by an array.

### Characteristics:

* Fixed size
* Thread-safe
* Uses single lock (lower concurrency)

### Example:

```java
BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);
queue.add(1);
queue.offer(2);
```

---

## 6. PriorityQueue

A `PriorityQueue` does **NOT** follow FIFO.

### Characteristics:

* Elements are ordered by **priority**
* Implemented using **Heap (Min-Heap by default)**
* Null elements not allowed

### Example (Min Heap):

```java
PriorityQueue<Integer> pq = new PriorityQueue<>();
pq.add(5);
pq.add(1);
pq.add(3);
```

Output priority:

```
1 → 3 → 5
```

### Max Heap using Comparator:

```java
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
```

### Time Complexity:

* Insert: O(log n)
* Delete: O(log n)

---

## 7. Deque (Double Ended Queue)

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

* `addFirst()`
* `addLast()`
* `offerFirst()`
* `offerLast()`

### Deletion:

* `removeFirst()`
* `removeLast()`
* `pollFirst()`
* `pollLast()`

### Peek:

* `getFirst()`
* `getLast()`
* `peekFirst()`
* `peekLast()`

### Stack Operations:

* `push()` → addFirst()
* `pop()` → removeFirst()

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
