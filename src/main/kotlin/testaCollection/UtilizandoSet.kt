package testaCollection

fun main(){
    val assistirCursoAndroid: Set<String> = setOf("Edrielle", "Ariane", "Carlos", "Camila", "Flor", "Neguinha")
    val assistirCursoKotlin: Set<String> =  setOf("Rosane", "Edrielle", "Flor", "Jessica", "Carla", "Ramon", "Carlos")

//    val assistirAmbos = assistirCursoAndroid + assistirCursoKotlin
    val assistirAmbos = mutableSetOf<String>()
    assistirAmbos.addAll(assistirCursoAndroid)
    assistirAmbos.addAll(assistirCursoKotlin)
    assistirAmbos.add("Ana")
    println(assistirAmbos)

    println(assistirAmbos union(assistirCursoAndroid  + assistirCursoKotlin))

    println(assistirCursoKotlin - assistirCursoAndroid)
    println(assistirCursoAndroid subtract(assistirCursoKotlin))
    println(assistirCursoAndroid.subtract(assistirCursoKotlin))

    println(assistirCursoAndroid.intersect(assistirCursoKotlin))
    println(assistirCursoKotlin intersect(assistirCursoAndroid))

    val assistiramList = assistirAmbos.toMutableList()

    assistiramList.add("Edrielle")
    println(assistiramList)
    println(assistiramList.distinct())

}