
import org.w3c.dom.*; // this is the 'DOM' in our downloaded java
import javax.xml.parsers.*; //... and the parsers! (DOM & SAX, see later for SAX)
import java.io.*;

public class DOMNavigator{
public static void main(String[] args) {
try{
//With following 3 lines we realize the chain:
//DocumentBuilderFactory->DocumentBuilder->Document
//and build an (DOM) Document doc from the input file
DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
DocumentBuilder builder = fact.newDocumentBuilder();
Document doc = builder.parse("C:/Users/IANOS/workspace/app1/WebContent/WEB-INF/Cars.xml");
//Examine document element
System.out.print("Name of document element is.. ");
//DocumentElement is the too element !
System.out.print(doc.getDocumentElement().getNodeName());
System.out.print(" ... and its value is .. "); //this must be NULL !!
System.out.println(doc.getDocumentElement().getNodeValue());
//... just a demonstration for 'getElementsByTagName'
System.out.print("No of elements named 'jeep' anywhere in the doc is .. ");
System.out.println(doc.getElementsByTagName("jeep").getLength());
//Iteratively examine every element, starting again from doc element
myDOMTreeProc dtp = new myDOMTreeProc();
dtp.processNode(doc.getDocumentElement());
} catch (Exception e){ e.getMessage(); }
}
}
class myDOMTreeProc
{
public void processNode(Node el)
{ System.out.println("\n////////////////////////////// ITERATIVE NODE PROCESSING //////////////////////");
NodeList mixedContent = el.getChildNodes();
int noOfChildren = mixedContent.getLength();
System.out.println("Element named '" + el.getNodeName() +
"' with parent '" + el.getParentNode().getNodeName() +
"' has " + noOfChildren + " child nodes (of any kind) and " +
" has content:");
for ( int i = 0 ; i < noOfChildren ; i++ )
{ Node currNode = mixedContent.item(i);
if (currNode.getNodeType() == Node.TEXT_NODE)
{ System.out.println(currNode.getNodeType() + "-Text..............: " + currNode.getNodeValue()); };
if (currNode.getNodeType() == Node.COMMENT_NODE)
{ System.out.println(currNode.getNodeType() + "-Comment.......: " + currNode.getNodeValue()); };
if (currNode.getNodeType() == Node.PROCESSING_INSTRUCTION_NODE)
{ System.out.println(currNode.getNodeType() + "-PI.....................: " + currNode.getNodeValue()); };
if (currNode.getNodeType() == Node.CDATA_SECTION_NODE)
{ System.out.println(currNode.getNodeType() + "-CDATA............: " + currNode.getNodeValue()); };
if (currNode.getNodeType() == Node.ELEMENT_NODE)
{ NamedNodeMap allAttr = currNode.getAttributes();
System.out.println(currNode.getNodeType() + "-Element '"
+ ((Element)currNode).getTagName() + "' has "+ allAttr.getLength() +" attribute(s): ");
// to use the Element method 'getTagName()', casting was used above
for ( int k = 0 ; k < allAttr.getLength() ; k++ )
{ System.out.println(allAttr.item(k).getNodeName() + " = " +
allAttr.item(k).getNodeValue());}
processNode(currNode); ; // recursive call to this same method !!!!
}
}
}
}