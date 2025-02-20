//ビジネスロジックを担うクラス。処理を分かりやすく整理する。
//リポジトリクラスを利用してDBとやり取りし、その結果を加工して返す。
package raisetech.student.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;
import raisetech.student.management.domain.StudentDetail;
import raisetech.student.management.repository.StudentRepository;
import java.util.List;

@Service
public class StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

        public List<Student> searchStudentList() {
        return repository.search();
        }

        public List<StudentsCourses> searchStudentsCourseList() {
            return repository.searchStudentsCourses();
        }

        @Transactional
        public void registerStudent(StudentDetail studentDetail) {
        repository.registerStudent(studentDetail.getStudent());
        //TODO:コース情報登録も行う。
        }
    }
