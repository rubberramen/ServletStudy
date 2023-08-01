package hello.servletPrac.presentation.student;

public class Student {

    private long stuNo;
    private String stuName;
    private int korScore;
    private int engScore;
    private int mathScore;
    private int sum;
    private float average;

    public Student() {
    }

    public Student(String stuName, int korScore, int engScore, int mathScore) {
        this.stuName = stuName;
        this.korScore = korScore;
        this.engScore = engScore;
        this.mathScore = mathScore;

        this.sum = korScore + engScore + mathScore;
        this.average = (float) (this.sum / 3.0);
    }

    public long getStuNo() {
        return stuNo;
    }

    public void setStuNo(long stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getKorScore() {
        return korScore;
    }

    public void setKorScore(int korScore) {
        this.korScore = korScore;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return  "학번 = " + stuNo +
                ", 이름 = " + stuName +
                ", 언어 점수 = " + korScore +
                ", 영어 점수 = " + engScore +
                ", 수학 점수 = " + mathScore +
                ", 합계 = " + sum +
                ", 평균 = " + average;
    }
}