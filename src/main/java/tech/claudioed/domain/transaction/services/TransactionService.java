package tech.claudioed.domain.transaction.services;

import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.transaction.repositories.TransactionRepository;

@ApplicationScoped
public class TransactionService {

  private final TransactionRepository transactionRepository;

  public TransactionService(TransactionRepository transactionRepository) {
    this.transactionRepository = transactionRepository;
  }


}
