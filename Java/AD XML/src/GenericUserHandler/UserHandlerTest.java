package GenericUserHandler;
import java.io.File;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;




public class UserHandlerTest
{
	public static class UserHandler extends DefaultHandler
	{
		String rootElementName;
		String elementName;
		
		String attributeName;
		String attributeValue;
		
		int SECount;
		String[] SENames;
		String[] SEValues;
		
		boolean[] hasSubElement;
		
		public UserHandler(String root, String element, String att, String... subelements)
		{
			this.rootElementName = root;
			this.elementName = element;
			this.attributeName = att;
			
			this.SECount = subelements.length;
			this.SENames = new String[SECount];
			this.SEValues = new String[SECount];
			this.hasSubElement = new boolean[SECount];
			
			for (int i=0; i<SECount; i++)
			{
				this.SENames[i] = subelements[i];
			}
			
			for (int i=0; i<SECount; i++)
			{
				this.hasSubElement[i] = false;
			}
		}
		
		public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
		{
			if (qName.equals(rootElementName))
			{
				System.out.println("<" + qName + ">");
			}
			if (qName.equals(elementName))
			{
				attributeValue = attributes.getValue(attributeName);
			}
			for (int i=0; i<SECount; i++)
			{
				if (qName.equals(SENames[i]))
					{hasSubElement[i] = true;}
			}
		}
		
		public void characters(char[] ch, int start, int length) throws SAXException
		{
			for (int i=0; i<SECount; i++)
			{
				if (hasSubElement[i])
				{
					SEValues[i] = new String(ch, start, length);
					hasSubElement[i] = false;
				}
			}
		}
		
		public void endElement(String uri, String localName, String qName)
		{
			if (qName.equals(elementName))
			{
				System.out.println("    <"+elementName+" "+attributeName+"="+attributeValue+">");
				for (int i=0; i<SECount; i++)
				{
					System.out.println("        <"+SENames[i] + ">" + SEValues[i] + "</"+SENames[i]+">");
				}
				System.out.println("    </"+elementName+">");
			}
			if (qName.equals(rootElementName))
			{
				System.out.println("</" + qName + ">");
			}
		}
	}
	
	
	
	
	
	
	public static void main(String[] args)
	{
		try
		{
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			File xmlFile = new File("src/versiones.xml");
			
			UserHandler userHandler = new UserHandler("versiones", "version", "numero", "nombre", "api");
			
			saxParser.parse(xmlFile, userHandler);
		}
		catch (Exception e) {e.printStackTrace();}
	}
}
