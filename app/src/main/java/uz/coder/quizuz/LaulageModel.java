package uz.coder.quizuz;

public class LaulageModel {
    private int image;
    private String name;
    private String laulage;

    public LaulageModel(int image, String name, String laulage) {
        this.image = image;
        this.name = name;
        this.laulage = laulage;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLaulage() {
        return laulage;
    }

    public void setLaulage(String laulage) {
        this.laulage = laulage;
    }
}
