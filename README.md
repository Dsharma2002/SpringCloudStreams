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

