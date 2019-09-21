package interceptor;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

/**
 *
 *@author Gxy
 *@Since 2019-08-25 02:38:13
 */
public class EncodingInterceptor implements Interceptor {

	@Override
	public String invoke(MvcHttpParams parmas) {
		try {
			HttpServletRequest request = parmas.getRequest();
			request.setCharacterEncoding("UTF-8");
			System.out.println(request.getParameter("user.username"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
