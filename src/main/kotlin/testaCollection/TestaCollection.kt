package testaCollection

fun main(){
    val assistirCursoAndroid: List<String> = listOf("Edrielle", "Ariane", "Carlos", "Camila")
    val assistirCursoKotlin: List<String> = listOf("Rosane", "Jessica", "Carla", "Ramon")
    val assistirAmbos: MutableList<String> = mutableListOf<String>()
    assistirAmbos.addAll(assistirCursoAndroid)
    assistirAmbos.addAll(assistirCursoKotlin)
    println(assistirAmbos)

}


fun outroTeste(){
    val assistirCursoAndroid: List<String> = listOf("Edrielle", "Ariane", "Carlos", "Camila")
    val assistirCursoKotlin: List<String> = listOf("Rosane", "Edrielle", "Carlos", "Jessica", "Carla", "Ramon")

    val assistirAmbos: List<String> = assistirCursoAndroid + assistirCursoKotlin
    println(assistirAmbos.distinct())
}