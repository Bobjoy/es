package com.sishuok.es.showcase.sample.web.controller;

import com.sishuok.es.common.web.controller.BaseCRUDController;
import com.sishuok.es.showcase.sample.entity.Sample;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/26 下午2:51
 * <p>Version: 1.0
 */

@Controller
@RequestMapping(value = "/showcase/sample")
public class SampleController extends BaseCRUDController<Sample, Long> {
}
