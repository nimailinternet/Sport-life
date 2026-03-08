package org.example.Males.Service;

import org.example.Males.MalesRepository;
import org.springframework.stereotype.Service;

@Service
public class MalesServiceIMpl implements MalesService {
    private final MalesRepository malesRepository;

    public MalesServiceIMpl(MalesRepository malesRepository) {
        this.malesRepository = malesRepository;
    }

}
