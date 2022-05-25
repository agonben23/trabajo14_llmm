import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import kotlin.system.exitProcess

class GestorNotas(private val cargador: String) {

    init {
        try {
            val xmlDoc = Archivo.readXml(cargador)
        }   catch (FileNotFoundException : Exception) {
            println("Archivo no encontrado")
            exitProcess(-1)
        }
    }

    companion object{
        const val menu = "¿Qué deseas hacer?\n-r Mostrar todos las notas\n-r [id] Muestra la nota con la id elegida\n-m [id] Modifica la nota seleccionada\n-d [id] Elimina la nota seleccionada\n-exit Salir del programa\n"
    }

    private var listaNotas = Archivo.obtenerListaNodosPorNombre(Archivo.readXml(cargador), "nota")

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

    fun modificarNota(idNota:String) {
        val mapeoElementos = mutableMapOf<String, Node>()
        listaNotas.forEach {
            val elemento = it as Element
            val id = Archivo.obtenerAtributosEnMapKV(elemento).getValue("id")
            mapeoElementos.putIfAbsent(id, elemento)
        }
        val nota = mapeoElementos.getValue(idNota)
        val notaNueva = mapeoElementos.getValue(idNota)

        val notaChilds = notaNueva.childNodes

        for (i in notaChilds.getRange()) {

            if (notaChilds.item(i).nodeName == "titulo") {
                println("introduzca el nuevo título (no introduzca nada si no desea cambiarlo)")
                val nuevoTitulo = readln()
                if (nuevoTitulo != "") {
                    notaChilds.item(i).nodeValue = nuevoTitulo
                }
            }

            if (notaChilds.item(i).nodeName == "contenido") {
                println("introduzca el nuevo contenido (no introduzca nada si no desea cambiarlo)")
                val nuevoContenido = readln()
                if (nuevoContenido != "") {
                    notaChilds.item(i).nodeValue = nuevoContenido
                }
            }

        }

        listaNotas.remove(nota)
        listaNotas.add(notaNueva)

        listaNotas = listaNotas.sortedBy { Archivo.obtenerAtributosEnMapKV(it as Element).getValue("id") } as MutableList<Node>

        Archivo.exportXML(listaNotas, File(cargador))
    }

    fun eliminarNota(idNota:String){
        val mapeoElementos = mutableMapOf<String, Node>()
        listaNotas.forEach {
            val elemento = it as Element
            val id = Archivo.obtenerAtributosEnMapKV(elemento).getValue("id")
            mapeoElementos.putIfAbsent(id, elemento)
        }
        val nota = mapeoElementos.getValue(idNota)
        listaNotas.remove(nota)
        Archivo.exportXML(listaNotas, File(cargador))
    }

    private fun imprimirNota(node: Node){
        println("---- Nota id: ${Archivo.obtenerAtributosEnMapKV(node as Element).getValue("id")} --------------")
        println("Título : ${node.getElementsByTagName("titulo").item(0).textContent}")
        println("Fecha de creacion : ${node.getElementsByTagName("fechaDeCreacion").item(0).textContent}")
        println("Contenido : ${node.getElementsByTagName("contenido").item(0).textContent}")
        println("----------------------------------\n")
    }

}

fun NodeList.getRange(): IntRange {
    return IntRange(0,this.length -1)
}