package mvc.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import mvc.model.News;
import mvc.model.NewsDAO;

@Path("/news")
public class NewsAPIService {
	NewsDAO dao;
	
	public NewsAPIService() {
		dao = new NewsDAO();
	}
	
	// ���� ���
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // Ŭ���̾�Ʈ ��û�� ���Ե� �̵�� Ÿ�� ����. JSON�� ���
	public String addNews(News news) {
		try {
			dao.addNews(news); 	// @Consumes ������ ���� HTTP Body�� ���Ե� JSON ���ڿ��� �ڵ����� News�� ��ȯ
								// �̸� ���� JSON ���ڿ��� Ű�� News ��ü�� ��� �������� �����ؾ� �Ѵ�.
		} catch (Exception e) {
			e.printStackTrace();
			return "News API: ���� ��� ����!";
		}
		return "News API: ���� ���!";
	}
	
	// ���� �� ����
	@GET
	@Path("{aid}")
	@Produces(MediaType.APPLICATION_JSON)
	public News getNews(@PathParam("aid") int aid ) {
		News news = null;
		
		try {
			news = dao.getNews(aid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return news;
	}
	
	// ���� ����
	@DELETE
	@Path("{aid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delNews(@PathParam("aid") int aid) {
		try {
			dao.delNews(aid); 	// @Consumes ������ ���� HTTP Body�� ���Ե� JSON ���ڿ��� �ڵ����� News�� ��ȯ
								// �̸� ���� JSON ���ڿ��� Ű�� News ��ü�� ��� �������� �����ؾ� �Ѵ�.
		} catch (Exception e) {
			e.printStackTrace();
			return "News API: ���� ���� ����!";
		}
		return "News API: ���� ����!";
	}
	
	// ���� ���
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<News> getAll() {
		List<News> list = null;
		
		try {
			list = dao.getAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
