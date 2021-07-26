package me.doflamingo.hackingspringbootch1reactive.reactive

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class ServerController(
    private val kitchenService: KitchenService
) {
    @GetMapping(value = ["/server"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun serverDishes() : Flux<Dish> {
        return this.kitchenService.getDishes()
    }
}
