package com.smart.commerce.ceo.modules.ceo.application;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoLoginCommand;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoLoginUseCase;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterUseCase;
import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCommand;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import com.smart.commerce.ceo.modules.ceo.domain.CeoRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CeoService implements CeoRegisterUseCase, CeoLoginUseCase {

    private final PasswordEncoder passwordEncoder;
    private final CeoRepository ceoRepository;

    public CeoService(final PasswordEncoder passwordEncoder,
                      final CeoRepository ceoRepository) {
        this.passwordEncoder = passwordEncoder;
        this.ceoRepository = ceoRepository;
    }

    @Override
    public Ceo register(final CeoRegisterCommand command) {
        return ceoRepository.save(ceo(command));
    }

    @Override
    public Ceo login(final CeoLoginCommand command) {
        final Ceo ceo = ceoRepository.findByAccount(command.account());
        ceo.login(password -> passwordEncoder.matches(command.password(), password));
        return ceo;
    }

    private Ceo ceo(final CeoRegisterCommand command) {
        return Ceo.initialize(
                command.account(), command.password(), command.name(),
                command.birth(), command.phoneNumber(), command.email()
        );
    }
}
