package com.nickrankin.ca1.CA1.Web.Services.helpers;

import com.nickrankin.ca1.CA1.Web.Services.model.Return;
import com.nickrankin.ca1.CA1.Web.Services.model.User;
import com.nickrankin.ca1.CA1.Web.Services.repository.ReturnsRepository;
import com.nickrankin.ca1.CA1.Web.Services.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {
    private static final Logger log = LoggerFactory.getLogger(DataLoader.class);





    @Bean
    CommandLineRunner initDb(UsersRepository repo, ReturnsRepository returnsRepo) {
        return data -> {
            log.info("Adding " + repo.save(new User("Nick Rankin", "123 Fake St", "1234K", "123")));
            log.info("Adding " + repo.save(new User("Mary Jane", "13 John St", "5264K", "123")));
            log.info("Adding " + repo.save(new User("Joe Bloggs", "84 City St", "82745K", "123")));
            log.info("Adding " + repo.save(new User("Sean O'Brien", "3 town Road", "13244K", "123")));
            log.info("========================~~~~~~~~~~~~~~~~~~~~~~~~~~~~==============================");
            log.info("Adding tax " + returnsRepo.save(new Return(1L, Form.FORM_11, 2023, 2456.45)));

        };
    }
}
