import java.time.LocalDate
import java.util.*

fun main() {
    println("Welcome to the FruitDealer2020")
    println("Apples: \$.60 or Buy 1 get 1 free!\n" +
            " Oranges \$.25 or Buy 2 get 1 free!")
    println("What can I get for you?")

    val userOrder = readLine()
    if(userOrder != null) {
        order_parse(userOrder)
    }

    var arrival = Calendar.getInstance()
    arrival.add(Calendar.DAY_OF_YEAR, 7)
    println("Your order has been placed! It will arrive on ${arrival.time}")
}

fun order_parse(userOrder:String){
    var delimiter = " "
    val orderItems = userOrder.split(delimiter)

    var apples = 0
    var oranges = 0

    val apple_stock = 5
    val orange_stock = 3

    var sold_apples = 0
    var sold_oranges = 0

    if (orderItems != null){
        for(current_item in orderItems.indices)
        {
            when(orderItems[current_item]){
                "apple"-> {
                    if(apples < apple_stock) {
                        apples++
                    }
                    else{
                        if(sold_apples ==0){
                            println("Sorry, only $apple_stock apples are available")
                            sold_apples++ //flag to ensure we only print this message once
                        }
                    }
                }
                "orange"->{
                    if(oranges < orange_stock) {
                        oranges++
                    }
                    else{
                        if(sold_oranges ==0){
                            println("Sorry, only $orange_stock oranges are available")
                            sold_oranges++ //flag to ensure we only print this message once
                        }
                    }
                }
                else-> {
                    println("Item $current_item was unable to be read")
                }
            }
        }
    }
    val total = special_deals(apples, oranges)
    println("Total: \$ %.2f".format(total))



}

fun special_deals(apples:Int, oranges:Int):Double{
    val special_apples = apples/2 * .60 //apples where the deal applies
    val not_special_apples = apples%2 * .60 //apples which are full price

    val special_oranges = oranges/3 *.50 //oranges where the deal applies (co
    val not_special_oranges = oranges%3 *.25 //oranges which are full price

    return special_apples + not_special_apples + special_oranges + not_special_oranges


}