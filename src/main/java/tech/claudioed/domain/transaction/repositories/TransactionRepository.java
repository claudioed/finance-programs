package tech.claudioed.domain.transaction.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import javax.enterprise.context.ApplicationScoped;
import tech.claudioed.domain.transaction.Transaction;
@ApplicationScoped
public class TransactionRepository implements PanacheRepository<Transaction> { }
