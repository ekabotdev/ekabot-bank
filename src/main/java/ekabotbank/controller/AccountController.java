package ekabotbank.controller;

import ekabotbank.dto.*;
import ekabotbank.service.AccountService;
import ekabotbank.service.TransferService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    public  final AccountService accountService;
    public  final TransferService transferService;
    public AccountController(AccountService accountService, TransferService transferService) {
        this.transferService = transferService;
        this.accountService = accountService;
    }
    @PostMapping
     public AccountResponse createAccount(@RequestBody CreateAccountRequest request) {
        return  accountService.createAccount(request);
    }
    @GetMapping
    public List<AccountResponse> findAllAccounts() {
        return accountService.findAllAccounts();
    }
    @GetMapping("/{accountNumber}")
    public AccountResponse findByAccountNumber( @PathVariable String accountNumber) {
        return accountService.findByAccountNumber(accountNumber);
    }
    @DeleteMapping("/{accountNumber}")
    public void deleteAccount(@PathVariable String accountNumber) {
        accountService.deleteByAccountNumber(accountNumber);
    }
    @PostMapping("/deposit/{accountNumber}")
    public AccountResponse depositAccount( @RequestBody DepositRequest request, @PathVariable String accountNumber) {
        return accountService.deposit(accountNumber, request);
    }
    @PostMapping("/withdraw/{accountNumber}")
    public AccountResponse withdrawAccount(@RequestBody WithdrawRequest request, @PathVariable String accountNumber) {
        return accountService.withdraw(accountNumber, request);
    }
    @PostMapping("/tranfers")
    public TransferResponse transfer(@RequestBody TransferRequest request) {
        return transferService.transfer(request);
    }
}
