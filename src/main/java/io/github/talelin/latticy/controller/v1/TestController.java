package io.github.talelin.latticy.controller.v1;

import io.github.talelin.latticy.mapper.BannerMapper;
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

    @Autowired
    private BannerMapper bannerMapper;

    @GetMapping("")
    public Map<String, String> getTest() {
        Map<String, String> map = new HashMap<>();
        map.put("Test", "test");
        return map;
    }

    @GetMapping("/banner/1")
    public List<BannerDO> getTest2() {
        return this.testService.getBanners2();
    }

    @GetMapping("/banner/2")
    public List<BannerDO> getTest3() {
        return this.testService.getBanners2();
    }

    @GetMapping("/banner/3")
    public List<BannerDO> getTest4() {
        return bannerMapper.selectList(null);
    }

    @GetMapping("/banner")
    public List<BannerDO> getBannerTest() {
        return this.testService.getBanners();
    }

    @GetMapping("/banner/insert")
    public Long insertBanner() {
        return testService.insertBanner();
    }
}
