package br.com.softplan.report.service;

import br.com.softplan.report.model.NotaFiscal;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacaoImpl implements GeradorObservacao {

    //Textos pré-definidos
    static final String umoNota = "Fatura da nota fiscal de simples remessa: ";

    @Override
    public String geraObservacao(final List<Integer> numeroDasNotas) {
        if (!numeroDasNotas.isEmpty()) {
            return this.identificaPrefixo(numeroDasNotas) + this.procesamentoNotasComSeparador(numeroDasNotas) + ".";
        }
        return "";
    }

    @Override
    public String geraObservacaoComNotaFiscal(List<NotaFiscal> notas) {
        if (!notas.isEmpty()) {
            return this.identificaPrefixo(notas) + this.procesamentoNotasComSeparador(notas) + ".";
        }
        return "";
    }

    private String procesamentoNotasComSeparador(List<?> numeroDasNotas) {

        final StringBuilder concactString = new StringBuilder();

        for (Iterator<Object> iterator = (Iterator<Object>) numeroDasNotas.iterator(); iterator.hasNext();) {

            final Object numeroDeNotas = iterator.next();

            final String separador = idetificaSeparador(concactString, iterator);

            concactString.append(separador + numeroDeNotas);
        }
        return concactString.toString();
    }

    private static String idetificaSeparador(final StringBuilder concactString, final Iterator<?> iterator) {
        if (concactString.toString().isEmpty()) {
            return "";
        } else if (iterator.hasNext()) {
            return ", ";
        }
        return " e ";
    }

    private String identificaPrefixo(List<?> numeroDasNotas) {
        if (numeroDasNotas.size() >= 2) {
            return "Fatura das notas fiscais de simples remessa: ";
        }
        return umoNota;
    }
}
