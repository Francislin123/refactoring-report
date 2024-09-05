package br.com.softplan.report.service;

import br.com.softplan.report.model.NotaFiscal;

import java.util.List;

public interface GeradorObservacao {
    String geraObservacao(final List<Integer> numeroDasNotas);

    String geraObservacaoComNotaFiscal(final List<NotaFiscal> notas);
}