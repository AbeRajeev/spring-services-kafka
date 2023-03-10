package co.rapidwriter.springkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${spring.kafka.topic.name}")
    private String topicName;

    @Value("${spring.kafka.topic-json.name}")
    private String topicJsonName;
    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("javaguides")
                //.partitions(10) // we can set the number of partitions, not using right now
                //.replicas(1) // we can set the number of replicas, not using right now
                .build();
    }

    @Bean
    public NewTopic javaguidesJsonTopic(){
        return TopicBuilder.name(topicJsonName)
                .build();
    }
}
