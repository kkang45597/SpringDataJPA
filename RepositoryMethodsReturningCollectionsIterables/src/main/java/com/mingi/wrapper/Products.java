package com.mingi.wrapper;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.data.util.Streamable;

import com.mingi.entity.Product;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(staticName = "of")
public class Products implements Streamable<Product>{

	private final Streamable<Product> streamable;
	
	// 총 가격 계산 메서드
	public BigDecimal getTotalPrice() {
		return streamable.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
	}
	
	@Override
	public Iterator<Product> iterator() {
		return streamable.iterator();
	}
}
