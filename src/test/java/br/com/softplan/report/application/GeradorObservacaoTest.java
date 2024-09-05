package br.com.softplan.report.application;

import br.com.softplan.report.model.NotaFiscal;
import br.com.softplan.report.service.GeradorObservacao;

import br.com.softplan.report.service.GeradorObservacaoImpl;
import org.junit.Test;
import org.mockito.InjectMocks;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

    @InjectMocks
    private GeradorObservacao geradorObservacao = new GeradorObservacaoImpl();

    @Test
    public void deve_gerar_observacao_sem_nota() {
        List<Integer> numerosNotaFiscal = new ArrayList<>();

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_uma_nota() {
        List<Integer> numerosNotaFiscal = singletonList(1);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura da nota fiscal de simples remessa: 1.", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_duas_notas() {
        List<Integer> numerosNotaFiscal = asList(1, 3);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 e 3.", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_diversas_notas() {
        List<Integer> numerosNotaFiscal = asList(1, 2, 3, 4, 5);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals("Fatura das notas fiscais de simples remessa: 1, 2, 3, 4 e 5.", observacao);
    }

    @Test
    public void deve_gerar_observacao_com_diversas_com_valor() {

        List<NotaFiscal> notas = new ArrayList<>();

        NotaFiscal notaFiscal01 = new NotaFiscal(1L, new BigDecimal(10));
        NotaFiscal notaFiscal02 = new NotaFiscal(2L, new BigDecimal(35));

        notas.add(notaFiscal01);
        notas.add(notaFiscal02);

        String observacao = geradorObservacao.geraObservacaoComNotaFiscal(notas);

        assertEquals("Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10 e 2 cujo valor é R$ 35.", observacao);
    }

}
