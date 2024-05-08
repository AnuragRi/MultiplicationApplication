package com.betaNxt.mediant;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import com.betaNxt.mediant.controller.MultiplicationController;

import java.util.List;

public class MultiplicationControllerTest {

	private MultiplicationController multiplicationController;
	private Model model;

	@BeforeEach
	public void setUp() {
		multiplicationController = new MultiplicationController();
		model = mock(Model.class);
	}


	@Test
	public void testMultiplyOutOfRangeNumber() {
		// Arrange
		when(model.addAttribute("message", "Number should be between 1 to 50.")).thenReturn(model);

		// Act
		String result = multiplicationController.multiply(model, String.valueOf(55));

		// Assert
		assertEquals("multiply", result);
	}

	@Test
	public void testMultiplyException() {
		// Arrange
		when(model.addAttribute("message", "Something went wrong while generating multiplication table."))
				.thenReturn(model);

		// Act
		String result = multiplicationController.multiply(model, String.valueOf(10));

		// Assert
		assertEquals("multiply", result);
	}


	public static <T> List<T> anyList() {
		return org.mockito.ArgumentMatchers.anyList();
	}
}
