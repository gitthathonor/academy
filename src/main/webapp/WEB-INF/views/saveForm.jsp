<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="layout/header.jsp" %>

<div class="container">
	<h1 style="text-align: center">학생 등록</h1>
	<form>
		<div class="d-flex justify-content-center">
			<select id="school">
				<option value="none">== 학교 선택 ==</option>
				<c:forEach var="school" items="${schoolList}">
					<option value="${school.id}">${school.name}</option>
				</c:forEach>
			</select> 
			<select id="teacher">
				<option value="none">== 선생님 선택 ==</option>
				<c:forEach var="teacher" items="${teacherList}">
					<option value="${teacher.id}">${teacher.name}</option>
				</c:forEach>
			</select> 
			학생명:<input id="name" class="form-control" placeholder="학생 이름 작성" />
			<button id="btnSave" type="button" class="btn btn-primary">등록</button>
		</div>
	</form>
</div>

<script>
	function getTeacherList(data) {
		$("#teacher").empty();
		$("#teacher").append("<option value='none'>== 선생님 선택 ==</option>");
		
		for(let i=0; i<data.length; i++) {
			let id = data[i].id;
			let name = data[i].name;
			$("#teacher").append("<option value="+id+">"+name+"</option>");
		}	
	}
	
	
	$("#school").change(()=>{
		let id = $("#school").val();
		console.log(id);
		
		$.ajax("/save/"+id,{
			type: "GET",
			dataType: "json"
		}).done((res)=>{
			if(res.code == 1) {
				getTeacherList(res.data);
			} else {
				alert("통신오류");
			}
		});
	});
</script>

<%@ include file="layout/footer.jsp" %>
