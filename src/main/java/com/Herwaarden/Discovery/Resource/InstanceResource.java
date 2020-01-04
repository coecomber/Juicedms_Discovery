package com.Herwaarden.Discovery.Resource;

import com.Herwaarden.Discovery.Model.Instance;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instance/")
public class InstanceResource {

    @GetMapping(value = "/get", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Instance> getInstances () {
        List<Instance> instances = new ArrayList<>();

        Instance instance = new Instance("yee", "sdf", 1234);
        Instance instance2 = new Instance("esc", "gsdfd", 6423);
        instances.add(instance);
        instances.add(instance2);

        return instances;
    }
}
