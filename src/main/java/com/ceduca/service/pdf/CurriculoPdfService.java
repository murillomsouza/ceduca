package com.ceduca.service.pdf;

import java.io.ByteArrayOutputStream;

import org.springframework.stereotype.Service;

import com.ceduca.model.Aluno;
import com.ceduca.model.Curriculo;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class CurriculoPdfService {

    public byte[] gerarPdf(Aluno aluno) {

        try {

            Curriculo curriculo = aluno.getCurriculo();

            Document document = new Document();

            ByteArrayOutputStream outputStream =
                    new ByteArrayOutputStream();

            PdfWriter.getInstance(document, outputStream);

            document.open();

            /*
             * FONTES
             */

            Font titulo =
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);

            Font subtitulo =
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14);

            Font texto =
                    FontFactory.getFont(FontFactory.HELVETICA, 12);

            /*
             * CABEÇALHO
             */

            Paragraph nome =
                    new Paragraph(aluno.getNome(), titulo);

            nome.setSpacingAfter(10);

            document.add(nome);

            document.add(new Paragraph(
                    aluno.getEmail(),
                    texto
            ));

            document.add(new Paragraph(
                    aluno.getTelefone(),
                    texto
            ));

            document.add(new Paragraph(
                    curriculo.getLinkedin(),
                    texto
            ));

            document.add(new Paragraph(
                    curriculo.getGithub(),
                    texto
            ));

            document.add(new Paragraph(" "));

            /*
             * RESUMO
             */

            Paragraph resumoTitulo =
                    new Paragraph("RESUMO", subtitulo);

            resumoTitulo.setSpacingAfter(5);

            document.add(resumoTitulo);

            document.add(new Paragraph(
                    curriculo.getResumo(),
                    texto
            ));

            document.add(new Paragraph(" "));

            /*
             * FORMAÇÕES
             */

            Paragraph formacaoTitulo =
                    new Paragraph("FORMAÇÃO", subtitulo);

            formacaoTitulo.setSpacingAfter(5);

            document.add(formacaoTitulo);

            if (curriculo.getFormacoes() != null) {

                curriculo.getFormacoes().forEach(formacao -> {

                    try {

                        document.add(new Paragraph(
                                formacao.getCurso()
                                        + " - "
                                        + formacao.getInstituicao(),
                                texto
                        ));

                        document.add(new Paragraph(
                                formacao.getInicio()
                                        + " - "
                                        + formacao.getFim(),
                                texto
                        ));

                        document.add(new Paragraph(" "));

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            /*
             * QUALIFICAÇÕES
             */

            Paragraph qualificacaoTitulo =
                    new Paragraph("QUALIFICAÇÕES", subtitulo);

            qualificacaoTitulo.setSpacingAfter(5);

            document.add(qualificacaoTitulo);

            curriculo.getQualificacoes().forEach(qualificacao -> {

                try {

                    document.add(new Paragraph(
                            "• " + qualificacao.getNome(),
                            texto
                    ));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            document.add(new Paragraph(" "));

            /*
             * EXPERIÊNCIAS
             */

            Paragraph experienciaTitulo =
                    new Paragraph("EXPERIÊNCIAS", subtitulo);

            experienciaTitulo.setSpacingAfter(5);

            document.add(experienciaTitulo);

            curriculo.getExperiencias().forEach(experiencia -> {

                try {

                    document.add(new Paragraph(
                            experiencia.getCargo()
                                    + " - "
                                    + experiencia.getEmpresa(),
                            texto
                    ));

                    document.add(new Paragraph(
                            experiencia.getInicio()
                                    + " - "
                                    + experiencia.getFim(),
                            texto
                    ));

                    document.add(new Paragraph(
                            experiencia.getDescricao(),
                            texto
                    ));

                    document.add(new Paragraph(" "));

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao gerar PDF do currículo."
            );
        }
    }
}