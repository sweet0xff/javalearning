package org.xxx.model.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter("/EncodingFilter")
public class EncodingFilter implements Filter {

	// ���ñ����ʽ
	private String charset = "";

    /**
     * Default constructor. 
     */
    public EncodingFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding(this.charset);
		response.setCharacterEncoding(this.charset);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		if(filterConfig.getInitParameter("encoding") != null){ //��ʾ�����ó�ʼ�������ʽ
			this.charset = filterConfig.getInitParameter("encoding");  //�޸�Ĭ�ϱ���
		}
	}

}
