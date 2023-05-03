package rapipay.nye.kafka.service

import org.apache.kafka.common.protocol.types.ArrayOf
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service
import rapipay.nye.kafka.payload.User

@Service
class KafkaJsonConsumer {

    var logger: Logger = LoggerFactory.getLogger(this::class.java)

    @KafkaListener(topics = ["jsonTopic"], groupId = "group")
    fun consumeJsonData(user: User){

        logger.info("json message recieved : $user")
    }
}