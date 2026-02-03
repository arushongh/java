# Java Comparable and Comparator

```java
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CompareDemo {
    public static void main(String[] args) {
        /**
         * Comparable is an interface in Java that defines a natural ordering for objects of a class.
         * It contains a single method, int compareTo(), which compares the current object with another object of
         * the same type.
         *
         * compareTo() returns:
         * - a negative value when this object is less than the specified object.
         * - 0 when this object is equal to the specified object.
         * - a positive value when this object is greater than the specified object.
         */
        class Student implements Comparable<Student> {
            String name;
            int marks;
            int age;
            double salary;

            public Student(String name, int marks, int age, double salary) {
                this.name = name;
                this.marks = marks;
                this.age = age;
                this.salary = salary;
            }

            // Natural ordering: by marks
            @Override
            public int compareTo(Student other) {
                return Integer.compare(this.marks, other.marks);
            }

            @Override
            public String toString() {
                return name;
            }
        }

        // Creating Student objects
        Student s1 = new Student("Arush", 85, 20, 50000.0);
        Student s2 = new Student("Buny", 92, 22, 60000.0);
        Student s3 = new Student("Chatiii", 78, 19, 55000.0);

        // Using compareTo (natural order by marks)
        System.out.println(s1.compareTo(s2)); // Output: -1 (since 85 < 92)

        List<Student> students = new ArrayList<>(List.of(s1, s2, s3));

        // Sorting by natural order (marks)
        Collections.sort(students);
        System.out.println(students); // Output: [Chatiii, Arush, Buny]

        /**
         * Arrays can also be sorted using Comparable:
         * Student arr[] = {s1, s2, s3};
         * Arrays.sort(arr); // Sorted by marks
         */

        /**
         * Why do we have Comparable's compareTo() and Comparator's compare()?
         * - Comparable: defines the **natural ordering** of a class. Implemented inside the class.
         * - Comparator: allows **custom ordering** without modifying the class. Useful for multiple sorting strategies.
         */

        // Sort by name using Comparator
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.name.compareTo(s2.name);
            }
        });
        System.out.println(students); // Output: [Arush, Buny, Chatiii]

        // Sort by age using lambda expression
        Collections.sort(students, (o1, o2) -> Integer.compare(o1.age, o2.age));
        System.out.println(students); // Output: [Chatiii, Arush, Buny]

        // Sort by salary using Comparator.comparing
        Collections.sort(students, Comparator.comparing(s -> s.salary));
        // Alternative: Comparator.comparingDouble(s -> s.salary)
        System.out.println(students); // Output: [Arush, Chatiii, Buny]

        // Sort by name length
        students.sort((o1, o2) -> Integer.compare(o1.name.length(), o2.name.length()));
        System.out.println(students); // Output: [Buny, Arush, Chatiii]

        // Sort in reverse order of name length
        students.sort(Comparator.comparingInt(o1 -> ((Student) o1).name.length()).reversed());
        System.out.println(students); // Output: [Chatiii, Arush, Buny]
    }
}
```

## Summary

* **Comparable**

    * Interface inside the class.
    * Defines **natural ordering** using `compareTo()`.
    * Only one natural ordering per class.

* **Comparator**

    * Separate interface.
    * Allows **custom ordering** using `compare()`.
    * Multiple comparators can exist for one class.
    * For example : we can sort students by name or by marks or by age ...

* **In Short**
    
  * compareTo is for natural ordering i.e; when we do Collections.sort(list) or Arrays.sort(arr) this is the way to go
    whereas compare is useful at the time of sorting when we want to sort in our own custom way.
  
* **Sorting Techniques in Java**

    * `Collections.sort(list)` → uses `Comparable`.
    * `Collections.sort(list, comparator)` → uses custom `Comparator`.
    * Lambda expressions simplify comparator definitions.
    * `Comparator.comparing()` and `Comparator.comparingInt()` are concise ways to define comparators.

