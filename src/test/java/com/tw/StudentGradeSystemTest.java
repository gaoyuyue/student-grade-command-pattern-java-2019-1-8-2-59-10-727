package com.tw;

import org.junit.Assert;
import org.junit.Test;

public class StudentGradeSystemTest {
    @Test
    public void should_return_student_grade_info_when_parse_correct_student_grade_format_string() {
        String studentGradeInfoString = "张三，201514620108，语文：75，数学：95，英语：80，编程：80";
        StudentGradeInfo expectInfo = new StudentGradeInfo("张三", "201514620108", 75, 95, 80, 80);
        StudentGradeSystem studentGradeSystem = new StudentGradeSystem();
        StudentGradeInfo actualInfo = studentGradeSystem.parseStudent(studentGradeInfoString);
        Assert.assertEquals(expectInfo, actualInfo);
    }
}
