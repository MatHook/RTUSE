import sys
import sys
import math

def main():
  if len(sys.argv) < 3:
    print("Неверные аргументы")
    exit(1)

  start = int(sys.argv[1])
  end = int(sys.argv[2])
  text = list(sys.argv[3])

  for step_size in range(start, end):
    splitted_text = []

    steps = len(text) // step_size

    add = 0
    if len(text) % step_size > 0:
      add = 1

    k = 0
    for j in range(step_size):
      if k // steps >= len(text) % step_size:
        add = 0
      splitted_text.append(text[k: k + steps + add])
      k = k + steps + add

    print(f'Step size: {step_size}')

    for i in range(len(splitted_text[0])):
      for j in range(len(splitted_text)):
        if (i >= len(splitted_text[j])):
          continue

        print(splitted_text[j][i], end="")

    print()

if __name__ == '__main__':
  main()
