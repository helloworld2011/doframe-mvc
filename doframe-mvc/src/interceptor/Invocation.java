package interceptor;

import xmlinfo.Mvc;

/**
 * ������
 *@author Gxy
 *@Since 2019-08-25 02:52:16
 */
public interface Invocation {
	//���ȷ���
	public void invoke();
	//���ò���
	public void setParams(MvcHttpParams params);
	//����mvcʵ�巽��
	public void setMvc(Mvc mvc);
}
