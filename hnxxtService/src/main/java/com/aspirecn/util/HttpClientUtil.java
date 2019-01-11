package com.aspirecn.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.hibernate.validator.internal.util.privilegedactions.GetMethod;
import org.springframework.http.RequestEntity;

import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: HttpClientUtil 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Sunming
 * @date 2019-1-9 下午02:28:03
 * @version V1.0 
 *
 * <p> 修改历史</p>
 * <p> 序号 日期 修改人 修改原因</p>
 */
@Slf4j
public class HttpClientUtil {
	

	/**
	 * HttpPost请求
	 * @param url String
	 * @param params Map<String, Object>
	 * @return String false-地址不通
	 * @throws Exception
	 */
	public static String requestHttp(String url,Map<String, String> params) throws Exception {
		HttpClient hc = new HttpClient();
		//请求超时时间
		hc.getHttpConnectionManager().getParams().setConnectionTimeout(10000);
		PostMethod pm = new PostMethod(url);
		//设置编码格式
		pm.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		
		List<String> paramsList = new ArrayList<String>(params.keySet());
		for(String p : paramsList){
			String val = params.get(p);
			if("".equals(val)||val==null){
				val = "";
			}
			pm.addParameter(p, val);
		}
		int state = hc.executeMethod(pm);
		
		String result = "";
		if(state==200){
			//获取返回结果
			result = pm.getResponseBodyAsString();
		}else{
			result = "false";
		}
		return result;
	}
	

	
	@SuppressWarnings("deprecation")
	public static String doPost(String url, String params,String charset) {
		  StringBuffer response = new StringBuffer();
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);
			// 设置Http Post数据
			method.setRequestHeader("Content-Type",
					"application/x-www-form-urlencoded;charset=" + charset);
			method.setRequestBody(params);
			InputStream responseBodyStream = null;
			InputStreamReader streamReader = null;
			BufferedReader reader = null;
			try {
				client.executeMethod(method);
				if (method.getStatusCode() == HttpStatus.SC_OK) {
					responseBodyStream = method.getResponseBodyAsStream();
					streamReader = new InputStreamReader(responseBodyStream,
							charset);
					reader = new BufferedReader(streamReader);
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
				}
				System.out.println(url+params);
			} catch (IOException e) {
				e.printStackTrace();
				log.error("执行HTTP Post请求" + url + "时，发生异常！", e);
			} finally {
				try {
					responseBodyStream.close();
					streamReader.close();
					reader.close();
				} catch (IOException e) {
					log.error("执行HTTP Post请求" + url + "时，发生异常，关闭流异常！", e);
					e.printStackTrace();
				}
				method.releaseConnection();
			}
			return response.toString();
	}
	
	@SuppressWarnings("deprecation")
	public static String doPostJSON(String url, String params,String charset) {
		  StringBuffer response = new StringBuffer();
			HttpClient client = new HttpClient();
			PostMethod method = new PostMethod(url);
			// 设置Http Post数据
			method.setRequestHeader("Content-Type",
					"application/json;charset=" + charset);
			method.setRequestBody(params);
			InputStream responseBodyStream = null;
			InputStreamReader streamReader = null;
			BufferedReader reader = null;
			try {
				client.executeMethod(method);
				if (method.getStatusCode() == HttpStatus.SC_OK) {
					responseBodyStream = method.getResponseBodyAsStream();
					streamReader = new InputStreamReader(responseBodyStream,
							charset);
					reader = new BufferedReader(streamReader);
					String line;
					while ((line = reader.readLine()) != null) {
						response.append(line);
					}
				}
				System.out.println(url+params);
			} catch (IOException e) {
				log.error("执行HTTP Post请求" + url + "时，发生异常！", e);
			} finally {
				try {
					responseBodyStream.close();
					streamReader.close();
					reader.close();
				} catch (IOException e) {
					log.error("执行HTTP Post请求" + url + "时，发生异常，关闭流异常！", e);
					e.printStackTrace();
				}
				method.releaseConnection();
			}
			return response.toString();
	}
	
}
