package com.platform.logiciels.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomLog", types = { Logiciel.class })
public interface LogicielProjection {
    public String getNomLogiciel();
}
