package com.arshad.webservice.UserManagement.mapper;

import com.arshad.webservice.UserManagement.beans.User;
import com.arshad.webservice.UserManagement.beans.UserResponseModel;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserResponseModel mapToUserResponseModel(final User user);

    List<UserResponseModel> mapToUserResponseModelList(final List<User> userList);
}
