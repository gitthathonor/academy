package site.metacoding.academy.web.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CMRespDto<T> {
	private Integer code;
	private String msg;
	private T data;
}
