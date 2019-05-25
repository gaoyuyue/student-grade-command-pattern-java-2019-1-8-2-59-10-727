package com.tw;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PrintUtilTest {
    @Test
    public void should_return_report_string_when_format_report() {
        List<StudentGradeReport> studentGradeReports = new ArrayList<>();
        StudentGradeReport studentGradeReport1 = new StudentGradeReport("张三", 75, 95, 80, 80);
        StudentGradeReport studentGradeReport2 = new StudentGradeReport("王五", 85, 80, 70, 90);
        studentGradeReports.add(studentGradeReport1);
        studentGradeReports.add(studentGradeReport2);
        String actualReport = PrintUtil.formatReport(studentGradeReports);
        String expectReport = "成绩单\n" +
                "姓名|语文|数学|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|75|95|80|80|82.5|330.0\n" +
                "王五|85|80|70|90|81.25|325.0\n" +
                "========================\n" +
                "全班总分平均数：327.5\n" +
                "全班总分中位数：327.5";
        Assert.assertEquals(expectReport, actualReport);
    }
}
