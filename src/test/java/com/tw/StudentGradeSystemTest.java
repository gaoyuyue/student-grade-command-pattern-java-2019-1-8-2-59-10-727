package com.tw;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StudentGradeSystemTest {
    private StudentGradeSystem studentGradeSystem;
    @Before
    public void before() {
        studentGradeSystem = new StudentGradeSystem();
    }

    @Test
    public void should_return_student_grade_info_when_parse_correct_student_grade_format_string() {
        String studentGradeInfoString = "张三，201514620108，语文：75，数学：95，英语：80，编程：80";
        StudentGradeInfo expectInfo = new StudentGradeInfo("张三", "201514620108", 75, 95, 80, 80);
        StudentGradeInfo actualInfo = studentGradeSystem.parseStudent(studentGradeInfoString);
        Assert.assertEquals(expectInfo, actualInfo);
    }

    @Test
    public void should_return_null_when_parse_not_correct_student_grade_format_string() {
        String studentGradeInfoString = "张三，201514620108，语文> 75，数学> 95，英语> 80，编程> 80";
        StudentGradeInfo actualInfo = studentGradeSystem.parseStudent(studentGradeInfoString);
        Assert.assertNull(actualInfo);
    }

    @Test
    public void should_return_true_when_save_a_student_grade_info() {
        StudentGradeInfo studentGradeInfo = new StudentGradeInfo("张三", "201514620108", 75, 95, 80, 80);
        Assert.assertTrue(studentGradeSystem.save(studentGradeInfo));
    }

    @Test
    public void should_return_false_when_save_a_existed_student_grade_info() {
        StudentGradeInfo studentGradeInfo = new StudentGradeInfo("张三", "201514620108", 75, 95, 80, 80);
        Assert.assertTrue(studentGradeSystem.save(studentGradeInfo));
        Assert.assertFalse(studentGradeSystem.save(studentGradeInfo));
    }
}
