# DSA & System Design Practice Repository

## 1. What is this Repository?

This repository is a comprehensive collection of solutions and implementations related to Data Structures, Algorithms, Low-Level Design (LLD), and System Design. It is primarily intended for personal revision and as a preparation toolkit for coding interviews. It covers a wide range of topics, from fundamental algorithms to complex system design case studies.

## 2. Why Use This Repository?

*   **One-Stop Solution**: It consolidates code for DSA, LLD, and System Design, saving you the effort of searching for resources across multiple places.
*   **Interview-Focused**: The content is curated for interview preparation, focusing on commonly asked questions and essential concepts, making it the best resource for interview practice and revision.
*   **Practical Implementations**: Instead of just theory, this repo provides working, runnable code for various systems like Parking Lots, Elevators, and Rate Limiters.
*   **Best for Revision**: The organized structure makes it easy to quickly revise a specific topic, whether it's a sorting algorithm or a design pattern.

## 3. How to Use This Repository

The repository is structured for easy navigation depending on your goal.

### For Brushing Up on DSA
- Start with the fundamentals in `/src/array`, `/src/recursion`, and `/src/sorting`.
- Review core data structure implementations in `/src/dsalgo/datastructure`.
- Practice problems from `/src/algorithm/leetcode` and `/src/gfg`.

### For LLD / System Design Interviews
- Study the SOLID principles in `/src/solidPrinciple`.
- Analyze the design patterns in `/src/designPattern`.
- Deep-dive into the case studies in the `/src/lld` directory (e.g., `/parkinglot`, `/cache`, `/atmv2`). Each is a self-contained project.
- Examine the larger, standalone system design projects like `rate-limiter`, `url-shortner`, and `dns-system`.

### Running the Code
- **Standard Java Files**: Most files in `src` can be compiled and run using `javac` and `java`.
  ```bash
  # From the root directory
  javac src/lld/parkinglot/Driver.java
  java -cp src lld.parkinglot.Driver
  ```
- **Maven Projects**: Projects like `rate-limiter` have their own `pom.xml` and should be run with Maven.
  ```bash
  cd rate-limiter
  ./mvnw clean install
  ```

## 4. Project Modules Overview

This repository contains several distinct modules:

-   `/src`: The main source folder containing core DSA, LLD, design patterns, and interview preparation code.
-   `/rate-limiter`: A standalone Maven project demonstrating rate-limiting algorithms.
-   `/consistent-hashing`: An implementation of the consistent hashing algorithm for distributed caching.
-   `/url-shortner`: A project for a URL shortening service.
-   `/dns-system`: A simulation of a basic DNS resolver.
-   `/logging-filter`: A Maven project for a logging and filtering service.
-   `/search-autocomplete`: A Trie-based search autocomplete service.

## 5. `src` Folder Deep Dive

The `/src` folder is the heart of this repository, organized into the following packages:

-   **`array`**: Solutions to common array-based coding problems.
-   **`algorithm`**: Implementations of various algorithms, including LeetCode solutions.
-   **`collections`**: Examples and use cases for the Java Collections Framework.
-   **`companies`**: Coding questions and problems asked by specific companies.
-   **`designPattern`**: Practical implementations of core Java and JEE design patterns.
-   **`dsalgo`**: Core data structures (Graph, Heap, Tree) and algorithm theory.
-   **`gfg`**: Problems sourced from GeeksforGeeks, categorized by topic.
-   **`interviewpreparingkit`**: A collection of notes, basics, and practice questions for interviews.
-   **`lld`**: Detailed, runnable solutions to classic Low-Level Design problems (Parking Lot, Elevator, ATM, etc.).
-   **`mathematics` / `gfg/maths`**: Implementations of mathematical algorithms (GCD, Factorial, Prime Factors).
-   **`mockInterview`**: Questions and solutions from mock interview sessions.
-   **`prcatice`**: A package for miscellaneous practice problems.
-   **`recursion`**: Solutions to classic recursion problems.
-   **`revision`**: A dedicated package for revising key data structures and algorithms.
-   **`solidPrinciple`**: Code examples demonstrating each of the five SOLID principles.
-   **`sorting`**: Implementations of various sorting algorithms like Bubble Sort.
-   **`stream`**: Examples using Java 8+ Stream API.
-   **`vectorandstack`**: Custom implementations and examples of stacks.

---

Created by: **Satish Yadav**
GitHub Profile: [https://github.com/Satish-yadav01]
<!---LeetCode Topics Start-->
# LeetCode Topics
## Array
|  |
| ------- |
| [0152-maximum-product-subarray](https://github.com/Satish-yadav01/DSA-practice/tree/master/0152-maximum-product-subarray) |
## Dynamic Programming
|  |
| ------- |
| [0152-maximum-product-subarray](https://github.com/Satish-yadav01/DSA-practice/tree/master/0152-maximum-product-subarray) |
<!---LeetCode Topics End-->