package com.devlawal.exercise;


import com.devlawal.Exercise;
import com.devlawal.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class ExerciseTest {
    private Exercise exercise;
    private final List<Student> students = List.of(
            new Student("jenna", 90),
            new Student("lawal", 80),
            new Student("kim", 60),
            new Student("josh", 53),
            new Student("joshua", 45)
    );

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

    @ParameterizedTest
    @CsvSource({
            "-1, IllegalArgumentException",
            "101, IllegalArgumentException"
    })
    void cannotGetGradeButThrowsException(String scoreStr, String expectedException) {
        var score = Integer.parseInt(scoreStr);
        assertThatThrownBy(() -> exercise.getGrade(score)).isInstanceOf(IllegalArgumentException.class).
                hasMessageContaining("Score must be between 0 and 100");
    }

    @Test
    void canCountVowels() {
        String name = "Hammed";
        int vowelCount = exercise.countVowels(name);
        assertThat(vowelCount).isEqualTo(2);
    }

    @Test
    void canCalculateAverage() {
        double actual = exercise.calculateAverage(List.of(6, 8, 9));
        assertThat(actual).isEqualTo(7.666666666666667);
    }

    @ParameterizedTest
    @CsvSource({
            "S9875, true",
            "S1768, true",
            "S1868, true",
            "1768, false"

    })
    void isValidStudentId(String stdId, String expectedBoolean) {
        Boolean expected = Boolean.parseBoolean(expectedBoolean);
        boolean isCorrectId = exercise.isValidStudentId(stdId);
        assertThat(isCorrectId).isEqualTo(expected);
    }

    @Test
    void canGenerateUsername() {
        var fullName = "Hammed Lawal";
        var actual = exercise.generateUsername(fullName);
        assertThat(actual).isEqualTo("hlawal");
    }

    @Test
    void canGetTopStudents() {
        List<Student> topStudents = exercise.getTopStudents(students, 79);
        List<Student> expected = List.of(
                new Student("kim", 60),
                new Student("josh", 53),
                new Student("joshua", 45)
        );
        assertThat(expected).isEqualTo(topStudents);
    }

    @Test
    void hasDuplicateNames() {
        //boolean actual = exercise.hasDuplicateNames(students);
        assertThat(exercise.hasDuplicateNames(students)).isEqualTo(false);
    }

    @Test
    void canReverseCourses() {
        List<String> actual = exercise.reverseCourses(List.of("Biology", "Physics", "Math", "Chemistry"));
        assertThat(actual).isEqualTo(List.of("Chemistry", "Math", "Physics", "Biology"));
    }

    @ParameterizedTest
    @CsvSource({
            "90, true",
            "10, false",
            "70, true",
            "40, false",
            "82, true",
            "49, false"
    })
    void hasPassed(String score, String expectedBoolean) {
        int stdScore = Integer.parseInt(score);
        boolean actual = exercise.hasPassed(stdScore);
        assertThat(actual).isEqualTo(Boolean.parseBoolean(expectedBoolean));
    }

    @Test
    void canAssignBadge() {
        String actual = exercise.assignBadge(false);
        assertThat(actual).isEqualTo("Needs Improvement");
    }
}