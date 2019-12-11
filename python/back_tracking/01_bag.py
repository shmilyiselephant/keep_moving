#!/usr/bin/python

from typing import List

picks = []
picks_with_max_value = []

def bag(capacity: int, cur_weight: int, items_info: List, pick_idx: int):
    """

    :param capacity: capacity of bag
    :param cur_weight: current weight of bag
    :param items_info: weight and value
    :param pick_idx: current pick index
    :return:
    """
    if pick_idx >= len(items_info) or cur_weight == capacity:
        global picks_with_max_value
        if get_value(items_info, picks) > get_value(items_info, picks_with_max_value):
            picks_with_max_value = picks.copy()
    else:
        item_weight = items_info[pick_idx][0]
        if cur_weight + item_weight <= capacity: #choose
            picks[pick_idx] = 1
            bag(capacity, cur_weight + item_weight, items_info, pick_idx + 1)

        picks[pick_idx] = 0                     #not choose
        bag(capacity, cur_weight, items_info, pick_idx+1)

def get_value(items_info: List, pick_items: List):
    values = [_[1] for _ in items_info]
    return sum([a*b for a,b in zip(values, pick_items)])

if __name__ == '__main__':
    item_info = [(3,1), (2,2), (3,4), (5,2), (1,10)]
    capacity = 8

    print('--- items info ---')
    print(item_info)

    print('\n--- capacity ---')
    print(capacity)

    picks = [0] * len(item_info)
    bag(capacity, 0, item_info, 0)

    print("\n --- picks ---")
    print(picks_with_max_value)

    print("\n --- value ---")
    print(get_value(item_info, picks_with_max_value))

