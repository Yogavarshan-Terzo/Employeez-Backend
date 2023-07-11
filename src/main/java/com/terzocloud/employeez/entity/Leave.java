package com.terzocloud.employeez.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.terzocloud.employeez.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "leaves")
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private String type;
    private String note;
    private Boolean isApplied;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
