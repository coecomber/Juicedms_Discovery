package com.Herwaarden.Discovery.Resource;

import com.Herwaarden.Discovery.Model.Instance;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instance/")
public class InstanceResource {

    @Autowired
    PeerAwareInstanceRegistry registry;

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Instance> getInstances () {
        List<Instance> instances = new ArrayList<>();

        Applications applications = registry.getApplications();
        System.out.println(applications.getRegisteredApplications());

        for(Application application : applications.getRegisteredApplications()){
            List<InstanceInfo> instanceInfo = application.getInstancesAsIsFromEureka();
            for(InstanceInfo instanceInformation : instanceInfo){
                Instance instance = new Instance();
                instance.setName(instanceInformation.getAppName());
                instance.setPort(instanceInformation.getPort());
                instance.setUrl(instanceInformation.getHomePageUrl());
                System.out.println(instance);

                instances.add(instance);
            }
        }

        return instances;
    }
}
