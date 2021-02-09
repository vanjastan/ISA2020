package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Examination;
import com.example.Pharmacy.repository.ExaminationRepository;
import com.example.Pharmacy.service.impl.ExaminationServiceImpl;
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
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExaminationServiceTest {

    @Mock
    private ExaminationRepository examinationRepositoryMock;

    @Mock
    private Examination examinationMock;

    @InjectMocks
    private ExaminationServiceImpl examinationService;

    @Mock
    private ExaminationService exService;

    @Test
    public void testFindAll() {

        when(examinationRepositoryMock.findAll()).thenReturn(Arrays.asList(new Examination(DB_ID, DB_PRICE, DB_DURATION, DB_DATE_EXAMINATION, DB_RATE, DB_TIME_EXAM)));
        List<Examination> examinations = examinationService.findAll();
        assertThat(examinations).hasSize(1);

        verify(examinationRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(examinationRepositoryMock);
    }

    @Test
    @Transactional
    public void saveExamination() {

        when(examinationRepositoryMock.save(examinationMock)).thenReturn(examinationMock);

        Examination savedExamination = examinationService.save(examinationMock);

        assertThat(savedExamination, is(equalTo(examinationMock)));
    }

    @Test
    public void testFindFreeExaminations() {

        List<Examination> examinations = examinationService.findAll();
        Examination ex = new Examination(DB_ID, DB_PRICE, DB_DURATION, DB_DATE_EXAMINATION, DB_RATE, DB_TIME_EXAM);
        ex.setPatient(null);
        examinations.add(ex);
        assertThat(examinations).hasSize(1);

        verify(examinationRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(examinationRepositoryMock);
    }

    @Test
    public void testCancelExamination() {

        when(examinationRepositoryMock.findById(DB_ID)).thenReturn(java.util.Optional.of((examinationMock)));

        Examination dbEx = examinationService.findById(DB_ID);

        assertThat(dbEx.getPatient()).isEqualTo(null);
    }
}
