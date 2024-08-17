# Kafka-Example
Introduction to the Apache Kafka Software - Based upon Amigoscode Youtube Tutorial https://www.youtube.com/watch?v=SqVfCyfCJqw&t=2194s

# Run instructions
* To run locally, Download latest kafka tgz file from https://kafka.apache.org/downloads, and use the following command to run zookeeper and kafka. 
    * .\bin\windows\zookeeper-server-start.bat  .\config\zookeeper.properties
    * .\bin\windows\kafka-server-start.bat .\config\server.properties
* You may need to update the properties file with different dataDir variables.
* Once these are running you can start the Springboot application.
* You can interact with the service in a number of ways.
* 1) Run .\bin\windows\kafka-console-consumer.bat --topic kafkaExample --from-beginning --bootstrap-server localhost:9092 
    * This will create a consumer server. If you populate the topic, you will see the newly added records here as they are consumed by the server.
* 2) To add to producer and subsequently to the topic, one can use the api/v1/messages end point in the message controller, posting to the localhost port of the spring application with the following json {"message": "Api with Kafka"}
* You will be able to see this on the running consumer in your command line set up previously.

# File/Revision Notes
When run locally, apache kafka all runs on port 9092. Producers, Topics and Consumers are all hosted there (In a real-world setting these would be distributed across many servers)

* KafkaApplication.java	Runs on start up, uses the 'kafkaTemplate' producer defined in KafkaProducerConfig to insert records into the Topic
* KafkaListeners.java	Utilises the @KafkaListener annotation to listen for and print out records from the topic (i.e is a consumer)
* MessageController.java	Restful api controller with a 'publish' endpoint that puts the request data into the kafkaExample topic
* MessageRequest.java	Class defining a message to be recieved by a post request

* KafkaProducerConfig	configures and defines the kafktemplate (i.e a producer) the data going into apache kafka. We have a factory method as this config class could be used to define multiple producers
* KafkaTopicConfig	defines the kafka topic by using the TopicBuilder
* KafkaConsumerConfig	Configures and defines the consumer. A consumer created by this factory will listen for data from the topic
