package ekabotbank.service;


import ekabotbank.entity.Transaction;
import ekabotbank.repository.TransactionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;


@Service
public class TransactionService {
    public final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    public Page<Transaction> getAllTransactions(int page, int size
    ) {

            Pageable pageable = PageRequest.of(page, size);
            return transactionRepository.findAll(pageable);
        }
    }
