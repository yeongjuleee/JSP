package product.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import product.model.ProductService;

@WebServlet("/product/productController")
public class ProductController extends HttpServlet{
   ProductService service;
   
   public ProductController() {
      //생성자에서 초기화, 즉 모든 사용자 요청에 대해 동일한 인스턴스가 사용
      service = new ProductService();
   }

   @Override
   protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //클라이언트 요청을 구분하고 처리 메소드를 호출한 다음, 뒤로 이동하는 구조를 작성
      String action = req.getParameter("action");
      String view = "";
      //System.out.println(action);
      if(action == null) {
         //action의 파라미터가 null인 경우, 즉 서블릿이 action 파라미터가 없어 호출된 경우 컨트롤러에 action 파라미터를 넣어 포워딩
         //mvc구조에서는 jsp화면을 바로 실행하는 것이 아니라 컨트롤러를 통해 jsp로 이동하기 때문에
         //실행의 편의를 위해 작업
         getServletContext().getRequestDispatcher("/product/productController?action=list").forward(req, resp);
      } 
      else {
         //action 파라미터 값에 미리 list, info 메소드를 호출
         //이때 request는 반드시 전달해야 파라미터 등을 읽어올 수 있으며
         //response의 경우 굳이 필요는 없지만 혹시 필요한 경우를 대비해 함께 전달
         switch(action) {
         case "list":
            view = list(req, resp); break;
         case "info" :
            view = info(req, resp); break;
          }
         //System.out.println(view);
         //각각의 list() info() 메소드를 실행한 후 문자열로 된 jsp 파일 이름을 리턴하고 포워딩
         getServletContext().getRequestDispatcher("/product/"+view).forward(req, resp);         
      }
   }
   
   private String info(HttpServletRequest request, HttpServletResponse response) {
      //productList.jsp에서 특정 상품을 선택했을 때 호출되는 메소드
      //특정 상품에 대한 정보를 가져와 productInfo.jsp로 이요해 보여줌
      request.setAttribute("product", service.find(request.getParameter("id")));
      return "productInfo.jsp";
   }
   
   private String list(HttpServletRequest request, HttpServletResponse response) {
      //전체 데이터를 보여주기 위한 메소드
      //service 객체의 findAll() 메소드를 호출한 결과를 request scope에 저장
      request.setAttribute("products", service.findAll());
      return "productList.jsp";
   }
   
}