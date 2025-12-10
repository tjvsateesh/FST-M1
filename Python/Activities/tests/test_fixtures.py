import pytest

def test_sum_of_list(num_list):
    sum = 0
    for number in num_list:
        sum += number

    assert sum == 55