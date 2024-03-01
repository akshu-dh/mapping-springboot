package com.mapping.entity;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "colleges")
//@AllArgsConstructor
@NoArgsConstructor
public class College {

    public Long getC_id() {
        return c_id;
    }

    public void setC_id(Long c_id) {
        this.c_id = c_id;
    }

    public College(Long c_id, String c_name, List<Student> students, List<Employee> employees, List<Faculty> faculties) {
        this.c_id = c_id;
        C_name = c_name;
        this.students = students;
        this.employees = employees;
        this.faculties = faculties;
    }

    public String getC_name() {
        return C_name;
    }

    public void setC_name(String c_name) {
        C_name = c_name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    @Id
    @Column(name = "`c_id`")
    @GeneratedValue
    private Long c_id;
    private  String C_name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
    private List<Student> students;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
    private List<Employee> employees;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_c_id", referencedColumnName = "c_id")
    private List<Faculty> faculties;



}
