package net.escoz.ruaw5ebff.controllers.dtos;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public final class PageOutDTO<T> {

	private int pageNumber;
	private int pageSize;
	private long totalElements;
	private long totalPages;
	private List<T> content;

	public PageOutDTO(Page<T> page) {
		this.pageNumber = page.getNumber();
		this.pageSize = page.getSize();
		this.totalElements = page.getTotalElements();
		this.totalPages = page.getTotalPages();
		this.content = page.getContent();
	}
}