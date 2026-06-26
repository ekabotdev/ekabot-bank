package ekabotbank.controller;


import ekabotbank.entity.Transaction;
import ekabotbank.service.TransactionService;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Pageable;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    public final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }
    @GetMapping
    public Page<Transaction> getTransactions(
            @RequestParam
            @Min(0)
            int page,

            @RequestParam
            @Positive
            int size
    ) {
        return transactionService.getAllTransactions(page, size);
    }
}
