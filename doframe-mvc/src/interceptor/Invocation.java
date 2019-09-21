package interceptor;

import xmlinfo.Mvc;

/**
 * 调度器
 *@author Gxy
 *@Since 2019-08-25 02:52:16
 */
public interface Invocation {
	//调度方法
	public void invoke();
	//设置参数
	public void setParams(MvcHttpParams params);
	//设置mvc实体方法
	public void setMvc(Mvc mvc);
}
