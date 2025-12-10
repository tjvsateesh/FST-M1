import pytest

@pytest.mark.parametrize("earned, spent, expected", [(30, 10, 20), (20, 2, 18)])
def test_expenditure(wallet_amount, earned, spent, expected):
    
    print("Initially my wallet has:", wallet_amount)

    wallet_amount += earned
    print("I have earned:", earned, "cash, now my wallet has:", wallet_amount)

    wallet_amount -= spent
    print("I have spent:", spent,", I am left with: ", wallet_amount)

    assert(wallet_amount == expected)
