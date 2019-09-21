package xmlinfo;

import java.util.List;

/**
 * 拦截器实体
 *@author Gxy
 *@Since 2019-08-23 02:23:59
 */
public class InterceptorStack {
	
	private String stackname;
	//拦截器列表
	private List<InterceptorInfo> interceptorlist;
	
	public void setInterceptorlist(List<InterceptorInfo> interceptorlist) {
		this.interceptorlist = interceptorlist;
	}
	
	public List<InterceptorInfo> getInterceptorlist() {
		return interceptorlist;
	}
	
	public void setStackname(String stackname) {
		this.stackname = stackname;
	}
	
	public String getStackname() {
		return stackname;
	}
	
	public InterceptorStack() {
		
	}
	
}
