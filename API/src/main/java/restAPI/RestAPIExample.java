package restAPI;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/test")
public class RestAPIExample {

    //������ ��û�� ���� get, post ��û�� �����Ͽ� ����

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayHello(){
        return "Hello API Service";
    }

    //post�� ��� ���� �Ķ����, �� html ���̳� http body�� ���� ���޵Ǵ� name=value ������ �ĸ����͸� �о�� ����ϰ� ������
    //�̿ܿ��� /api/test/hello�� ���� ������ �ĸ���Ʈ�� ó���� �� ����.
    @POST
    public String sayHello(@QueryParam("msg") String msg){
        return msg + " API Service";
    }
}
