package springrest.exam.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value={"password","ssn"})     //객체를 가지고 json형식으로 변환시 이 속성 제외
public class User extends RepresentationModel<User> {
    private Integer id;

    @Size(min=2, message = "이름은 2글자 이상 입력해주세요.")
    private String name;

    @Past(message = "과거 시간을 입력해주세요.")
    private Date joinDate;

    private String password;
    private String ssn;
}
