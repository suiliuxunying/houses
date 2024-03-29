package com.shao.house.house.model;

import java.util.Date;

public class House {

    private Long id;
    private String name;
    private Boolean type;
    private Integer price;
    private String images;
    private Integer area;
    private Integer beds;
    private Integer baths;
    private String remarks;
    private String floorPlan;
    private String tags;
    private Date createTime;
    private Integer cityId;
    private Integer communityId;
    private Boolean state;

    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.id
     *
     * @param id the value for house.id
     *
     * @mbggenerated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.name
     *
     * @return the value of house.name
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.name
     *
     * @param name the value for house.name
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.type
     *
     * @return the value of house.type
     *
     * @mbggenerated
     */
    public Boolean getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.type
     *
     * @param type the value for house.type
     *
     * @mbggenerated
     */
    public void setType(Boolean type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.price
     *
     * @return the value of house.price
     *
     * @mbggenerated
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.price
     *
     * @param price the value for house.price
     *
     * @mbggenerated
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.images
     *
     * @return the value of house.images
     *
     * @mbggenerated
     */
    public String getImages() {
        return images;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.images
     *
     * @param images the value for house.images
     *
     * @mbggenerated
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.area
     *
     * @return the value of house.area
     *
     * @mbggenerated
     */
    public Integer getArea() {
        return area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.area
     *
     * @param area the value for house.area
     *
     * @mbggenerated
     */
    public void setArea(Integer area) {
        this.area = area;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.beds
     *
     * @return the value of house.beds
     *
     * @mbggenerated
     */
    public Integer getBeds() {
        return beds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.beds
     *
     * @param beds the value for house.beds
     *
     * @mbggenerated
     */
    public void setBeds(Integer beds) {
        this.beds = beds;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.baths
     *
     * @return the value of house.baths
     *
     * @mbggenerated
     */
    public Integer getBaths() {
        return baths;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.baths
     *
     * @param baths the value for house.baths
     *
     * @mbggenerated
     */
    public void setBaths(Integer baths) {
        this.baths = baths;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.remarks
     *
     * @return the value of house.remarks
     *
     * @mbggenerated
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.remarks
     *
     * @param remarks the value for house.remarks
     *
     * @mbggenerated
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.floor_plan
     *
     * @return the value of house.floor_plan
     *
     * @mbggenerated
     */
    public String getFloorPlan() {
        return floorPlan;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.floor_plan
     *
     * @param floorPlan the value for house.floor_plan
     *
     * @mbggenerated
     */
    public void setFloorPlan(String floorPlan) {
        this.floorPlan = floorPlan == null ? null : floorPlan.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.tags
     *
     * @return the value of house.tags
     *
     * @mbggenerated
     */
    public String getTags() {
        return tags;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.tags
     *
     * @param tags the value for house.tags
     *
     * @mbggenerated
     */
    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.create_time
     *
     * @return the value of house.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.create_time
     *
     * @param createTime the value for house.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.city_id
     *
     * @return the value of house.city_id
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.city_id
     *
     * @param cityId the value for house.city_id
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.community_id
     *
     * @return the value of house.community_id
     *
     * @mbggenerated
     */
    public Integer getCommunityId() {
        return communityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.community_id
     *
     * @param communityId the value for house.community_id
     *
     * @mbggenerated
     */
    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column house.state
     *
     * @return the value of house.state
     *
     * @mbggenerated
     */
    public Boolean getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column house.state
     *
     * @param state the value for house.state
     *
     * @mbggenerated
     */
    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", price=" + price +
                ", images='" + images + '\'' +
                ", area=" + area +
                ", beds=" + beds +
                ", baths=" + baths +
                ", remarks='" + remarks + '\'' +
                ", floorPlan='" + floorPlan + '\'' +
                ", tags='" + tags + '\'' +
                ", createTime=" + createTime +
                ", cityId=" + cityId +
                ", communityId=" + communityId +
                ", state=" + state +
                '}';
    }
}