package com.sishuok.es.sys.user.repository;

import com.sishuok.es.common.repository.BaseRepository;
import com.sishuok.es.common.repository.support.annotation.SearchableQuery;
import com.sishuok.es.sys.user.entity.User;

/**
 * <p>User: baofangliang
 * <p>Date: 2017/4/25 下午2:21
 * <p>Version: 1.0
 */

@SearchableQuery(callbackClass = UserSearchCallback.class)
public interface UserRepository extends BaseRepository<User, Long> {

	User findByUsername(String username);
}
