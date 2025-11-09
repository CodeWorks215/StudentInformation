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

    @Select("select * from students where id = #{id}")
    Student searchStudent(String id);

    @Select("select * from students_courses")
    List<StudentsCourses> searchStudentsCoursesList();

    @Select("select * from students_courses where student_id = #{studentId}")
    List<StudentsCourses> searchStudentsCourses(String studentId);


    @Insert(
        "INSERT INTO students(name, kana_Name, nickName,email,area,age,sex,remark,is_deleted) "
        + "VALUES(#{name}, #{kanaName}, #{nickName}, #{email}, #{area}, #{age}, #{sex}, #{remark},false)")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudent(Student student);

    @Insert("INSERT INTO students_courses(student_id,course_name, course_start_at, course_end_at) "
        +  "VALUES(#{studentId}, #{courseName}, #{courseStartAt}, #{courseEndAt})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void registerStudentsCourses(StudentsCourses studentsCourses);

    @Update("UPDATE students SET name = #{name}, kana_name = #{kanaName}, nickname = #{nickName},"
            + "email = #{email}, area = #{area}, age = #{age}, sex = #{sex}, remark = #{remark},is_deleted = #{isDeleted} where id = #{id}")
    void updateStudent(Student student);

    @Update("UPDATE students_courses SET course_name = #{course_name} WHERE id = #{id}")
    void updateStudentsCourses(StudentsCourses studentsCourses);
}