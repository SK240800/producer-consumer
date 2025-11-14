📦 Producer–Consumer System (Java | Multithreading | Dockerized)

A full implementation of the classic Producer–Consumer pattern using:

✔ Java
✔ Multithreading (Thread, wait(), notifyAll())
✔ Thread synchronization
✔ Shared buffer
✔ Analysis utilities
✔ Unit tests
✔ Maven build
✔ Docker containerization

🚀 Features
Producer

Reads elements from a source list

Places items into a shared buffer

Blocks when buffer is full

Consumer

Reads elements from the shared buffer

Writes items to the destination list

Blocks when buffer is empty

Shared Buffer

Fully synchronized

Uses wait() / notifyAll()

Analysis Utilities

Confirms all items were transferred

Checks order preservation

Detects missing items

🧪 Running Unit Tests
mvn test

🧱 Build the Project
mvn clean package -DskipTests


This generates:

target/producer-consumer-1.0.0.jar

🐳 Running With Docker
1. Build the Docker image
docker build -t producer-consumer .

2. Run the container
docker run producer-consumer

Output example:
== Running Producer-Consumer Pipeline ==
Source:       [1,2,3,4,5,6,7,8,9,10]
Destination:  [1,2,3,4,5,6,7,8,9,10]

== Analysis Results ==
All items transferred : true
Order preserved        : true
Missing items          : []

📂 Project Structure
producer-consumer/
 ├── src/main/java/com/example/producerconsumer
 │    ├── Producer.java
 │    ├── Consumer.java
 │    ├── SharedBuffer.java
 │    ├── ProducerConsumerPipeline.java
 │    └── AnalysisUtils.java
 ├── src/test/java/com/example/producerconsumer
 │    ├── AnalysisUtilsTest.java
 │    └── ProducerConsumerPipelineTest.java
 ├── Dockerfile
 ├── pom.xml
 └── README.md

📝 Technologies Used

Java 17

Maven

Docker

JUnit 5

Multithreading primitives

Blocking queue logic (custom)

👩‍💻 Author

Kiran (SK240800)
