package site.metacoding.academy.domain.teacher;

import java.util.List;

public interface TeacherDao {
	public void insert();
	public Teacher findById(Integer id);
	public List<Teacher> findBySchoolId(Integer schoolId);
	public List<Teacher> findAll();
	public void update();
	public void deleteById(Integer id);
}
