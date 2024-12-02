package com.mingi.repository;

import com.mingi.entity.User;
import java.util.List;

public interface UserRepositoryCustom {
    List<User> customQueryMethod();
}