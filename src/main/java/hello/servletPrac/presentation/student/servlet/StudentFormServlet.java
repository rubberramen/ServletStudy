package hello.servletPrac.presentation.student.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentFormServlet", urlPatterns = "/students/new-form")
public class StudentFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter writer = response.getWriter();
        writer.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/students/save\" method=\"post\">\n" +
                " 학생 이름: <input type=\"text\" name=\"stuName\" />\n" +
                "<br>" +
                " 국어 점수: <input type=\"text\" name=\"korScore\" />\n" +
                "<br>" +
                " 영어 점수: <input type=\"text\" name=\"engScore\" />\n" +
                "<br>" +
                " 수학 점수: <input type=\"text\" name=\"mathScore\" />\n" +
                "<br>" +
                " <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");
    }
}
