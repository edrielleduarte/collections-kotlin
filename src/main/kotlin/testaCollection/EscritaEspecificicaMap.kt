package testaCollection

fun main(){
    val pedidos: MutableMap<Int, Double> = mutableMapOf(Pair(1, 20.0), Pair(2, 30.0), 3 to 50.0, 4 to 100.0, 5 to 100.0, 6 to 80.0)

    println(pedidos + mapOf(7 to 90.0, 8 to 20.0))

    println(pedidos - 6)
    println(pedidos)

    println(pedidos  - listOf(5, 6))

    pedidos += (listOf(7 to 90.0, 8 to 20.0))
    println(pedidos)

    pedidos.keys.remove(1)
    println(pedidos)

    pedidos.values.remove(50.0)
    println(pedidos)

    pedidos.values.remove(100.00)
    println(pedidos)

    pedidos -= 6
    println(pedidos)
}