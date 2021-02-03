package com.example.Pharmacy.controller;

import com.example.Pharmacy.service.impl.SftpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/sftp")
public class SftpController {

    @Autowired
    private SftpServiceImpl sftpServiceImpl;

    @RequestMapping(value = "/downloadPrescription", method = RequestMethod.GET)
    public void download() throws IOException {
        sftpServiceImpl.downloadPrescription();
    }

    @RequestMapping(value = "/downloadReport", method = RequestMethod.GET)
    public void downloadReport() throws IOException {
        sftpServiceImpl.downloadReport();
    }

    @RequestMapping(value = "/downloadUrgentOrder", method = RequestMethod.GET)
    public void downloadUrgentOrder() throws IOException {
        sftpServiceImpl.downloadUrgentOrder();
    }
}
