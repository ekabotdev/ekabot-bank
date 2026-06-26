package ekabotbank.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionResponse {
    private String fromAccount;
    private String toAccount;
    private double amount;
    private LocalDateTime transactionDate;

}
