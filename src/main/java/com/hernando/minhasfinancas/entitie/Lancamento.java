package com.hernando.minhasfinancas.entitie;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.convert.Jsr310Converters;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name = "lancamento" , schema ="financas")
@Data
@Builder
public class Lancamento  {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento ")
	private Long id;

    @Column(name = "descricao")
	private String descricao;
	
	@Column(name = "mes")
	private Integer mes;

	@Column(name = "ano")
	private Integer ano;

	@Column(name = "id_usuario")
	private User usuario;

	@Column(name = "valor")
	private BigDecimal valor;
	

	@Column(name = "data_cadastro")
	@Convert(converter = Jsr310Converters.LocalDateToDateConverter.class)
	private LocalDate datacadastros;
	
	@Column(name = "tipo")
	@Enumerated(value = EnumType.STRING)
	private TipoLancamento tipo;
	

	@Column(name = "status")
	@Enumerated(value = EnumType.STRING)
	private StatusLancamento status;
	
	


}
