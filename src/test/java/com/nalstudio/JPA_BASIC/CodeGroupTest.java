package com.nalstudio.JPA_BASIC;

import com.nalstudio.JPA_BASIC.domain.CodeDetail;
import com.nalstudio.JPA_BASIC.domain.CodeGroup;
import com.nalstudio.JPA_BASIC.repository.CodeDetailRepository;
import com.nalstudio.JPA_BASIC.repository.CodeGroupRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class CodeGroupTest {

    private static final Logger logger = LoggerFactory.getLogger(CodeGroupTest.class);

    @Autowired
    CodeGroupRepository codeGroupRepository;

    @Test
    public void testCodeRegister() {
        CodeGroup codeGroup = new CodeGroup();
        codeGroup.setGroupCode("A01");
        codeGroup.setGroupName("job");

        CodeDetail codeDetail = new CodeDetail();
        codeDetail.setCodeValue("00");
        codeDetail.setCodeName("Developer");

        CodeDetail codeDetail2 = new CodeDetail();
        codeDetail2.setCodeValue("01");
        codeDetail2.setCodeName("Designer");

        codeGroup.setCodeDetails(Arrays.asList(codeDetail, codeDetail2));

        codeGroupRepository.save(codeGroup);
    }

    @Transactional
    @Test
    public void testCodeFindAll() {
        Iterable<CodeGroup> codeGroups= codeGroupRepository.findAll();

        for(CodeGroup codeGroup : codeGroups) {
            logger.info(codeGroup.toString());
        }
    }

    @Transactional
    @Rollback(value = false)
    @Test
    public void testCodeModify() {
        codeGroupRepository.updateCodeDetailName(1L, "super");
    }

}
