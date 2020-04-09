package com.fqyd.hrm.model;

import java.util.Date;

public class Employee {
    /**
     * 职员ID
     */
    private Integer id;

    /**
     * 部门ID
     */
    private Integer departmentId;

    /**
     * 职位ID
     */
    private Integer jobId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 工号
     */
    private String cardId;

    /**
     * 地址
     */
    private String address;

    /**
     * 邮政编码
     */
    private String postCode;

    /**
     * 家庭电话
     */
    private String telephone;

    /**
     * 移动号码
     */
    private String mobile;

    /**
     * QQ号
     */
    private String qq;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 派别
     */
    private String party;

    /**
     * 生日
     */
    private Date birthday;

    /**
     * 种族
     */
    private String race;

    /**
     * 教育
     */
    private String education;

    /**
     * 特长
     */
    private String speciality;

    /**
     * 爱好
     */
    private String hobby;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 职员ID
     * @return id 职员ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * 职员ID
     * @param id 职员ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 部门ID
     * @return department_id 部门ID
     */
    public Integer getDepartmentId() {
        return departmentId;
    }

    /**
     * 部门ID
     * @param departmentId 部门ID
     */
    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * 职位ID
     * @return job_id 职位ID
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * 职位ID
     * @param jobId 职位ID
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * 姓名
     * @return name 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 工号
     * @return card_id 工号
     */
    public String getCardId() {
        return cardId;
    }

    /**
     * 工号
     * @param cardId 工号
     */
    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    /**
     * 地址
     * @return address 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 邮政编码
     * @return post_code 邮政编码
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮政编码
     * @param postCode 邮政编码
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode == null ? null : postCode.trim();
    }

    /**
     * 家庭电话
     * @return telephone 家庭电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 家庭电话
     * @param telephone 家庭电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 移动号码
     * @return mobile 移动号码
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 移动号码
     * @param mobile 移动号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * QQ号
     * @return qq QQ号
     */
    public String getQq() {
        return qq;
    }

    /**
     * QQ号
     * @param qq QQ号
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 性别
     * @return sex 性别
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别
     * @param sex 性别
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 派别
     * @return party 派别
     */
    public String getParty() {
        return party;
    }

    /**
     * 派别
     * @param party 派别
     */
    public void setParty(String party) {
        this.party = party == null ? null : party.trim();
    }

    /**
     * 生日
     * @return birthday 生日
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 种族
     * @return race 种族
     */
    public String getRace() {
        return race;
    }

    /**
     * 种族
     * @param race 种族
     */
    public void setRace(String race) {
        this.race = race == null ? null : race.trim();
    }

    /**
     * 教育
     * @return education 教育
     */
    public String getEducation() {
        return education;
    }

    /**
     * 教育
     * @param education 教育
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * 特长
     * @return speciality 特长
     */
    public String getSpeciality() {
        return speciality;
    }

    /**
     * 特长
     * @param speciality 特长
     */
    public void setSpeciality(String speciality) {
        this.speciality = speciality == null ? null : speciality.trim();
    }

    /**
     * 爱好
     * @return hobby 爱好
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 爱好
     * @param hobby 爱好
     */
    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    /**
     * 备注
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 创建时间
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", departmentId=").append(departmentId);
        sb.append(", jobId=").append(jobId);
        sb.append(", name=").append(name);
        sb.append(", cardId=").append(cardId);
        sb.append(", address=").append(address);
        sb.append(", postCode=").append(postCode);
        sb.append(", telephone=").append(telephone);
        sb.append(", mobile=").append(mobile);
        sb.append(", qq=").append(qq);
        sb.append(", email=").append(email);
        sb.append(", sex=").append(sex);
        sb.append(", party=").append(party);
        sb.append(", birthday=").append(birthday);
        sb.append(", race=").append(race);
        sb.append(", education=").append(education);
        sb.append(", speciality=").append(speciality);
        sb.append(", hobby=").append(hobby);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}