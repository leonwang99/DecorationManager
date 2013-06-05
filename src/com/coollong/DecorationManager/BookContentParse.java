package com.coollong.DecorationManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




public class BookContentParse {
	public static BookContent getBookContent(InputStream stream)
	{
		BookContent content = new BookContent();
			
		//�õ� DocumentBuilderFactory ����, �ɸö�����Եõ� DocumentBuilder ����
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		
		try {
			//�õ�DocumentBuilder����
			DocumentBuilder builder=factory.newDocumentBuilder();
			//�õ���������xml��Document����
			Document document=builder.parse(stream);
			//�õ� "���ڵ�" 
			Element root=document.getDocumentElement();
			//��ȡ���ڵ������items�Ľڵ�
			NodeList items=root.getElementsByTagName("item");  
			
			//�������нڵ�
			for(int i=0;i<items.getLength();i++)
			{
				//BookContent question=new BookContent();
				Element item=(Element)items.item(i);
				content.setName(getSubelementTextContentByName(item,"title"));
				content.setContent(getSubelementTextContentByName(item,"content"));
			}
			
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return content;
	}
		
	/** 
	 * �õ�ָ��Ԫ�ص���Ԫ���ı� �ڵ�( 
	 * @param item ��Ԫ�� 
	 * @param name ��Ԫ������  
	 * @return 
	 */  
	private static String getSubelementTextContentByName(Element item, String name) {  
		NodeList list=item.getElementsByTagName(name);  
	    Element e=(Element) list.item(0);  
	    return e.getTextContent();   
	}  
						
	public static List<Map<String, String>> getData(InputStream is) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		//InputStream stream = is;
		//List<Question> channlist = getQuestionList(stream);

		//for (int i = 0; i < channlist.size(); i++) {
		//	Map<String, String> map = new HashMap<String, String>();
		//	Question question = (Question) channlist.get(i);
		//	map.put("question", question.getQuestion());
		//	map.put("answer", question.getAnswer());
		//	list.add(map);	
		//}				
		return list;
	}
}
