package com.bootcampmck.controller;

import com.bootcampmck.model.Addresses;
import com.bootcampmck.service.ViaCepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
public class AddressesController {

    @GetMapping()
    Addresses returnAddresses(@RequestParam String cep) throws Exception{
        ViaCepService viaCepService = new ViaCepService();
        Addresses newAddresses = null;
        newAddresses = viaCepService.getAddresses(cep);

        return newAddresses;
    }
}
