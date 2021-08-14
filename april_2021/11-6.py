
rules_len, text_len = map(int, input().split())

# rules_len = 2
# text_len = 32


# rules_list = [
    # ("doctor", "cafe"),
    # ("Wednesday", "Friday")
# ]

rules_list = []

for i in range(rules_len):
    sub_from, sub_to = input().split()
    tuple_res = (sub_from.replace('"', ''), sub_to.replace('"', ''))
    rules_list.append(tuple_res)

# text = "I went to a doctor on Wednesday."
text = input()


class Node:
    def __init__(self, text: str, is_sub: bool = False, next=None):
        self.next = next
        self.is_sub = is_sub
        self.text = text


def sub_with_rules(text: str, rules: list) -> str:
    head_node = Node(text)
    for rule in rules:
        sub_from = rule[0]
        sub_to = rule[1]
        process_nodes(head=head_node, sub_from=sub_from, sub_to=sub_to)

    return join_text(head_node)


def process_nodes(head: Node, sub_from: str, sub_to: str):
    current_node = head
    while current_node is not None:
        if not current_node.is_sub:
            text_to_process = current_node.text
            next_index = text_to_process.find(sub_from)

            if next_index != -1:
                first_part = text_to_process[0:next_index]
                current_node.text = first_part

                third_part = text_to_process[next_index + len(sub_from):]

                tail_node = current_node.next
                third_node = Node(text=third_part, next=tail_node)
                sub_node = Node(text=sub_to, is_sub=True, next=third_node)
                current_node.next = sub_node

                current_node = third_node
            else:
                current_node = current_node.next
        else:
            current_node = current_node.next


def join_text(head: Node):
    result = []
    current_node = head

    while current_node is not None:
        result.append(current_node.text)
        current_node = current_node.next

    return "".join(result)


result = sub_with_rules(text=text, rules=rules_list)
# print("result")
print(result)
