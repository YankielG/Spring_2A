package Zjazd3.wszib.skierowanie.service;

import Zjazd3.wszib.skierowanie.dto.SkierowanieDoLekarzaDTO;

import java.util.Collection;

public interface SkierowanieService {

    Collection<SkierowanieDoLekarzaDTO> listSkierowanie();
    SkierowanieDoLekarzaDTO getSkierowanie(Integer id);
    void deleteSkierowanie(Integer id);
    SkierowanieDoLekarzaDTO createSkierowanie(SkierowanieDoLekarzaDTO skierowanie);
    SkierowanieDoLekarzaDTO updateSkierowanie(SkierowanieDoLekarzaDTO skierowanie);

}
