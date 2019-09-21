package xmltootls;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.sun.corba.se.impl.orbutil.closure.Constant;

import xmlinfo.Action;
import xmlinfo.InterceptorInfo;
import xmlinfo.InterceptorStack;
import xmlinfo.Mvc;

/**
 * xml读取工具
 *@author Gxy
 *@Since 2019-08-24 06:08:39
 */
public class MvcXmlFactory {

	public static void init() {
		String filename = MvcXmlFactory.class.getResource("Mvc.xml").getFile();
		File file = new File(filename);
		SAXReader saxReader = new SAXReader();
		Document doc;
		try {
			doc = saxReader.read(file);
			Element rootElement = doc.getRootElement();
			Element pack = rootElement.element("package");
			String defaultfilename = pack.attributeValue("extends");
			getdefaultXmlInfo(defaultfilename);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private static void getdefaultXmlInfo(String defaultfilename) {
		File file = new File(MvcXmlFactory.class.getResource(defaultfilename+".xml").getFile());
		SAXReader reader = new SAXReader();
		Document doc = null;
		List<InterceptorInfo> allinterceptor=null;
		Map<String, InterceptorStack> stackmap=null;
		String defaultstack="";
		Mvc mvc = new Mvc();
		try {
			doc = reader.read(file);
			Element rootElement = doc.getRootElement();
			Element element = rootElement.element("package");
			List<Element> elements = element.elements();
			for(Element ele : elements) {
				if("interceptor".equals(ele.getName())) {
					if(null == allinterceptor) {
						allinterceptor=new ArrayList<InterceptorInfo>();
					}
					InterceptorInfo info=new InterceptorInfo();
					info.setInterceptorclass(ele.attributeValue("class"));
					info.setInterceptorname(ele.attributeValue("name"));
					allinterceptor.add(info);
				}
				if("interceptor-stack".equals(ele.getName())) {
					if(null == stackmap) {
						stackmap = new HashMap<String, InterceptorStack>();
					}
					InterceptorStack stack=new InterceptorStack();
					stack.setStackname(ele.attributeValue("name"));
					List<Element> elements2 = ele.elements();
					List<InterceptorInfo> infos = new ArrayList<InterceptorInfo>();
					for(Element refElement : elements2) {
						String refname = refElement.attributeValue("name");
						for(InterceptorInfo info : allinterceptor ) {
							if(refname.equals(info.getInterceptorname())) {
								infos.add(info);
								break;
							}
						}
					}
					stack.setInterceptorlist(infos);
					stackmap.put(stack.getStackname(), stack);
				}if(ele.getName().equals("defaultstack")) {
					defaultstack=ele.attributeValue("name");
				}
			}
			mvc.setDefaultstack(defaultstack);
			mvc.setAllinterceptor(allinterceptor);
			mvc.setStackmap(stackmap);
			ConstantMvc.DEFAULTMVC = mvc;
		} catch (DocumentException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		init();
		Mvc mvc = ConstantMvc.DEFAULTMVC;
		System.out.println("默认拦截器名字"+":"+mvc.getDefaultstack());
		List<InterceptorInfo> allinterceptor = mvc.getAllinterceptor();
		for(InterceptorInfo info : allinterceptor) {
			System.out.println(info.getInterceptorname()+":"+info.getInterceptorclass());
		}
		
		Map<String, Action> actionmap = mvc.getActionmap();
		if(actionmap != null) {
			Set<String> set=actionmap.keySet();
			Iterator<String> it=set.iterator();
		}
	}
}
