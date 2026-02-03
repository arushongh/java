# Optional in Java

## Why Optional Exists

Before `Optional`, Java developers used `null` to represent "no value". This caused frequent **NullPointerExceptions**.

`Optional<T>` is simply a **container (box)** that:

* May contain a value
* Or may be empty

It forces the developer to **handle absence explicitly**.

---

## Code Example 

```java
import java.util.NoSuchElementException;
import java.util.Optional;

public class OptionalsDemo {
    public static void main(String[] args) {
        Optional<String>name = getValue();
        
            //Optional.empty() always returns a new instance of empty optional

            // if(name==Optional.empty()) { // since it is a reference comparison this will always be false
            //     System.out.println("it is indeed empty");
            // }

        // isPresent() method to check if value is present

        if(name.isPresent()) {
            System.out.println(name.get().toUpperCase());//get() method to get the value
        } else {
            System.out.println("Name is not present");
        }

        // ifPresent() method to execute action if value is present it takes Consumer functional interface
        name.ifPresent(x->System.out.println(x.toUpperCase()));

        // orElse() method to provide default value if value is not present
        String defaultName = name.orElse("Default Name");
        System.out.println(defaultName.toUpperCase());

        //orElseGet() method to provide default value using Supplier functional interface used when too much computation is involved in creating default value
        String defaultName2 = name.orElseGet(()->"Default Name from Supplier");
        System.out.println(defaultName2.toUpperCase());

        //orElseThrow() method to throw exception if value is not present
        try {
            String nameValue = name.orElseThrow(()->new NoSuchElementException("Name is not present"));
            System.out.println(nameValue.toUpperCase());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        //map() method to transform the value if present
        Optional<String> upperName = name.map(String::toUpperCase);
        upperName.ifPresent(x->System.out.println("Mapped Name: "+x));

        //filter() method to filter the value based on predicate
        Optional<String> filteredString = name.filter(x->x.startsWith("A"));
        filteredString.ifPresent(x->System.out.println("Filtered Name: "+x));

        //flatMap() method to transform the value using a function that returns an Optional
        


    }
    public static Optional<String>getValue() {
        String name = null;
        name="Arush";
        //return Optional.of(name); // This returns optionals and would throw NullPointerException if name is null
        //return Optional.ofNullable(name); // This returns optionals and is safe even if name is null
        return Optional.empty(); // This returns an empty optional
    }
    
}
```

---

## Line-by-Line Explanation

### Creating Optional

```java
Optional<String> name = getValue();
```

`name` may or may not contain a `String`. This removes the need for `null` checks.

---

### ❌ Why `name == Optional.empty()` is wrong

```java
// if(name==Optional.empty()) { ... }
```

* `==` compares **object references**, not meaning
* `Optional.empty()` is **not guaranteed** to return the same object every time

✅ Correct approach:

```java
name.isEmpty();
name.isPresent();
```

---

### isPresent() + get()

```java
if(name.isPresent()) {
    System.out.println(name.get().toUpperCase());
}
```

* `isPresent()` checks if value exists
* `get()` retrieves the value (unsafe if empty)

⚠️ `get()` should always be guarded by `isPresent()`

---

### ifPresent() (Cleaner & Safer)

```java
name.ifPresent(x -> System.out.println(x.toUpperCase()));
```

Executes code **only if value exists**. No `null`, no crash.

---

### orElse()

```java
String defaultName = name.orElse("Default Name");
```

* Returns actual value if present
* Otherwise returns default

⚠️ Default is **always created**, even if not used

---

### orElseGet()

```java
String defaultName2 = name.orElseGet(() -> "Default Name from Supplier");
```

* Default value created **only if Optional is empty**
* Use when default creation is expensive

---

### orElseThrow()

```java
name.orElseThrow(() -> new NoSuchElementException("Name is not present"));
```

Throws exception when value is missing.

Useful when absence is a **bug**, not a valid case.

---

### map() – Transform value

```java
Optional<String> upperName = name.map(String::toUpperCase);
```

* Transforms value if present
* Returns another Optional
* Does NOTHING if empty

---

### filter() – Keep or drop value

```java
Optional<String> filteredString = name.filter(x -> x.startsWith("A"));
```

* Keeps value only if condition is true
* Otherwise becomes empty

---

### getValue() Method

```java
return Optional.empty();
```

Represents "no value" **without using null**.

Comparison:

* `Optional.of(name)` → ❌ crashes if name is null
* `Optional.ofNullable(name)` → ✅ safe

---

## Rules to Remember 🧠🔥

* ✅ Use Optional for **return types**
* ❌ Never use Optional for fields or parameters
* ❌ Never compare using `== Optional.empty()`
* ✅ Prefer `map`, `filter`, `ifPresent`
* ⚠️ Avoid `get()` unless guarded

---

## One-Line Summary

> Optional is a safe container that forces you to handle missing values explicitly instead of using null.

---

