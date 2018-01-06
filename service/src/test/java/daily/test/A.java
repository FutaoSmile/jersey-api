//package daily.test;
//
//import com.alibaba.fastjson.JSONObject;
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.ResponseHandler;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//
//import java.io.IOException;
//
///**
// * @author futao
// * Created on 2017/12/28 - 13:13.
// */
//public class A {
//    /**
//     * 获取全部人员列表
//     * @return
//     */
//    public  JSONObject getAllEmployee(){
//        //获取微信号
//        String token=getTokenFromWx();
//        String dep_root=ROOT_DEP;//跟部门树
//        try {
//            CloseableHttpClient httpclient = HttpClients.createDefault();
//            HttpPost httpPost= new HttpPost("https://qyapi.weixin.qq.com/cgi-bin/user/list?access_token="+token+"&department_id="+dep_root+"&fetch_child="+FETCH_CHILD+"&status="+STATE);
//            // Create a custom response handler
//            ResponseHandler<JSONObject> responseHandler = new ResponseHandler<JSONObject>() {
//                //成功调用连接后，对返回数据进行的操作
//                public JSONObject handleResponse(
//                        final HttpResponse response) throws ClientProtocolException, IOException {
//                    int status = response.getStatusLine().getStatusCode();
//                    if (status >= 200 && status < 300) {
//                        //获得调用成功后  返回的数据
//                        HttpEntity entity = response.getEntity();
//                        if(!=entity){
//                            String result= EntityUtils.toString(entity);
//                            //根据字符串生成JSON对象
//                            JSONObject resultObj = JSONObject.fromObject(result);
//                            return resultObj;
//                        }else{
//                            return ;
//                        }
//                    } else {
//                        throw new ClientProtocolException("Unexpected response status: " + status);
//                    }
//                }
//
//            };
//            //返回的json对象
//            JSONObject responseBody = httpclient.execute(httpPost, responseHandler);
//            //System.out.println(responseBody);
//            return responseBody;
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ;
//        }
//    }
//}
