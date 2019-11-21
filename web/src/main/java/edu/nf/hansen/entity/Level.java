package edu.nf.hansen.entity;

/**
 * @author Achine
 * @date 2019/11/18
 */
public class Level {
    private Integer levelId;
    private String levelName;
    private Integer levelNum;

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Integer getLevelNum() {
        return levelNum;
    }

    public void setLevelNum(Integer levelNum) {
        this.levelNum = levelNum;
    }
}
