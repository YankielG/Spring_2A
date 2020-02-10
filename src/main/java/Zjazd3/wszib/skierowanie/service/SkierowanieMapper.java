package Zjazd3.wszib.skierowanie.service;

import Zjazd3.wszib.skierowanie.model.SkierowanieDoLekarza;
import Zjazd3.wszib.skierowanie.dto.SkierowanieDoLekarzaDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SkierowanieMapper {

    SkierowanieDoLekarzaDTO toDTO(SkierowanieDoLekarza skierowanieDoLekarza);

    SkierowanieDoLekarza toDB(SkierowanieDoLekarzaDTO skierowanieDoLekarzaDTO);

    List<SkierowanieDoLekarzaDTO> toDTO(List<SkierowanieDoLekarza> skierowanieDoLekarzaList);
}
