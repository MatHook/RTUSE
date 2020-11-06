import sys
import itertools

ALPHABET = ('А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я')

def encode(key, text, *, alphabet=ALPHABET):
  if isinstance(key, int):
    key = [key]

  result = ''

  for v, k in zip(text, itertools.cycle(key)):
    result += alphabet[(alphabet.index(v) + k) % len(alphabet)]

  return result


def decode(key, text, *, alphabet=ALPHABET):
  if isinstance(key, int):
    key = [key]

  result = ''

  for v, k in zip(text, itertools.cycle(key)):
    result += alphabet[(alphabet.index(v) - k) % len(alphabet)]
    
  return result

if __name__ == "__main__":
  args = sys.argv

  if len(args) < 2:
    print(f'usage: {args[0]} ((encode | decode) <key> <msg> | bruteforce <msg>)')
    exit(1)

  if args[1] == 'bruteforce':
    offset = 0

    while True:
      print(offset, decode(offset, ' '.join(args[2:])))
      input('Ctrl + C to stop | Enter to continue')
      offset += 1

  if len(args) < 3:
      print(f'usage: {args[0]} ((encode | decode <key> <msg> | bruteforce <msg>)')
      exit(1)

    
  def to_key(value):
    return list(map(int, value.split(',')))

  if args[1] == 'encode':
    print(encode(to_key(args[2]), ' '.join(args[3:])))
    exit()

  if args[1] == 'decode':
    print(decode(to_key(args[2]), ' '.join(args[3:])))
    exit()
