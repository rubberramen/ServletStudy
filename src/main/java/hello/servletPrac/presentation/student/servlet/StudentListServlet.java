package hello.servletPrac.presentation.student.servlet;

import hello.servletPrac.domain.member.Member;
import hello.servletPrac.presentation.student.Student;
import hello.servletPrac.presentation.student.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "studentListServlet", urlPatterns = "/students")
public class StudentListServlet extends HttpServlet {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        List<Student> students = studentRepository.findAll();

        PrintWriter w = response.getWriter();
        w.write("<html>");
        w.write("<head>");
        w.write(" <meta charset=\"UTF-8\">");
        w.write(" <title>Title</title>");
        w.write("</head>");
        w.write("<body>");
        w.write("<a href=\"/index.html\">메인</a>");
        w.write("<table>");
        w.write(" <thead>");
        w.write(" <th>학번</th>");
        w.write(" <th>이름</th>");
        w.write(" <th>국어</th>");
        w.write(" <th>영어</th>");
        w.write(" <th>수학</th>");
        w.write(" <th>총점</th>");
        w.write(" <th>평균</th>");
        w.write(" </thead>");
        w.write(" <tbody>");

        for (Student student : students) {
            w.write(" <tr>");
            w.write(" <td>" + student.getStuNo() + "</td>");
            w.write(" <td>" + student.getStuName() + "</td>");
            w.write(" <td>" + student.getKorScore() + "</td>");
            w.write(" <td>" + student.getEngScore() + "</td>");
            w.write(" <td>" + student.getMathScore() + "</td>");
            w.write(" <td>" + student.getSum() + "</td>");
            w.write(" <td>" + student.getAverage() + "</td>");
            w.write(" </tr>");
        }
        w.write(" </tbody>");
        w.write("</table>");
        w.write("</body>");
        w.write("</html>");
    }
}
