# product-publisher

A log-based architecture powered by Apache Kafka for publishing Product Data. This PoC was inspired by the article [Publishing with Apache Kafka at The New York Times](https://www.confluent.io/blog/publishing-apache-kafka-new-york-times/). To properly understand the benefits and concept of this architecture is recommended to read the article.

The stack used is:

* Spring Boot 2
* Spring Kafka 
* Spring Data JPA
* Spring Data ElasticSearch

## Overview

This Proof of Concept tests a simple data publishing workflow.

* products - As an example of producer, the Simple Product Data Service for each change in a product publishes the change to the Publishing Gateway
* products-publisher-gateway - Receives data for Products from different sources and sends it to the Kafka log
* products-indexer - As an example of consumer, the Products Indexer reads the Kafka log and index the Product data to the ElasticSearch (this ElasticSearch is supposed to be used by the search feature on the websites and native apps)

## Setup the environment to test the PoC

Start a Kafka instance (https://gist.github.com/abacaphiliac/f0553548f9c577214d16290c2e751071)
```shell
docker run -d -p 2181:2181 -p 9092:9092 --env ADVERTISED_HOST=kafka --env ADVERTISED_PORT=9092 --name kafka -h kafka spotify/kafka
```

Create the `products` Topic
```shell
docker exec kafka /opt/kafka_2.11-0.10.1.0/bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic products
```

Start an ElasticSearch instance (https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html)
```shell
docker run -d -p 9200:9200 -p 9300:9300 --name elasticsearch -h elasticsearch --env "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:6.2.2
```

You can, also, start a consumer using the shell to monitor the messages
```shell
docker run -it --rm --link kafka spotify/kafka /opt/kafka_2.11-0.10.1.0/bin/kafka-console-consumer.sh --bootstrap-server kafka:9092 --topic products --from-beginning
```
