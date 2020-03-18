import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.Scanner;

public class TestXML {

    public static void displayMenu()
    {
        System.out.println();
        System.out.println("################ Product Management System  ############# ");
        System.out.println();

        System.out.println("        1:- Show the name of all bars.");
        System.out.println("        2:- Sort bars based on highest protein content.");
        System.out.println("        3:- Sort bars based on highest fat content.");
        System.out.println("        4:- Filter bars which has less than \"some number from the user\" fiber and sort them from highest to lowest.");
        System.out.println("        5:- Find all protein bars with more than X protein reviewed by Y (X and Y should be entered from the user)");
          System.out.print("        6:- Choose a number   :       ");
        System.out.println();
    }

    public static void main(String[] args) {

        XmlClass xmlclss = new XmlClass();
        xmlclss.fetchData();

        String input;
        Scanner sc = new Scanner(System.in);
        displayMenu();

        do {
            input = "";
            input = sc.next();

            switch (input) {
                case "1":
                    xmlclss.ShowBars();
                    displayMenu();
                    break;
                case "2":
                    displayMenu();
                    break;
                case "3":
                    displayMenu();
                    break;
                case "4":
                    displayMenu();
                    break;
                case "5":
                    displayMenu();
                    break;
                case "6":
                    System.out.println("Good bye and see you soon ");
                    break;
                default: {
                    System.out.println("Please select a valid number ");
                }
            }
            // condition should be satisfied to keep iterating
        }while (input== "1" | input == "2" | input == "3" | input == "4" | input == "5" | (!input.equals("6")));
    }
}


