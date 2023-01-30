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
	
	// 뉴스 등록
	@POST
	@Consumes(MediaType.APPLICATION_JSON) // 클라이언트 요청에 포함된 미디어 타입 지정. JSON을 사용
	public String addNews(News news) {
		try {
			dao.addNews(news); 	// @Consumes 설정에 따라 HTTP Body에 포함된 JSON 문자열이 자동으로 News로 변환
								// 이를 위해 JSON 문자열의 키와 News 객체의 멤버 변수명이 동일해야 한다.
		} catch (Exception e) {
			e.printStackTrace();
			return "News API: 뉴스 등록 실패!";
		}
		return "News API: 뉴스 등록!";
	}
	
	// 뉴스 상세 정보
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
	
	// 뉴스 삭제
	@DELETE
	@Path("{aid}")
	@Consumes(MediaType.APPLICATION_JSON)
	public String delNews(@PathParam("aid") int aid) {
		try {
			dao.delNews(aid); 	// @Consumes 설정에 따라 HTTP Body에 포함된 JSON 문자열이 자동으로 News로 변환
								// 이를 위해 JSON 문자열의 키와 News 객체의 멤버 변수명이 동일해야 한다.
		} catch (Exception e) {
			e.printStackTrace();
			return "News API: 뉴스 삭제 실패!";
		}
		return "News API: 뉴스 삭제!";
	}
	
	// 뉴스 목록
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
