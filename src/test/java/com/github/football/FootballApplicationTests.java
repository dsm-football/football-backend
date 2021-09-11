package com.github.football;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FootballApplicationTests {

    @Test
    @DisplayName("테스트 환경 점검 테스트")
    void test() {

    }
}
