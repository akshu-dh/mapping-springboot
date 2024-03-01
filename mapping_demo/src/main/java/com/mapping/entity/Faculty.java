package com.mapping.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="faculty")
@AllArgsConstructor
@NoArgsConstructor
public class Faculty {

    @Id
    @Column(name="`f_id`")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long f_id;
    private String f_name;

    @JsonIgnore
//	@ManyToOne(optional = false,cascade = CascadeType.ALL)
//	@JoinColumn(name = "c_id")
//	private College college;
//	@ManyToOne fix---
//	private College college; fix---
    @ManyToOne
    @JoinColumn(name = "fk_c_id")
    private College college;
}
