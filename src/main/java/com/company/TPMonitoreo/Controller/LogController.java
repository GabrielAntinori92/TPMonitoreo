package com.company.TPMonitoreo.Controller;

import com.company.TPMonitoreo.Model.Log;
import com.company.TPMonitoreo.Repository.LogDao;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogController {

    @Autowired
    LogDao dao;

    @RequestMapping(value = "/")
    public List<Log> getinfo(){

        List<Log> loglist = dao.findAll();

        return loglist;
    }

    @RequestMapping(value = "/savelog")
    public Log newLog(@RequestHeader(value = "User-Agent") String usragent){

        UserAgent useragent = UserAgent.parseUserAgentString(usragent);
        OperatingSystem agent = useragent.getOperatingSystem();
        Browser browser = useragent.getBrowser();

        String so = agent.getName();
        String navegador = browser.getName();

        Log nuevo = new Log(so,navegador);

        dao.save(nuevo);

        return nuevo;
    }

    @RequestMapping(value="/mostUsedBrowser")
    public String mostUsedBrowser(){
        List<Log> loglist = dao.findAll();
        int count_chrome = 0;
        int count_firefox = 0;

        for(Log log : loglist){
            if(log.getBrowser().compareTo("Chrome 62")==0){
                count_chrome++;
            }else
                if(log.getBrowser().compareTo("Firefox 56")==0){
                count_firefox++;
                }
        }

        String mostUsed = "";
        if(count_chrome >= count_firefox){
            mostUsed = "Chrome 62";
        }else{
            mostUsed = "Firefox 56";
        }

        return mostUsed ;
    }


    @RequestMapping(value="/mostUsedOS")
    public String mostUsedOS(){
        List<Log> loglist = dao.findAll();
        int count_linux = 0;
        int count_windows = 0;

        for(Log log : loglist){
            if(log.getSo().compareTo("Linux")==0){
                count_linux++;
            }else if(log.getSo().compareTo("Windows")==0){
                count_windows++;
            }
        }

        String mostUsed = "";
        if(count_linux >= count_windows){
            mostUsed = "Linux";
        }else {
            mostUsed = "Windows";
        }

        return mostUsed ;

    }

    @RequestMapping(value="/mostUsedSO&Browser")
    public String mostUsedSOBrowser(){
        List<Log> loglist = dao.findAll();
        int count_linuxchrome = 0;
        int count_linuxfirefox = 0;

        for(Log log : loglist){
            if(log.getBrowser().equals("Chrome 62") && log.getSo().equals("Linux")){
                count_linuxchrome++;
            }else{
                count_linuxfirefox++;
            }
        }

        String mostUsed = "";
        if(count_linuxchrome >   count_linuxfirefox){
            mostUsed = "Linux & Chrome 62";
        }else{
            mostUsed = "Linux & Firefox 56";
        }

        return mostUsed;
    }

}
