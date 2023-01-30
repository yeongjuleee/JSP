package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

//Servlet Filter implementation class EncFilter
//@WebFilter("/EncFilter") // ���� ������ ���� ������̼��̰�, �Ű������� URL ���� �κ�
@WebFilter("*.jsp")
public class EncFilter extends HttpFilter implements Filter {
    private String encoding = null; // ���ڿ� ������ �о�� �Ű����� ���� �����ϱ� ���� ���
	
	
    /**
     * @see HttpFilter#HttpFilter()
     */
    public EncFilter() {
        super();
        // TODO Auto-generated constructor stub
    }


	//@see Filter#destroy()
	public void destroy() {
		// TODO Auto-generated method stub
	}

	
	//@see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ���� ó�� �޼ҵ�
		// ĳ���� ���ڵ� ������ ���� ��쿡�� ĳ���� ���ڵ� ����

		if(request.getCharacterEncoding() == null) {
			request.setCharacterEncoding(encoding);
			chain.doFilter(request, response);
		}
	}

	
	//@see Filter#init(FilterConfig)
	public void init(FilterConfig fConfig) throws ServletException {
		// ���Ͱ� ó�� �ʱ�ȭ �� �� �� ���� ȣ��Ǵ� �޼ҵ�
		// ���� �ʱ�ȭ�� �ʱ�ȭ �Ķ���Ϳ��� ���ڵ� �⺻���� ������
		// web.xml�� �ʱ�ȭ �Ű������� 'encoding'���� ������ ���� ���ڿ� ���� encoding�� ����
		// ���� ������ ������ doFilter() �޼ҵ忡�� �̷����
		this.encoding = fConfig.getServletContext().getInitParameter("encoding");
	}

}
