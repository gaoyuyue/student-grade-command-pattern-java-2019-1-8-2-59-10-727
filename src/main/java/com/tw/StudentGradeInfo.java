package com.tw;

import java.io.Serializable;
import java.util.Objects;

public class StudentGradeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public StudentGradeInfo() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setChineseScore(Integer chineseScore) {
        this.chineseScore = chineseScore;
    }

    public void setMathScore(Integer mathScore) {
        this.mathScore = mathScore;
    }

    public void setEnglishScore(Integer englishScore) {
        this.englishScore = englishScore;
    }

    public void setProgramScore(Integer programScore) {
        this.programScore = programScore;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public Integer getChineseScore() {
        return chineseScore;
    }

    public Integer getMathScore() {
        return mathScore;
    }

    public Integer getEnglishScore() {
        return englishScore;
    }

    public Integer getProgramScore() {
        return programScore;
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
