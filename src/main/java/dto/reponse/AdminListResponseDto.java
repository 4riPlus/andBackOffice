package dto.reponse;
import lombok.Getter;
import java.util.List;

@Getter
public class AdminListResponseDto {
    private List<AdminResponseDto> adminList;

    public AdminListResponseDto(List<AdminResponseDto> adminList) {
        this.adminList = adminList;
    }
}
