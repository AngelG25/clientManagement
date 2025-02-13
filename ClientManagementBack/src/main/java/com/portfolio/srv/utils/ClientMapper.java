package com.portfolio.srv.utils;

import com.portfolio.api.models.Client;
import com.portfolio.dao.ClientDao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientDao toClientDao(Client task);

    Client toClientDto(ClientDao taskDao);

}
