# 🚀 Java 8 Features – Lambdas & Functional Interfaces

This document is a **clean, GitHub‑ready explanation + reference** for core **Java 8 functional programming concepts**, with **complete runnable code** and **simple explanations** wherever things are usually confusing.

---

## ✨ What Changed in Java 8?

Java 8 introduced **functional programming** concepts to Java, making code:

* More **readable**
* More **concise**
* Easier to work with **collections & parallelism**

The biggest additions:

* **Lambda Expressions**
* **Functional Interfaces**
* Built‑in interfaces like `Predicate`, `Function`, `Consumer`, `Supplier`
* **Method & Constructor References**

---

## 🧠 Lambda Expression

> A **lambda expression** is an **anonymous function**.

### Key properties

* No access modifier
* No return type (inferred)
* No method name
* Used to implement **functional interfaces**

**Syntax**

```java
(parameters) -> expression
(parameters) -> { statements }
```

---

## 🧩 Functional Interface

> An interface with **exactly one abstract method**.

### Important points

* Can have **default** and **static** methods
* Used as the base for lambda expressions
* Marked using `@FunctionalInterface` (optional but recommended)

---

## 🧵 Example 1 – Runnable (Before vs After Lambda)

### Before Java 8

```java
Thread myThread = new Thread(new Task());
myThread.run();
```

### Using Lambda

```java
Thread myThread1 = new Thread(() -> {
    System.out.println("Hello");
});
myThread1.run();
```

✔ `Runnable` is a functional interface → lambda replaces the class

---

## ➕ Example 2 – Custom Functional Interface

### Functional Interface

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}
```

### Traditional Implementation

```java
class PlusOperation implements MathOperation {
    public int operate(int a, int b) {
        return a + b;
    }
}
```

### Using Lambda

```java
MathOperation add2 = (x, y) -> x + y;
MathOperation sub1 = (x, y) -> x - y;
```

---

## ✅ Predicate

> Used **only for conditions**

### Method

```java
boolean test(T t)
```

### Example

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
System.out.println(isEven.test(4));
```

### Combining Predicates

```java
Predicate<String> isWordStartingWithA = str -> str.toLowerCase().startsWith("a");
Predicate<String> isWordEndingWithH = str -> str.toLowerCase().endsWith("h");

Predicate<String> and = isWordStartingWithA.and(isWordEndingWithH);

System.out.println(and.test("Arush"));
```

---

## 🔁 Function

> Takes **one input** and **returns one output**

### Method

```java
R apply(T t)
```

### Example

```java
Function<Integer, Integer> doubleIt = x -> 2 * x;
Function<Integer, Integer> tripleIt = x -> 3 * x;

System.out.println(doubleIt.apply(5));
```

### andThen vs compose

```java
// First double → then triple
System.out.println(doubleIt.andThen(tripleIt).apply(10));

// First triple → then double
System.out.println(doubleIt.compose(tripleIt).apply(20));
```

### identity()

```java
Function<Integer, Integer> identity = Function.identity();
System.out.println(identity.apply(10));
```

---

## 📥 Consumer

> Takes input but **returns nothing**

### Method

```java
void accept(T t)
```

### Example

```java
Consumer<Integer> consumer = x -> System.out.println("Consumed : " + x);
consumer.accept(10);
```

### Consumer with Collections

```java
List<Integer> list = Arrays.asList(1, 3, 5, 2);
Consumer<List<Integer>> printList = x -> {
    for (int i : x)
        System.out.println(i);
};
printList.accept(list);
```

✔ Has `andThen()` but **no compose** (no return value)

---

## 📤 Supplier

> Takes **no input**, returns a value

### Method

```java
T get()
```

### Example

```java
Supplier<String> giveHelloWorld = () -> "Hello World";
System.out.println(giveHelloWorld.get());
```

---

## 🔗 Combined Example

```java
Predicate<Integer> even = x -> x % 2 == 0;
Function<Integer, Integer> square = x -> x * x;
Consumer<Integer> takes = x -> System.out.println(x);
Supplier<Integer> supply = () -> 100;

if (even.test(supply.get())) {
    takes.accept(square.apply(supply.get()));
}
```

✔ Shows real‑world functional pipeline

---

## 🧑‍🤝‍🧑 Bi‑Interfaces (Two Inputs)

### BiPredicate

```java
BiPredicate<Integer, Integer> isSumEven = (x, y) -> (x + y) % 2 == 0;
System.out.println(isSumEven.test(3, 5));
```

### BiConsumer

```java
BiConsumer<Integer, String> takesTwo = (x, y) -> {
    System.out.println(x);
    System.out.println(y);
};
takesTwo.accept(10, "Arush");
```

### BiFunction

```java
BiFunction<String, String, Integer> stringLen = (x, y) -> x.length() + y.length();
System.out.println(stringLen.apply("arush", "monika"));
```

🚫 No `BiSupplier` — suppliers return only **one value**

---

## ➗ Unary & Binary Operators

```java
UnaryOperator<Integer> uop = x -> x + 2;
BinaryOperator<Integer> bop = (x, y) -> x + y;
```

✔ Shortcuts over `Function` and `BiFunction`

---

## 🔗 Method Reference

> Use methods **without calling them**

### Example

```java
List<String> students = Arrays.asList("Arush", "monika", "mohit", "ravindra");
students.forEach(System.out::println);
```

### Lambda → Method Reference Mapping

| Lambda                    | Method Reference    |
| ------------------------- | ------------------- |
| `x -> foo(x)`             | `ClassName::foo`    |
| `x -> obj.bar(x)`         | `obj::bar`          |
| `(a,b) -> a.compareTo(b)` | `String::compareTo` |
| `() -> new Book()`        | `Book::new`         |

---

## 🏗 Constructor Reference

```java
Supplier<ArrayList<String>> list1 = () -> new ArrayList<>();
Supplier<ArrayList<String>> list2 = ArrayList::new;
```

---


## 🎯 When to Use What?

| Interface | Use When                |
| --------- | ----------------------- |
| Predicate | Checking conditions     |
| Function  | Transforming data       |
| Consumer  | Performing actions      |
| Supplier  | Generating data         |
| Bi*       | Working with two inputs |

---

