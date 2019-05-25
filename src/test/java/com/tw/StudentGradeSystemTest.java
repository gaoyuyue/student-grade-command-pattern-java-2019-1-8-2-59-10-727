package com.tw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentGradeSystemTest {
    private StudentGradeSystem studentGradeSystem;
    @Before
    public void before() {
        studentGradeSystem = new StudentGradeSystem();
    }

    @After
    public void after() {
        new File("student_grade_infos.json").delete();
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

    @Test
    public void should_return_that_grade_infos_when_find_some_student_by_ids() {
        List<StudentGradeInfo> expectInfos = new ArrayList<>();
        StudentGradeInfo studentGradeInfo1 = new StudentGradeInfo("张三", "201514620107", 75, 95, 80, 80);
        StudentGradeInfo studentGradeInfo2 = new StudentGradeInfo("张三", "201514620108", 75, 95, 80, 80);
        StudentGradeInfo studentGradeInfo3 = new StudentGradeInfo("张三", "201514620109", 75, 95, 80, 80);
        studentGradeSystem.save(studentGradeInfo1);
        studentGradeSystem.save(studentGradeInfo2);
        studentGradeSystem.save(studentGradeInfo3);
        expectInfos.add(studentGradeInfo1);
        expectInfos.add(studentGradeInfo3);

        List<StudentGradeInfo> actualInfos = studentGradeSystem.find(Arrays.asList("201514620107", "201514620109"));
        Assert.assertArrayEquals(expectInfos.toArray(), actualInfos.toArray());
    }

    @Test
    public void should_return_student_grade_report_when_generate_student_grade_report() {
        StudentGradeInfo studentGradeInfo1 = new StudentGradeInfo("张三", "201514620107", 75, 95, 80, 80);
        StudentGradeInfo studentGradeInfo2 = new StudentGradeInfo("李四", "201514620108", 75, 95, 80, 80);
        StudentGradeInfo studentGradeInfo3 = new StudentGradeInfo("王五", "201514620109", 75, 95, 80, 80);
        studentGradeSystem.save(studentGradeInfo1);
        studentGradeSystem.save(studentGradeInfo2);
        studentGradeSystem.save(studentGradeInfo3);

        List<StudentGradeReport> expectInfos = new ArrayList<>();
        StudentGradeReport studentGradeReport1 = new StudentGradeReport("张三", 75, 95, 80, 80);
        StudentGradeReport studentGradeReport2 = new StudentGradeReport("王五", 75, 95, 80, 80);
        expectInfos.add(studentGradeReport1);
        expectInfos.add(studentGradeReport2);

        List<StudentGradeInfo> studentGradeInfos = studentGradeSystem.find(Arrays.asList("201514620107", "201514620109"));
        List<StudentGradeReport> actualInfos = studentGradeSystem.generateReport(studentGradeInfos);
        Assert.assertArrayEquals(expectInfos.toArray(), actualInfos.toArray());
    }

    @Test
    public void should_return_student_id_list_when_parse_student_ids_string() {
        List<String> expectIds = Arrays.asList("201514620108", "201514620109");
        List<String> actualIds = studentGradeSystem.parseStudentIds("201514620108, 201514620109");
        Assert.assertArrayEquals(expectIds.toArray(), actualIds.toArray());
    }
}
