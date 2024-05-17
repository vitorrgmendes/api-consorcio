package com.consorcio.api.Repository;

import com.consorcio.api.Model.FilterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilterRepository extends JpaRepository<FilterModel, Long> {
}
