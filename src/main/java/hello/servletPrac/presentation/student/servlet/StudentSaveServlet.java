package hello.servletPrac.presentation.student.servlet;

import hello.servletPrac.presentation.student.Student;
import hello.servletPrac.presentation.student.StudentRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "studentSaveServlet", urlPatterns = "/students/save")
public class StudentSaveServlet extends HttpServlet {

    private StudentRepository studentRepository = StudentRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("StudentSaveServlet.service");
        String stuName = request.getParameter("stuName");

        int korScore = Integer.parseInt(request.getParameter("korScore"));
        int engScore = Integer.parseInt(request.getParameter("engScore"));
        int mathScore = Integer.parseInt(request.getParameter("mathScore"));

        Student student = new Student(stuName, korScore, engScore, mathScore);
        System.out.println("student = " + student);
        studentRepository.save(student);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter();
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>학생번호="+student.getStuNo()+"</li>\n" +
                " <li>이름="+student.getStuName()+"</li>\n" +
                " <li>국어 점수="+student.getKorScore()+"</li>\n" +
                " <li>영어 점수="+student.getEngScore()+"</li>\n" +
                " <li>수학 점수="+student.getMathScore()+"</li>\n" +
                " <li>총점="+student.getSum()+"</li>\n" +
                " <li>평균="+student.getAverage()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");
    }
}
