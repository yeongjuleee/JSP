package restConfig;

// JAX-RS�� ���õ� ��Ű���� �� javax.ws.rs.*�� ���.
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import java.util.HashMap;
import java.util.Map;

@ApplicationPath("/api") // REST API ���� �������� �ǹ�.
public class RestConfig extends Application {
    public Map<String, Object> getProperties() {
        Map<String, Object> properties = new HashMap<String, Object>();
        // Ŭ�������� REST-API ���񽺸� ã�´ٴ� �������� �Ӽ� �̸��� "jersey.config.server.provider.packages" ��Ȯ�� �ۼ�
        properties.put("jersey.config.server.provider.packages", "restAPI");
        return properties;
    }
}
