package ekabotbank.service;

import ekabotbank.dto.AccountResponse;
import ekabotbank.dto.CreateAccountRequest;
import ekabotbank.dto.DepositRequest;
import ekabotbank.dto.WithdrawRequest;
import ekabotbank.entity.Account;
import ekabotbank.exception.AccountNotFoundException;
import ekabotbank.exception.InsufficientBalanceException;
import ekabotbank.exception.InvalidAmountException;
import ekabotbank.exception.MinimumOpeningBalanceException;
import ekabotbank.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountResponse createAccount(CreateAccountRequest request) {
        if (accountRepository.findByAccountNumber(request.getAccountNumber()) != null) {

            throw new RuntimeException("Account  already exists"
            );

        }if (request.getBalance() < 10000) {
            throw new MinimumOpeningBalanceException("Minimum opening balance is  10000");
        }

        Account account = new Account();
        account.setAccountNumber(request.getAccountNumber());
        account.setOwnerName(request.getOwnerName());
        account.setBalance(request.getBalance());


        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(
                savedAccount.getAccountNumber(),
                savedAccount.getOwnerName(),
                savedAccount.getBalance()
        );
    }
    public List<AccountResponse> findAllAccounts() {
        List<Account> accounts = accountRepository.findAll();
        List<AccountResponse> accountResponses = new ArrayList<>();

        for (Account account : accounts) {
            accountResponses.add(new AccountResponse(
                    account.getAccountNumber(),
                    account.getOwnerName(),
                    account.getBalance()
            ));
        }
        return accountResponses;
    }
    public AccountResponse findByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return new AccountResponse(
                account.getAccountNumber(),
                account.getOwnerName(),
                account.getBalance()
        );
    }
    public void deleteByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        accountRepository.delete(account);
    }
    public AccountResponse deposit(String accountNumber, DepositRequest request) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        if(request.getAmount() <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }
        account.setBalance(account.getBalance() + request.getAmount());
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(
                savedAccount.getAccountNumber(),
                savedAccount.getOwnerName(),
                savedAccount.getBalance()
        );
    }
    public AccountResponse withdraw(String accountNumber, WithdrawRequest request) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        if(request.getAmount() <= 0) {
            throw new InvalidAmountException("Amount must be greater than 0");
        }if (request.getAmount() > account.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        account.setBalance(account.getBalance() - request.getAmount());
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(
                savedAccount.getAccountNumber(),
                savedAccount.getOwnerName(),
                savedAccount.getBalance()
        );
    }

}
