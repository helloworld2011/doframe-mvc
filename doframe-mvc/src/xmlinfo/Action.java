package xmlinfo;

import java.util.List;
import java.util.Map;

/**
 *
 *@author Gxy
 *@Since 2019-08-23 02:20:57
 */
public class Action {
	
	private String actionname;
	private String actionmethod;
	private String actionclass;
	
	private List<InterceptorInfo> interceptorInfolist;
	private List<InterceptorStack> stackList;
	private Map<String,Result> resultmap;
	
	public String getActionname() {
		return actionname;
	}
	public void setActionname(String actionname) {
		this.actionname = actionname;
	}
	public String getActionmethod() {
		return actionmethod;
	}
	public void setActionmethod(String actionmethod) {
		this.actionmethod = actionmethod;
	}
	public String getActionclass() {
		return actionclass;
	}
	public void setActionclass(String actionclass) {
		this.actionclass = actionclass;
	}
	public List<InterceptorInfo> getInterceptorInfolist() {
		return interceptorInfolist;
	}
	public void setInterceptorInfolist(List<InterceptorInfo> interceptorInfolist) {
		this.interceptorInfolist = interceptorInfolist;
	}
	public List<InterceptorStack> getStackList() {
		return stackList;
	}
	public void setStackList(List<InterceptorStack> stackList) {
		this.stackList = stackList;
	}
	public Map<String, Result> getResultmap() {
		return resultmap;
	}
	public void setResultmap(Map<String, Result> resultmap) {
		this.resultmap = resultmap;
	}
	
	
}
