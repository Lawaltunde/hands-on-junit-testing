package com.hammedcode.exercise;

import com.hammedcode.Exercise;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;

class ExerciseTest {
    private Exercise exercise;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        exercise = new Exercise();
    }

    @Test
    void canGetGrade() {
        var score = 85;
        var grade = exercise.getGrade(score);
        assertThat(grade).isEqualTo("B");
    }

    @Test
    void canCountVowels() {
    }

    @Test
    void isValidStudentId() {
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