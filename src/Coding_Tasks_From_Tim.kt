fun main() {
    println("Welcome to the FruitDealer2020")
    println("Apples: \$.60, Oranges \$.25")
    println("What can I get for you?")

    val userOrder = readLine()
    if(userOrder != null) {
        order_parse(userOrder)
    }


}

fun order_parse(userOrder:String){
    var delimiter = " "
    val orderItems = userOrder.split(delimiter)

    var apples = 0.0
    var oranges = 0.0

    if (orderItems != null){
        for(current_item in orderItems.indices)
        {
            when(orderItems[current_item]){
                "apple"-> {
                    apples+=.6
                }
                "orange"->{
                    oranges+=.25
                }
                else-> {
                    println("Item $current_item was unable to be read")
                }
            }
        }
    }
    println("Total: \$ ${apples+oranges}")

}