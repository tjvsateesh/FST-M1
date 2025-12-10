import pytest

def test_addition():
	num1 = 84
	num2 = 24
	sum = num1 + num2
	assert sum == 108

def test_subtraction():
	num1 = 69
	num2 = 52
	diff = num1 - num2
	assert diff == 17

@pytest.mark.activity
def test_multiplication():
	num1 = 2
	num2 = 8
	mul = num1 * num2
	assert mul == 16

@pytest.mark.activity
def test_division():
	num1 = 40
	num2 = 4
	div = num1 / num2
	assert div == 10