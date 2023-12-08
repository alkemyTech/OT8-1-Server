package com.alkemy.wallet.controller;

import com.alkemy.wallet.entity.FixedTermDeposit;
import com.alkemy.wallet.service.FixedTermDepositService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fixed-term-deposits")
public class FixedTermDepositController {

    private final FixedTermDepositService fixedTermDepositService;

    public FixedTermDepositController(FixedTermDepositService fixedTermDepositService) {
        this.fixedTermDepositService = fixedTermDepositService;
    }

    @GetMapping("/")
    public List<FixedTermDeposit> getAllFixedTermDeposits() {
        return fixedTermDepositService.getAllFixedTermDeposits();
    }

    @PostMapping("/")
    public FixedTermDeposit createFixedTermDeposit(@RequestBody FixedTermDeposit fixedTermDeposit) {
        return fixedTermDepositService.createFixedTermDeposit(fixedTermDeposit);
    }

}
