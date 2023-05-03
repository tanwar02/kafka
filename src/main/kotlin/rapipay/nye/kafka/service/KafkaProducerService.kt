package rapipay.nye.kafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class KafkaProducerService {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)
    val template: KafkaTemplate<String, String>

    constructor(_template: KafkaTemplate<String, String>){

        template = _template
    }

    fun sendMessage(message: String){

        logger.info("message sent : $message")
        template.send("topic1", message)
    }
}