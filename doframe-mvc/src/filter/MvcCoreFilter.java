package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.adam.mvc.core.interceptor.DefaultActionInvocation;

import interceptor.DefaultInvocation;
import interceptor.Invocation;
import interceptor.MvcHttpParams;
import xmlinfo.Mvc;
import xmltootls.ConstantMvc;
import xmltootls.MvcXmlFactory;

/**
 * 自定义核心过滤器
 *@author Gxy
 *@Since 2019-08-25 02:26:25
 */
public class MvcCoreFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if (null == ConstantMvc.DEFAULTMVC) {
			MvcXmlFactory.init();
		}
		Mvc mvc = ConstantMvc.DEFAULTMVC;
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		MvcHttpParams httpParams = new MvcHttpParams();
		httpParams.setRequest(httpServletRequest);
		httpParams.setResponse(httpServletResponse);
		// 执行调度器
		DefaultInvocation defaultInvocation = new DefaultInvocation();
		defaultInvocation.setMvc(mvc);
		defaultInvocation.setParams(httpParams);
		defaultInvocation.invoke();
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

}
