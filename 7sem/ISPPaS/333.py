import sys

ALPHABET = ['А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ь', 'Ы', 'Ъ', 'Э', 'Ю', 'Я']


def encode():
  text = input("Input text\n").upper()
  print("Result: ")
  output = ''
  for char in text:
    output += str(int(ALPHABET.index(char) / 6 + 1))
    output += str(ALPHABET.index(char) % 6 + 1)
  print(output)

def decode():
  text = input("Input text\n").upper()
  print("Result: ")
  output = ''
  for i in range(0, int(len(text)), 2):
    output += ALPHABET[(int(text[i]) - 1) * 6 + int(text[i + 1]) - 1]
  print(output)

if __name__ == "__main__":
  args = sys.argv

  if len(args) < 2:
    raise Exception("Wrong arguments")

  if (args[1] == "encode"):
    encode()
    exit()
  if (args[1] == "decode"):
    decode()
    exit()