package com.smart.commerce.ceo.modules.ceo.application;

import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCboCommand;
import com.smart.commerce.ceo.modules.ceo.application.command.CeoRegisterCbrCommand;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterCboUseCase;
import com.smart.commerce.ceo.modules.ceo.application.usecase.CeoRegisterCbrUseCase;
import com.smart.commerce.ceo.modules.ceo.domain.Cbo;
import com.smart.commerce.ceo.modules.ceo.domain.Cbr;
import com.smart.commerce.ceo.modules.ceo.domain.Ceo;
import com.smart.commerce.ceo.modules.ceo.domain.CeoRepository;
import org.springframework.stereotype.Service;


@Service
public class CeoCertificateService implements CeoRegisterCbrUseCase, CeoRegisterCboUseCase {

    private final CeoRepository ceoRepository;

    public CeoCertificateService(final CeoRepository ceoRepository) {
        this.ceoRepository = ceoRepository;
    }

    @Override
    public Ceo registerCbr(final CeoRegisterCbrCommand command) {
        final Ceo ceo = ceoRepository.findById(command.ceoId());
        final Cbr cbr = cbr(command);
        return ceoRepository.save(ceo.registerCbr(cbr));
    }

    @Override
    public Ceo registerCbo(final CeoRegisterCboCommand command) {
        final Ceo ceo = ceoRepository.findById(command.ceoId());
        final Cbo cbo = cbo(command);
        return ceoRepository.save(ceo.registerCbo(cbo));
    }

    private Cbr cbr(final CeoRegisterCbrCommand command) {
        return Cbr.initialize(
                command.brand(),
                command.ceoName(),
                command.birthDate(),
                command.openDate(),
                command.businessAddress(),
                command.businessType(),
                command.issueDate()
        );
    }

    private Cbo cbo(final CeoRegisterCboCommand command) {
        return Cbo.initialize(
                command.ceoName(),
                command.ceoBirth(),
                command.businessName(),
                command.businessAddress(),
                command.businessArea(),
                command.businessType(),
                command.condition());
    }
}
