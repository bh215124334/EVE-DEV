package com.bai.lpstore.tools;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


public class HttpUtil {

    public static HttpClientResult doPost(String url, Map<String, String> params, StringEntity entity){
        CloseableHttpClient httpClient = getIgnoreSSLClient();
        HttpClientResult result = null;
        try {

            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);

            // 添加参数
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }

            HttpPost httpPost = new HttpPost(uriBuilder.build());
            httpPost.setEntity(entity);
            CloseableHttpResponse response = httpClient.execute(httpPost);
            String context = EntityUtils.toString(response.getEntity(), "UTF-8");
            result = new HttpClientResult(response.getStatusLine().getStatusCode(), context);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static HttpClientResult doGet(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = getIgnoreSSLClient();
        HttpClientResult result = null;
        try {

            // 创建访问的地址
            URIBuilder uriBuilder = new URIBuilder(url);

            // 添加参数
            if (params != null) {
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    uriBuilder.setParameter(entry.getKey(), entry.getValue());
                }
            }


            HttpGet httpGet = new HttpGet(uriBuilder.build());
            CloseableHttpResponse response = httpClient.execute(httpGet);
            String context = EntityUtils.toString(response.getEntity(), "UTF-8");
            result = new HttpClientResult(response.getStatusLine().getStatusCode(), context);

        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 创建忽视证书的HttpClient
     * @author BaiHeng
     * @return IgnoreSSLClient
     * @throws Exception
     */
    private static CloseableHttpClient getIgnoreSSLClient()  {
        CloseableHttpClient client = null;
        try {
            SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustStrategy() {
                @Override
                public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
                    return true;
                }
            }).build();

            //创建httpClient
            client = HttpClients.custom().setSSLContext(sslContext).
                    setSSLHostnameVerifier(new NoopHostnameVerifier()).build();
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            e.printStackTrace();
        }
        return client;
    }

    private static void printAll(HttpPatch httpPatch, HttpResponse response) throws IOException {
        System.out.println(httpPatch);
        for (Header header : httpPatch.getAllHeaders()){
            System.out.println(header);
        }
        System.out.println("请求body： " + EntityUtils.toString(httpPatch.getEntity()));
        System.out.println(response);
        System.out.println(EntityUtils.toString(response.getEntity()));
    }

}

