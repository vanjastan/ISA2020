package com.example.Pharmacy.service;

import com.example.Pharmacy.model.EPrescription;
import com.example.Pharmacy.repository.EPrescriptionRepository;
import com.example.Pharmacy.service.impl.EPrescriptionServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static com.example.Pharmacy.constants.EPrescriptionConstants.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EPrescriptionServiceTest {

    @Mock
    private EPrescriptionRepository prescriptionRepositoryMock;

    @InjectMocks
    private EPrescriptionServiceImpl prescriptionService;

    @Mock
    private EPrescription prescriptionMock;

    @Test
    public void testFindOne() {

        when(prescriptionRepositoryMock.findById(DB_ID)).thenReturn(java.util.Optional.of(prescriptionMock));

        EPrescription dbPrescription = prescriptionService.findOne(DB_ID);

        assertEquals(prescriptionMock, dbPrescription);
        verify(prescriptionRepositoryMock, times(1)).findById(DB_ID);
        verifyNoMoreInteractions(prescriptionRepositoryMock);
    }

    @Test
    public void testFindAll() {

        when(prescriptionRepositoryMock.findAll()).thenReturn(Arrays.asList(new EPrescription(DB_ID, DB_DATE_OF_PUB, DB_STATUS)));
        List<EPrescription> prescriptions = prescriptionService.findAll();
        assertThat(prescriptions).hasSize(1);

        verify(prescriptionRepositoryMock, times(1)).findAll();
        verifyNoMoreInteractions(prescriptionRepositoryMock);
    }
}
