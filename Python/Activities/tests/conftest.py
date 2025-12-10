import pytest

@pytest.fixture
def num_list():

    nums = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    return nums

@pytest.fixture
def wallet_amount():
   amount = 0
   return amount