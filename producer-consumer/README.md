# Producer–Consumer Pattern with Thread Synchronization (Java)

This project implements the classic **producer–consumer** pattern using:

- `synchronized`, `wait()`, and `notifyAll()` for **thread synchronization**
- A bounded queue (`SharedBuffer`) acting as a **blocking queue**
- Separate `Producer` and `Consumer` threads
- Simple **analysis methods** to verify the correctness of data transfer

## Requirements

- Java 17+
- Maven 3.8+

## Project Structure

- `src/main/java/com/example/producerconsumer`
  - `SharedBuffer.java` — bounded blocking buffer with wait/notify
  - `Producer.java` — reads from a source container and produces to buffer
  - `Consumer.java` — consumes from buffer into destination container
  - `AnalysisUtils.java` — analysis/verification methods
  - `ProducerConsumerPipeline.java` — wires everything together
  - `ProducerConsumerApp.java` — main entry point
- `src/test/java/com/example/producerconsumer`
  - `AnalysisUtilsTest.java` — unit tests for all analysis methods
  - `ProducerConsumerPipelineTest.java` — integration-style test for the pipeline

## How to Build

```bash
mvn clean install
