package com.ceduca.service.pdf;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

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
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            20
                    );

            Font subtitulo =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            14
                    );

            Font texto =
                    FontFactory.getFont(
                            FontFactory.HELVETICA,
                            12
                    );

            /*
             * NOME EXIBIÇÃO
             */

            String nomeExibicao =
                    curriculo.getNomeSocial() != null
                            && !curriculo.getNomeSocial().isBlank()
                            ? curriculo.getNomeSocial()
                            : aluno.getNome();

            /*
             * CABEÇALHO
             */

            Paragraph nome =
                    new Paragraph(nomeExibicao, titulo);

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

            /*
             * DATA NASCIMENTO
             */

            if (curriculo.getDataNascimento() != null) {

                document.add(new Paragraph(
                        "Data de nascimento: "
                                + curriculo.getDataNascimento()
                                .format(
                                        DateTimeFormatter.ofPattern("dd/MM/yyyy")
                                ),
                        texto
                ));
            }

            /*
             * ENDEREÇO
             */

            if (curriculo.getEndereco() != null
                    && !curriculo.getEndereco().isBlank()) {

                document.add(new Paragraph(
                        curriculo.getEndereco(),
                        texto
                ));
            }

            /*
             * CIDADE
             */

            if (curriculo.getCidade() != null
                    && !curriculo.getCidade().isBlank()) {

                document.add(new Paragraph(
                        curriculo.getCidade(),
                        texto
                ));
            }

            /*
             * LINKEDIN
             */

            if (curriculo.getLinkedin() != null
                    && !curriculo.getLinkedin().isBlank()) {

                document.add(new Paragraph(
                        curriculo.getLinkedin(),
                        texto
                ));
            }

            /*
             * RESUMO
             */

            if (curriculo.getResumo() != null
                    && !curriculo.getResumo().isBlank()) {

                Paragraph resumoTitulo =
                        new Paragraph("RESUMO", subtitulo);

                resumoTitulo.setSpacingAfter(5);

                document.add(resumoTitulo);

                document.add(new Paragraph(
                        curriculo.getResumo(),
                        texto
                ));

                document.add(new Paragraph(" "));
            }

            /*
             * FORMAÇÕES
             */

            if (curriculo.getFormacoes() != null
                    && !curriculo.getFormacoes().isEmpty()) {

                Paragraph formacaoTitulo =
                        new Paragraph("FORMAÇÃO", subtitulo);

                formacaoTitulo.setSpacingAfter(5);

                document.add(formacaoTitulo);

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

            if (curriculo.getQualificacoes() != null
                    && !curriculo.getQualificacoes().isEmpty()) {

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
            }

            /*
             * EXPERIÊNCIAS
             */

            if (Boolean.TRUE.equals(
                    curriculo.getPossuiExperiencia())
                    && curriculo.getExperiencias() != null
                    && !curriculo.getExperiencias().isEmpty()) {

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
            }

            document.close();

            return outputStream.toByteArray();

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao gerar PDF do currículo."
            );
        }
    }
}