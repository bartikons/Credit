package com.springboot.credit.credit.controler;

import java.util.List;

import com.springboot.credit.credit.command.CreditCommand;
import com.springboot.credit.credit.service.CreditService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/")
public class CreditControler {
    private final CreditService creditService;

    public CreditControler(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("credit")
    public ResponseEntity<List<CreditCommand>> getCredits() {
        return creditService.getCreditsInfo();
    }

    @PostMapping("credit")
    public ResponseEntity<Integer> createCredit(@RequestBody CreditCommand creditCommand) {
        return creditService.createNewCredit(creditCommand);
    }

}
