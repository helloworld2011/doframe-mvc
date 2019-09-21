package xmlinfo;

import java.util.List;
import java.util.Map;

/**
 *
 *@author Gxy
 *@Since 2019-08-23 02:36:52
 */
public class Mvc {
	
	private Package packageobj;
	private List<InterceptorInfo> allinterceptor;
	private Map<String, InterceptorStack> stackmap;
	private String defaultstack;
	private Map<String, Action> actionmap;
	private List<IncludeFile> includeFiles;
	
	public Package getPackageobj() {
		return packageobj;
	}
	public void setPackageobj(Package packageobj) {
		this.packageobj = packageobj;
	}
	public List<InterceptorInfo> getAllinterceptor() {
		return allinterceptor;
	}
	public void setAllinterceptor(List<InterceptorInfo> allinterceptor) {
		this.allinterceptor = allinterceptor;
	}
	public Map<String, InterceptorStack> getStackmap() {
		return stackmap;
	}
	public void setStackmap(Map<String, InterceptorStack> stackmap) {
		this.stackmap = stackmap;
	}
	public String getDefaultstack() {
		return defaultstack;
	}
	public void setDefaultstack(String defaultstack) {
		this.defaultstack = defaultstack;
	}
	public Map<String, Action> getActionmap() {
		return actionmap;
	}
	public void setActionmap(Map<String, Action> actionmap) {
		this.actionmap = actionmap;
	}
	public List<IncludeFile> getIncludeFiles() {
		return includeFiles;
	}
	public void setIncludeFiles(List<IncludeFile> includeFiles) {
		this.includeFiles = includeFiles;
	}
}
