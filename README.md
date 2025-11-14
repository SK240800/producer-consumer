Producer–Consumer System
Java · Multithreading · Synchronization · Maven · Docker

This project implements the Producer–Consumer Pattern using Java multithreading, synchronized shared buffer logic, and a complete pipeline to validate correctness.
It includes full Maven build support, JUnit tests, and Docker containerization for easy execution.


Features
✔ Producer

Reads items from a predefined source list

Inserts items into the shared buffer

Waits when buffer is full

✔ Consumer

Reads items from the shared buffer

Writes results into a destination list

Waits when buffer is empty

✔ Shared Buffer (Synchronized)

Custom implementation using wait() and notifyAll()

Thread-safe operations

Fixed capacity

✔ Analysis Utilities

Validates whether all items were transferred

Ensures order preservation

Detects missing items

✔ Complete Pipeline

Runs producer and consumer threads together and generates a verification report.

📂 Project Structure
producer-consumer/
 ├── src/
 │   ├── main/java/com/example/producerconsumer/
 │   │     ├── Producer.java
 │   │     ├── Consumer.java
 │   │     ├── SharedBuffer.java
 │   │     ├── AnalysisUtils.java
 │   │     └── ProducerConsumerPipeline.java
 │   └── test/java/com/example/producerconsumer/
 │         ├── AnalysisUtilsTest.java
 │         └── ProducerConsumerPipelineTest.java
 ├── Dockerfile
 ├── pom.xml
 └── README.md

🧪 Running Unit Tests
mvn test

🔨 Build the Application (JAR)
mvn clean package -DskipTests


This generates:

target/producer-consumer-1.0.0.jar

🐳 Run Using Docker
1️⃣ Build the Docker image
docker build -t producer-consumer .

2️⃣ Run the container
docker run producer-consumer

Example Output
== Running Producer-Consumer Pipeline ==
Source       : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Destination  : [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

== Analysis Results ==
All items transferred : true
Order preserved       : true
Missing items         : []

🛠 Technologies Used

Java 17

Maven 3.9+

JUnit 5

Docker

Multithreading (wait/notifyAll)

📘 How It Works (High-Level Flow)

Producer generates items → adds to SharedBuffer

SharedBuffer blocks producer if full, blocks consumer if empty

Consumer removes items → stores in destination list

AnalysisUtils validates:

All items transferred

Order preserved

No data loss

Pipeline prints the final results

👤 Author
Kiran (SK240800)
