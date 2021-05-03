package com.hcl.bank.repositry;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.bank.model.Transaction;

@Repository
public interface TransactionRepositry extends JpaRepository<Transaction, Integer> {
	@Query("from Transaction t where t.fromAccount=:accountNumber and Month(t.dateOfTransaction)=:month")
	List<Transaction> findByFromAccountAndDateOfTransaction(@Param("accountNumber") Long accountNumber,
			@Param("month") int month, Pageable pagable);

	@Query("from Transaction t where t.fromAccount=:fromAccount and Month(t.dateOfTransaction)=:date")

	List<Transaction> findByFromAccountAndDateOfTransaction(@Param("fromAccount") Long fromAccount,
			@Param("date") Integer date);

	/*
	 * @Query("from Transaction t where t.fromAccount=:accountNumber and t.dateOfTransaction BETWEEN :fromDate AND :toDate"
	 * )
	 * 
	 * List<Transaction>
	 * findByFromAccountAndDateOfTransaction(@Param("accountNumber") Long
	 * accountNumber,
	 * 
	 * @Param("fromDate") LocalDate fromDate, @Param("toDate") LocalDate toDate);
	 */
	List<Transaction> findByFromAccountAndDateOfTransactionBetween(Long accountNumber, LocalDate fromDate,
			LocalDate toDate);

}
