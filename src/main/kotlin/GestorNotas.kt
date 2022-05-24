import org.w3c.dom.Element
import org.w3c.dom.Node
import kotlin.system.exitProcess

class GestorNotas(cargador: String) {

    init {
        try {
            val xmlDoc = Archivo.readXml(cargador)
        }   catch (FileNotFoundException : Exception) {
            println("Archivo no encontrado")
            exitProcess(-1)
        }
    }

    private val listaNotas = Archivo.obtenerListaNodosPorNombre(Archivo.readXml(cargador), "nota")

    fun imprimirTodasLasNotas() = listaNotas.forEach{ imprimirNota(it)}

    fun buscarNota(idNota:String){
        val mapeoElementos = mutableMapOf<String, Node>()
        listaNotas.forEach{
            val elemento = it as Element
            val id = Archivo.obtenerAtributosEnMapKV(elemento).getValue("id")
            mapeoElementos.putIfAbsent(id,elemento)
        }
        val nota = mapeoElementos.getValue(idNota)
        imprimirNota(nota)
    }

    private fun imprimirNota(node: Node){
        println("---- Nota id: ${Archivo.obtenerAtributosEnMapKV(node as Element).getValue("id")} --------------")
        println("Título : ${node.getElementsByTagName("titulo").item(0).textContent}")
        println("Fecha de creacion : ${node.getElementsByTagName("fechaDeCreacion").item(0).textContent}")
        println("Contenido : ${node.getElementsByTagName("contenido").item(0).textContent}")
        println("----------------------------------\n")
    }
}