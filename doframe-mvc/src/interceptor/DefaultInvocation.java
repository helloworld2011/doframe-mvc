package interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import org.apache.catalina.tribes.membership.McastService;

import xmlinfo.InterceptorInfo;
import xmlinfo.InterceptorStack;
import xmlinfo.Mvc;

/**
 *
 *@author Gxy
 *@Since 2019-08-25 02:57:04
 */
public class DefaultInvocation implements Invocation {

	private MvcHttpParams params;
	private Mvc mvc;

	public void invoke() {
		String defaultstack = mvc.getDefaultstack();
		InterceptorStack stack = mvc.getStackmap().get(defaultstack);
		List<InterceptorInfo> interceptorlist = stack.getInterceptorlist();
		for (InterceptorInfo info : interceptorlist) {
			try {
				Class c=Class.forName(info.getInterceptorclass());
				Object o=c.newInstance();
				Method method=c.getDeclaredMethod("invoke", params.getClass());
				method.invoke(o, params);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void setParams(MvcHttpParams params) {
		this.params = params;
	}

	@Override
	public void setMvc(Mvc mvc) {
		this.mvc = mvc;
	}

}
