package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author a7818
 */
@RestController
@RequestMapping("/v1/test")
public class TestController {
    @Autowired
    private TestService testService;

    @GetMapping("")
    public Map<String, String> getTest() {
        Map<String, String> map = new HashMap<>();
        map.put("Test", "test");
        return map;
    }

    @GetMapping("/banner")
    public List<BannerDO> getBannerTest() {
        return this.testService.getBanners();
    }
}
