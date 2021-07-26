package me.doflamingo.hackingspringbootch1reactive.reactive

import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import java.time.Duration
import java.util.*


@Service
class KitchenService {

    private val menu = listOf(
        Dish("Sesame chicken"),
        Dish("Lo mein noodles. plain"),
        Dish("Sweet & sour beef")
    )
    private val picker = Random()

    fun getDishes() : Flux<Dish> {

        return Flux.generate<Dish>{sink -> sink.next(randomDish())}
            .delayElements(Duration.ofMillis(250))
    }

    private fun randomDish(): Dish {
        val menuUnit = menu[picker.nextInt(menu.size)]
        println(menuUnit)
        return menuUnit
    }

}