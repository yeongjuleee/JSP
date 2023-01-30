package mvc.controller;

import mvc.model.NewsDAO;
import mvc.model.News;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;


@WebServlet("*.nhn")
// ���� �̹��� ���� ���ε� ó���� ���� @MultipartCongif �߰�
// �ִ� ���� ũ�� ���� ��ġ�� ����
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/img")

public class NewsController extends HttpServlet {
	private NewsDAO dao;
	private ServletContext ctx;	// ���� �α� �޽��� ������ ���� ����
	
	// �� ���ҽ� �⺻ ��� ����
	private final String START_PAGE = "ver01/newsList.jsp";
	
	public void init(ServletConfig config) throws ServletException {
		// init() �޼ҵ忡�� �ʱ�ȭ ����
		super.init(config);
		dao = new NewsDAO();
		ctx = getServletContext();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String action = req.getParameter("action");
		
		dao = new NewsDAO();
		
		// �ڹ� ���÷����� ����� if,  switch ���� ��û�� ���� ���� �޼ҵ尡 ����ǵ��� ����
		// �ڹ��� ���÷��� API�� ����� �ڵ����� action�� ������ �̸��� ������ �޼ҵ带 ȣ���ϴ� ����
		// ���ʿ��� if ó���� �ٿ��ְ� ���� ���濡 ������ ���
		
		Method m;
		String view = null;
		
		// action �Ķ���� ���� ������ ���
		// ��Ʈ�ѷ� ���� �� �ڵ����� ���� �������� �̵�
		if (action == null) {
			action = "listNews";
		}
		
		// 1. �ڹ� ���÷������� action���� ���޵� �̸��� �޼ҵ� �ڵ����� ȣ��
		try {
			// ���� Ŭ�������� action �̸��� HttpServeltRequest �Ķ���ͷ� �ϴ� �޼ҵ带 ã��
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			// this.getClass() : ���� Ŭ���� ��ü�� ���� ����
			// getMethod() : ù ��° ���ڷ� �޼ҵ� �̸�, �� ��° ���� Ÿ���� �޼ҵ� ���ڷ� ������ �޼ҵ� ��ü�� ������
			
			// �޼ҵ� ���� �� ���� �� �޾ƿ�
			view = (String) m.invoke(this, req);
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			ctx.log("��û action ����!");	// ��Ĺ�� �ֿܼ� �ε� �޽����� ����� �޼ҵ� 
			req.setAttribute("error", "action �Ķ���Ͱ� �߸��Ǿ����ϴ�.");
			view = START_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 2. �� �̵�
		// ��û ó�� �޼ҵ带 ȣ���� ���� ���� �� �� �������� �̵�
		
		// view ���ڿ��� "redirect:/" ���ڿ��� �����ϴ� ��� "redirect:/" ������ ��θ�
		// ���� resp.sendRedirect()�� �̿��� ������ �̵�
		
		if (view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());	// redirect:/ ���ڿ� ������ ��θ� ������
			resp.sendRedirect(rview);
		}
		else {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher(view);
			requestDispatcher.forward(req, resp);	// ������ ��� ������
		}
		
	} // protected void service ��
	
	private String getFilename(Part part) {
		// Part ��ü�� ����� multipart ������� ���� �̸� ����
		String fileName = null;
		
		// ���� �̸��� ��� �ִ� ��� ������ ������
		// ���� �̸��� ��� �ִ� ��� ������ ������ ��??
		String header = part.getHeader("content-disposition");
		// part.getHeader => form-data; name="file"; filename="����5.jpg"
		ctx.log("File Header : " + header);
		
		// ���� �̸��� ����ִ� �Ӽ� �κ��� ���� ��ġ�� ������ �ֵ���ǥ ������ �� �κи� ������
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length()-1);
		ctx.log("���ϸ�: " + fileName);
		return fileName;
	}
	
	public String addNews(HttpServletRequest req) {
		// ���� ��� ����ϱ� ���� ��û�� ó���ϴ� �޼ҵ�
		News news = new News();
		
		try {
			// �̹��� ���� ������ ���� request�κ��� Part ��ü ����
			Part part = req.getPart("file");
			String fileName = getFilename(part);
			if(fileName != null && !fileName.isEmpty()) {
				part.write(fileName);	// ���� �̸��� ������ ���� ����
			}
			// BeanUtils.populate() : �Ķ���ͷ� ���޵� name �Ӽ��� ��ġ�ϴ� news Ŭ������ ��� ������ ã�� ���� ����
			BeanUtils.populate(news, req.getParameterMap());
			// �̹��� ���� �̸��� News ��ü���� ����
			news.setImg("/img/" + fileName);
			
			dao.addNews(news);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("���� �߰� �������� ���� �߻�!");
			req.setAttribute("error", "������ ���������� ��ϵ��� �ʾҽ��ϴ�!");
			return listNews(req);
		}
		return "redirect:/news.nhn?action=listNews";
	}
	
	public String listNews(HttpServletRequest req) {
		// newsList.jsp ���� ���� ����� �����ֱ� ���� ��û�� ó���ϴ� �޼ҵ�
		List<News> list;
		
		try {
			list = dao.getAll();
			req.setAttribute("newslist", list);
		}catch (Exception e) {
			e.printStackTrace();
			ctx.log("���� ��� ���� �������� ���� �߻�!!");
			req.setAttribute("error", "���� ����� ���������� ó������ �ʾҽ��ϴ�!");
		}
		return "./newsList.jsp";
	}
	
	public String getNews(HttpServletRequest req) {
		// Ư�� ���� ��縦 Ŭ������ �� ȣ���ϱ� ���� ��û�� ó���ϴ� �޼ҵ�
		int aid = Integer.parseInt(req.getParameter("aid"));
		try {
			News n = dao.getNews(aid);
			req.setAttribute("news", n);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("������ �������� �������� ���� �߻�!");
			req.setAttribute("error", "������ ���������� �������� ���߽��ϴ�!");
		}
		return "./newsView.jsp";
	}
	
	public String deleteNews(HttpServletRequest req) {
		int aid = Integer.parseInt(req.getParameter("aid"));
		
		try {
			dao.delNews(aid);
		} catch (SQLException e) {
			e.printStackTrace();
			ctx.log("���� ���� �������� ���� �߻�!");
			req.setAttribute("error", "������ ���������� �������� �ʾҽ��ϴ�!");
			return listNews(req);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect:/news.nhn?action=listNews";
	}
	
	
} // ��Ʈ�ѷ� ��
