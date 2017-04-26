package com.sishuok.es.showcase.sample.repository;

import com.sishuok.es.common.repository.BaseRepository;
import com.sishuok.es.showcase.sample.entity.Sample;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/26 下午3:00
 * <p>Version: 1.0
 */
public interface SampleRepository extends BaseRepository<Sample, Long> {

	Sample findByName(String name);
}
