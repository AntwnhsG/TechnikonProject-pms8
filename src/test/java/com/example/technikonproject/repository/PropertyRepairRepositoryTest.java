package com.example.technikonproject.repository;

import com.example.technikonproject.domain.PropertyRepair;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.List;

@DataJpaTest
public class PropertyRepairRepositoryTest {

    @Test
    @DisplayName("Test if the property repairs of specific user are returned")
    void searchPropertyRepairsByWebUserId(){

    }

    @Test
    @DisplayName("Test if all the repairs of a property are returned between specific dates")
    void searchPropertyRepairsByDateOfScheduledRepairBetween(){}
}
