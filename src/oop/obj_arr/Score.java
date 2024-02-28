package oop.obj_arr;

public class Score {

    /*
     - 이름, 국어, 영어, 수학, 총점, 평균(double)을
      담을 수 있는 객체를 디자인하세요.

     - 학생의 모든 정보를 한 눈에 확인할 수 있게
      scoreInfo() 메서드를 선언해 주세요.
      메서드 내부에는 출력문을 이용해서 모든 정보를 출력해 주세요.

     - 캡슐화를 구현해서 작성해 주세요. (생성자는 맘대로 하세요.)
    */
    private String name;
    private int korean;
    private int english;
    private int math;
    private int total;
    private double average;
    
    public Score() {
    }
    
    public Score(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
        this.setTotalAndAvg();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

//    public void setTotal() {
//        this.total = this.korean + this.english + this.math;
//    }

    public double getAverage() {
        return average;
    }

//    public void setAverage() {
//        this.average = this.total / 3.0;
//    }

    // 점수 유효성 검증
//    int scoreTotal() {
//        return korean + english + math;
//    }

//    double scoreAverage() {
//        return total / 3.0;
//    }

    // 총점과 평균을 한번에 계산해서 세팅하는 메서드
    public void setTotalAndAvg() {
        this.total = this.korean + this.english + this.math;
        this.average = this.total / 3.0;
    }

    public static boolean isValidateScore(int score) {
        if(score > 100 || score < 0) {
            System.out.println("유효하지 않은 점수입니다. (0 ~ 100)");
            return false;
        }
        return true;
    }

    void scoreInfo() {
        System.out.printf("이름: %s\n국어: %d점  영어: %d점  수학: %d점\n총점: %d점\n평균: %.2f점\n"
                , this.name, this.korean, this.english, this.math, this.total, this.average);
    }

//        public Score(String name, int korean, int english, int math) {
//        this.name = name;
//        this.korean = korean;
//        this.english = english;
//        this.math = math;
//        this.total = scoreTotal();
//        this.average = scoreAverage();
//    }

}
