package dto.reponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponseDto {
    private Integer status;
    private String message;

    public ApiResponseDto(String message, int status) {
        this.status = status;
        this.message = message;
    }
}
