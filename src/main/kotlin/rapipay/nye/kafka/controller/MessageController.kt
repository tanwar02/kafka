package rapipay.nye.kafka.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import rapipay.nye.kafka.service.KafkaProducerService

@RestController
@RequestMapping("/nye/v1")
class MessageController {

    var producer: KafkaProducerService

    constructor(_producer: KafkaProducerService){

        producer = _producer
    }

    @GetMapping("/publish")
    fun publish(@RequestParam("message") message: String): ResponseEntity<String>{

        producer.sendMessage(message)
        return ResponseEntity.ok("Message sent to kafka topic.")
    }
}