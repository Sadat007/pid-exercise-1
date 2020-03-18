import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;

public class XmlClass {

    //the list of all the bars , its static in order to use it in other class
    public static ArrayList<Bar> productBarList = new ArrayList<>();

    public  void ShowBars() {

        for (int i = 0; i < productBarList.size(); i++) {
          System.out.println("Bar_SN : " + productBarList.get(i).getName());
        }
    }


    public void fetchData() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {

            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File("bars.xml"));

            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            NodeList children = root.getElementsByTagName("bar");

            for (int counter = 0; counter < children.getLength(); counter++) {

                NodeList grandGrandChildren = null;
                int iterator = 0;
                int reviewerCount = 0;

                Element element = (Element) children.item(counter);

                NodeList grandchildren = children.item(counter).getChildNodes();
                while (!grandchildren.item(iterator).getNodeName().equals("review") && iterator < grandchildren.getLength()) {
                    iterator++;
                }
                if (grandchildren.item(iterator).getNodeName().equals("review")) {
                    grandGrandChildren = grandchildren.item(iterator).getChildNodes();
                }

                for (int count = 0; count < grandGrandChildren.getLength(); count++) {
                    if (grandGrandChildren.item(count).getNodeName().equals("reviewer")) {
                        reviewerCount++;
                    }
                }

                String name = element.getAttribute("SN");
                String fat = element.getElementsByTagName("fett").item(0).getTextContent();
                String energy = element.getElementsByTagName("energy").item(0).getTextContent();
                String kolhydrat = element.getElementsByTagName("kolhydrat").item(0).getTextContent();
                String protein = element.getElementsByTagName("protein").item(0).getTextContent();
                String fiber = element.getElementsByTagName("fiber").item(0).getTextContent();

                Double fatDouble = Double.valueOf(fat);
                Double energyDouble = Double.valueOf(energy);
                Double kolhydratDouble = Double.valueOf(kolhydrat);
                Double proteinDouble = Double.valueOf(protein);
                Double fiberDouble = Double.valueOf(fiber);
                Bar newBar = new Bar(name, fatDouble, energyDouble, kolhydratDouble, proteinDouble, fiberDouble, reviewerCount);

                //Adding the bar class to my arraylist of bar
                productBarList.add(newBar);
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}






    /*DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse("bars.xml");

    // read the data from document sequentially
    // get the root element from Document obj

    Element rootElement = document.getDocumentElement();
    // get the child elements
    NodeList children = rootElement.getChildNodes();
    Node current = null;

    // get the node object from NodeList
            for (int i =0; i<children.getLength(); i++){
        current = children.item(i);

        if(current.getNodeType() == current.ELEMENT_NODE) {

            Element element = (Element) current;
            if (element.getTagName().equalsIgnoreCase("tableOfContents")) {
                rootElement.removeChild(element);
            }



            // System.out.println(node.getNodeName() + "-->" + node.getTextContent());
        }
    }
            System.out.println(document.getDocumentElement());
}
        catch (Exception e){
                System.out.println(e.getMessage());

                }*/