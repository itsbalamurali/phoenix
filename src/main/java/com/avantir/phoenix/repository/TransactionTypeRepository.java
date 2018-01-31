package com.avantir.phoenix.repository;

import com.avantir.phoenix.model.AccountType;
import com.avantir.phoenix.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lekanomotayo on 01/01/2018.
 */

@Repository
@Transactional
public interface TransactionTypeRepository extends JpaRepository<TransactionType, String> {

    //@Cacheable(value = "endpointById")
    TransactionType findById(@Param("id") Long id);
    //@Cacheable(value = "endpointByName")
    TransactionType findByCodeAllIgnoringCase(@Param("code") String code);
    @Query("FROM Node n WHERE n.status = :status")
    List<TransactionType> findByStatus(@Param("status") int status);


}
