package com.artur_f.project.test;

import com.artur_f.project.repository.CustomersRepository;
import com.artur_f.project.servise.CustomersService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class CustomerServiceTest {

    @Autowired
    CustomersService customersService;

    @MockBean
    private CustomersRepository customersRepository;

    @Test
    public void checkCustomerPhonePositiveCase() {
//        boolean boo = customersService.checkCustomerPhone("29-168-59-36" );
        boolean boo = customersRepository.checkCustomerPhone("1" );
        Assert.assertFalse(boo);

        Mockito.verify(customersRepository, Mockito.times(1)).checkCustomerPhone("1");

    }


}
