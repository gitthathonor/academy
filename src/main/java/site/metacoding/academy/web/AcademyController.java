package site.metacoding.academy.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.academy.domain.school.School;
import site.metacoding.academy.domain.teacher.Teacher;
import site.metacoding.academy.service.AcademyService;
import site.metacoding.academy.web.dto.response.CMRespDto;

@Controller
@RequiredArgsConstructor
public class AcademyController {
	
	private final AcademyService academyService;
	
	@GetMapping("/save")
	public String saveForm(Model model) {
		List<School> schoolList = academyService.학교목록보기();
		List<Teacher> teacherList = academyService.선생님목록보기();
		model.addAttribute("schoolList", schoolList);
		model.addAttribute("teacherList", teacherList);
		return "saveForm";
	}
	
	@GetMapping("/save/{id}")
	public @ResponseBody CMRespDto<?> teacherListReload(@PathVariable Integer id) {
		System.out.println("컨트롤러 실행");
		List<Teacher> teacherList = academyService.학교별선생님목록보기(id);
		System.out.println("컨트롤러 종료");
		return new CMRespDto<>(1, "선생님 리스트 새로 불러오기", teacherList);
	}
	
}
