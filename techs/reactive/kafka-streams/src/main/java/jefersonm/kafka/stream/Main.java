package jefersonm.kafka.stream;

import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStreamBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.processor.WallclockTimestampExtractor;

import java.util.Properties;

/**
 * Created by jefersonm on 6/15/16.
 */
//http://docs.confluent.io/3.0.0/streams/developer-guide.html
public class Main {

    public static void main(String[] args){

        // When you want to override serdes explicitly/selectively
        final Serde<String> stringSerde = Serdes.String();

        KStreamBuilder builder = new KStreamBuilder();

        // Method 1: Read the input Kafka topic `TextLinesTopic` into a KStream instance.
        KStream<String, String> textLines = builder.stream(stringSerde, stringSerde, "TextLinesTopic");

        // Write (i.e. persist) the results to a new Kafka topic called "UppercasedTextLinesTopic".
        KStream<String, String> uppercasedWithMapValues = textLines.mapValues(String::toUpperCase);
        uppercasedWithMapValues.to("UppercasedTextLinesTopic");

        // Method 2: using `map`, modify value only (equivalent to method 1)
        KStream<String, String> uppercasedWithMap = textLines.map((key, value) -> new KeyValue<>(key, value.toUpperCase()));

        // Method 3: using `map`, modify both key and value
        KStream<String, String> originalAndUppercased = textLines.map((key, value) -> KeyValue.pair(value, value.toUpperCase()));

        // Write the results to a new Kafka topic `OriginalAndUppercased`.
        originalAndUppercased.to(stringSerde, stringSerde, "OriginalAndUppercased");

        StreamsConfig config = new StreamsConfig(getProperties());
        KafkaStreams kafkaStreams = new KafkaStreams(builder, config);
        kafkaStreams.start();
    }

    private static Properties getProperties() {
        Properties props = new Properties();
        props.put(StreamsConfig.CLIENT_ID_CONFIG, "Kafka-Streams-Analysis");
        props.put("group.id", "kafka-streams");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "kafka-streams-id");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(StreamsConfig.ZOOKEEPER_CONNECT_CONFIG, "localhost:2181");
        props.put(StreamsConfig.REPLICATION_FACTOR_CONFIG, 1);
        props.put(StreamsConfig.TIMESTAMP_EXTRACTOR_CLASS_CONFIG, WallclockTimestampExtractor.class);

        // When configuring the default serdes of StreamConfig
        props.put(StreamsConfig.KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        props.put(StreamsConfig.VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());

        return props;
    }

}
