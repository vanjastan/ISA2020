package com.example.Pharmacy.service;

import com.example.Pharmacy.model.ExaminationPh;
import com.example.Pharmacy.repository.ExaminationPhRepository;
import com.example.Pharmacy.service.impl.ExaminationPhServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

import static com.example.Pharmacy.constants.ExaminationConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationPhServiceTest {
    @Mock
    private ExaminationPhRepository examinationPhRepositoryMock;

    @Mock
    private ExaminationPh examinationPhMock;

    @InjectMocks
    private ExaminationPhServiceImpl examinationPhService;

    @Mock
    private ExaminationPhService exPhService;

    @Test
    public void testFindAll() {

        when(examinationPhRepositoryMock.findAll()).thenReturn(Arrays.asList(new ExaminationPh(DB_ID, DB_PRICE, DB_DURATION, DB_DATE_EXAMINATION)));
        List<ExaminationPh> examinations = examinationPhService.findAll();
        assertThat(examinations).hasSize(1);

        verify(examinationPhRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(examinationPhRepositoryMock);
    }

    @Test
    @Transactional
    public void saveExamination() {

        when(examinationPhRepositoryMock.save(examinationPhMock)).thenReturn(examinationPhMock);

        ExaminationPh savedExamination = examinationPhService.save(examinationPhMock);

        Assert.assertThat(savedExamination, is(equalTo(examinationPhMock)));
    }
}

