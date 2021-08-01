package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public interface ControllerV3 {
  //v2에서의 MyView
  // MyView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

  ModelView process(Map<String, String> paramMap);

}
