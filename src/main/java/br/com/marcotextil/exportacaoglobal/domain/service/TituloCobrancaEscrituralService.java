package br.com.marcotextil.exportacaoglobal.domain.service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import br.com.marcotextil.exportacaoglobal.domain.model.TituloCobrancaEscritural;

@Service
public class TituloCobrancaEscrituralService implements ApplicationRunner {
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		buscarTitulos();
	}

	public List<TituloCobrancaEscritural> buscarTitulos() throws Exception {
		   List<TituloCobrancaEscritural> titulos = new ArrayList<>();

		jdbcTemplate.query("select fatu_500.cgc_9, fatu_500.cgc_4, fatu_500.cgc_2, fatu_500.nome_empresa, "
				+ "pedi_010.cgc_9, pedi_010.cgc_4, pedi_010.cgc_2, pedi_010.nome_cliente, "
				+ "pedi_010.endereco_cliente, pedi_010.numero_imovel, pedi_010.bairro, "
				+ "basi_160.cidade, basi_160.estado, pedi_010.cep_cliente, basi_160.ddd, "
				+ "pedi_010.telefone_cliente, fatu_070.tipo_titulo, fatu_070.num_duplicata, "
				+ "fatu_070.seq_duplicatas, fatu_070.data_emissao, fatu_070.data_prorrogacao, "
				+ "fatu_070.saldo_duplicata,                                                                                                                                                                                                                                                            "
				+ "pedi_020.nome_rep_cliente, pedi_020.numero_celular "
				+ "from fatu_070, fatu_500, pedi_010, basi_160, pedi_020 "
				+ "where (fatu_500.codigo_empresa = fatu_070.codigo_empresa) "
				+ "  and (pedi_010.cgc_9 = fatu_070.cli_dup_cgc_cli9 "
				+ "      and pedi_010.cgc_4 = fatu_070.cli_dup_cgc_cli4 "
				+ "          and pedi_010.cgc_2 = fatu_070.cli_dup_cgc_cli2) "
				+ "  and (basi_160.cod_cidade = pedi_010.cod_cidade) "
				+ "  and (pedi_020.cod_rep_cliente = fatu_070.cod_rep_cliente) "
				+ "  and fatu_070.cd_centro_custo = 8800 and fatu_070.data_transf_tit is null "
				+ "  and fatu_070.saldo_duplicata > 0.00 ", (rs) -> {

					TituloCobrancaEscritural titulo = new TituloCobrancaEscritural();

					titulo.setCgc_9_empresa(rs.getInt(1));
					titulo.setCgc_4_empresa(rs.getInt(2));
					titulo.setCgc_2_empresa(rs.getInt(3));
					titulo.setNome_empresa(rs.getString(4));
					titulo.setCgc_9_cliente(rs.getInt(5));
					titulo.setCgc_4_cliente(rs.getInt(6));
					titulo.setCgc_2_cliente(rs.getInt(7));
					titulo.setNome_cliente(rs.getString(8));
					titulo.setEndereco_cliente(rs.getString(9));
					titulo.setNumero_imovel(rs.getString(10));
					titulo.setBairro(rs.getString(11));
					titulo.setCidade(rs.getString(12));
					titulo.setEstado(rs.getString(13));
					titulo.setCep_cliente(rs.getInt(14));
					titulo.setDdd(rs.getInt(15));
					titulo.setTelefone_cliente(rs.getInt(16));
					titulo.setTipo_titulo(rs.getInt(17));
					titulo.setNum_duplicata(rs.getInt(18));
					titulo.setSeq_duplicatas(rs.getInt(19));
					titulo.setData_emissao(rs.getDate(20));
					titulo.setData_prorrogacao(rs.getDate(21));
					titulo.setSaldo_duplicata(rs.getDouble(22));
					titulo.setNome_rep_cliente(rs.getString(23));
					titulo.setNumero_celular(rs.getInt(24));

					titulos.add(titulo);

				});

		List<String> listaExportacaoGlobal = new ArrayList<>();

		titulos.forEach(titulo -> {

			String txt = "";

			SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

			txt = padLeft(Integer.toString(titulo.getCgc_9_empresa()), 8, "0");
			txt += padLeft(Integer.toString(titulo.getCgc_4_empresa()), 4, "0");
			txt += padLeft(Integer.toString(titulo.getCgc_2_empresa()), 2, "0");
			txt += padRight(titulo.getNome_empresa(), 50, " ");
			txt += formataCliente(titulo.getCgc_9_cliente(), titulo.getCgc_4_cliente(), titulo.getCgc_2_cliente());
			txt += padRight(titulo.getNome_cliente(), 50, " ");
			txt += padRight(titulo.getEndereco_cliente(), 44, " ").substring(0, 44) + ",";
			txt += padRight((titulo.getNumero_imovel()), 5, " ");
			txt += padRight(titulo.getBairro(), 20, " ");
			txt += padRight(titulo.getCidade(), 20, " ").substring(0, 20);
			txt += titulo.getEstado();
			txt += padLeft(Integer.toString(titulo.getCep_cliente()), 8, "0");
			txt += padLeft(Integer.toString(titulo.getDdd()), 4, "0").substring(1, 4);
			txt += padLeft(Integer.toString(titulo.getTelefone_cliente()), 8, "0") + "DP";
			txt += padLeft(Integer.toString(titulo.getTipo_titulo()), 2, "0") + "-";
			txt += padLeft(Integer.toString(titulo.getNum_duplicata()), 9, "0");
			txt += padLeft(Integer.toString(titulo.getSeq_duplicatas()), 2, "0");
			txt += formatador.format(titulo.getData_emissao());
			txt += formatador.format(titulo.getData_prorrogacao());
			txt += padLeft(Double.toString(titulo.getSaldo_duplicata()), 15, " ").substring(0, 15) + "           0.00";
			txt += padRight("", 255, " ");
			txt += padRight(titulo.getNome_rep_cliente(), 40, " ");
			txt += padLeft(Integer.toString(titulo.getNumero_celular()), 9, " ").substring(1, 8);
			listaExportacaoGlobal.add(txt);
		});

		gerarTxt(listaExportacaoGlobal);

		UpdateTitulos();

		return titulos;
	}

	public String padLeft(String inputString, int length, String caracter) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		while (sb.length() < length - inputString.length()) {
			sb.append(caracter);
		}
		sb.append(inputString);

		return sb.toString();
	}

	public String padRight(String inputString, int length, String caracter) {
		if (inputString.length() >= length) {
			return inputString;
		}
		StringBuilder sb = new StringBuilder();
		sb.append(inputString);
		while (sb.length() < length) {
			sb.append(caracter);
		}

		return sb.toString();
	}

	public String formataCliente(int cgc9, int cgc4, int cgc2) {
		String cgcCliente = "";
		if (cgc4 == 0) {
			cgcCliente = padLeft(Integer.toString(cgc9), 9, "0") + "-";
			cgcCliente += padLeft(Integer.toString(cgc2), 2, "0") + " ";
			return cgcCliente;
		}
		cgcCliente = padLeft(Integer.toString(cgc9), 8, "0");
		cgcCliente += padLeft(Integer.toString(cgc4), 4, "0");
		cgcCliente += padLeft(Integer.toString(cgc2), 2, "0");

		return cgcCliente;

	}

	public void gerarTxt(List<String> titulosCobranca) throws Exception {

		// FileSystemView system = FileSystemView.getFileSystemView(); //Funçâo que
		// chama o caminho do desktop do usuario no windows.

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy_HHmmss");
		String formattedDate = myDateObj.format(myFormatObj);

		String arqGlobal = "ARQ_GLOBAL" + "_" + formattedDate;
		String caminhoLog = "X:\\Exportado";
		new File(caminhoLog).mkdir();

		OutputStream caminhoArquivo = new FileOutputStream(caminhoLog + File.separator + arqGlobal + ".txt", true);
		OutputStreamWriter textoLido = new OutputStreamWriter(caminhoArquivo);
		BufferedWriter gravar = new BufferedWriter(textoLido);

		titulosCobranca.forEach(linha -> {
			try {
				gravar.write(linha + "\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
		});

		gravar.close();
	}

	public void UpdateTitulos() throws Exception {
		jdbcTemplate.update("update fatu_070 set fatu_070.cd_centro_custo = 8810,"
						  + "fatu_070.data_transf_tit = to_date(sysdate) where fatu_070.cd_centro_custo = 8800"
						  + "and fatu_070.data_transf_tit is null");

	}

}
