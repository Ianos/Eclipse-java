import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
public class JDOMTreeProc
{
public void processElement(Element el)
{
// Print name and text of el
System.out.println("\n-----------------------------------------");
System.out.println("\nNEW ELEMENT named: "+ el.getName()+ ", with text:"+ el.getText());
//Print attribute names and values:
//(to do this first get all attributes via a list)
List attributeList = el.getAttributes();
printAttributes(attributeList);
//mixedContent list will contains the contents of el
// ---!!! Attributes are NOT considered contents of el ---!!
List mixedContent = el.getContent();
//Contents can be Text, Comment, ProcessingInstruction, ...
//scan the content list, assigning first each of the list's
//inhomogeneous elements to a general object o
for (Iterator i = mixedContent.iterator(); i.hasNext();)
{
Object o = i.next();
//if object o belongs to some particular class
//(Text,etc, see JDOM classes),
//we use casting and make o a pointer to an object
//of this class, then place an appropriate call.
if (o instanceof Text){processText((Text)o);};
if (o instanceof Comment){processComment((Comment)o);};
if (o instanceof ProcessingInstruction)
{processProcessingInstruction((ProcessingInstruction)o);};
if (o instanceof EntityRef){processEntityRef((EntityRef)o);}
if (o instanceof CDATA){processCDATA((CDATA)o);}
if (o instanceof Element)
{//here a recursive call to this same method !!!!
processElement((Element)o);}
}
}
public void printAttributes(List attributeList)
{
System.out.println("ATTRIBUTES (name/value pairs):");
for (Iterator i = attributeList.iterator(); i.hasNext();)
{
Attribute att = (Attribute)i.next();
System.out.print(att.getName()+ "="+ att.getValue() + " ");
}
}
public void processText(Text text)
{
//we output the (possibly void) element text once more
System.out.println("\nANOTHER output of TEXT: " + text);
}
public void processProcessingInstruction(ProcessingInstruction pi)

{
System.out.println("\nPI Target : " + pi.getTarget());
System.out.println("\nPI Data : " + pi.getData());
System.out.println("\nPI Parent element: " + pi.getParent());
}
public void processEntityRef(EntityRef er)
{
//related to DDT - see later
}
public void processCDATA(CDATA cd)
{//print as CDATA contents
System.out.println("\nCDATA printed as text: " + cd.getText());
}
public void processComment(Comment cm)
{
System.out.println(">>>>>>>>>>>>>>>>>>>>>> COMMENT: " + cm.getText());
}
}