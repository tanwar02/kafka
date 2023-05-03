package rapipay.nye.kafka.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import rapipay.nye.kafka.payload.User
import rapipay.nye.kafka.service.KafkaJsonProducer

@RestController
@RequestMapping("/nye/v1")
class JsonMessageController {

    var producer: KafkaJsonProducer

    constructor(_producer: KafkaJsonProducer){

        producer = _producer
    }

    @PostMapping("/publish")
    fun publish(@RequestBody user: User): ResponseEntity<String> {

        println(user)
        producer.sendMessage(user)
        return ResponseEntity.ok("Json Message sent to kafka topic.")
    }
}