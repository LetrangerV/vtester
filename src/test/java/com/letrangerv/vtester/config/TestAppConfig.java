package com.letrangerv.vtester.config;

import com.letrangerv.vtester.persistence.QuizAssembler;
import com.letrangerv.vtester.persistence.QuizAssemblerImpl;
import com.letrangerv.vtester.persistence.QuizDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author VStrokan
 * @version 1.0
 * @since 3/11/16
 */
@Configuration
@Profile("dev")
public class TestAppConfig {
    @Bean
    public QuizAssembler quizAssembler() {
        return new QuizAssemblerImpl();
    }

    @Bean
    public QuizDto quizDto() {
        QuizDto quizDto = new QuizDto();
        quizDto.setNumberOfOptions(new int[]{2, 1, 3, 4});
        quizDto.setQuestionTypes(new String[]{"multi_answer", "user_input", "mapping", "one_answer"});
        quizDto.setOptionText(new String[]{
            "q1op1",
            "q1op2",
            "q2op1",
            "q3op1",
            "q3op2",
            "q3op3",
            "q4op1",
            "q4op2",
            "q4op3",
            "q4op4"
        });
        quizDto.setQuestionText(new String[]{"q1", "q2", "q3", "q4"});
        quizDto.setRightAnswer(new boolean[]{
            true, false,
            true,
            false, false, true,
            true, true, false, false
        });
        return quizDto;
    }
}
