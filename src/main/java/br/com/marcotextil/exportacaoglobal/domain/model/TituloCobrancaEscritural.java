package br.com.marcotextil.exportacaoglobal.domain.model;

import java.util.Date;

public class TituloCobrancaEscritural {
	
	private Integer cgc_9_empresa;
	private Integer cgc_4_empresa;
	private Integer cgc_2_empresa;
	private String nome_empresa;
	private Integer cgc_9_cliente;
	private Integer cgc_4_cliente;
	private Integer cgc_2_cliente;
	private String nome_cliente;
	private String endereco_cliente;
	private String numero_imovel;
	private String bairro;
	private String cidade;
	private String estado;
	private Integer cep_cliente;
	private Integer ddd;
	private Integer telefone_cliente;
	private Integer tipo_titulo;
	private Integer num_duplicata;
	private Integer seq_duplicatas;
	private Date data_emissao;
	private Date data_prorrogacao;
	private Double saldo_duplicata;
	private String nome_rep_cliente;
	private Integer numero_celular;
	
	@Override
	public String toString() {
		return "TituloCobrancaEscritural [cgc_9_empresa=" + cgc_9_empresa + ", cgc_4_empresa=" + cgc_4_empresa
				+ ", cgc_2_empresa=" + cgc_2_empresa + ", nome_empresa=" + nome_empresa + ", cgc_9_cliente="
				+ cgc_9_cliente + ", cgc_4_cliente=" + cgc_4_cliente + ", cgc_2_cliente=" + cgc_2_cliente
				+ ", nome_cliente=" + nome_cliente + ", endereco_cliente=" + endereco_cliente + ", numero_imovel="
				+ numero_imovel + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep_cliente="
				+ cep_cliente + ", ddd=" + ddd + ", telefone_cliente=" + telefone_cliente + ", tipo_titulo="
				+ tipo_titulo + ", num_duplicata=" + num_duplicata + ", seq_duplicatas=" + seq_duplicatas
				+ ", data_emissao=" + data_emissao + ", data_prorrogacao=" + data_prorrogacao + ", saldo_duplicata="
				+ saldo_duplicata + ", nome_rep_cliente=" + nome_rep_cliente + ", numero_celular=" + numero_celular
				+ "]";
	}
	
	public Integer getCgc_9_empresa() {
		return cgc_9_empresa;
	}
	public void setCgc_9_empresa(Integer cgc_9_empresa) {
		this.cgc_9_empresa = cgc_9_empresa;
	}
	public Integer getCgc_4_empresa() {
		return cgc_4_empresa;
	}
	public void setCgc_4_empresa(Integer cgc_4_empresa) {
		this.cgc_4_empresa = cgc_4_empresa;
	}
	public Integer getCgc_2_empresa() {
		return cgc_2_empresa;
	}
	public void setCgc_2_empresa(Integer cgc_2_empresa) {
		this.cgc_2_empresa = cgc_2_empresa;
	}
	public String getNome_empresa() {
		return nome_empresa;
	}
	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	public Integer getCgc_9_cliente() {
		return cgc_9_cliente;
	}
	public void setCgc_9_cliente(Integer cgc_9_cliente) {
		this.cgc_9_cliente = cgc_9_cliente;
	}
	public Integer getCgc_4_cliente() {
		return cgc_4_cliente;
	}
	public void setCgc_4_cliente(Integer cgc_4_cliente) {
		this.cgc_4_cliente = cgc_4_cliente;
	}
	public Integer getCgc_2_cliente() {
		return cgc_2_cliente;
	}
	public void setCgc_2_cliente(Integer cgc_2_cliente) {
		this.cgc_2_cliente = cgc_2_cliente;
	}
	public String getNome_cliente() {
		return nome_cliente;
	}
	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}
	public String getEndereco_cliente() {
		return endereco_cliente;
	}
	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}
	public String getNumero_imovel() {
		return numero_imovel;
	}
	public void setNumero_imovel(String string) {
		this.numero_imovel = string;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getCep_cliente() {
		return cep_cliente;
	}
	public void setCep_cliente(Integer cep_cliente) {
		this.cep_cliente = cep_cliente;
	}
	public Integer getDdd() {
		return ddd;
	}
	public void setDdd(Integer ddd) {
		this.ddd = ddd;
	}
	public Integer getTelefone_cliente() {
		return telefone_cliente;
	}
	public void setTelefone_cliente(Integer telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}
	public Integer getTipo_titulo() {
		return tipo_titulo;
	}
	public void setTipo_titulo(Integer tipo_titulo) {
		this.tipo_titulo = tipo_titulo;
	}
	public Integer getNum_duplicata() {
		return num_duplicata;
	}
	public void setNum_duplicata(Integer num_duplicata) {
		this.num_duplicata = num_duplicata;
	}

	public Integer getSeq_duplicatas() {
		return seq_duplicatas;
	}
	public void setSeq_duplicatas(Integer seq_duplicatas) {
		this.seq_duplicatas = seq_duplicatas;
	}
	public Date getData_emissao() {
		return data_emissao;
	}
	public void setData_emissao(Date data_emissao) {
		this.data_emissao = data_emissao;
	}
	public Date getData_prorrogacao() {
		return data_prorrogacao;
	}
	public void setData_prorrogacao(Date data_prorrogacao) {
		this.data_prorrogacao = data_prorrogacao;
	}
	public Double getSaldo_duplicata() {
		return saldo_duplicata;
	}
	public void setSaldo_duplicata(Double saldo_duplicata) {
		this.saldo_duplicata = saldo_duplicata;
	}
	public String getNome_rep_cliente() {
		return nome_rep_cliente;
	}
	public void setNome_rep_cliente(String nome_rep_cliente) {
		this.nome_rep_cliente = nome_rep_cliente;
	}
	public Integer getNumero_celular() {
		return numero_celular;
	}
	public void setNumero_celular(Integer numero_celular) {
		this.numero_celular = numero_celular;
	}

	

}
