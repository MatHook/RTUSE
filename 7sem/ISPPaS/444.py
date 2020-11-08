import sys

ALPHABET = ['А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ъ', 'Ы', 'Ь', 'Э', 'Ю', 'Я']

def encode(reverse = 1, debug = False):
  key = input("Input key\n").upper()
  text = input("Input text\n").upper()
  i = 0
  output = ''
  
  for char in text:
    current = ALPHABET[(ALPHABET.index(char) + reverse * ALPHABET.index(key[i % len(key)])) % 33]
    if debug:
      print(char, "+" if reverse == 1 else "-", key[i % len(key)], ": ", current)
    output += current
    i += 1
  print("Result\n", output)

if __name__ == "__main__":
  args = sys.argv

  if len(args) < 2:
    raise Exception("Wrong arguments")

  if (args[1] == "encode"):
    encode(1, debug = True)
    exit()
  if (args[1] == "decode"):
    encode(-1)
    exit()