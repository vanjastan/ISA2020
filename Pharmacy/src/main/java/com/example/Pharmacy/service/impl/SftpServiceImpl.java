package com.example.Pharmacy.service.impl;

import org.springframework.stereotype.Service;

import java.io.IOException;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;


@Service
public class SftpServiceImpl {

    private SSHClient setup() throws IOException {
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect("192.168.0.13", 22);
        client.authPassword("user", "password");
        return client;
    }

    private SSHClient setupForReport() throws IOException{
        SSHClient client = new SSHClient();
        client.addHostKeyVerifier(new PromiscuousVerifier());
        client.connect("192.168.0.13", 22);
        client.authPassword("user", "password");
        return client;
    }

    public void downloadPrescription() throws IOException {
        SSHClient sshClient = setup();
        SFTPClient sftpClient = sshClient.newSFTPClient();
        String localDir = "src/main/resources";
        sftpClient.get("Prescription_15-01-2021.json", localDir + "Prescription.json");

        sftpClient.close();
        sshClient.disconnect();
    }

    public void downloadReport() throws IOException {
        SSHClient sshClient = setupForReport();
        SFTPClient sftpClient = sshClient.newSFTPClient();
        String localDir = "src/main/resources";
        sftpClient.get("Report_27-12-2020.json", localDir + "Report.json");

        sftpClient.close();
        sshClient.disconnect();
    }
}

