package com.shao.house.house.model;

import java.util.Date;
import java.util.List;

public class HouseCondition {
//    private Long id;
//    private String name;
//    private String images;
//    private Boolean type;//1:卖 2：租
    private House house;
    private List<Integer> priceN;
    private List<Integer> areaN;
    private List<Integer> bedsN;
    private List<Integer> bathN;
    private List<String> tagsS;
//    private String remarks;
//    private String floorPlan;
//    private Date createTime;
//    private Integer cityId;
//    private Integer communityId;
//    private Boolean state;

    public void setHouse(House house) {
        this.house = house;
    }

    public void setPriceN(List<Integer> priceN) {
        this.priceN = priceN;
    }

    public void setAreaN(List<Integer> areaN) {
        this.areaN = areaN;
    }

    public void setBedsN(List<Integer> bedsN) {
        this.bedsN = bedsN;
    }

    public void setBathN(List<Integer> bathN) {
        this.bathN = bathN;
    }

    public void setTagsS(List<String> tagsS) {
        this.tagsS = tagsS;
    }

    public House getHouse() {

        return house;
    }

    public List<Integer> getPriceN() {
        return priceN;
    }

    public List<Integer> getAreaN() {
        return areaN;
    }

    public List<Integer> getBedsN() {
        return bedsN;
    }

    public List<Integer> getBathN() {
        return bathN;
    }

    public List<String> getTagsS() {
        return tagsS;
    }

    @Override
    public String toString() {
        return "HouseCondition{" +
                "house=" + house +
                ", priceN=" + priceN +
                ", areaN=" + areaN +
                ", bedsN=" + bedsN +
                ", bathN=" + bathN +
                ", tagsS=" + tagsS +
                '}';
    }
}
