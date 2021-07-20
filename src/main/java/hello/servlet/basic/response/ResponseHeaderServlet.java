package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ResponseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setStatus(200);
        //그냥 200이라는 숫자가 아니라 OK라는 의미를 바로 확인할 수 있으므로 이렇게 사용한다.
        System.out.println("[status-line]");
        response.setStatus(HttpServletResponse.SC_OK);

        System.out.println("[response-header]");
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        //response.setContentType("Content-Type", "text/plain;charset=utf-8");
        //reponse.setCharacterEncoding("utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");


        //쿠키
//        response.setHeader("Set-Cookie", "saltCookie=delicious; Max-Age=600");
        Cookie cookie = new Cookie("saltCookie", "delicious");
        cookie.setMaxAge(600);
        response.addCookie(cookie);


        //redirect
//        response.setStatus(HttpServletResponse.SC_FOUND); //302
//        response.setHeader("Location", "/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");

        response.getWriter().println("ok");
    }
}
