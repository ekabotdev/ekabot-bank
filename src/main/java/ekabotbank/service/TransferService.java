package ekabotbank.service;


import ekabotbank.dto.TransferRequest;
import ekabotbank.dto.TransferResponse;
import ekabotbank.entity.Account;
import ekabotbank.entity.Transaction;
import ekabotbank.exception.AccountNotFoundException;
import ekabotbank.exception.InsufficientBalanceException;
import ekabotbank.repository.AccountRepository;
import ekabotbank.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferService {
    public final AccountRepository accountRepository;
    public final TransactionRepository transactionRepository;

    @Transactional
    public TransferResponse transfer(TransferRequest request) {

        Account sender = accountRepository.findByAccountNumber(request.getFromAccount());
        Account receiver = accountRepository.findByAccountNumber(request.getToAccount());

        if (sender == null || receiver == null) {
            throw new AccountNotFoundException("Account not found");
        }
        if (sender.getBalance() <request.getAmount()) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        sender.setBalance(sender.getBalance() - request.getAmount());
        receiver.setBalance(receiver.getBalance() + request.getAmount());

        accountRepository.save(sender);
        accountRepository.save(receiver);

        Transaction transaction = new Transaction();
        transaction.setFromAccount(request.getFromAccount());
        transaction.setToAccount(request.getToAccount());
        transaction.setAmount(request.getAmount());
        LocalDateTime.now();


        return new TransferResponse("Transfer Successful",
                request.getAmount());
    }

}
