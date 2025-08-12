Start Docker image for Kafka on Docker Desktop

Start the producer application
ProducerApplication.java

get docker container id
docker ps

get messages for topic my-topic
docker exec -it id /opt/kafka/bin/kafka-console-consumer.sh \
  --topic my-topic \
  --from-beginning \
  --bootstrap-server localhost:9092

or alternatively Start the consumer application
ConsumerApplication.java

and test post request to http://localhost:8080/api/send?message=message on postman


# Note

**Jackson Deserialization Error – No Creators like Default Constructor**
This happens when Jackson receives JSON for a class without a no-args constructor or `@JsonCreator` annotated all-args constructor. By default, Jackson creates an empty object using a no-args constructor, then populates fields via setters. If no such constructor exists, it fails.  
**Fix:** Add a public no-args constructor (and setters) or annotate the all-args constructor with `@JsonCreator` and each parameter with `@JsonProperty`.  


## Functional Interfaces in Java

A **functional interface** is an interface with exactly **one abstract method**.  
It can have default and static methods, but only one unimplemented method.  
They are the foundation for **lambda expressions** and **method references** in Java.

Example:
```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

## Spring Cloud Function

Spring Cloud Function is a framework that lets you write a single piece of business logic as a **Java function**  
(`Supplier`, `Function`, or `Consumer`) and run it in multiple environments without changing the code.  

You can bind the same function to:
- **HTTP endpoints** (like a REST API)
- **Message brokers** (e.g., Kafka, RabbitMQ)
- **Serverless platforms** (e.g., AWS Lambda, Azure Functions)

**Key benefits:**
- **Write once, run anywhere** – the same function can work for HTTP, messaging, or serverless just by changing configuration.
- Encourages **functional programming style** in Spring.
- Reduces boilerplate code by focusing only on business logic.

**Example:**
```java
@Bean
public Function<String, String> uppercase() {
    return value -> value.toUpperCase();
}
