package hello.servletPrac.presentation.student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {

    private static Map<Long, Student> store = new HashMap<>();
    private static long sequence = 0L;

    private static final StudentRepository instance = new StudentRepository();

    public static StudentRepository getInstance() {
        return instance;
    }

    private StudentRepository() {
    }

    public Student save(Student student) {
        student.setStuNo(++sequence);
        store.put(student.getStuNo(), student);
        return student;
    }

    public Student findByStuNo(Long stuNo) {
        return store.get(stuNo);
    }

    public List<Student> findAll() {
        return new ArrayList<>(store.values());
    }
}
