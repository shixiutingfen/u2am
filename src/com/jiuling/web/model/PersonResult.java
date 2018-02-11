package com.jiuling.web.model;

import java.util.Date;

public class PersonResult {
    private Long id;

    private String serialnumber;

    private Long cameraid;

    private String imgurl;

    private String bigimgurl;

    private Short objtype;

    private String frmidx;

    private String pos;

    private String headPos;

    private String upperbodyPos;

    private String enlargepos;

    private String uppercolor;

    private Byte gender;

    private Byte age;

    private Byte wheels;

    private Byte backpack;

    private Byte glasses;

    private Byte umbrella;

    private Short angle;

    private Byte carryingbag;

    private Float distance;

    private Short lamShape;

    private Byte bikeHasPlate;

    private Date createtime;

    private Date inserttime;

    private String upperclothing;

    private String trousersStyle;

    private String bikeFeatureJson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber == null ? null : serialnumber.trim();
    }

    public Long getCameraid() {
        return cameraid;
    }

    public void setCameraid(Long cameraid) {
        this.cameraid = cameraid;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public String getBigimgurl() {
        return bigimgurl;
    }

    public void setBigimgurl(String bigimgurl) {
        this.bigimgurl = bigimgurl == null ? null : bigimgurl.trim();
    }

    public Short getObjtype() {
        return objtype;
    }

    public void setObjtype(Short objtype) {
        this.objtype = objtype;
    }

    public String getFrmidx() {
        return frmidx;
    }

    public void setFrmidx(String frmidx) {
        this.frmidx = frmidx == null ? null : frmidx.trim();
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }

    public String getHeadPos() {
        return headPos;
    }

    public void setHeadPos(String headPos) {
        this.headPos = headPos == null ? null : headPos.trim();
    }

    public String getUpperbodyPos() {
        return upperbodyPos;
    }

    public void setUpperbodyPos(String upperbodyPos) {
        this.upperbodyPos = upperbodyPos == null ? null : upperbodyPos.trim();
    }

    public String getEnlargepos() {
        return enlargepos;
    }

    public void setEnlargepos(String enlargepos) {
        this.enlargepos = enlargepos == null ? null : enlargepos.trim();
    }

    public String getUppercolor() {
        return uppercolor;
    }

    public void setUppercolor(String uppercolor) {
        this.uppercolor = uppercolor == null ? null : uppercolor.trim();
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Byte getWheels() {
        return wheels;
    }

    public void setWheels(Byte wheels) {
        this.wheels = wheels;
    }

    public Byte getBackpack() {
        return backpack;
    }

    public void setBackpack(Byte backpack) {
        this.backpack = backpack;
    }

    public Byte getGlasses() {
        return glasses;
    }

    public void setGlasses(Byte glasses) {
        this.glasses = glasses;
    }

    public Byte getUmbrella() {
        return umbrella;
    }

    public void setUmbrella(Byte umbrella) {
        this.umbrella = umbrella;
    }

    public Short getAngle() {
        return angle;
    }

    public void setAngle(Short angle) {
        this.angle = angle;
    }

    public Byte getCarryingbag() {
        return carryingbag;
    }

    public void setCarryingbag(Byte carryingbag) {
        this.carryingbag = carryingbag;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Short getLamShape() {
        return lamShape;
    }

    public void setLamShape(Short lamShape) {
        this.lamShape = lamShape;
    }

    public Byte getBikeHasPlate() {
        return bikeHasPlate;
    }

    public void setBikeHasPlate(Byte bikeHasPlate) {
        this.bikeHasPlate = bikeHasPlate;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getInserttime() {
        return inserttime;
    }

    public void setInserttime(Date inserttime) {
        this.inserttime = inserttime;
    }

    public String getUpperclothing() {
        return upperclothing;
    }

    public void setUpperclothing(String upperclothing) {
        this.upperclothing = upperclothing == null ? null : upperclothing.trim();
    }

    public String getTrousersStyle() {
        return trousersStyle;
    }

    public void setTrousersStyle(String trousersStyle) {
        this.trousersStyle = trousersStyle == null ? null : trousersStyle.trim();
    }

    public String getBikeFeatureJson() {
        return bikeFeatureJson;
    }

    public void setBikeFeatureJson(String bikeFeatureJson) {
        this.bikeFeatureJson = bikeFeatureJson == null ? null : bikeFeatureJson.trim();
    }
}