package com.c7.curso.arch.ddd.borrow.infra;

import com.c7.curso.arch.ddd.borrow.model.Loan;
import com.c7.curso.arch.ddd.borrow.service.LoanDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LoanMapper {

    LoanDto toDto(Loan loan);

    Loan toEntity(LoanDto loanDto);
}
