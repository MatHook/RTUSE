text = list('ФТБЕОЗРЬЩМАОСЕОИАОИНШВОНЖ')
key = list('XX5X1')
matrix = []

row_len = len(text) // len(key)
unused = []

for i in range(len(key)):
    matrix.append(text[row_len * i: row_len * i + row_len])

    if str(i + 1) not in key:
        unused.append(matrix[i])


def print_mrx_w_key(key, matrix):
    print(''.join(key))
    print(''.join(matrix[j][i] for i in range(len(matrix[0]))
                  for j in range(len(matrix))))
    print('-' * 80)

print_mrx_w_key(key, matrix)
print(f"Unknown var count: {key.count('X')}")

every_var = []

def find_every_var(count, key):
  if len(count) == 1:
    key.append(count[0])
    every_var.append(key)
  else:
    for i in range(len(count)):
      new_count = count.copy()
      new_key = key.copy()

      new_key.append(count[i])
      new_count.remove(count[i])

      find_every_var(new_count, new_key)

find_every_var(unused, [])

for v in every_var:
  new_matrix = []
  for a in key: 
    if a != "X":
      new_matrix.append(matrix[int(a) - 1])
    else:
      new_matrix.append(v.pop())

print_mrx_w_key(key, new_matrix)