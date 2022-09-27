package site.metacoding.academy.domain.school;

import java.util.List;

public interface SchoolDao {
	public void insert();
	public School findById(Integer id);
	public List<School> findAll();
	public void update();
	public void deleteById(Integer id);
}
