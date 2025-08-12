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


