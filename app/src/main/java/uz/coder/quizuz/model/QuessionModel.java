package uz.coder.quizuz.model;

public class QuessionModel {
    private String quession;
    private String var1;
    private String var2;
    private String var3;
    private String var4;
    private String trueAnswer;

    public QuessionModel(String quession, String var1, String var2, String var3, String var4, String trueAnswer) {
        this.quession = quession;
        this.var1 = var1;
        this.var2 = var2;
        this.var3 = var3;
        this.var4 = var4;
        this.trueAnswer = trueAnswer;
    }

    public QuessionModel() {
    }

    public String getQuession() {
        return quession;
    }

    public void setQuession(String quession) {
        this.quession = quession;
    }

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public String getVar2() {
        return var2;
    }

    public void setVar2(String var2) {
        this.var2 = var2;
    }

    public String getVar3() {
        return var3;
    }

    public void setVar3(String var3) {
        this.var3 = var3;
    }

    public String getVar4() {
        return var4;
    }

    public void setVar4(String var4) {
        this.var4 = var4;
    }

    public String getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(String trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
