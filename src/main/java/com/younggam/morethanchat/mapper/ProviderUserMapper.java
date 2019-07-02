package com.younggam.morethanchat.mapper;

import com.younggam.morethanchat.domain.ProviderUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface ProviderUserMapper {
    @Select("SELECT * FROM provider_user WHERE email = #{email}")
    Optional<ProviderUser> findByEmail(@Param("email") final String email);

    @Select("SELECT FROM provider_user WHERE id = #{id}")
    Optional<ProviderUser> findById(@Param("id") final Long id);
}
