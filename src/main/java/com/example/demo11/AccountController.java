package com.example.demo11;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @GetMapping("/home")
    public String home(
            @PageableDefault(page = 0 , size = 2 , sort = "id" , direction = Sort.Direction.ASC)Pageable pageable,
            @RequestParam(name = "search" , defaultValue = "") String search,
            Model model
    ){
        Page<Account> accountPage = accountService.getAll(search, pageable);
        model.addAttribute("accountPage", accountPage);
        model.addAttribute("search", search);
        return "home";
    }

}
