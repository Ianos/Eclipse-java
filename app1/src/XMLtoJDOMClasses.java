import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;


public class XMLtoJDOMClasses {
public static void main(String args[]) throws FileNotFoundException,IOException,JDOMException
{
System.out.println("hello from Vehicle classes demo" + "\n" +"\n");
//Build the Document object doc instantiating the inputted
//XML tree structure, via a JDOM tree (sxhma above)
SAXBuilder builder = new SAXBuilder();
Document doc = builder.build(new FileInputStream("C:/Users/IANOS/workspace/app1/WebContent/WEB-INF/vehicles.xml"));
//call our only method of jtp (see processElement of JDOMTreeProc below).
//This will process the root of the doc object,
//(i.e. the root element of the XML) passed as an argument.
//Method getRootElement of doc is found in the JDOM API
JDOMTreeProc jtp = new JDOMTreeProc();
jtp.processElement(doc.getRootElement());
}
}
