package by.tvoibanki.controller;

import by.tvoibanki.domain.Bank;
import by.tvoibanki.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/common")
public class MainController {

    @Autowired
    ExchangeService exchangeService;

    @RequestMapping("/exchange.do")
    public String getExchangePage(Model model) throws IOException {
        ArrayList<Bank> banks = exchangeService.getRatesFromDB();
        model.addAttribute("banks", banks);
        return "exchangeMain";
    }

    @RequestMapping("/updaterates.do")
    public void updateRates() {
        exchangeService.insertMoscowMinskRatesIntoDB();
        exchangeService.insertBelGazRatesIntoDB();
    }

}
