package impl.com.bjpn.servlet;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.HttpClientUtils;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author futao
 * Created on 2017/12/28 - 9:32.
 */
@WebServlet(name = "IpQueryServlet", urlPatterns = "/ip", loadOnStartup = 3)
public class IpQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String localAddr = request.getLocalAddr();
        String remoteAddr = request.getRemoteAddr();
        System.out.println(localAddr);
        System.out.println(remoteAddr);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("http://ip.taobao.com/service/getIpInfo.php?ip=");
        HttpGet httpGet = new HttpGet("http://ip.taobao.com/service/getIpInfo.php?ip=" + request.getLocalAddr());
        httpGet.getMethod();
        CloseableHttpClient httpclient = HttpClients.createDefault();
        ResponseHandler responseHandler=new ResponseHandler() {
            @Override
            public Object handleResponse(HttpResponse httpResponse) throws ClientProtocolException, IOException {
                System.out.println(httpResponse.getEntity().toString());
                return new Object();
            }
        };
        httpclient.execute(httpGet,responseHandler);
    }
}
