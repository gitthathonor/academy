package site.metacoding.academy.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.academy.domain.school.School;
import site.metacoding.academy.domain.school.SchoolDao;
import site.metacoding.academy.domain.teacher.Teacher;
import site.metacoding.academy.domain.teacher.TeacherDao;

@Service
@RequiredArgsConstructor
public class AcademyService {
	
	private final SchoolDao schoolDao;
	private final TeacherDao teacherDao;
	
	public void 선생님등록() {
		teacherDao.insert();
	}
	
	public HashMap<String, List<?>> 학교및선생목록보기() {
		List<School> schoolList = schoolDao.findAll();
		List<Teacher> teacherList = teacherDao.findAll();
		HashMap<String, List<?>> map = new HashMap<>();
		map.put("schoolList", schoolList);
		map.put("teacherList", teacherList);
		return map;
	}
	
	public List<School> 학교목록보기() {
		return schoolDao.findAll();
	}
	
	public List<Teacher> 선생님목록보기() {
		return teacherDao.findAll();
	}
	
	public List<Teacher> 학교별선생님목록보기(Integer id) {
		System.out.println("서비스 실행");
		return teacherDao.findBySchoolId(id);
	}
	
}
