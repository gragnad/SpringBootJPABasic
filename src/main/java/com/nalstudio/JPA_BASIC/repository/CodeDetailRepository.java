package com.nalstudio.JPA_BASIC.repository;

import com.nalstudio.JPA_BASIC.domain.CodeDetail;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CodeDetailRepository extends CrudRepository<CodeDetail, Long> {


}
