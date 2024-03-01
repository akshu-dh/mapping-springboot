package com.mapping.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@Table(name = "student")
//@AllArgsConstructor
@NoArgsConstructor
public class Student {

    public Long getS_id() {
        return s_id;
    }

    public void setS_id(Long s_id) {
        this.s_id = s_id;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String s_name) {
        S_name = s_name;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Student(Long s_id, String s_name, College college) {
        this.s_id = s_id;
        S_name = s_name;
        this.college = college;
    }

    @Id
    @Column(name = "`s_id`")
    @GeneratedValue
    private Long s_id;
    private  String S_name;

    @ManyToOne
    @JoinColumn(name = "fk_c_id")
    private College college;
}
