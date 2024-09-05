package br.com.softplan.report.model;

import java.math.BigDecimal;

public class NotaFiscal {

    private final Long numero;
    private final BigDecimal valor;

    public NotaFiscal(final Long numero, final BigDecimal valor) {
        this.numero = numero;
        this.valor = valor;
    }

    public Long getNumero() {
        return numero;
    }

    public BigDecimal getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return numero + " cujo valor é R$ " + valor;
    }
}
