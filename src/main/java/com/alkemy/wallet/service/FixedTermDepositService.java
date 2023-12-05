package com.alkemy.wallet.service;

import com.alkemy.wallet.entity.FixedTermDeposit;
import com.alkemy.wallet.repository.FixedTermDepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FixedTermDepositService {

    private final FixedTermDepositRepository fixedTermDepositRepository;

    public FixedTermDepositService(FixedTermDepositRepository fixedTermDepositRepository) {
        this.fixedTermDepositRepository = fixedTermDepositRepository;
    }

    public List<FixedTermDeposit> getAllFixedTermDeposits() {
        return fixedTermDepositRepository.findAll();
    }

    public FixedTermDeposit createFixedTermDeposit(FixedTermDeposit fixedTermDeposit) {
        return fixedTermDepositRepository.save(fixedTermDeposit);
    }

}
