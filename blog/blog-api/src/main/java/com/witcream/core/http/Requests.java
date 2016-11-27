package com.witcream.core.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class Requests {
	public static enum Method {
		DELETE, GET, HEAD, POST, PUT;

		private Method() {
		}
	}

	public static class AllowAllHostNamesVerifier implements HostnameVerifier {
		public boolean verify(String urlHostName, SSLSession session) {
			return true;
		}
	}

	public static Requests delete(String url) throws MalformedURLException {
		return method(Method.DELETE, url);
	}

	public static Requests get(String url) throws MalformedURLException {
		return method(Method.GET, url);
	}

	public static Requests method(Method method, String url) throws MalformedURLException {
		Requests req = new Requests();
		req.method = method;
		req.url = url;
		return req;
	}

	public static Requests post(String url) throws MalformedURLException {
		return method(Method.POST, url);
	}

	public static Requests put(String url) throws MalformedURLException {
		return method(Method.PUT, url);
	}

	private byte[] body = null;
	private int connectionTimeout = 1000;
	private Map<String, String> data = new HashMap<String, String>();
	private boolean followRedirects = true;
	private Map<String, String> headers = new HashMap<String, String>();
	private Method method;
	private Map<String, String> params = new HashMap<String, String>();
	private int readTimeout = 1000;
	private String url;
	private SSLSocketFactory socketFactory;
	private boolean allowAllHostnames;

	public Requests allowAllHostnames() {
		this.allowAllHostnames = true;
		return this;
	}

	public Requests allowAllHostnames(boolean allowAllHostnames) {
		this.allowAllHostnames = allowAllHostnames;
		return this;
	}

	public Requests body(String body) {
		this.body = body.getBytes();
		return this;
	}

	public Requests body(byte[] body) {
		this.body = body;
		return this;
	}

	public Requests connectionTimeout(int milliseconds) {
		this.connectionTimeout = milliseconds;
		return this;
	}

	public Requests data(Map<String, String> values) {
		this.data.putAll(values);
		return this;
	}

	public Requests data(String name, String value) {
		this.data.put(name, value);
		return this;
	}

	public Response execute() throws IOException {
		URL fullUrl = new URL(this.url + getParams());

		HttpURLConnection conn = (HttpURLConnection) fullUrl.openConnection();
		if ((conn instanceof HttpsURLConnection)) {
			((HttpsURLConnection) conn).setSSLSocketFactory(this.socketFactory);
			if (this.allowAllHostnames) {
				((HttpsURLConnection) conn).setHostnameVerifier(new AllowAllHostNamesVerifier());
			}
		}
		for (Map.Entry<String, String> header : this.headers.entrySet()) {
			conn.addRequestProperty((String) header.getKey(), (String) header.getValue());
		}
		conn.setRequestMethod(this.method.name());
		conn.setInstanceFollowRedirects(this.followRedirects);
		conn.setConnectTimeout(this.connectionTimeout);
		conn.setReadTimeout(this.readTimeout);
		if (this.data.size() > 0) {
			conn.setDoOutput(true);
			writeForm(conn);
		} else if (this.body != null) {
			conn.setDoOutput(true);
			writeBytes(conn, this.body);
		}
		InputStream is = null;
		int code = conn.getResponseCode();
		if (code / 200 > 1) {
			is = conn.getErrorStream();
		} else {
			is = conn.getInputStream();
		}
		return new Response(code, conn.getHeaderFields(), is);
	}

	private String getParams() throws UnsupportedEncodingException {
		StringBuilder filter = new StringBuilder();
		if (this.params.size() > 0) {
			filter.append('?');
		}
		boolean first = true;
		for (Map.Entry<String, String> p : this.params.entrySet()) {
			if (!first) {
				filter.append('&');
			}
			filter.append(URLEncoder.encode((String) p.getKey(), "UTF-8"));
			filter.append('=');
			filter.append(URLEncoder.encode((String) p.getValue(), "UTF-8"));
			first = false;
		}
		return filter.toString();
	}

	public Requests followRedirects(boolean value) {
		this.followRedirects = value;
		return this;
	}

	public Method getMethod() {
		return this.method;
	}

	public String getUrl() {
		return this.url;
	}

	public Requests header(String name, String value) {
		this.headers.put(name, value);
		return this;
	}

	public Requests headers(Map<String, String> values) {
		this.headers.putAll(values);
		return this;
	}

	public Requests param(String name, String value) {
		this.params.put(name, value);
		return this;
	}

	public Requests params(Map<String, String> values) {
		this.params.putAll(values);
		return this;
	}

	public Requests readTimeout(int milliseconds) {
		this.readTimeout = milliseconds;
		return this;
	}

	public Requests sendJson() {
		return header("Content-Type", "application/json");
	}

	protected void writeBytes(HttpURLConnection conn, byte[] outBytes) throws IOException {
		conn.setRequestProperty("Content-Length", Integer.toString(outBytes.length));
		conn.getOutputStream().write(outBytes);
		conn.getOutputStream().close();
	}

	protected void writeForm(HttpURLConnection conn) throws IOException {
		boolean first = true;
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		StringBuilder out = new StringBuilder();
		for (Map.Entry<String, String> d : this.data.entrySet()) {
			if (!first) {
				out.append('&');
			}
			out.append(URLEncoder.encode((String) d.getKey(), "UTF-8"));
			out.append('=');
			out.append(URLEncoder.encode((String) d.getValue(), "UTF-8"));
			first = false;
		}
		writeBytes(conn, out.toString().getBytes());
	}

	public Requests socketFactory(SSLSocketFactory socketFactory) {
		this.socketFactory = socketFactory;
		return this;
	}

	public Requests defaultSocketFactory() {
		this.socketFactory = getDefaultSslSocketFactory();
		return this;
	}

	private static SSLSocketFactory getDefaultSslSocketFactory() {
		try {
			TrustManager[] byPassTrustManagers = { new X509TrustManager() {
				public X509Certificate[] getAcceptedIssuers() {
					return new X509Certificate[0];
				}

				public void checkClientTrusted(X509Certificate[] chain, String authType) {
				}

				public void checkServerTrusted(X509Certificate[] chain, String authType) {
				}
			} };
			SSLContext sslContext = SSLContext.getInstance("TLS");
			sslContext.init(null, byPassTrustManagers, new SecureRandom());
			return sslContext.getSocketFactory();
		} catch (Exception e) {
		}
		return (SSLSocketFactory) SSLSocketFactory.getDefault();
	}
}
