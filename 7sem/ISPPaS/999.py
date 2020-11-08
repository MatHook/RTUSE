import sys
import random

ALPHABET = ['А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З',
 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т',
 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э',
 'Ю', 'Я', '.', ',', ' ', ';', ':', '!', '?', '(', ')',
 '-', '"']

def gen_keys():
  with open('keys.txt', 'w+') as fh:
    for _ in range(10):
      for _ in range(40):
        fh.write('%d,' % (random.randint(0, 43)))
      fh.write('\n')
  print('Written to keys.txt')

def pop_key(filename):
  with open(filename, 'r') as fh:
    data = fh.read().splitlines()
  with open(filename, 'w') as fh:
    fh.write('\n'.join(data))
  return data[0].split(',')

def decrypt(key, msg):
  print('Result:')

  for c in msg:
    if c in ALPHABET:
      print(ALPHABET[(ALPHABET.index(c) + int(key.pop(0))) % len(ALPHABET)], end='')
    else:
      print(c, end='')
  print()

def encrypt(key, msg):
  print('Result:')

  for c in msg:
    if c in ALPHABET:
      print(ALPHABET[(ALPHABET.index(c) - int(key.pop(0)) + len(ALPHABET)) % len(ALPHABET)], end='')
    else:
      print(c, end='')
  print()
  
if __name__ == "__main__":
  if len(sys.argv) < 2:
    raise Exception("Wrong arguments")

  if sys.argv[1] == '--gen-keys':
    gen_keys()

  elif sys.argv[1] == '--encrypt':
    key = pop_key(sys.argv[3])
    encrypt(key, sys.argv[2].upper())
  
  elif sys.argv[1] == '--decrypt':
    key = pop_key(sys.argv[3])
    decrypt(key, sys.argv[2].upper())