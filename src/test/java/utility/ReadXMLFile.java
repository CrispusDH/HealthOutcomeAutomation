package utility;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.*;


public class ReadXMLFile {
    private static String neededConstant;

    public static String takeConstantFromXML(String TagName, String Name, String InnerTagName) {

        try {
            File fXmlFile = new File("constant.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName(TagName);
            /*for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("name").equals(Name)){
                        neededConstant = eElement.getElementsByTagName(InnerTagName).item(0).getTextContent();
                    }
                }
            }*/
            int temp =0;
            boolean statement = true;
            //System.out.println(TagName + " " + Name + " " + InnerTagName );
            do {
                Node nNode = nList.item(temp);
                temp +=1;
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    if (eElement.getAttribute("name").equals(Name)){
                        neededConstant = eElement.getElementsByTagName(InnerTagName).item(0).getTextContent();
                        //System.out.println(neededConstant + " counter = " + temp + "\n");
                        statement=false;
                    }
                }
            }while (statement);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return neededConstant;
    }
}


