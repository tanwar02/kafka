package rapipay.nye.kafka.service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service
import rapipay.nye.kafka.payload.User

@Service
class KafkaJsonProducer {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)
    var template: KafkaTemplate<String, User>

    constructor(template: KafkaTemplate<String, User>) {
        this.template = template
    }

    fun sendMessage(user: User){

        logger.info("message sent : $user")
        var message: Message<User> = MessageBuilder.withPayload(user).setHeader(KafkaHeaders.TOPIC, "jsonTopic").build()
        logger.info("##################################")
        template.send(message)
    }
}