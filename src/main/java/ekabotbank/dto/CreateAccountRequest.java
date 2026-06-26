package ekabotbank.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CreateAccountRequest {

    @NotBlank
    private String accountNumber;
    @NotBlank
    private String ownerName;
    @Positive
    private double balance;

}
