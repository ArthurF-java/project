//package com.artur_f.project.configSecurity;
//
//import com.artur_f.project.entity.Customer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Configuration
//public class Configure {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Bean
//    public SimpleJpaRepository<Customer, Long> getYourEntitySimpleRepository() {
//        return new SimpleJpaRepository<>(Customer.class, entityManager);
//    }
//}
