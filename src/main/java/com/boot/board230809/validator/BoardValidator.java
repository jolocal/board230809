package com.boot.board230809.validator;

import com.boot.board230809.model.Board;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

//@Autowired(스프링 실행할때 객체 생성) 와 연결
@Component
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Board.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        Board b = (Board) obj;
        // 값이 비어있는 경우
        if(StringUtils.isEmpty(b.getContent())){
            errors.rejectValue("content","key","내용을 입력하세요.");
        }
    }
}
