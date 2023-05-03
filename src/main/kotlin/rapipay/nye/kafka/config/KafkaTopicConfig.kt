package rapipay.nye.kafka.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaTopicConfig {

    @Bean
    fun buildTopic(): NewTopic{

        return TopicBuilder.name("topic1").build()
    }

    @Bean
    fun buildJsonTopic(): NewTopic{

        return TopicBuilder.name("jsonTopic").build()
    }
}