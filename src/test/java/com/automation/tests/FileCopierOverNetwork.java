package com.automation.tests;

import java.util.Properties;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
//this is the working copy of code that establishes connection between linux and windows


//if there is any problem add the following
//vi /etc/ssh/sshd_config

/*
Port 22
Protocol 2
HostKey /etc/ssh/ssh_host_rsa_key
HostKey /etc/ssh/ssh_host_dsa_key
HostKey /etc/ssh/ssh_host_ecdsa_key
HostKey /etc/ssh/ssh_host_ed25519_key
UsePrivilegeSeparation yes
KeyRegenerationInterval 3600
ServerKeyBits 1024
SyslogFacility AUTH
LogLevel INFO
LoginGraceTime 120
PermitRootLogin no
StrictModes yes
RSAAuthentication yes
PubkeyAuthentication yes
IgnoreRhosts yes
RhostsRSAAuthentication no
HostbasedAuthentication no
PermitEmptyPasswords no
ChallengeResponseAuthentication no
X11Forwarding yes
X11DisplayOffset 10
PrintMotd no
PrintLastLog yes
TCPKeepAlive yes
AcceptEnv LANG LC_*
Subsystem sftp /usr/lib/openssh/sftp-server
UsePAM yes
ClientAliveInterval 30
ClientAliveCountMax 99999
*/
public class FileCopierOverNetwork {
    public static void main(String args[]) {
        String hostname = "192.168.1.220";
        String username = "root";
        String password = "abhi_123";
        String copyFrom = "/home/siva/Desktop/appl/applicationName/one.txt";
        String copyTo = "C:\\"; 
        JSch jsch = new JSch();
        Session session = null;
        System.out.println("Trying to connect.....");
        try {
            session = jsch.getSession(username, hostname, 22);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);
            session.setPassword(password);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.setConfig("PreferredAuthentications", "password");
            session.connect(); 
            System.out.println("Session created.....");
            Channel channel = session.openChannel("sftp");
            channel.connect();
            System.out.println("Channel created....");
            ChannelSftp sftpChannel = (ChannelSftp) channel; 
            sftpChannel.get(copyFrom, copyTo);
            sftpChannel.exit();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();  
        } catch (SftpException e) {
            e.printStackTrace();
        }
        System.out.println("Done !!");
    }
}