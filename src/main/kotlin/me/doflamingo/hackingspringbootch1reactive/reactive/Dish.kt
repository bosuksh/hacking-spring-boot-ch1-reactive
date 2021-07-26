package me.doflamingo.hackingspringbootch1reactive.reactive

data class Dish(
    var description: String,
    private var delivered: Boolean = false
) {

    fun isDelivered() : Boolean {
        return delivered
    }

    companion object {
        fun deliver(dish: Dish) : Dish{
            val deliveredDish  = Dish(dish.description)
            deliveredDish.delivered = true
            return deliveredDish
        }
    }
}
