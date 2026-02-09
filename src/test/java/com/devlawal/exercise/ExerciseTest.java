package com.devlawal.exercise;


import com.devlawal.Exercise;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ExerciseTest {
    private Exercise exercise;

    @BeforeEach
    void setUp() {
        exercise = new Exercise();
    }

    @ParameterizedTest
    @CsvSource({
            "95, A",
            "85, B",
            "75, C",
            "65, D",
            "55, E",
            "45, F"
//            "-1, IllegalArgumentException",
//            "101, IllegalArgumentException"
    })
    void canGetGrade(String scoreStr, String expectedGrade) {
        var score = Integer.parseInt(scoreStr);
        var grade = exercise.getGrade(score);
        assertThat(grade).isEqualTo(expectedGrade);
    }

    @Test
    void canCountVowels() {
        String name = "Hammed";
        int vowelCount = exercise.countVowels(name);
        assertThat(vowelCount).isEqualTo(2);
    }

    @Test
    void isValidStudentId() {
        String stdId = "S9875";
        boolean isCorrectId = exercise.isValidStudentId(stdId);
        assertThat(isCorrectId).isEqualTo(true);
    }

    @Test
    void canCalculateAverage() {
    }

    @Test
    void canGenerateUsername() {
    }

    @Test
    void canGetTopStudents() {
    }

    @Test
    void hasDuplicateNames() {
    }

    @Test
    void canReverseCourses() {
    }

    @Test
    void hasPassed() {
    }

    @Test
    void canAssignBadge() {
    }
}