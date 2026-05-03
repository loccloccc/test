package com.example.demo11;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    Page<Account> getAll(String search , Pageable pageable){
        return accountRepository.findByName(search, pageable);
    }
}
