package rapipay.nye.kafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumerService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = arrayOf("topic1"), groupId = "group")
    fun consumeMessage(message: String){

        logger.info("message recieved : $message")
    }
}