import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class XmlReader {
    public static void readFromXML() {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bf = factory.newDocumentBuilder();
            Document doc = bf.parse("src/test.xml");
            NodeList newspapers = doc.getElementsByTagName("channel");

            for (int i = 0; i < newspapers.getLength(); i++) {
                Element channel = (Element) newspapers.item(i);
                Attr idAttr = doc.createAttribute("id");
                idAttr.setValue(" ");
                channel.setAttributeNode(idAttr);
                NodeList childs = channel.getChildNodes();

                for (int j = 0; j < childs.getLength(); j++) {
                    Node child = childs.item(j);
                    if (child.getNodeName().equals("name"))
                        System.out.println("<name> The Newspaper is:" + child.getFirstChild().getNodeValue());
                    if (child.getNodeName().equals("description"))
                        System.out.println("<description> Description:" + child.getFirstChild().getNodeValue());
                    if (child.getNodeName().equals("item")) {
                        NodeList items = child.getChildNodes();
                        for (int k = 0; k < items.getLength(); k++) {
                            Node item = items.item(k);
                            if (item.getNodeName().equals("name"))
                                System.out.println(" <name> is title of:" + item.getFirstChild().getNodeValue());
                            if (item.getNodeName().equals("source"))
                                System.out.println(" <source> is source of:" + item.getFirstChild().getNodeValue());
                            if (item.getNodeName().equals("description"))
                                System.out.println("<item> / <description> :" + item.getFirstChild().getNodeValue());
                        }
                    }
                }
            }
            writeToXml(doc, "/test1.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void writeToXml(Document doc, String wayToFile) {
        try {
            xmlwrite(doc, wayToFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    static void xmlwrite(Document doc, String wayToFile) throws TransformerException, IOException {
        OutputStream fileOutputStream = new FileOutputStream(wayToFile);
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(fileOutputStream);
        transformer.transform(source, result);
        fileOutputStream.close();
    }
}
