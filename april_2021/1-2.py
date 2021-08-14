import copy


numbers = [1, 2, 3, 4, 5, 6, 7, 8, 21]
storage = set()


def calc(storage: set, numbers: list, current_val: int):
    if len(numbers) == 0:
        storage.add(current_val)
        return

    next_positive = numbers[0]
    next_negative = -1 * next_positive

    new_numbers = copy.copy(numbers[1:])
    calc(storage, new_numbers, current_val + next_positive)
    calc(storage, new_numbers, current_val + next_negative)


calc(storage, numbers, 0)
print("storage")
print(storage)
print(len(storage))
