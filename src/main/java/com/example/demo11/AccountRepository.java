package com.example.demo11;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("""
    select a from Account a where a.name like concat('%',:search,'%') 
    """)
    Page<Account> findByName(@Param("search") String search, Pageable pageable);
}
