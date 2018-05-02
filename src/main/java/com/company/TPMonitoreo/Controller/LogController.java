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

    /*@RequestMapping(value="/mostUsedBrowser")
    public String mostUsedBrowser(){
        List<Log> loglist = dao.findAll();
        int[] countlist = {0,0,0};

        for(Log log : loglist){
            if(log.getBrowser().compareTo("Chrome 62")==0){
                countlist[0]++;
            }else if(log.getBrowser().compareTo("Firefox 56")==0){
                countlist[1]++;
            }else if(log.getBrowser().compareTo("Opera")==0){
                countlist[2]++;
            }
        }

        for (int i=0; i<countlist.length; i++){

        }

        return ;
    }*/


}
