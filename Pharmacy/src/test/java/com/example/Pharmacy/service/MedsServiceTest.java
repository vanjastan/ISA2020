package com.example.Pharmacy.service;

import com.example.Pharmacy.model.Meds;
import com.example.Pharmacy.repository.MedsRepository;
import com.example.Pharmacy.service.impl.MedsServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import static com.example.Pharmacy.constants.MedsConstants.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedsServiceTest {

    @Mock
    private MedsRepository medsRepositoryMock;

    @InjectMocks
    private MedsServiceImpl medsService;

    @Mock
    private Meds medsMock;

    @Test
    public void testFindAll() {

        when(medsRepositoryMock.findAll()).thenReturn(Arrays.asList(new Meds(DB_ID, DB_NAME, DB_CODE, DB_TYPE, DB_CONTRADICTIONS, DB_INGREDIENTS, DB_DAILYDOSE, DB_REPLACEMENT, DB_SHAPE, DB_MANUFACTURER, DB_ISSUING, DB_NOTES, DB_RESERVED, DB_ALLERGIC)));
        List<Meds> meds = medsService.findAll();
        assertThat(meds).hasSize(1);

        verify(medsRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(medsRepositoryMock);
    }

    @Test
    @Transactional
    public void saveMed() {

        when(medsRepositoryMock.save(medsMock)).thenReturn(medsMock);

        Meds savedMeds = medsService.save(medsMock);

        Assert.assertThat(savedMeds, is(equalTo(medsMock)));
    }

    @Test
    public void testFindOne() {

        when(medsRepositoryMock.findById(DB_ID)).thenReturn(java.util.Optional.of(medsMock));

        Meds dbMeds = medsService.findOne(DB_ID);

        assertEquals(medsMock, dbMeds);
        verify(medsRepositoryMock, times(1)).findById(DB_ID);
        verifyNoMoreInteractions(medsRepositoryMock);
    }

    @Test
    public void testCancelMedicine() {

        when(medsRepositoryMock.findById(DB_ID)).thenReturn(java.util.Optional.of((medsMock)));

        Meds dbMeds = medsService.findById(DB_ID);

        assertThat(dbMeds.getPatient()).isEqualTo(null);
    }
}
