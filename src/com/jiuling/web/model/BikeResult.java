package com.jiuling.web.model;

import java.util.Date;

public class BikeResult {
    private Long id;

    private String serialnumber;

    private Long cameraid;

    private String imgurl;

    private String bigimgurl;

    private String pos;

    private String headPos;

    private String uppercolor;

    private String helmetcolor;

    private String upperbodyPos;

    private String enlargepos;

    private Byte sex;

    private Byte age;

    private Byte wheels;

    private Byte bag;

    private Byte glasses;

    private Byte umbrella;

    private Integer umbrellaPos;

    private Short angle;

    private Byte handbag;

    private Integer startframeidx;

    private Integer endframeidx;

    private Integer startframepts;

    private Integer endframepts;

    private Integer frameidx;

    private Float distance;

    private Integer bikeColor;

    private Integer bikeGenre;

    private Integer seatingCount;

    private String helmet;

    private Integer helmetColorTag1;

    private Integer helmetColorTag2;

    private Short lamShape;

    private Byte bikeHasPlate;

    private Date createtime;

    private Date inserttime;

    private String coatStyle;

    private String trousersStyle;

    private String billboard;

    private Integer billboardPos;

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

    public String getUppercolor() {
        return uppercolor;
    }

    public void setUppercolor(String uppercolor) {
        this.uppercolor = uppercolor == null ? null : uppercolor.trim();
    }

    public String getHelmetcolor() {
        return helmetcolor;
    }

    public void setHelmetcolor(String helmetcolor) {
        this.helmetcolor = helmetcolor == null ? null : helmetcolor.trim();
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

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
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

    public Byte getBag() {
        return bag;
    }

    public void setBag(Byte bag) {
        this.bag = bag;
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

    public Integer getUmbrellaPos() {
        return umbrellaPos;
    }

    public void setUmbrellaPos(Integer umbrellaPos) {
        this.umbrellaPos = umbrellaPos;
    }

    public Short getAngle() {
        return angle;
    }

    public void setAngle(Short angle) {
        this.angle = angle;
    }

    public Byte getHandbag() {
        return handbag;
    }

    public void setHandbag(Byte handbag) {
        this.handbag = handbag;
    }

    public Integer getStartframeidx() {
        return startframeidx;
    }

    public void setStartframeidx(Integer startframeidx) {
        this.startframeidx = startframeidx;
    }

    public Integer getEndframeidx() {
        return endframeidx;
    }

    public void setEndframeidx(Integer endframeidx) {
        this.endframeidx = endframeidx;
    }

    public Integer getStartframepts() {
        return startframepts;
    }

    public void setStartframepts(Integer startframepts) {
        this.startframepts = startframepts;
    }

    public Integer getEndframepts() {
        return endframepts;
    }

    public void setEndframepts(Integer endframepts) {
        this.endframepts = endframepts;
    }

    public Integer getFrameidx() {
        return frameidx;
    }

    public void setFrameidx(Integer frameidx) {
        this.frameidx = frameidx;
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public Integer getBikeColor() {
        return bikeColor;
    }

    public void setBikeColor(Integer bikeColor) {
        this.bikeColor = bikeColor;
    }

    public Integer getBikeGenre() {
        return bikeGenre;
    }

    public void setBikeGenre(Integer bikeGenre) {
        this.bikeGenre = bikeGenre;
    }

    public Integer getSeatingCount() {
        return seatingCount;
    }

    public void setSeatingCount(Integer seatingCount) {
        this.seatingCount = seatingCount;
    }

    public String getHelmet() {
        return helmet;
    }

    public void setHelmet(String helmet) {
        this.helmet = helmet == null ? null : helmet.trim();
    }

    public Integer getHelmetColorTag1() {
        return helmetColorTag1;
    }

    public void setHelmetColorTag1(Integer helmetColorTag1) {
        this.helmetColorTag1 = helmetColorTag1;
    }

    public Integer getHelmetColorTag2() {
        return helmetColorTag2;
    }

    public void setHelmetColorTag2(Integer helmetColorTag2) {
        this.helmetColorTag2 = helmetColorTag2;
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

    public String getCoatStyle() {
        return coatStyle;
    }

    public void setCoatStyle(String coatStyle) {
        this.coatStyle = coatStyle == null ? null : coatStyle.trim();
    }

    public String getTrousersStyle() {
        return trousersStyle;
    }

    public void setTrousersStyle(String trousersStyle) {
        this.trousersStyle = trousersStyle == null ? null : trousersStyle.trim();
    }

    public String getBillboard() {
        return billboard;
    }

    public void setBillboard(String billboard) {
        this.billboard = billboard == null ? null : billboard.trim();
    }

    public Integer getBillboardPos() {
        return billboardPos;
    }

    public void setBillboardPos(Integer billboardPos) {
        this.billboardPos = billboardPos;
    }
}