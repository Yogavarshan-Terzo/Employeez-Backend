package com.terzocloud.employeez.repository;

import com.terzocloud.employeez.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface LeaveRepository extends JpaRepository<Leave,Long> {
}
