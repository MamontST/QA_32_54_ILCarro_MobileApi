package dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BookedDto {
    private String email;
    private String startDate;
    private String endDate;
}
