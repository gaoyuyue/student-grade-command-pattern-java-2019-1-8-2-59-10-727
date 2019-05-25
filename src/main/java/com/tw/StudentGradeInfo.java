package com.tw;

import java.util.Objects;

public class StudentGradeInfo {
    private String name;
    private String studentId;
    private Integer chineseScore;
    private Integer mathScore;
    private Integer englishScore;
    private Integer programScore;

    public StudentGradeInfo(String name, String studentId, Integer chineseScore, Integer mathScore, Integer englishScore, Integer programScore) {
        this.name = name;
        this.studentId = studentId;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGradeInfo that = (StudentGradeInfo) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(studentId, that.studentId) &&
                Objects.equals(chineseScore, that.chineseScore) &&
                Objects.equals(mathScore, that.mathScore) &&
                Objects.equals(englishScore, that.englishScore) &&
                Objects.equals(programScore, that.programScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, studentId, chineseScore, mathScore, englishScore, programScore);
    }
}
