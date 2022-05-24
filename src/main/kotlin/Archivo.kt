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
    }
}