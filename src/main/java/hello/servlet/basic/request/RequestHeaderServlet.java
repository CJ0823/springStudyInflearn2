package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "RequestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    printStartLine(request);
    printHeaders(request);
    printHeaderUtils(request);
    printEtc(request);

  }

  private void printEtc(HttpServletRequest request) {
    System.out.println(" --- 기타 조회 --- ");
    System.out.println("[Remote]");
    System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
    System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
    System.out.println("request.getRemotePort() = " + request.getRemotePort());

    System.out.println("[Local]");
    System.out.println("request.getLocalName() = " + request.getLocalName());
    System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
    System.out.println("request.getLocalPort() = " + request.getLocalPort());
    System.out.println(" --- 기타 조회 --- ");
  }

  private void printHeaderUtils(HttpServletRequest request) {
    System.out.println("--- Header 편의 조회 ---");
    System.out.println("[Host]");
    System.out.println("request.getServerName() = " + request.getServerName());
    System.out.println("request.getServerPort() = " + request.getServerPort());
    System.out.println();

    System.out.println("[Accept-Language]");
    request.getLocales().asIterator().forEachRemaining(locale -> {
      System.out.println("locale = " + locale);
    });
    System.out.println();

    System.out.println("[cookie]");
    Cookie[] cookies = request.getCookies();
    if(cookies != null) {
      for (Cookie cookie : cookies) {
        System.out.println(cookie.getName() + ": " + cookie.getValue());
      }
    }
    System.out.println();

    System.out.println("[Content]");
    System.out.println("request.getContentType() = " + request.getContentType());
    System.out.println("requesst.getContentLength() = " + request.getContentLength());
    System.out.println("request.getCharacterEncoding() = " + request.getCharacterEncoding());
    System.out.println();
    System.out.println("--- Header 편의 조회 ---");
  }

  private void printHeaders(HttpServletRequest request) {
    Enumeration<String> headerNames = request.getHeaderNames();
    headerNames.asIterator().forEachRemaining(headerName -> {
      System.out.println(headerName + ": " + request.getHeader(headerName));
    });
  }

  private void printStartLine(HttpServletRequest request) {
    System.out.println("---REQUEST START---");
    System.out.println("request.getMethod = " + request.getMethod());
    System.out.println("request.getProtocol = " + request.getProtocol());
    System.out.println("request.getScheme = " + request.getScheme());
    System.out.println("request.getRequestURL = " + request.getRequestURL());
    System.out.println("request.getRequestURI = " + request.getRequestURI());
    System.out.println("request.getQueryString = " + request.getQueryString());
    System.out.println("request.isSecure = " + request.isSecure());
    System.out.println("---REQUEST END ---");
    System.out.println();
  }
}
