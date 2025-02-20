//シンプルにDBとやり取りをするクラス。
package raisetech.student.management.repository;

import java.util.List;
import org.apache.ibatis.annotations.*;
import raisetech.student.management.data.Student;
import raisetech.student.management.data.StudentsCourses;

@Mapper
public interface StudentRepository {

    @Select("select * from students")
    List<Student> search();

    @Select("select * from students_courses")
    List<StudentsCourses> searchStudentsCourses();

    @Insert("INSERT INTO students(name, kana_Name, nickName,email,area,age,sex) "
        + "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{sex})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);
}