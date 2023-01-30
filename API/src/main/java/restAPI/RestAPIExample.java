package restAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestAPIExample {

    //동일한 요청에 대해 get, post 요청을 구분하여 동작

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello API Service";
    }

    //post의 경우 쿼리 파라미터, 즉 html 폼이나 http body를 통해 전달되는 name=value 형태의 파리미터를 읽어와 사용하고 있으며
    //이외에도 /api/test/hello와 같은 형식의 파리머트도 처리할 수 있음.
    @POST
    public String sayHello(@QueryParam("msg") String msg){
        return msg + " API Service";
    }
}
