package org.example.Male.Service;

import org.example.Male.MaleRepository;
import org.springframework.stereotype.Service;

@Service
public class MaleServiceImpl implements MaleService {
    private final MaleRepository maleRepository;

    public MaleServiceImpl(MaleRepository maleRepository) {
        this.maleRepository = maleRepository;
    }

}
