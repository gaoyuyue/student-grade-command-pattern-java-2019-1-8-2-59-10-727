package com.tw;

import java.util.List;

public class PrintUtil {
    public static String formatReport(List<StudentGradeReport> studentGradeReports) {
        StringBuilder builder = new StringBuilder();
        builder.append("成绩单\n" +
                "姓名|语文|数学|英语|编程|平均分|总分\n" +
                "========================\n");
        studentGradeReports.forEach(item -> {
            builder.append(item.getName()).append("|")
                    .append(item.getChineseScore()).append("|")
                    .append(item.getMathScore()).append("|")
                    .append(item.getEnglishScore()).append("|")
                    .append(item.getProgramScore()).append("|")
                    .append(item.getAverageScore()).append("|")
                    .append(item.getTotalScore()).append("\n");
        });
        double median = getClassMedianScore(studentGradeReports);
        builder.append("========================\n" + "全班总分平均数：").append(getClassAverageScore(studentGradeReports)).append("\n").append("全班总分中位数：").append(median);
        return builder.toString();
    }

    private static double getClassMedianScore(List<StudentGradeReport> studentGradeReports) {
        double[] result = studentGradeReports.stream().mapToDouble(StudentGradeReport::getTotalScore).sorted().toArray();
        int size = studentGradeReports.size();
        int middle = size >> 1;
        return size % 2 == 1 ? result[middle] : (result[middle - 1] + result[middle]) / 2;
    }

    private static Double getClassAverageScore(List<StudentGradeReport> studentGradeReports) {
        return studentGradeReports.stream().mapToDouble(StudentGradeReport::getTotalScore).sum() / studentGradeReports.size();
    }
}
