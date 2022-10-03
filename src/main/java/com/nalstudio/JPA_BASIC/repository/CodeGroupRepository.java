package com.nalstudio.JPA_BASIC.repository;

import com.nalstudio.JPA_BASIC.domain.CodeGroup;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface CodeGroupRepository extends CrudRepository<CodeGroup, String> {

    @Modifying
    @Query(value = "DELETE code_detail cd WHERE (cd.code_detail_no = ?1)", nativeQuery = true)
    public int deleteCodeDetail(Long code_detail_no);

    @Modifying
    @Query(value = "UPDATE code_detail cd SET cd.code_name = ?2 WHERE (cd.code_detail_no = ?1)", nativeQuery = true)
    public int updateCodeDetailName(Long code_detail_no, String code_name);
}
