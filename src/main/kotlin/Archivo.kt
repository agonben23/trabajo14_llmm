import org.w3c.dom.Document
import org.w3c.dom.Element
import org.w3c.dom.Node
import org.w3c.dom.NodeList
import java.io.File
import javax.xml.parsers.DocumentBuilderFactory

class Archivo() {

    companion object {
        fun readXml(pathName: String): Document {
            val xmlFile = File(pathName)
            return DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile)
        }

        fun obtenerAtributosEnMapKV(e: Element): MutableMap<String, String> {
            val mMap = mutableMapOf<String, String>()
            for (j in 0 until e.attributes.length)
                mMap.putIfAbsent(e.attributes.item(j).nodeName, e.attributes.item(j).nodeValue)
            return mMap
        }

        fun obtenerListaNodosPorNombre(doc: Document, tagName: String): MutableList<Node> {
            val bookList: NodeList = doc.getElementsByTagName(tagName)
            val lista = mutableListOf<Node>()
            for (i in 0 until bookList.length)
                lista.add(bookList.item(i))
            return lista
        }
        fun exportXML(listaNotas: MutableList<Node>, file: File){
            var string = "<?xml version=\"1.0\"?>\n<notas>"
            listaNotas.forEach {
                string += "\n   <nota id=\"${obtenerAtributosEnMapKV(it as Element).getValue("id")}\">" +
                        "\n      <titulo>${it.getElementsByTagName("titulo").item(0).textContent}</titulo>" +
                        "\n      <fechaDeCreacion>${it.getElementsByTagName("fechaDeCreacion").item(0).textContent}</fechaDeCreacion>" +
                        "\n      <contenido>${it.getElementsByTagName("contenido").item(0).textContent}</contenido>" +
                        "\n   </nota>"
            }
            string += "\n</notas>"

            file.writeText(string)
        }
    }
}