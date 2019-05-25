package com.tw;

import java.util.Objects;

public class StudentGradeReport {
    private String name;
    private Integer chineseScore;
    private Integer mathScore;
    private Integer englishScore;
    private Integer programScore;

    public StudentGradeReport(String name, Integer chineseScore, Integer mathScore, Integer englishScore, Integer programScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        this.programScore = programScore;
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

    public Double getAverageScore() {
        return getTotalScore() / 4;
    }

    public Double getTotalScore() {
        return chineseScore + mathScore + englishScore + programScore + 0.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentGradeReport that = (StudentGradeReport) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(chineseScore, that.chineseScore) &&
                Objects.equals(mathScore, that.mathScore) &&
                Objects.equals(englishScore, that.englishScore) &&
                Objects.equals(programScore, that.programScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, chineseScore, mathScore, englishScore, programScore);
    }
}
